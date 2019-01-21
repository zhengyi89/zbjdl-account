package com.zbjdl.account.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import com.zbjdl.account.dto.VoucherInfoDto;
import com.zbjdl.account.dto.VoucherSubDetailDto;
import com.zbjdl.account.dto.VoucherSubInfoDto;
import com.zbjdl.account.dto.request.DetailAccountReportReqDto;
import com.zbjdl.account.dto.response.CashFlowStatementRespDto;
import com.zbjdl.account.dto.response.ReportDetailAccountRespDto;
import com.zbjdl.account.enumtype.SystemEnum;
import com.zbjdl.account.service.AccountSettleInfoService;
import com.zbjdl.account.service.AssistAccountInfoService;
import com.zbjdl.account.service.CurrencyInfoService;
import com.zbjdl.account.service.SubjectInfoService;
import com.zbjdl.account.service.VoucherInfoService;
import com.zbjdl.account.service.VoucherSubInfoService;
import com.zbjdl.account.util.AccountUtils;
import com.zbjdl.account.util.DateUtils;
import com.zbjdl.account.util.ReportUtils;
import com.zbjdl.common.amount.Amount;
import com.zbjdl.common.utils.BeanUtils;
import com.zbjdl.common.utils.StringUtils;

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
	private VoucherInfoService voucherInfoService;

	@Autowired
	private VoucherSubInfoService voucherSubInfoService;

	@Autowired
	private AssistAccountInfoService assistAccountInfoService;

	private static final String SUMMARY_1 = "上期结转";
	private static final String SUMMARY_MONTH = "本月合计";
	private static final String SUMMARY_YEAR = "本年累计";
	private static final String DEFAULT_SUBJECT = "1001";

	/*
	 * 总账
	 */
	@RequestMapping(value = "/ledger", method = RequestMethod.GET)
	public ModelAndView ledgerIndex(DetailAccountReportReqDto reqDto) {
		ModelAndView mav = new ModelAndView("report/ledgerIndex");
		List<SubjectInfoDto> subjectList = subjectInfoService.findBySyscode(getCurrentSystemInfo().getSystemCode());
		mav.addObject("subjectList", subjectList);
		
		if (reqDto.getStartdate()==null) {
			mav.addObject("startdate", getCurrentSystemInfo().getAccountMonth());
			mav.addObject("enddate", getCurrentSystemInfo().getAccountMonth());
			mav.addObject("subjectCode", DEFAULT_SUBJECT);
		}
		

		return mav;
	}

	/*
	 * 明细账
	 */
	@RequestMapping(value = "/detailAccount", method = RequestMethod.GET)
	public ModelAndView detailAccount(DetailAccountReportReqDto reqDto) {
		ModelAndView mav = new ModelAndView("report/detailAccount");
		
		reqDto.setSystemCode(getCurrentSystemInfo().getSystemCode());
		SubjectInfoDto subjectDto = subjectInfoService.selectByCode(reqDto.getSubjectCode(), reqDto.getSystemCode());
		List<SubjectInfoDto> subjectList = subjectInfoService.findBySyscode(getCurrentSystemInfo().getSystemCode());
		mav.addObject("subjectList", subjectList);
		mav.addObject("subject", subjectDto);
		
		if (reqDto.getStartdate()==null) {
			reqDto.setStartdate(getCurrentSystemInfo().getAccountMonth());
			reqDto.setEnddate(getCurrentSystemInfo().getAccountMonth());
			reqDto.setSubjectCode(DEFAULT_SUBJECT);
		}
		
		
		// 根据起始日期查询期初
		AccountSettleInfoDto accountSettleDto = accountSettleInfoService.findAssistRecord(subjectDto.getId(), reqDto.getAssistCode(),
				reqDto.getStartdate());
		List<ReportDetailAccountRespDto> resultList = new ArrayList<ReportDetailAccountRespDto>();
		Amount remainAmount = new Amount();
		if (accountSettleDto != null) {
			ReportDetailAccountRespDto dto = new ReportDetailAccountRespDto();
			dto.setAccountMonth(reqDto.getStartdate());
			dto.setSummary(SUMMARY_1);
			dto.setRemainAmount(accountSettleDto.getOpeningBalance());
			resultList.add(dto);

			remainAmount = accountSettleDto.getOpeningBalance();
		}

		Amount yearDebit = new Amount();
		Amount yearCredit = new Amount();

		// 获取记账区间月份
		List<String> dateList = DateUtils.getBetweenMonth(reqDto.getStartdate(), reqDto.getEnddate());
		// 遍历，按月查询
		for (String date : dateList) {
			reqDto.setAccountMonth(date);
			List<VoucherSubDetailDto> detailList = voucherSubInfoService.findListByParamOrder(reqDto);
			// 本月合计
			ReportDetailAccountRespDto monthDto = new ReportDetailAccountRespDto();
			monthDto.setAccountMonth(date);
			monthDto.setSummary(SUMMARY_MONTH);
			Amount sumDebit = new Amount();
			Amount sumCredit = new Amount();

			// 遍历凭证
			for (VoucherSubDetailDto voucherSubDetailDto : detailList) {
				sumDebit = sumDebit.add(voucherSubDetailDto.getDebitAmount());
				sumCredit = sumCredit.add(voucherSubDetailDto.getCreditAmount());
				ReportDetailAccountRespDto voucherDto = new ReportDetailAccountRespDto();
				BeanUtils.copyProperties(voucherSubDetailDto, voucherDto);
				voucherDto.setAccountMonth(DateUtils.DATE_MONTH_FORMAT.format(voucherSubDetailDto.getAccountPeriod()));
				remainAmount = remainAmount.subtract(voucherSubDetailDto.getAmount());
				voucherDto.setRemainAmount(remainAmount);
				resultList.add(voucherDto);
			}

			// 计算当月真实发生金额
			monthDto.setRemainAmount(remainAmount);
			monthDto.setCreditAmount(sumCredit);
			monthDto.setDebitAmount(sumDebit);
			resultList.add(monthDto);

			// 计算年累计真实发生金额
			yearDebit = yearDebit.add(sumDebit);
			yearCredit = yearCredit.add(sumCredit);
			ReportDetailAccountRespDto yearDto = new ReportDetailAccountRespDto();
			yearDto.setAccountMonth(date);
			yearDto.setSummary(SUMMARY_YEAR);
			yearDto.setDebitAmount(yearDebit);
			yearDto.setCreditAmount(yearCredit);
			yearDto.setRemainAmount(remainAmount);
			resultList.add(yearDto);

		}

		for (ReportDetailAccountRespDto result : resultList) {
			System.out.println(result.getAccountMonth() + "--" + result.getSerialNum() + "--" + result.getSummary() + "--"
					+ result.getCreditAmount() + "--" + result.getDebitAmount() + "--" + result.getRemainAmount());
		}

		mav.addObject("resultList", resultList);
		
		mav.addObject("startdate", reqDto.getStartdate());
		mav.addObject("enddate", reqDto.getEnddate());
		mav.addObject("subjectCode", reqDto.getSubjectCode());
		mav.addObject("assistCode", reqDto.getAssistCode());

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
	public ModelAndView voucherSumm(String startdate, String enddate) {
		ModelAndView mav = new ModelAndView("report/voucherSumm");

		// 查询会计凭证列表
		List<VoucherInfoDto> voucherList = voucherInfoService.findListMonthBetween(getCurrentSystemInfo().getSystemCode(), startdate,
				enddate);

		Integer rows = 0;
		Integer papers = 0;
		for (VoucherInfoDto voucherInfoDto : voucherList) {
			rows++;
			papers += voucherInfoDto.getVoucherPapers();
		}
		mav.addObject("rows", rows);
		mav.addObject("papers", papers);

		Map<String, String> dateMap = DateUtils.genDateSelector(getCurrentSystemInfo().getStartMonth(), getCurrentSystemInfo()
				.getLatestMonth());
		mav.addObject("dateMap", dateMap);

		return mav;
	}

	/*
	 * 辅助核算明细账
	 */
	@RequestMapping(value = "/assistAccountDetail", method = RequestMethod.GET)
	public ModelAndView assistAccountDetail(String subjectCode, String assistCode, String startdate) {
		ModelAndView mav = new ModelAndView("report/assistAccountDetail");

		// 查询带有辅助核算科目列表
		List<SubjectInfoDto> subjectList = subjectInfoService.findListWithAssist(getCurrentSystemInfo().getSystemCode());
		mav.addObject("subjectList", subjectList);

		// 查询辅助核算列表
		List<AssistAccountInfoDto> assistList = assistAccountInfoService.findBySyscode(getCurrentSystemInfo().getSystemCode());
		mav.addObject("assistList", assistList);

		// 查询科目
		SubjectInfoDto subject = subjectInfoService.selectByCode(subjectCode, getCurrentSystemInfo().getSystemCode());

		// 查询期初
		AccountSettleInfoDto dto = accountSettleInfoService.findAssistRecord(subject.getId(), assistCode, startdate);

		Map<String, String> dateMap = DateUtils.genDateSelector(getCurrentSystemInfo().getStartMonth(), getCurrentSystemInfo()
				.getLatestMonth());
		mav.addObject("dateMap", dateMap);
		mav.addObject("openingBalance", dto == null ? new Amount() : dto.getOpeningBalance());

		return mav;
	}

	/*
	 * 辅助核算余额表
	 */
	@RequestMapping(value = "/assistAccountBalance", method = RequestMethod.GET)
	public ModelAndView assistAccountBalance(String subjectCode, String assistCode, String startdate, String enddate) {
		ModelAndView mav = new ModelAndView("report/assistAccountBalance");
		// 查询带有辅助核算科目列表
		List<SubjectInfoDto> subjectList = subjectInfoService.findListWithAssist(getCurrentSystemInfo().getSystemCode());
		mav.addObject("subjectList", subjectList);

		// 查询辅助核算列表
		List<AssistAccountInfoDto> assistList = assistAccountInfoService.findBySyscode(getCurrentSystemInfo().getSystemCode());
		mav.addObject("assistList", assistList);

		Map<String, String> dateMap = DateUtils.genDateSelector(getCurrentSystemInfo().getStartMonth(), getCurrentSystemInfo()
				.getLatestMonth());
		mav.addObject("dateMap", dateMap);

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
		Map<String, AccountSettleWithSubjectInfoDto> map = new LinkedHashMap<String, AccountSettleWithSubjectInfoDto>();
		List<AccountSettleWithSubjectInfoDto> accountSettleList = accountSettleInfoService.findListByMonth(getCurrentSystemInfo()
				.getSystemCode(), getCurrentSystemInfo().getAccountMonth());
		for (AccountSettleWithSubjectInfoDto accountSettleWithSubjectInfoDto : accountSettleList) {
			accountSettleWithSubjectInfoDto.setClosingBalance(accountSettleWithSubjectInfoDto.getOpeningBalance());
			map.put(accountSettleWithSubjectInfoDto.getSubjectCode(), accountSettleWithSubjectInfoDto);
		}

		List<VoucherSubInfoDto> voucherSubList = voucherSubInfoService.findListByMonth(getCurrentSystemInfo().getSystemCode(),
				getCurrentSystemInfo().getAccountMonth());
		for (VoucherSubInfoDto voucherSubInfoDto : voucherSubList) {
			AccountSettleInfoDto dto = map.get(voucherSubInfoDto.getSubjectCode());
			if (dto != null) {
				dto.setClosingBalance(dto.getClosingBalance().add(voucherSubInfoDto.getAmount()));
			}

		}

		// 父科目金额汇总
		for (Map.Entry<String, AccountSettleWithSubjectInfoDto> entry : map.entrySet()) {
			// 先汇总三级科目
			if (entry.getValue().getSubjectCode().length() > 4) {
				// 获取父编码
				String code = entry.getValue().getSubjectCode();
				AccountSettleWithSubjectInfoDto parent = map.get(code.substring(0, code.length() - 2));
				if (entry.getValue().getBalanceDirect().equals(parent.getBalanceDirect())) {
					parent.setClosingBalance(parent.getClosingBalance().add(entry.getValue().getClosingBalance()));
					parent.setYearOpeningBalance(parent.getYearOpeningBalance().add(entry.getValue().getYearOpeningBalance()));
				} else {
					parent.setClosingBalance(parent.getClosingBalance().subtract(entry.getValue().getClosingBalance()));
					parent.setYearOpeningBalance(parent.getYearOpeningBalance().subtract(entry.getValue().getYearOpeningBalance()));
				}

			}
		}

		for (Map.Entry<String, AccountSettleWithSubjectInfoDto> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "----" + entry.getValue().getClosingBalance());
		}

		ModelAndView mav;
		// 小企业和企业报表不同
		if (SystemEnum.ACCOUNT_TYPE_GENERAL.getCode().equals(getCurrentSystemInfo().getAccountType())) {
			mav = new ModelAndView("report/balanceSheetGeneral");
		} else {
			mav = new ModelAndView("report/balanceSheetSmall");
		}

		mav.addObject("dto", map);
		return mav;
	}

	/*
	 * 利润表
	 */
	@RequestMapping(value = "/profitStatement", method = RequestMethod.GET)
	public ModelAndView profitStatement() {

		Map<String, AccountSettleWithSubjectInfoDto> map = new LinkedHashMap<String, AccountSettleWithSubjectInfoDto>();
		// 查询结算记录
		List<AccountSettleWithSubjectInfoDto> accountSettleList = accountSettleInfoService.findListByMonth(getCurrentSystemInfo()
				.getSystemCode(), getCurrentSystemInfo().getAccountMonth());
		for (AccountSettleWithSubjectInfoDto accountSettleWithSubjectInfoDto : accountSettleList) {
			accountSettleWithSubjectInfoDto.setClosingBalance(accountSettleWithSubjectInfoDto.getOpeningBalance());
			accountSettleWithSubjectInfoDto.setCreditAmount(new Amount());
			accountSettleWithSubjectInfoDto.setSumAmount(new Amount());
			map.put(accountSettleWithSubjectInfoDto.getSubjectCode(), accountSettleWithSubjectInfoDto);
		}

		List<VoucherSubInfoDto> voucherSubList = voucherSubInfoService.findListByMonth(getCurrentSystemInfo().getSystemCode(),
				getCurrentSystemInfo().getAccountMonth());
		// 凭证汇总
		for (VoucherSubInfoDto voucherSubInfoDto : voucherSubList) {
			AccountSettleInfoDto dto = map.get(voucherSubInfoDto.getSubjectCode());
			if (dto != null) {
				if (voucherSubInfoDto.getSubjectCode().equals("5001")) {
					System.out.println(1);
				}
				// 本期金额
				dto.setSumAmount(dto.getSumAmount().add(voucherSubInfoDto.getAmount()));
				// 本年累积金额 ＝ 期初金额－年初金额＋本期金额
				dto.setSumYearAmount(dto.getOpeningBalance().subtract(dto.getYearOpeningBalance()).add(dto.getSumAmount()));
				dto.setCreditAmount(dto.getCreditAmount().add(voucherSubInfoDto.getCreditAmount()));
				dto.setYearCreditAmount(dto.getYearCreditAmount().add(voucherSubInfoDto.getCreditAmount()));
			}

		}

		// 父科目金额汇总
		for (Map.Entry<String, AccountSettleWithSubjectInfoDto> entry : map.entrySet()) {
			if (entry.getValue().getSubjectCode().length() > 4) {
				// 获取父编码
				String code = entry.getValue().getSubjectCode();
				AccountSettleWithSubjectInfoDto parent = map.get(code.substring(0, code.length() - 2));
				if (entry.getValue().getBalanceDirect().equals(parent.getBalanceDirect())) {
					parent.setSumAmount(parent.getSumAmount().add(entry.getValue().getSumAmount()));
					parent.setSumYearAmount(parent.getSumYearAmount().add(entry.getValue().getSumYearAmount()));
					parent.setCreditAmount(parent.getCreditAmount().add(entry.getValue().getCreditAmount()));
					parent.setYearCreditAmount(parent.getYearCreditAmount().add(entry.getValue().getYearCreditAmount()));
				} else {
					parent.setSumAmount(parent.getSumAmount().subtract(entry.getValue().getSumAmount()));
					parent.setSumYearAmount(parent.getSumYearAmount().subtract(entry.getValue().getSumYearAmount()));
					parent.setCreditAmount(parent.getCreditAmount().subtract(entry.getValue().getCreditAmount()));
					parent.setYearCreditAmount(parent.getYearCreditAmount().subtract(entry.getValue().getYearCreditAmount()));
				}

			}
		}

		for (Map.Entry<String, AccountSettleWithSubjectInfoDto> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "----" + entry.getValue().getSumAmount() + "---" + entry.getValue().getSumYearAmount());
		}
		ModelAndView mav;
		// 小企业和企业报表不同
		if (SystemEnum.ACCOUNT_TYPE_GENERAL.getCode().equals(getCurrentSystemInfo().getAccountType())) {
			mav = new ModelAndView("report/profitStatementGeneral");
		} else {
			mav = new ModelAndView("report/profitStatementSmall");
		}
		mav.addObject("dto", map);
		return mav;
	}

	/*
	 * 现金流量明细表
	 */
	@RequestMapping(value = "/cashFlowStatement", method = RequestMethod.GET)
	public ModelAndView cashFlowStatement() {

		Map<String, AccountSettleWithSubjectInfoDto> map = new LinkedHashMap<String, AccountSettleWithSubjectInfoDto>();
		// 查询结算记录
		List<AccountSettleWithSubjectInfoDto> accountSettleList = accountSettleInfoService.findListByMonth(getCurrentSystemInfo()
				.getSystemCode(), getCurrentSystemInfo().getAccountMonth());
		for (AccountSettleWithSubjectInfoDto accountSettleWithSubjectInfoDto : accountSettleList) {
			accountSettleWithSubjectInfoDto.setClosingBalance(accountSettleWithSubjectInfoDto.getOpeningBalance());

			accountSettleWithSubjectInfoDto.setCreditAmount(new Amount());
			accountSettleWithSubjectInfoDto.setSumAmount(new Amount());
			accountSettleWithSubjectInfoDto.setDebitAmount(new Amount());

			map.put(accountSettleWithSubjectInfoDto.getSubjectCode(), accountSettleWithSubjectInfoDto);
		}

		List<VoucherSubInfoDto> voucherSubList = voucherSubInfoService.findListByMonth(getCurrentSystemInfo().getSystemCode(),
				getCurrentSystemInfo().getAccountMonth());
		// 凭证汇总
		for (VoucherSubInfoDto voucherSubInfoDto : voucherSubList) {
			AccountSettleInfoDto dto = map.get(voucherSubInfoDto.getSubjectCode());
			if (dto != null) {
				// 本期金额
				dto.setSumAmount(dto.getSumAmount().add(voucherSubInfoDto.getAmount()));
				// 本年累积金额 ＝ 期初金额－年初金额＋本期金额
				dto.setSumYearAmount(dto.getOpeningBalance().subtract(dto.getYearOpeningBalance()).add(dto.getSumAmount()));
				dto.setCreditAmount(dto.getCreditAmount().add(voucherSubInfoDto.getCreditAmount()));
				dto.setYearCreditAmount(dto.getYearCreditAmount().add(voucherSubInfoDto.getCreditAmount()));
				dto.setDebitAmount(dto.getDebitAmount().add(voucherSubInfoDto.getDebitAmount()));
				dto.setYearDebitAmount(dto.getYearDebitAmount().add(voucherSubInfoDto.getDebitAmount()));
			}

		}

		// 父科目金额汇总
		for (Map.Entry<String, AccountSettleWithSubjectInfoDto> entry : map.entrySet()) {
			// 先汇总三级科目
			if (entry.getValue().getSubjectCode().length() > 4) {
				// 获取父编码
				String code = entry.getValue().getSubjectCode();
				AccountSettleWithSubjectInfoDto parent = map.get(code.substring(0, code.length() - 2));
				// 判断子科目和父科目科目方向
				if (entry.getValue().getBalanceDirect().equals(parent.getBalanceDirect())) {
					parent.setSumAmount(parent.getSumAmount().add(entry.getValue().getSumAmount()));
					parent.setSumYearAmount(parent.getSumYearAmount().add(entry.getValue().getSumYearAmount()));
					parent.setCreditAmount(parent.getCreditAmount().add(entry.getValue().getCreditAmount()));
					parent.setYearCreditAmount(parent.getYearCreditAmount().add(entry.getValue().getYearCreditAmount()));
					parent.setDebitAmount(parent.getDebitAmount().add(entry.getValue().getDebitAmount()));
					parent.setYearDebitAmount(parent.getYearDebitAmount().add(entry.getValue().getYearDebitAmount()));
				} else {
					parent.setSumAmount(parent.getSumAmount().subtract(entry.getValue().getSumAmount()));
					parent.setSumYearAmount(parent.getSumYearAmount().subtract(entry.getValue().getSumYearAmount()));
					parent.setCreditAmount(parent.getCreditAmount().subtract(entry.getValue().getCreditAmount()));
					parent.setYearCreditAmount(parent.getYearCreditAmount().subtract(entry.getValue().getYearCreditAmount()));
					parent.setDebitAmount(parent.getDebitAmount().subtract(entry.getValue().getDebitAmount()));
					parent.setYearDebitAmount(parent.getYearDebitAmount().subtract(entry.getValue().getYearDebitAmount()));
				}

			}
		}

		for (Map.Entry<String, AccountSettleWithSubjectInfoDto> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "----" + entry.getValue().getSumAmount() + "---" + entry.getValue().getSumYearAmount());
		}

		ModelAndView mav;
		if (SystemEnum.ACCOUNT_TYPE_GENERAL.getCode().equals(getCurrentSystemInfo().getAccountType())) {
			mav = ReportUtils.cashFlowStatementGeneral(map);
		}else {
			mav = ReportUtils.cashFlowStatementSmall(map);
		}
		
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
