package com.zbjdl.account.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zbjdl.account.controller.frame.AccountBaseController;
import com.zbjdl.account.dto.AccountSettleInfoDto;
import com.zbjdl.account.dto.AccountSettleWithSubjectInfoDto;
import com.zbjdl.account.dto.AssistAccountInfoDto;
import com.zbjdl.account.dto.SubjectInfoDto;
import com.zbjdl.account.dto.SystemInfoDto;
import com.zbjdl.account.dto.VoucherSubInfoDto;
import com.zbjdl.account.dto.request.AccountSettleInfoSaveReqDto;
import com.zbjdl.account.dto.request.AccountSettleWithAssistSaveReqDto;
import com.zbjdl.account.dto.response.BaseRespDto;
import com.zbjdl.account.dto.response.TrialBalanceRespDto;
import com.zbjdl.account.enumtype.AccountSettleStatusEnum;
import com.zbjdl.account.enumtype.DataStatusEnum;
import com.zbjdl.account.enumtype.ReturnEnum;
import com.zbjdl.account.enumtype.SystemInfoEnum;
import com.zbjdl.account.service.AccountSettleInfoService;
import com.zbjdl.account.service.AssetDeprecitionInfoService;
import com.zbjdl.account.service.AssistAccountInfoService;
import com.zbjdl.account.service.SubjectInfoService;
import com.zbjdl.account.service.SystemInfoService;
import com.zbjdl.account.service.VoucherInfoService;
import com.zbjdl.account.service.VoucherSubInfoService;
import com.zbjdl.account.util.AccountUtils;
import com.zbjdl.account.util.DateUtils;
import com.zbjdl.common.amount.Amount;
import com.zbjdl.common.utils.BeanUtils;
import com.zbjdl.common.utils.StringUtils;
import com.zbjdl.common.utils.config.TextResource;

/**
 * AccountSettleInfoController
 * 
 * @author code-generator
 * @date 2018-12-18 16:34:22
 * 
 */
@Controller
@RequestMapping("accountSettle")
public class AccountSettleInfoController extends AccountBaseController {
	private static final Logger logger = LoggerFactory.getLogger(AccountSettleInfoController.class);
	@Autowired
	private AccountSettleInfoService accountSettleInfoService;

	@Autowired
	private SubjectInfoService subjectInfoService;

	@Autowired
	private AssistAccountInfoService assistAccountInfoService;

	@Autowired
	private SystemInfoService systemInfoService;

	@Autowired
	private VoucherInfoService voucherInfoService;

	@Autowired
	private VoucherSubInfoService voucherSubInfoService;
	
	@Autowired
	private AssetDeprecitionInfoService assetDeprecitionInfoService;

	/*
	 * 列表页面
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView accountSettleInfoIndex() {
		ModelAndView mav = new ModelAndView("accountSettle/accountSettleIndex");
		return mav;
	}

	/*
	 * 进入新增页面
	 */
	@RequestMapping(value = "/edit/index", method = RequestMethod.GET)
	public ModelAndView accountSettleInfoEditIndex(Long id) {
		ModelAndView mav = new ModelAndView("accountSettle/accountSettleEdit");
		if (id != null) {
			AccountSettleInfoDto accountSettleInfoDto = accountSettleInfoService.selectById(id);
			mav.addObject("dto", accountSettleInfoDto);
		}
		return mav;
	}
	
	/*
	 * 编辑保存
	 */
	@RequestMapping(value = "/saveSubjectOpening", method = RequestMethod.POST)
	public ModelAndView saveSubjectOpening(AccountSettleInfoSaveReqDto accountSettleSaveReqDto) {
		logger.info("save saveSubjectOpening, param is : {}", JSON.toJSONString(accountSettleSaveReqDto));

		// 根据subjectid查询
		SubjectInfoDto subjectInfo = subjectInfoService.selectById(accountSettleSaveReqDto.getSubjectId());

		if (SystemInfoEnum.DEBIT.getCode().equals(subjectInfo.getBalanceDirect())) {
			// 科目方向－借方，年初余额＝期初余额－（本年累积借方－本年累积贷方）
			accountSettleSaveReqDto.setYearOpeningBalance(accountSettleSaveReqDto.getOpeningBalance().subtract(
					accountSettleSaveReqDto.getYearDebitAmount().subtract(accountSettleSaveReqDto.getYearCreditAmount())));
		} else {
			// 科目方向－贷方，年初余额＝期初余额－（本年累积贷方－本年累积借方）
			accountSettleSaveReqDto.setYearOpeningBalance(accountSettleSaveReqDto.getOpeningBalance().subtract(
					accountSettleSaveReqDto.getYearCreditAmount().subtract(accountSettleSaveReqDto.getYearDebitAmount())));
		}

//		Amount amount = AccountUtils.getRealAmount(subjectInfo.getBalanceDirect(), accountSettleSaveReqDto.getYearDebitAmount(),
//				accountSettleSaveReqDto.getYearCreditAmount());
//		accountSettleSaveReqDto.setSumAmount(amount);
		accountSettleSaveReqDto.setAccountMonth(getCurrentSystemInfo().getStartMonth());

		// 设置年度累积
//		accountSettleSaveReqDto.setSumRemainAmount(amount);

		accountSettleSaveReqDto.setSettleType(DataStatusEnum.INIT.getCode());

		AccountSettleInfoDto dto = new AccountSettleInfoDto();
		BeanUtils.copyProperties(accountSettleSaveReqDto, dto);
		accountSettleInfoService.saveOrUpdate(dto);
		ModelAndView mav = new ModelAndView("redirect:/accountSettle/openingIndex");
		return mav;
	}

	/*
	 * 编辑保存
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView accountSettleInfoSave(AccountSettleInfoSaveReqDto accountSettleSaveReqDto) {
		logger.info("save AccountSettleInfo, param is : {}", JSON.toJSONString(accountSettleSaveReqDto));

		// 根据subjectid查询
		SubjectInfoDto subjectInfo = subjectInfoService.selectById(accountSettleSaveReqDto.getSubjectId());

		if (SystemInfoEnum.DEBIT.getCode().equals(subjectInfo.getBalanceDirect())) {
			// 科目方向－借方，年初余额＝期初余额－（本年累积借方－本年累积贷方）
			accountSettleSaveReqDto.setYearOpeningBalance(accountSettleSaveReqDto.getOpeningBalance().subtract(
					accountSettleSaveReqDto.getDebitAmount().subtract(accountSettleSaveReqDto.getCreditAmount())));
		} else {
			// 科目方向－贷方，年初余额＝期初余额－（本年累积贷方－本年累积借方）
			accountSettleSaveReqDto.setYearOpeningBalance(accountSettleSaveReqDto.getOpeningBalance().subtract(
					accountSettleSaveReqDto.getCreditAmount().subtract(accountSettleSaveReqDto.getDebitAmount())));
		}

		Amount amount = AccountUtils.getRealAmount(subjectInfo.getBalanceDirect(), accountSettleSaveReqDto.getDebitAmount(),
				accountSettleSaveReqDto.getCreditAmount());
		accountSettleSaveReqDto.setSumAmount(amount);
		accountSettleSaveReqDto.setAccountMonth(getCurrentSystemInfo().getStartMonth());

		// 设置年度累积
		accountSettleSaveReqDto.setYearCreditAmount(accountSettleSaveReqDto.getCreditAmount());
		accountSettleSaveReqDto.setYearDebitAmount(accountSettleSaveReqDto.getDebitAmount());
		accountSettleSaveReqDto.setSumRemainAmount(amount);

		accountSettleSaveReqDto.setStatus(DataStatusEnum.INIT.getCode());

		AccountSettleInfoDto dto = new AccountSettleInfoDto();
		BeanUtils.copyProperties(accountSettleSaveReqDto, dto);
		accountSettleInfoService.saveOrUpdate(dto);
		ModelAndView mav = new ModelAndView("redirect:/accountSettle/openingIndex");
		return mav;
	}

	/*
	 * 编辑保存－带辅助核算
	 */
	@RequestMapping(value = "/saveWithAssist", method = RequestMethod.POST)
	@ResponseBody
	public Object accountSettleWithAssistSave(@RequestBody AccountSettleWithAssistSaveReqDto accountSettleWithAssistSaveReqDto) {
		logger.info("save AccountSettleInfo, param is : {}", JSON.toJSONString(accountSettleWithAssistSaveReqDto));

		// 根据subjectid查询
		SubjectInfoDto subjectInfo = subjectInfoService.selectById(accountSettleWithAssistSaveReqDto.getSubjectId());

		Amount sumDebitAmount = new Amount();
		Amount sumCreditAmount = new Amount();
		Amount sumOpeningBalance = new Amount();
		Amount sumYearOpeningBalance = new Amount();

		for (AccountSettleInfoSaveReqDto accountSettleInfoSaveReqDto : accountSettleWithAssistSaveReqDto.getAccountSettleInfoSaveReqDto()) {
			sumDebitAmount = sumDebitAmount.add(accountSettleInfoSaveReqDto.getDebitAmount());
			sumCreditAmount = sumCreditAmount.add(accountSettleInfoSaveReqDto.getCreditAmount());
			sumOpeningBalance = sumOpeningBalance.add(accountSettleInfoSaveReqDto.getOpeningBalance());

			if (SystemInfoEnum.DEBIT.getCode().equals(subjectInfo.getBalanceDirect())) {
				// 科目方向－借方，年初余额＝期初余额－（本年累积借方－本年累积贷方）
				accountSettleInfoSaveReqDto.setYearOpeningBalance(accountSettleInfoSaveReqDto.getOpeningBalance().subtract(
						accountSettleInfoSaveReqDto.getDebitAmount().subtract(accountSettleInfoSaveReqDto.getCreditAmount())));
			} else {
				// 科目方向－贷方，年初余额＝期初余额－（本年累积贷方－本年累积借方）
				accountSettleInfoSaveReqDto.setYearOpeningBalance(accountSettleInfoSaveReqDto.getOpeningBalance().subtract(
						accountSettleInfoSaveReqDto.getCreditAmount().subtract(accountSettleInfoSaveReqDto.getDebitAmount())));
			}

			sumYearOpeningBalance = sumYearOpeningBalance.add(accountSettleInfoSaveReqDto.getYearOpeningBalance());
		}

		// 计算实际累积金额
		Amount sumAmount = AccountUtils.getRealAmount(subjectInfo.getBalanceDirect(), sumDebitAmount, sumCreditAmount);

		AccountSettleInfoDto saveDto = new AccountSettleInfoDto();

		saveDto.setId(accountSettleWithAssistSaveReqDto.getId());
		saveDto.setSubjectId(accountSettleWithAssistSaveReqDto.getSubjectId());
		saveDto.setCreditAmount(sumCreditAmount);
		saveDto.setDebitAmount(sumDebitAmount);
		saveDto.setOpeningBalance(sumOpeningBalance);
		saveDto.setSumAmount(sumAmount);
		saveDto.setYearOpeningBalance(sumYearOpeningBalance);
		saveDto.setAccountMonth(getCurrentSystemInfo().getStartMonth());
		saveDto.setExtend(JSON.toJSONString(accountSettleWithAssistSaveReqDto.getAccountSettleInfoSaveReqDto()));

		// 设置年度累积
		saveDto.setYearCreditAmount(sumCreditAmount);
		saveDto.setYearDebitAmount(sumDebitAmount);
		saveDto.setSumRemainAmount(sumAmount);

		accountSettleInfoService.saveOrUpdate(saveDto);

		BaseRespDto respDto = new BaseRespDto(ReturnEnum.SUCCESS);

		return respDto;
	}

	/*
	 * 详情展示
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView accountSettleInfoDetail(Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("accountSettle/accountSettleDetail");
		AccountSettleInfoDto accountSettleInfoDto = accountSettleInfoService.selectById(id);
		mav.addObject("dto", accountSettleInfoDto);
		return mav;
	}

	/*
	 * 科目期初
	 */
	@RequestMapping(value = "/openingIndex", method = RequestMethod.GET)
	public ModelAndView subjectOpeningInfoIndex() {
		ModelAndView mav = new ModelAndView("accountSettle/subjectOpeningIndex");
		return mav;
	}

	/*
	 * 设置科目期初页面
	 */
	@RequestMapping(value = "/subjectOpeningEdit/index", method = RequestMethod.GET)
	public ModelAndView subjectOpeningEditIndex(Long id, Long subjectId) {
		// 查询科目信息
		SubjectInfoDto subjectInfoDto = subjectInfoService.selectById(subjectId);
		ModelAndView mav;
		if (StringUtils.isBlank(subjectInfoDto.getAssistAccount())) {
			mav = new ModelAndView("accountSettle/subjectOpeningEdit");
		} else {
			mav = new ModelAndView("accountSettle/subjectOpeningWithAssistEdit");
			mav.addObject("subject", subjectInfoDto);
			List<AssistAccountInfoDto> assistAccountInfoDtos = assistAccountInfoService.findByAssistType(getCurrentSystemInfo()
					.getSystemCode(), subjectInfoDto.getAssistAccount());
			mav.addObject("assistList", assistAccountInfoDtos);
			mav.addObject("_textResource", new TextResource());
		}

		AccountSettleInfoDto accountSettleInfoDto;
		if (id != null) {
			accountSettleInfoDto = accountSettleInfoService.selectById(id);
		} else {
			accountSettleInfoDto = new AccountSettleInfoDto();
			accountSettleInfoDto.setSubjectId(subjectId);
		}
		mav.addObject("dto", accountSettleInfoDto);
		// JSONArray array = JSONArray.fromObject();
		com.alibaba.fastjson.JSONArray jsonObject = com.alibaba.fastjson.JSONArray.parseArray(accountSettleInfoDto.getExtend());
		mav.addObject("items", jsonObject);

		return mav;
	}

	/*
	 * 期末凭证
	 */
	@RequestMapping(value = "/closingIndex", method = RequestMethod.GET)
	public ModelAndView closingIndex() {
		ModelAndView mav = new ModelAndView("accountSettle/closingIndex");
		return mav;
	}

	/*
	 * 期末凭证
	 */
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	@ResponseBody
	public Object check() {
		BaseRespDto baseRespDto = new BaseRespDto(ReturnEnum.SUCCESS);

		// 1.凭证漏审
		// 2.结转损益
		// 3.资产负债表
		// 4.凭证断号
		// 5.计提固定资产折旧

		// 1.往来挂账
		// 2.库存现金
		// 3.银行存款
		// 4.原材料
		// 5.库存商品
		// 6.长期待摊费用
		return baseRespDto;
	}

	/*
	 * 结账
	 */
	@RequestMapping(value = "/settle", method = RequestMethod.GET)
	@ResponseBody
	public Object settle() {
		BaseRespDto baseRespDto = new BaseRespDto(ReturnEnum.SUCCESS);
		String systemCode = getCurrentSystemInfo().getSystemCode();

		/*
		 * 1. 当月汇总
		 */
		Map<String, AccountSettleWithSubjectInfoDto> map = new HashMap<String, AccountSettleWithSubjectInfoDto>();
		List<AccountSettleWithSubjectInfoDto> AccountSettleWithSubjectInfoDtoList = accountSettleInfoService.findListByMonth(systemCode,
				getCurrentSystemInfo().getAccountMonth());
		for (AccountSettleWithSubjectInfoDto accountSettleWithSubjectInfoDto : AccountSettleWithSubjectInfoDtoList) {
			map.put(accountSettleWithSubjectInfoDto.getSubjectCode(), accountSettleWithSubjectInfoDto);
		}

		// 查询当月凭证
		List<VoucherSubInfoDto> voucherSubInfoDtos = voucherSubInfoService.findListByMonth(systemCode, getCurrentSystemInfo()
				.getAccountMonth());

		// 汇总凭证
		for (VoucherSubInfoDto voucherSubInfoDto : voucherSubInfoDtos) {
			AccountSettleWithSubjectInfoDto accountSettleInfoDto = map.get(voucherSubInfoDto.getSubjectCode());
			if (accountSettleInfoDto!=null) {
				accountSettleInfoDto.setDebitAmount(accountSettleInfoDto.getDebitAmount().add(voucherSubInfoDto.getDebitAmount()));
				accountSettleInfoDto.setCreditAmount(accountSettleInfoDto.getCreditAmount().add(voucherSubInfoDto.getCreditAmount()));
			}
		}

		for (Map.Entry<String, AccountSettleWithSubjectInfoDto> entry : map.entrySet()) {
			AccountSettleWithSubjectInfoDto ad = entry.getValue();
			// 计算汇总
			ad.setSumAmount(AccountUtils.getRealAmount(ad.getBalanceDirect(), ad.getDebitAmount(), ad.getCreditAmount()));
			ad.setClosingBalance(ad.getOpeningBalance().add(ad.getSumAmount()));

			AccountSettleInfoDto saveDto = new AccountSettleInfoDto();
			BeanUtils.copyProperties(ad, saveDto);
			saveDto.setStatus(AccountSettleStatusEnum.SETTLE.getCode());
			accountSettleInfoService.saveOrUpdate(saveDto);

		}

		/*
		 * 2.切换记账月份
		 */
		// getCurrentSystemInfo().set
		// 如果是最新月份
		if (getCurrentSystemInfo().getAccountMonth().equals(getCurrentSystemInfo().getLatestMonth())) {
			SystemInfoDto systemInfoDto = systemInfoService.selectById(getCurrentSystemInfo().getSystemId());

			String latestMonth = DateUtils.addMonth(systemInfoDto.getServerMonth(), 1);
			String prevMonth = systemInfoDto.getServerMonth();

			systemInfoDto.setServerMonth(latestMonth);
			systemInfoService.saveOrUpdate(systemInfoDto);

//			getCurrentSystemInfo().setAccountMonth(latestMonth);
//			getCurrentSystemInfo().setLatestMonth(latestMonth);
			/*
			 * 3.创建初始分录
			 */
			accountSettleInfoService.initSubjectOpening(systemCode, latestMonth);
			List<AccountSettleWithSubjectInfoDto> initAccountSettleList = accountSettleInfoService.findListByMonth(systemCode, latestMonth);
			for (AccountSettleWithSubjectInfoDto accountSettleWithSubjectInfoDto : initAccountSettleList) {
				// 查询上一个月结账记录
				AccountSettleInfoDto preAccountSettle = accountSettleInfoService.findInitBySubjectAndMonth(
						accountSettleWithSubjectInfoDto.getSubjectId(), prevMonth);
				if (preAccountSettle!=null) {
					accountSettleWithSubjectInfoDto.setOpeningBalance(preAccountSettle.getClosingBalance());
					accountSettleWithSubjectInfoDto.setYearOpeningBalance(preAccountSettle.getYearOpeningBalance());
					accountSettleWithSubjectInfoDto.setYearCreditAmount(preAccountSettle.getYearCreditAmount().add(
							preAccountSettle.getCreditAmount()));
					accountSettleWithSubjectInfoDto.setYearDebitAmount(preAccountSettle.getYearDebitAmount().add(
							preAccountSettle.getDebitAmount()));
				}
			}

		} else { // 如果非最新月份

			String currMonth = getCurrentSystemInfo().getAccountMonth();
			// 查询当月到最新记账月期间所有结账记录，并更新
			while (!getCurrentSystemInfo().getLatestMonth().equals(currMonth)) {
				String nextMonth = DateUtils.addMonth(currMonth, 1);
				List<AccountSettleWithSubjectInfoDto> settleList = accountSettleInfoService.findListByMonth(systemCode, nextMonth);
				for (AccountSettleWithSubjectInfoDto settleDto : settleList) {
					// 查询月结账记录
					AccountSettleInfoDto accountSettle = accountSettleInfoService.findInitBySubjectAndMonth(settleDto.getSubjectId(),
							currMonth);
					// 判断当前月的期末是否等于下月期初
					if (!settleDto.getOpeningBalance().equals(accountSettle.getClosingBalance())
							|| !settleDto.getDebitAmount().equals(accountSettle.getYearDebitAmount().add(accountSettle.getDebitAmount()))) {
						settleDto.setOpeningBalance(accountSettle.getClosingBalance());
						settleDto.setYearCreditAmount(accountSettle.getYearCreditAmount().add(accountSettle.getCreditAmount()));
						settleDto.setYearDebitAmount(accountSettle.getYearDebitAmount().add(accountSettle.getDebitAmount()));
						// 如果已结账，设置期末余额
						if (AccountSettleStatusEnum.SETTLE.getCode().equals(settleDto.getStatus())) {
							settleDto.setClosingBalance(settleDto.getOpeningBalance().add(settleDto.getSumAmount()));
						}
						accountSettleInfoService.saveOrUpdate(settleDto);
					}
					
				}
				currMonth = nextMonth;
			}

		}

		// 生成折旧明细
		assetDeprecitionInfoService.doDeprecition(getCurrentSystemInfo().getSystemCode(), getCurrentSystemInfo().getAccountMonth());
		
		// 切换到最新月份
		getCurrentSystemInfo().setAccountMonth(getCurrentSystemInfo().getLatestMonth());

		return baseRespDto;
	}

	/*
	 * 期末凭证
	 */
	@RequestMapping(value = "/trialBalance", method = RequestMethod.GET)
	@ResponseBody
	public Object trialBalance() {
		TrialBalanceRespDto baseRespDto = new TrialBalanceRespDto(ReturnEnum.SUCCESS);

		List<AccountSettleWithSubjectInfoDto> dtoList = accountSettleInfoService.findInitBySystemCode(getCurrentSystemInfo()
				.getSystemCode());
		Amount sumDebitOpeningAmount = new Amount();
		Amount sumCreditOpeningAmount = new Amount();
		Amount sumYearDebitAmount = new Amount();
		Amount sumYearCreditAmount = new Amount();

		for (AccountSettleWithSubjectInfoDto accountSettleDto : dtoList) {
			if (SystemInfoEnum.DEBIT.getCode().equals(accountSettleDto.getBalanceDirect())) {
				sumDebitOpeningAmount = sumDebitOpeningAmount.add(accountSettleDto.getOpeningBalance());
			}else {
				if (!accountSettleDto.getOpeningBalance().isZero()) {
					System.out.println(accountSettleDto.getOpeningBalance());
				}
				sumCreditOpeningAmount = sumCreditOpeningAmount.add(accountSettleDto.getOpeningBalance());
			}
			sumYearCreditAmount = sumYearCreditAmount.add(accountSettleDto.getYearCreditAmount());
			sumYearDebitAmount = sumYearDebitAmount.add(accountSettleDto.getYearDebitAmount());
		}

		// 如果是前面的月份，选择结账区间
		baseRespDto.setSumCreditOpeningAmount(sumCreditOpeningAmount);
		baseRespDto.setSumDebitOpeningAmount(sumDebitOpeningAmount);
		baseRespDto.setSumYearCreditAmount(sumYearCreditAmount);
		baseRespDto.setSumYearDebitAmount(sumYearDebitAmount);

		return baseRespDto;
	}

}
