package com.zbjdl.account.controller;

import java.util.Date;
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
import com.zbjdl.account.dto.AssistAccountSettleInfoDto;
import com.zbjdl.account.dto.SubjectInfoDto;
import com.zbjdl.account.dto.SystemInfoDto;
import com.zbjdl.account.dto.VoucherInfoDto;
import com.zbjdl.account.dto.VoucherSubInfoDto;
import com.zbjdl.account.dto.request.AccountSettleInfoSaveReqDto;
import com.zbjdl.account.dto.request.AccountSettleWithAssistSaveReqDto;
import com.zbjdl.account.dto.request.FindPreDeprecitionInfoReqDto;
import com.zbjdl.account.dto.response.AccountSettleCheckRespDto;
import com.zbjdl.account.dto.response.BaseRespDto;
import com.zbjdl.account.dto.response.TrialBalanceRespDto;
import com.zbjdl.account.enumtype.AccountSettleStatusEnum;
import com.zbjdl.account.enumtype.DataStatusEnum;
import com.zbjdl.account.enumtype.ReturnEnum;
import com.zbjdl.account.enumtype.SystemEnum;
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

		if (SystemEnum.DEBIT.getCode().equals(subjectInfo.getBalanceDirect())) {
			// 科目方向－借方，年初余额＝期初余额－（本年累积借方－本年累积贷方）
			accountSettleSaveReqDto.setYearOpeningBalance(accountSettleSaveReqDto.getOpeningBalance().subtract(
					accountSettleSaveReqDto.getYearDebitAmount().subtract(accountSettleSaveReqDto.getYearCreditAmount())));
		} else {
			// 科目方向－贷方，年初余额＝期初余额－（本年累积贷方－本年累积借方）
			accountSettleSaveReqDto.setYearOpeningBalance(accountSettleSaveReqDto.getOpeningBalance().subtract(
					accountSettleSaveReqDto.getYearCreditAmount().subtract(accountSettleSaveReqDto.getYearDebitAmount())));
		}

		// Amount amount =
		// AccountUtils.getRealAmount(subjectInfo.getBalanceDirect(),
		// accountSettleSaveReqDto.getYearDebitAmount(),
		// accountSettleSaveReqDto.getYearCreditAmount());
		// accountSettleSaveReqDto.setSumAmount(amount);
		accountSettleSaveReqDto.setAccountMonth(getCurrentSystemInfo().getStartMonth());

		// 设置年度累积
		// accountSettleSaveReqDto.setSumRemainAmount(amount);

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

		if (SystemEnum.DEBIT.getCode().equals(subjectInfo.getBalanceDirect())) {
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

			if (SystemEnum.DEBIT.getCode().equals(subjectInfo.getBalanceDirect())) {
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
		// saveDto.setSumRemainAmount(sumAmount);

		accountSettleInfoService.saveOrUpdate(saveDto);

		// 删除
		accountSettleInfoService.deleteChildren(saveDto.getId());
		for (AccountSettleInfoSaveReqDto accountSettleInfoSaveReqDto : accountSettleWithAssistSaveReqDto.getAccountSettleInfoSaveReqDto()) {
			accountSettleInfoSaveReqDto.setSumAmount(AccountUtils.getRealAmount(subjectInfo.getBalanceDirect(),
					accountSettleInfoSaveReqDto.getDebitAmount(), accountSettleInfoSaveReqDto.getCreditAmount()));
			accountSettleInfoSaveReqDto.setParentId(saveDto.getId());
			accountSettleInfoSaveReqDto.setAccountMonth(getCurrentSystemInfo().getStartMonth());

			AccountSettleInfoDto dto = new AccountSettleInfoDto();
			BeanUtils.copyProperties(accountSettleInfoSaveReqDto, dto);
			dto.setSubjectId(accountSettleWithAssistSaveReqDto.getSubjectId());
			dto.setClosingBalance(new Amount());
			dto.setYearCreditAmount(dto.getCreditAmount());
			dto.setYearDebitAmount(dto.getDebitAmount());
			dto.setSettleType(DataStatusEnum.INIT.getCode());
			accountSettleInfoService.saveOrUpdate(dto);
		}

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
		AccountSettleCheckRespDto baseRespDto = new AccountSettleCheckRespDto(ReturnEnum.SUCCESS);

		/*
		 * 1.凭证漏审
		 */
		// 查询当期所有凭证
		List<VoucherInfoDto> voucherList = voucherInfoService.findListByMonth(getCurrentSystemInfo().getSystemCode(),
				getCurrentSystemInfo().getAccountMonth());
		for (VoucherInfoDto voucherInfoDto : voucherList) {
			// 根据审核人id判断未审
			if (voucherInfoDto.getAuditorId() == null) {
				baseRespDto.setVoucherAuditFlag(false);
				baseRespDto.setCode(ReturnEnum.FAILD.getCode());
				break;
			}
		}
		/*
		 * 2.结转损益
		 */

		/*
		 * 3.资产负债表
		 */

		/*
		 * 4.凭证断号
		 */
		Integer serNum = 1;
		for (VoucherInfoDto voucherInfoDto : voucherList) {
			// 根据审核人id判断未审
			if (voucherInfoDto.getSerialNum() != serNum++) {
				baseRespDto.setVocherSerialNumFlag(false);
				baseRespDto.setCode(ReturnEnum.FAILD.getCode());
				break;
			}
		}
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
			// 重置 creditAmont 和 debitAmont 值
			accountSettleWithSubjectInfoDto.setCreditAmount(new Amount());
			accountSettleWithSubjectInfoDto.setDebitAmount(new Amount());
			map.put(accountSettleWithSubjectInfoDto.getSubjectCode(), accountSettleWithSubjectInfoDto);

			// 存在辅助核算
			if (StringUtils.isNotBlank(accountSettleWithSubjectInfoDto.getAssistAccount())) {
				List<AccountSettleWithSubjectInfoDto> list = accountSettleInfoService.findListByParentId(accountSettleWithSubjectInfoDto
						.getId());
				for (AccountSettleWithSubjectInfoDto assistAccountSettleInfoDto : list) {
					assistAccountSettleInfoDto.setParentId(accountSettleWithSubjectInfoDto.getId());
					map.put(accountSettleWithSubjectInfoDto.getSubjectCode() + "-" + assistAccountSettleInfoDto.getAssistCode(),
							assistAccountSettleInfoDto);
				}
			}
		}

		// 查询当月凭证
		List<VoucherSubInfoDto> voucherSubInfoDtos = voucherSubInfoService.findListByMonth(systemCode, getCurrentSystemInfo()
				.getAccountMonth());

		// 汇总凭证
		for (VoucherSubInfoDto voucherSubInfoDto : voucherSubInfoDtos) {
			AccountSettleWithSubjectInfoDto accountSettleInfoDto = map.get(voucherSubInfoDto.getSubjectCode());
			if (accountSettleInfoDto != null) {
				accountSettleInfoDto.setDebitAmount(accountSettleInfoDto.getDebitAmount().add(voucherSubInfoDto.getDebitAmount()));
				accountSettleInfoDto.setCreditAmount(accountSettleInfoDto.getCreditAmount().add(voucherSubInfoDto.getCreditAmount()));
			}

			// 如果是辅助核算, 汇总
			if (StringUtils.isNotBlank(voucherSubInfoDto.getAssistCode())) {
				AccountSettleWithSubjectInfoDto accountSettleInfoDto1 = map.get(voucherSubInfoDto.getSubjectCode() + "-"
						+ voucherSubInfoDto.getAssistCode());
				if (accountSettleInfoDto1 == null) {
					accountSettleInfoDto1 = new AccountSettleWithSubjectInfoDto();
					accountSettleInfoDto1.setParentId(accountSettleInfoDto.getId());
					accountSettleInfoDto1.setSubjectId(accountSettleInfoDto.getSubjectId());
					accountSettleInfoDto1.setAccountMonth(accountSettleInfoDto.getAccountMonth());
					accountSettleInfoDto1.amountInit();
					accountSettleInfoDto1.setDebitAmount(voucherSubInfoDto.getDebitAmount());
					accountSettleInfoDto1.setCreditAmount(voucherSubInfoDto.getCreditAmount());
					accountSettleInfoDto1.setAssistCode(voucherSubInfoDto.getAssistCode());
					map.put(accountSettleInfoDto.getSubjectCode() + "-" + voucherSubInfoDto.getAssistCode(), accountSettleInfoDto1);
				} else {
					accountSettleInfoDto1.setDebitAmount(accountSettleInfoDto1.getDebitAmount().add(voucherSubInfoDto.getDebitAmount()));
					accountSettleInfoDto1.setCreditAmount(accountSettleInfoDto1.getCreditAmount().add(voucherSubInfoDto.getCreditAmount()));
				}

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

			if (entry.getKey().indexOf("-") > 0) {
				System.out.println(11);
			}
			// TODO
			// TODO 待优化
			// TODO
			// 更新汇总结果
			accountSettleInfoService.saveOrUpdate(saveDto);

		}

		/*
		 * 2.切换记账月份
		 */
		// 如果是最新月份
		if (getCurrentSystemInfo().getAccountMonth().equals(getCurrentSystemInfo().getLatestMonth())) {

			// 更新系统最新记账月份到下月
			SystemInfoDto systemInfoDto = systemInfoService.selectById(getCurrentSystemInfo().getSystemId());

			String latestMonth = DateUtils.addMonth(systemInfoDto.getServerMonth(), 1);
			String prevMonth = systemInfoDto.getServerMonth();

			systemInfoDto.setServerMonth(latestMonth);
			systemInfoService.saveOrUpdate(systemInfoDto);

			// 更新最新记账月份缓存
			getCurrentSystemInfo().setLatestMonth(latestMonth);

			/*
			 * 3.初始化下月账单
			 */
			accountSettleInfoService.initSubjectOpening(systemCode, latestMonth);
			List<AccountSettleWithSubjectInfoDto> latestAccountSettleList = accountSettleInfoService.findListByMonth(systemCode,
					latestMonth);
			for (AccountSettleWithSubjectInfoDto latestAccountSettleWithSubjectDto : latestAccountSettleList) {
				// 查询上一个月结账记录
				// if
				// (accountSettleWithSubjectInfoDto.getSubjectId().equals(4798L))
				// {
				// System.out.println();
				// }
				AccountSettleInfoDto preAccountSettle = accountSettleInfoService.findBySubjectIdAndMonth(
						latestAccountSettleWithSubjectDto.getSubjectId(), prevMonth);
				if (preAccountSettle != null) {
					latestAccountSettleWithSubjectDto.setOpeningBalance(preAccountSettle.getClosingBalance());
					latestAccountSettleWithSubjectDto.setYearOpeningBalance(preAccountSettle.getYearOpeningBalance());
					latestAccountSettleWithSubjectDto.setYearCreditAmount(preAccountSettle.getYearCreditAmount().add(
							preAccountSettle.getCreditAmount()));
					latestAccountSettleWithSubjectDto.setYearDebitAmount(preAccountSettle.getYearDebitAmount().add(
							preAccountSettle.getDebitAmount()));
					if (StringUtils.isNotBlank(latestAccountSettleWithSubjectDto.getAssistAccount())) {
						// 查询辅助核算列表
						List<AccountSettleWithSubjectInfoDto> list = accountSettleInfoService.findListByParentId(preAccountSettle.getId());
						for (AccountSettleWithSubjectInfoDto accountSettleInfoDto : list) {
							AccountSettleWithSubjectInfoDto accountSettleInfoDto1 = new AccountSettleWithSubjectInfoDto();

							BeanUtils.copyProperties(accountSettleInfoDto, accountSettleInfoDto1);
							accountSettleInfoDto1.setId(null);
							accountSettleInfoDto1.setParentId(latestAccountSettleWithSubjectDto.getId());
							accountSettleInfoDto1.setAccountMonth(latestMonth);
							accountSettleInfoDto1.setDebitAmount(new Amount());
							accountSettleInfoDto1.setCreditAmount(new Amount());
							accountSettleInfoDto1.setClosingBalance(new Amount());
							accountSettleInfoDto1.setSumAmount(new Amount());
							accountSettleInfoDto1.setOpeningBalance(accountSettleInfoDto.getClosingBalance());
							accountSettleInfoDto1.setYearOpeningBalance(accountSettleInfoDto.getYearOpeningBalance());
							accountSettleInfoDto1.setYearCreditAmount(accountSettleInfoDto.getYearCreditAmount().add(
									accountSettleInfoDto.getCreditAmount()));
							accountSettleInfoDto1.setYearDebitAmount(accountSettleInfoDto.getYearDebitAmount().add(
									accountSettleInfoDto.getDebitAmount()));
							accountSettleInfoDto1.setStatus(DataStatusEnum.NORMAL.getCode());
							accountSettleInfoDto1.setCreateTime(new Date());
							accountSettleInfoDto1.setLastUpdateTime(new Date());
							accountSettleInfoService.saveOrUpdate(accountSettleInfoDto1);
						}
					}
					accountSettleInfoService.saveOrUpdate(latestAccountSettleWithSubjectDto);
				}
			}

			/*
			 * 3.1 生成折旧明细
			 */
			FindPreDeprecitionInfoReqDto reqDto = new FindPreDeprecitionInfoReqDto();
			reqDto.setDeprecitionMonth(getCurrentSystemInfo().getAccountMonth());
			reqDto.setSystemCode(getCurrentSystemInfo().getSystemCode());
			assetDeprecitionInfoService.doDeprecition(reqDto);

		} else { // 如果非最新月份

			String currMonth = getCurrentSystemInfo().getAccountMonth();
			String nextMonth = DateUtils.addMonth(currMonth, 1);
			// 查询当月到最新记账月期间所有结账记录，并更新
			while (!getCurrentSystemInfo().getLatestMonth().equals(nextMonth)) {
				List<AccountSettleWithSubjectInfoDto> nextSettleList = accountSettleInfoService.findListByMonth(systemCode, nextMonth);
				for (AccountSettleWithSubjectInfoDto nextSettleDto : nextSettleList) {
					// 查询月结账记录
					AccountSettleInfoDto currAccountSettle = accountSettleInfoService.findBySubjectIdAndMonth(nextSettleDto.getSubjectId(),
							currMonth);
					// 判断当前月的期末是否等于下月期初
					if (!nextSettleDto.getOpeningBalance().equals(currAccountSettle.getClosingBalance())
							|| !nextSettleDto.getYearDebitAmount().equals(
									currAccountSettle.getYearDebitAmount().add(currAccountSettle.getDebitAmount()))
							|| !nextSettleDto.getYearCreditAmount().equals(
									currAccountSettle.getYearCreditAmount().add(currAccountSettle.getCreditAmount()))) {
						nextSettleDto.setOpeningBalance(currAccountSettle.getClosingBalance());
						nextSettleDto.setYearCreditAmount(currAccountSettle.getYearCreditAmount().add(currAccountSettle.getCreditAmount()));
						nextSettleDto.setYearDebitAmount(currAccountSettle.getYearDebitAmount().add(currAccountSettle.getDebitAmount()));
						// 如果已结账，设置期末余额
						if (AccountSettleStatusEnum.SETTLE.getCode().equals(nextSettleDto.getStatus())) {
							nextSettleDto.setClosingBalance(nextSettleDto.getOpeningBalance().add(nextSettleDto.getSumAmount()));
						}
						accountSettleInfoService.saveOrUpdate(nextSettleDto);
					}

					if (StringUtils.isNotBlank(nextSettleDto.getAssistCode())) {
						// 先删除
//						accountSettleInfoService.deleteChildren(nextSettleDto.getId());
						// 查询辅助核算列表
						List<AccountSettleWithSubjectInfoDto> currList = accountSettleInfoService.findListByParentId(currAccountSettle.getId());
						for (AccountSettleWithSubjectInfoDto currAccountSettleInfoDto : currList) {
							
							AccountSettleInfoDto nextDto = accountSettleInfoService.findAssistRecord(currAccountSettleInfoDto.getSubjectId(), currAccountSettleInfoDto.getAssistCode(), nextMonth);
							
							nextDto.setOpeningBalance(currAccountSettleInfoDto.getClosingBalance());
							nextDto.setYearCreditAmount(currAccountSettleInfoDto.getYearCreditAmount().add(currAccountSettleInfoDto.getCreditAmount()));
							nextDto.setYearDebitAmount(currAccountSettleInfoDto.getYearDebitAmount().add(currAccountSettleInfoDto.getDebitAmount()));
							// 如果已结账，设置期末余额
							if (AccountSettleStatusEnum.SETTLE.getCode().equals(nextDto.getStatus())) {
								nextDto.setClosingBalance(nextDto.getOpeningBalance().add(nextDto.getSumAmount()));
							}
							nextDto.setLastUpdateTime(new Date());
							accountSettleInfoService.saveOrUpdate(nextDto);
						}
					}

				}
				currMonth = nextMonth;
				
				
				Boolean isSettle = accountSettleInfoService.isSettle(getCurrentSystemInfo().getSystemCode(), nextMonth);
				// 如果期间存在未结账，在当前月份停止更新
				if (!isSettle) {
					break;
				}
			}

		}

		// 更新缓存到最新月份
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
			if (SystemEnum.DEBIT.getCode().equals(accountSettleDto.getBalanceDirect())) {
				sumDebitOpeningAmount = sumDebitOpeningAmount.add(accountSettleDto.getOpeningBalance());
			} else {
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
