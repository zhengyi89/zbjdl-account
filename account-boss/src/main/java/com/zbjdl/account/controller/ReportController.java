package com.zbjdl.account.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zbjdl.account.controller.frame.AccountBaseController;
import com.zbjdl.account.dto.AccountSettleInfoDto;
import com.zbjdl.account.dto.AccountSettleWithSubjectInfoDto;
import com.zbjdl.account.dto.AssistAccountInfoDto;
import com.zbjdl.account.dto.SubjectInfoDto;
import com.zbjdl.account.dto.VoucherSubInfoDto;
import com.zbjdl.account.dto.response.BalanceSheetRespDto;
import com.zbjdl.account.enumtype.SystemInfoEnum;
import com.zbjdl.account.service.AccountSettleInfoService;
import com.zbjdl.account.service.AssistAccountInfoService;
import com.zbjdl.account.service.CurrencyInfoService;
import com.zbjdl.account.service.SubjectInfoService;
import com.zbjdl.account.service.VoucherSubInfoService;

/**
 * 报表
 * 
 * @author code-generator
 * @date 2018-11-23 15:46:41 
 * 
 */
@Controller
@RequestMapping("report")
public class ReportController extends AccountBaseController {
	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
	@Autowired
	private CurrencyInfoService currencyInfoService;

	@Autowired
	private SubjectInfoService subjectInfoService;
	
	@Autowired
	private AccountSettleInfoService accountSettleInfoService;
	
	@Autowired
	private VoucherSubInfoService voucherSubInfoService;
	
	@Autowired
	private AssistAccountInfoService assistAccountInfoService;
	/*
	 * 总账
	 */
	@RequestMapping(value = "/ledger", method = RequestMethod.GET)
	public ModelAndView ledgerIndex() {
		ModelAndView mav = new ModelAndView("report/ledgerIndex");
		List<SubjectInfoDto> subjectList = subjectInfoService.findBySyscode(getCurrentSystemInfo().getSystemCode());
		mav.addObject("subjectList", subjectList);
		
		return mav;
	}
	
	
	/*
	 * 明细账
	 */
	@RequestMapping(value = "/detailAccount", method = RequestMethod.GET)
	public ModelAndView detailAccount() {
		ModelAndView mav = new ModelAndView("report/detailAccount");
		
		List<SubjectInfoDto> subjectList = subjectInfoService.findBySyscode(getCurrentSystemInfo().getSystemCode());
		mav.addObject("subjectList", subjectList);
		return mav;
	}
	
	
	
	/*
	 * 科目余额
	 */
	@RequestMapping(value = "/subjectBalance", method = RequestMethod.GET)
	public ModelAndView subjectBalance() {
		ModelAndView mav = new ModelAndView("report/subjectBalance");
		return mav;
	}
	
	
	/*
	 * 凭证汇总
	 */
	@RequestMapping(value = "/voucherSumm", method = RequestMethod.GET)
	public ModelAndView voucherSumm() {
		ModelAndView mav = new ModelAndView("report/voucherSumm");
		return mav;
	}
	
	/*
	 * 辅助核算明细账
	 */
	@RequestMapping(value = "/assistAccountDetail", method = RequestMethod.GET)
	public ModelAndView assistAccountDetail() {
		ModelAndView mav = new ModelAndView("report/assistAccountDetail");
		
		// 查询带有辅助核算科目列表
		List<SubjectInfoDto> subjectList = subjectInfoService.findListWithAssist(getCurrentSystemInfo().getSystemCode());
		mav.addObject("subjectList", subjectList);
		
		// 查询辅助核算列表
		List<AssistAccountInfoDto> assistList = assistAccountInfoService.findBySyscode(getCurrentSystemInfo().getSystemCode());
		mav.addObject("assistList", assistList);
		return mav;
	}
	
	/*
	 * 辅助核算余额表
	 */
	@RequestMapping(value = "/assistAccountBalance", method = RequestMethod.GET)
	public ModelAndView assistAccountBalance() {
		ModelAndView mav = new ModelAndView("report/assistAccountBalance");
		// 查询带有辅助核算科目列表
		List<SubjectInfoDto> subjectList = subjectInfoService.findListWithAssist(getCurrentSystemInfo().getSystemCode());
		mav.addObject("subjectList", subjectList);
		
		// 查询辅助核算列表
		List<AssistAccountInfoDto> assistList = assistAccountInfoService.findBySyscode(getCurrentSystemInfo().getSystemCode());
		mav.addObject("assistList", assistList);
		return mav;
	}
	
	/*
	 * 现金流量明细表
	 */
	@RequestMapping(value = "/cashFlowDetail", method = RequestMethod.GET)
	public ModelAndView cashFlowDetail() {
		ModelAndView mav = new ModelAndView("report/cashFlowDetail");
		return mav;
	}
	
	/*
	 * 资产负债表
	 */
	@RequestMapping(value = "/balanceSheet", method = RequestMethod.GET)
	public ModelAndView balanceSheet() {
		Map<String, AccountSettleWithSubjectInfoDto> map = new HashMap<String, AccountSettleWithSubjectInfoDto>();
		List<AccountSettleWithSubjectInfoDto> accountSettleList = accountSettleInfoService.findListByMonth(getCurrentSystemInfo().getSystemCode(), getCurrentSystemInfo().getAccountMonth());
		for (AccountSettleWithSubjectInfoDto accountSettleWithSubjectInfoDto : accountSettleList) {
			accountSettleWithSubjectInfoDto.setClosingBalance(accountSettleWithSubjectInfoDto.getOpeningBalance());
			map.put(accountSettleWithSubjectInfoDto.getSubjectCode(), accountSettleWithSubjectInfoDto);
		}
		
		List<VoucherSubInfoDto> voucherSubList = voucherSubInfoService.findListByMonth(getCurrentSystemInfo().getSystemCode(), getCurrentSystemInfo().getAccountMonth());
		for (VoucherSubInfoDto voucherSubInfoDto : voucherSubList) {
			AccountSettleInfoDto dto = map.get(voucherSubInfoDto.getSubjectCode());
			if (dto!=null) {
				dto.setClosingBalance(dto.getClosingBalance().add(voucherSubInfoDto.getAmount()));
			}
			
		}
		
		// 父科目金额汇总
		for (Map.Entry<String, AccountSettleWithSubjectInfoDto> entry : map.entrySet()) {
			if (entry.getValue().getLastLevel() && entry.getValue().getSubjectCode().length()>4) {
				// 获取父编码
				String code = entry.getValue().getSubjectCode();
				AccountSettleWithSubjectInfoDto parent = map.get(code.substring(0, code.length()-2));
				parent.setClosingBalance(parent.getClosingBalance().add(entry.getValue().getClosingBalance()));
				parent.setYearOpeningBalance(parent.getYearOpeningBalance().add(entry.getValue().getYearOpeningBalance()));
			}
		}
		
		// 拼装报表
//		Map<String, AccountSettleInfoDto> result = new HashMap<String, AccountSettleInfoDto>();
		
//		BalanceSheetRespDto dto1 = new BalanceSheetRespDto();
//		dto1.setClosingAmount(map.get("1001").getClosingBalance().add(map.get("1002").getClosingBalance()).add(map.get("1012").getClosingBalance()).add(map.get("1004").getClosingBalance()));
//		dto1.setClosingAmount(map.get("1001").getClosingBalance().add(map.get("1002").getClosingBalance()).add(map.get("1012").getClosingBalance()).add(map.get("1004").getClosingBalance()));
//		result.put("1", dto1);
		
		ModelAndView mav;
		// 小企业和企业报表不同
		if (SystemInfoEnum.ACCOUNT_TYPE_GENERAL.getCode().equals(getCurrentSystemInfo().getAccountType())) {
			mav = new ModelAndView("report/balanceSheet");
		}else {
			mav = new ModelAndView("report/balanceSheetSmall");
		}
		
		mav.addObject("dto", map);
		System.out.println(JSON.toJSONString(map));
		return mav;
	}
	
	/*
	 * 利润表
	 */
	@RequestMapping(value = "/profitStatement", method = RequestMethod.GET)
	public ModelAndView profitStatement() {
		
		
		Map<String, AccountSettleWithSubjectInfoDto> map = new HashMap<String, AccountSettleWithSubjectInfoDto>();
		// 查询结算记录
		List<AccountSettleWithSubjectInfoDto> accountSettleList = accountSettleInfoService.findListByMonth(getCurrentSystemInfo().getSystemCode(), getCurrentSystemInfo().getAccountMonth());
		for (AccountSettleWithSubjectInfoDto accountSettleWithSubjectInfoDto : accountSettleList) {
			accountSettleWithSubjectInfoDto.setClosingBalance(accountSettleWithSubjectInfoDto.getOpeningBalance());
			map.put(accountSettleWithSubjectInfoDto.getSubjectCode(), accountSettleWithSubjectInfoDto);
		}
		
		List<VoucherSubInfoDto> voucherSubList = voucherSubInfoService.findListByMonth(getCurrentSystemInfo().getSystemCode(), getCurrentSystemInfo().getAccountMonth());
		// 凭证汇总
		for (VoucherSubInfoDto voucherSubInfoDto : voucherSubList) {
			AccountSettleInfoDto dto = map.get(voucherSubInfoDto.getSubjectCode());
			if (dto!=null) {
				// 本期金额
				dto.setSumAmount(dto.getSumAmount().add(voucherSubInfoDto.getAmount()));
				// 本年累积金额 ＝ 期初金额－年初金额＋本期金额
				dto.setSumYearAmount(dto.getOpeningBalance().subtract(dto.getYearOpeningBalance()).add(dto.getSumAmount()));
			}
			
		}
		
		// 父科目金额汇总
		for (Map.Entry<String, AccountSettleWithSubjectInfoDto> entry : map.entrySet()) {
			if (entry.getValue().getLastLevel() && entry.getValue().getSubjectCode().length()>4) {
				// 获取父编码
				String code = entry.getValue().getSubjectCode();
				AccountSettleWithSubjectInfoDto parent = map.get(code.substring(0, code.length()-2));
				parent.setClosingBalance(parent.getClosingBalance().add(entry.getValue().getClosingBalance()));
				parent.setYearOpeningBalance(parent.getYearOpeningBalance().add(entry.getValue().getYearOpeningBalance()));
			}
		}
		
		
		
		ModelAndView mav = new ModelAndView("report/profitStatement");
		mav.addObject("dto", map);
		return mav;
	}
	
	
	/*
	 * 现金流量明细表
	 */
	@RequestMapping(value = "/cashFlowStatement", method = RequestMethod.GET)
	public ModelAndView cashFlowStatement() {

		Map<String, AccountSettleInfoDto> map = new HashMap<String, AccountSettleInfoDto>();
		// 查询结算记录
		List<AccountSettleWithSubjectInfoDto> accountSettleList = accountSettleInfoService.findListByMonth(getCurrentSystemInfo().getSystemCode(), getCurrentSystemInfo().getAccountMonth());
		for (AccountSettleWithSubjectInfoDto accountSettleWithSubjectInfoDto : accountSettleList) {
			accountSettleWithSubjectInfoDto.setClosingBalance(accountSettleWithSubjectInfoDto.getOpeningBalance());
			map.put(accountSettleWithSubjectInfoDto.getSubjectCode(), accountSettleWithSubjectInfoDto);
		}
		
		List<VoucherSubInfoDto> voucherSubList = voucherSubInfoService.findListByMonth(getCurrentSystemInfo().getSystemCode(), getCurrentSystemInfo().getAccountMonth());
		// 凭证汇总
		for (VoucherSubInfoDto voucherSubInfoDto : voucherSubList) {
			AccountSettleInfoDto dto = map.get(voucherSubInfoDto.getSubjectCode());
			if (dto!=null) {
				// 本期金额
				dto.setSumAmount(dto.getSumAmount().add(voucherSubInfoDto.getAmount()));
				// 本年累积金额 ＝ 期初金额－年初金额＋本期金额
				dto.setSumYearAmount(dto.getOpeningBalance().subtract(dto.getYearOpeningBalance()).add(dto.getSumAmount()));
			}
			
		}
		
		ModelAndView mav = new ModelAndView("report/cashFlowStatement");
		mav.addObject("dto", map);
		return mav;
	}
	
	
	/*
	 * 纳税汇总表
	 */
	@RequestMapping(value = "/taxpaySheet", method = RequestMethod.GET)
	public ModelAndView taxpaySheet() {
		ModelAndView mav = new ModelAndView("report/taxpaySheet");
		return mav;
	}
	
	

}
