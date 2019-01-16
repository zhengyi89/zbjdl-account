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
			mav = new ModelAndView("report/balanceSheet");
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
		ModelAndView mav = new ModelAndView("report/profitStatement");
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

		Amount a5001c = map.get("5001").getCreditAmount();
		Amount a1122c = map.get("1122").getCreditAmount();
		Amount a1121c = map.get("1121").getCreditAmount();
		Amount a2203c = map.get("2203").getCreditAmount();
		Amount a222101c = map.get("222101").getCreditAmount();
		Amount a5301c = map.get("5301").getCreditAmount();
		Amount a5051c = map.get("5051").getCreditAmount();
		Amount a1101c = map.get("1101").getCreditAmount();
		Amount a1501c = map.get("1501").getCreditAmount();
		Amount a1511c = map.get("1511").getCreditAmount();
		Amount a5111c = map.get("5111").getCreditAmount();
		Amount a1131c = map.get("1131").getCreditAmount();
		Amount a1132c = map.get("1132").getCreditAmount();
		Amount a1606c = map.get("1606").getCreditAmount();
		Amount a1621c = map.get("1621").getCreditAmount();
		Amount a1701c = map.get("1701").getCreditAmount();
		Amount a2001c = map.get("2001").getCreditAmount();
		Amount a2501c = map.get("2501").getCreditAmount();
		Amount a3001c = map.get("3001").getCreditAmount();
		Amount a3002c = map.get("3002").getCreditAmount();

		Amount a1403d = map.get("1403").getDebitAmount();
		Amount a1405d = map.get("1405").getDebitAmount();
		Amount a5401d = map.get("5401").getDebitAmount();
		Amount a5402d = map.get("5402").getDebitAmount();
		Amount a5403d = map.get("5403").getDebitAmount();
		Amount a2201d = map.get("2201").getDebitAmount();
		Amount a2202d = map.get("2202").getDebitAmount();
		Amount a1123d = map.get("1123").getDebitAmount();
		Amount a2221d = map.get("2221").getDebitAmount();
		Amount a222101d = map.get("222101").getDebitAmount();
		Amount a2211d = map.get("2211").getDebitAmount();
		Amount a560207d = map.get("560207").getDebitAmount();
		Amount a5711d = map.get("5711").getDebitAmount();
		Amount a5602d = map.get("5602").getDebitAmount();
		Amount a560206d = map.get("560206").getDebitAmount();
		Amount a560208d = map.get("560208").getDebitAmount();
		Amount a560212d = map.get("560212").getDebitAmount();
		Amount a1101d = map.get("1101").getDebitAmount();
		Amount a1501d = map.get("1501").getDebitAmount();
		Amount a1511d = map.get("1511").getDebitAmount();
		Amount a1601d = map.get("1601").getDebitAmount();
		Amount a1701d = map.get("1701").getDebitAmount();
		Amount a1604d = map.get("1604").getDebitAmount();
		Amount a1621d = map.get("1621").getDebitAmount();
		Amount a2001d = map.get("2001").getDebitAmount();
		Amount a2501d = map.get("2501").getDebitAmount();
		Amount a560306d = map.get("560306").getDebitAmount();
		Amount a2231d = map.get("2231").getDebitAmount();
		Amount a2232d = map.get("2232").getDebitAmount();

		/*
		 * 以下是本年累计
		 */
		Amount y5001c = map.get("5001").getYearCreditAmount();
		Amount y1122c = map.get("1122").getYearCreditAmount();
		Amount y1121c = map.get("1121").getYearCreditAmount();
		Amount y2203c = map.get("2203").getYearCreditAmount();
		Amount y222101c = map.get("222101").getYearCreditAmount();
		Amount y5301c = map.get("5301").getYearCreditAmount();
		Amount y5051c = map.get("5051").getYearCreditAmount();
		Amount y1101c = map.get("1101").getYearCreditAmount();
		Amount y1501c = map.get("1501").getYearCreditAmount();
		Amount y1511c = map.get("1511").getYearCreditAmount();
		Amount y5111c = map.get("5111").getYearCreditAmount();
		Amount y1131c = map.get("1131").getYearCreditAmount();
		Amount y1132c = map.get("1132").getYearCreditAmount();
		Amount y1606c = map.get("1606").getYearCreditAmount();
		Amount y1621c = map.get("1621").getYearCreditAmount();
		Amount y1701c = map.get("1701").getYearCreditAmount();
		Amount y2001c = map.get("2001").getYearCreditAmount();
		Amount y2501c = map.get("2501").getYearCreditAmount();
		Amount y3001c = map.get("3001").getYearCreditAmount();
		Amount y3002c = map.get("3002").getYearCreditAmount();

		Amount y1403d = map.get("1403").getYearDebitAmount();
		Amount y1405d = map.get("1405").getYearDebitAmount();
		Amount y5401d = map.get("5401").getYearDebitAmount();
		Amount y5402d = map.get("5402").getYearDebitAmount();
		Amount y5403d = map.get("5403").getYearDebitAmount();
		Amount y2201d = map.get("2201").getYearDebitAmount();
		Amount y2202d = map.get("2202").getYearDebitAmount();
		Amount y1123d = map.get("1123").getYearDebitAmount();
		Amount y2221d = map.get("2221").getYearDebitAmount();
		Amount y222101d = map.get("222101").getYearDebitAmount();
		Amount y2211d = map.get("2211").getYearDebitAmount();
		Amount y560207d = map.get("560207").getYearDebitAmount();
		Amount y5711d = map.get("5711").getYearDebitAmount();
		Amount y5602d = map.get("5602").getYearDebitAmount();
		Amount y560206d = map.get("560206").getYearDebitAmount();
		Amount y560208d = map.get("560208").getYearDebitAmount();
		Amount y560212d = map.get("560212").getYearDebitAmount();
		Amount y1101d = map.get("1101").getYearDebitAmount();
		Amount y1501d = map.get("1501").getYearDebitAmount();
		Amount y1511d = map.get("1511").getYearDebitAmount();
		Amount y1601d = map.get("1601").getYearDebitAmount();
		Amount y1701d = map.get("1701").getYearDebitAmount();
		Amount y1604d = map.get("1604").getYearDebitAmount();
		Amount y1621d = map.get("1621").getYearDebitAmount();
		Amount y2001d = map.get("2001").getYearDebitAmount();
		Amount y2501d = map.get("2501").getYearDebitAmount();
		Amount y560306d = map.get("560306").getYearDebitAmount();
		Amount y2231d = map.get("2231").getYearDebitAmount();
		Amount y2232d = map.get("2232").getYearDebitAmount();

		CashFlowStatementRespDto dto1 = new CashFlowStatementRespDto();
		dto1.setSumAmount(a5001c.add(a1121c).add(a1122c).add(a2203c).add(a222101c));
		dto1.setSumYearAmount(y5001c.add(y1121c).add(y1122c).add(y2203c).add(y222101c));

		CashFlowStatementRespDto dto2 = new CashFlowStatementRespDto();
		dto2.setSumAmount(a5301c.add(a5051c));
		dto2.setSumYearAmount(y5301c.add(y5051c));

		CashFlowStatementRespDto dto3 = new CashFlowStatementRespDto();
		dto3.setSumAmount(a1403d.add(a1405d).add(a5401d).add(a5402d).add(a2201d).add(a2202d).add(a1123d).add(a222101d));
		dto3.setSumYearAmount(y1403d.add(y1405d).add(y5401d).add(y5402d).add(y2201d).add(y2202d).add(y1123d).add(y222101d));

		CashFlowStatementRespDto dto4 = new CashFlowStatementRespDto();
		dto4.setSumAmount(a2211d.add(a560207d));
		dto4.setSumYearAmount(y2211d.add(y560207d));

		CashFlowStatementRespDto dto5 = new CashFlowStatementRespDto();
		dto5.setSumAmount(a2221d.subtract(a222101d).add(a5403d));
		dto5.setSumYearAmount(y2221d.subtract(y222101d).add(y5403d));

		CashFlowStatementRespDto dto6 = new CashFlowStatementRespDto();
		dto6.setSumAmount(a5711d.add(a5602d).subtract(a560206d).subtract(a560208d).subtract(a560212d));
		dto6.setSumYearAmount(y5711d.add(y5602d).subtract(y560206d).subtract(y560208d).subtract(y560212d));

		CashFlowStatementRespDto dto7 = new CashFlowStatementRespDto();
		dto7.setSumAmount(dto1.getSumAmount().add(dto2.getSumAmount()).subtract(dto3.getSumAmount()).subtract(dto4.getSumAmount())
				.subtract(dto5.getSumAmount()).subtract(dto6.getSumAmount()));
		dto7.setSumYearAmount(dto1.getSumYearAmount().add(dto2.getSumYearAmount()).subtract(dto3.getSumYearAmount())
				.subtract(dto4.getSumYearAmount()).subtract(dto5.getSumYearAmount()).subtract(dto6.getSumYearAmount()));

		CashFlowStatementRespDto dto8 = new CashFlowStatementRespDto();
		dto8.setSumAmount(a1101c.add(a1501c).add(a1511c));
		dto8.setSumYearAmount(y1101c.add(y1501c).add(y1511c));

		CashFlowStatementRespDto dto9 = new CashFlowStatementRespDto();
		dto9.setSumAmount(a5111c.add(a1131c).add(a1132c));
		dto9.setSumYearAmount(y5111c.add(y1131c).add(y1132c));

		CashFlowStatementRespDto dto10 = new CashFlowStatementRespDto();
		dto10.setSumAmount(a1606c.add(a1701c).add(a1621c));
		dto10.setSumYearAmount(y1606c.add(y1701c).add(y1621c));

		CashFlowStatementRespDto dto11 = new CashFlowStatementRespDto();
		dto11.setSumAmount(a1101d.add(a1501d).add(a1511d));
		dto11.setSumYearAmount(a1101d.add(a1501d).add(a1511d));

		CashFlowStatementRespDto dto12 = new CashFlowStatementRespDto();
		dto12.setSumAmount(a1601d.add(a1701d).add(a1604d).add(a1621d));
		dto12.setSumYearAmount(y1601d.add(y1701d).add(y1604d).add(y1621d));

		CashFlowStatementRespDto dto13 = new CashFlowStatementRespDto();
		dto13.setSumAmount(dto8.getSumAmount().add(dto9.getSumAmount()).add(dto10.getSumAmount()).subtract(dto11.getSumAmount())
				.subtract(dto12.getSumAmount()));
		dto13.setSumYearAmount(dto8.getSumYearAmount().add(dto9.getSumYearAmount()).add(dto10.getSumYearAmount())
				.subtract(dto11.getSumYearAmount()).subtract(dto12.getSumYearAmount()));

		CashFlowStatementRespDto dto14 = new CashFlowStatementRespDto();
		dto14.setSumAmount(a2001c.add(a2501c));
		dto14.setSumYearAmount(y2001c.add(y2501c));

		CashFlowStatementRespDto dto15 = new CashFlowStatementRespDto();
		dto15.setSumAmount(a3001c.add(a3002c));
		dto15.setSumYearAmount(y3001c.add(y3002c));

		CashFlowStatementRespDto dto16 = new CashFlowStatementRespDto();
		dto16.setSumAmount(a2001d.add(a2501d));
		dto16.setSumYearAmount(y2001d.add(y2501d));

		CashFlowStatementRespDto dto17 = new CashFlowStatementRespDto();
		dto17.setSumAmount(a560306d.add(a2231d));
		dto17.setSumYearAmount(y560306d.add(y2231d));

		CashFlowStatementRespDto dto18 = new CashFlowStatementRespDto();
		dto18.setSumAmount(a2232d);
		dto18.setSumYearAmount(y2232d);

		CashFlowStatementRespDto dto19 = new CashFlowStatementRespDto();
		dto19.setSumAmount(dto14.getSumAmount().add(dto15.getSumAmount()).subtract(dto16.getSumAmount()).subtract(dto17.getSumAmount())
				.subtract(dto18.getSumAmount()));
		dto19.setSumYearAmount(dto14.getSumYearAmount().add(dto15.getSumYearAmount()).subtract(dto16.getSumYearAmount())
				.subtract(dto17.getSumYearAmount()).subtract(dto18.getSumYearAmount()));

		CashFlowStatementRespDto dto20 = new CashFlowStatementRespDto();
		dto20.setSumAmount(dto7.getSumAmount().add(dto13.getSumAmount()).add(dto19.getSumAmount()));
		dto20.setSumYearAmount(dto7.getSumYearAmount().add(dto13.getSumYearAmount()).add(dto19.getSumYearAmount()));

		CashFlowStatementRespDto dto21 = new CashFlowStatementRespDto();
		dto21.setSumAmount(map.get("1001").getOpeningBalance().add(map.get("1002").getOpeningBalance())
				.add(map.get("1012").getOpeningBalance()));
		dto21.setSumYearAmount(map.get("1001").getYearOpeningBalance().add(map.get("1002").getYearOpeningBalance())
				.add(map.get("1012").getYearOpeningBalance()));

		CashFlowStatementRespDto dto22 = new CashFlowStatementRespDto();
		dto22.setSumAmount(dto20.getSumAmount().add(dto21.getSumAmount()));
		dto22.setSumYearAmount(dto20.getSumYearAmount().add(dto21.getSumYearAmount()));

		ModelAndView mav = new ModelAndView("report/cashFlowStatement");
		mav.addObject("dto1", dto1);
		mav.addObject("dto2", dto2);
		mav.addObject("dto3", dto3);
		mav.addObject("dto4", dto4);
		mav.addObject("dto5", dto5);
		mav.addObject("dto6", dto6);
		mav.addObject("dto7", dto7);
		mav.addObject("dto8", dto8);
		mav.addObject("dto9", dto9);
		mav.addObject("dto10", dto10);
		mav.addObject("dto11", dto11);
		mav.addObject("dto12", dto12);
		mav.addObject("dto13", dto13);
		mav.addObject("dto14", dto14);
		mav.addObject("dto15", dto15);
		mav.addObject("dto16", dto16);
		mav.addObject("dto17", dto17);
		mav.addObject("dto18", dto18);
		mav.addObject("dto19", dto19);
		mav.addObject("dto20", dto20);
		mav.addObject("dto21", dto21);
		mav.addObject("dto22", dto22);
		// System.out.println(JSON.toJSONString(map));
		// mav.addObject("dto", map);
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
