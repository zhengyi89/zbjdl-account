package com.zbjdl.account.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zbjdl.account.controller.frame.AccountBaseController;
import com.zbjdl.account.dto.AssetDeprecitionInfoDto;
import com.zbjdl.account.dto.AssistAccountInfoDto;
import com.zbjdl.account.dto.SubjectInfoDto;
import com.zbjdl.account.dto.VoucherInfoDto;
import com.zbjdl.account.dto.VoucherSubInfoDto;
import com.zbjdl.account.dto.request.FindPreDeprecitionInfoReqDto;
import com.zbjdl.account.dto.request.VoucherInfoSaveReqDto;
import com.zbjdl.account.dto.request.VoucherSaveDto;
import com.zbjdl.account.dto.request.VoucherSubInfoSaveReqDto;
import com.zbjdl.account.dto.request.VoucherTemplateSaveDto;
import com.zbjdl.account.dto.response.BaseRespDto;
import com.zbjdl.account.enumtype.AssetEnum;
import com.zbjdl.account.enumtype.DataStatusEnum;
import com.zbjdl.account.enumtype.MethodEnum;
import com.zbjdl.account.enumtype.ReturnEnum;
import com.zbjdl.account.enumtype.SystemEnum;
import com.zbjdl.account.enumtype.VoucherTypeEnum;
import com.zbjdl.account.service.AssetDeprecitionInfoService;
import com.zbjdl.account.service.AssistAccountInfoService;
import com.zbjdl.account.service.SubjectInfoService;
import com.zbjdl.account.service.VoucherInfoService;
import com.zbjdl.account.service.VoucherSubInfoService;
import com.zbjdl.account.util.AccountUtils;
import com.zbjdl.account.util.DateUtils;
import com.zbjdl.common.amount.Amount;
import com.zbjdl.common.utils.BeanUtils;
import com.zbjdl.common.utils.StringUtils;

/**
 * VoucherInfoController
 * 
 * @author code-generator
 * @date 2018-11-22 21:52:47
 * 
 */
@Controller
@RequestMapping("voucher")
public class VoucherInfoController extends AccountBaseController {
	private static final Logger logger = LoggerFactory.getLogger(VoucherInfoController.class);
	@Autowired
	private VoucherInfoService voucherInfoService;

	@Autowired
	private AssistAccountInfoService assistAccountInfoService;

	@Autowired
	private VoucherSubInfoService voucherSubInfoService;

	@Autowired
	private SubjectInfoService subjectInfoService;

	@Autowired
	private AssetDeprecitionInfoService assetDeprecitionInfoService;

	/*
	 * 列表页面
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("voucher/voucherIndex");

		return mav;
	}

	/*
	 * 进入新增页面
	 */
	@RequestMapping(value = "/edit/index", method = RequestMethod.GET)
	public ModelAndView editIndex(Long id) {
		ModelAndView mav = new ModelAndView("voucher/voucherEdit");
		VoucherSaveDto dto = new VoucherSaveDto();
		VoucherInfoDto voucherInfoDto = null;
		if (id != null) {
			voucherInfoDto = voucherInfoService.selectById(id);
			List<VoucherSubInfoDto> voucherSubInfoDtos = voucherSubInfoService.selectByVoucherId(id);
			BeanUtils.copyProperties(voucherInfoDto, dto);
			List<VoucherSubInfoSaveReqDto> list = new ArrayList<VoucherSubInfoSaveReqDto>();
			for (VoucherSubInfoDto voucherSubInfoDto : voucherSubInfoDtos) {
				VoucherSubInfoSaveReqDto voucherSubInfoSaveReqDto = new VoucherSubInfoSaveReqDto();
				BeanUtils.copyProperties(voucherSubInfoDto, voucherSubInfoSaveReqDto);
				// voucherSubInfoSaveReqDto.setCreditAmount(voucherSubInfoDto.getAmount());
				list.add(voucherSubInfoSaveReqDto);
			}
			dto.setVoucherSubInfoDtos(list);
		}

		if (id == null || (voucherInfoDto != null && voucherInfoDto.getTemplateFlag())) {
			// 新增凭证，默认当前日期
			dto.setAccountPeriod(DateUtils.getMonthLastDay(getCurrentSystemInfo().getAccountMonth()));
			dto.setVoucherPapers(0);
			Integer defSerialNum = voucherInfoService.selectDefaultSerialNum(getCurrentSystemInfo().getSystemCode(), getCurrentSystemInfo()
					.getAccountMonth());
			dto.setSerialNum(defSerialNum == null ? 1 : defSerialNum);
		}
		mav.addObject("dto", dto);
		List<SubjectInfoDto> subjectList = subjectInfoService.findBySyscode(getCurrentSystemInfo().getSystemCode());
		mav.addObject("subjectList", subjectList);
		return mav;
	}

	/*
	 * 进入新增页面
	 */
	@RequestMapping(value = "/editTemplateIndex", method = RequestMethod.GET)
	public ModelAndView editTemplateIndex(Long id) {
		ModelAndView mav = new ModelAndView("voucher/voucherTemplateEdit");
		VoucherSaveDto dto = new VoucherSaveDto();
		VoucherInfoDto voucherInfoDto = null;
		if (id != null) {
			voucherInfoDto = voucherInfoService.selectById(id);
			List<VoucherSubInfoDto> voucherSubInfoDtos = voucherSubInfoService.selectByVoucherId(id);
			BeanUtils.copyProperties(voucherInfoDto, dto);
			List<VoucherSubInfoSaveReqDto> list = new ArrayList<VoucherSubInfoSaveReqDto>();
			for (VoucherSubInfoDto voucherSubInfoDto : voucherSubInfoDtos) {
				VoucherSubInfoSaveReqDto voucherSubInfoSaveReqDto = new VoucherSubInfoSaveReqDto();
				BeanUtils.copyProperties(voucherSubInfoDto, voucherSubInfoSaveReqDto);
				// voucherSubInfoSaveReqDto.setCreditAmount(voucherSubInfoDto.getAmount());
				list.add(voucherSubInfoSaveReqDto);
			}
			dto.setVoucherSubInfoDtos(list);
		}

		mav.addObject("dto", dto);
		List<SubjectInfoDto> subjectList = subjectInfoService.findBySyscode(getCurrentSystemInfo().getSystemCode());
		mav.addObject("subjectList", subjectList);
		return mav;
	}

	/*
	 * 编辑保存
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(VoucherSaveDto dto, BindingResult bindingResult) {
		logger.info("save VoucherInfo, param is : {}", JSON.toJSONString(dto));
		ModelAndView mav = new ModelAndView("redirect:/voucher/index");

		VoucherInfoDto voucherInfoDto = new VoucherInfoDto();
		BeanUtils.copyProperties(dto, voucherInfoDto);
		voucherInfoDto.setSystemCode(getCurrentSystemInfo().getSystemCode());
		if (dto.getId() == null) {
			voucherInfoDto.setTemplateFlag(false);
			voucherInfoDto.setCreatorId(getCurrentUser().getUserId());
			voucherInfoDto.setCreatorName(getCurrentUser().getUserName());
		}

		Long voucherId = voucherInfoService.saveOrUpdate(voucherInfoDto);
		for (VoucherSubInfoSaveReqDto voucherSubInfoSaveReqDto : dto.getVoucherSubInfoDtos()) {
			if (!voucherSubInfoNullValid(voucherSubInfoSaveReqDto)) {
				voucherSubInfoSaveReqDto.setVoucherId(voucherId);
				// 根据余额方向，设置凭证金额
				Amount amount = AccountUtils.getRealAmount(voucherSubInfoSaveReqDto.getBalanceDirect(),
						voucherSubInfoSaveReqDto.getDebitAmount(), voucherSubInfoSaveReqDto.getCreditAmount());
				voucherSubInfoSaveReqDto.setAmount(amount);
				VoucherSubInfoDto voInfoDto = new VoucherSubInfoDto();
				BeanUtils.copyProperties(voucherSubInfoSaveReqDto, voInfoDto);
				voucherSubInfoService.saveOrUpdate(voInfoDto);
			}
		}

		return mav;
	}

	/*
	 * 模版保存
	 */
	@RequestMapping(value = "/saveTemplate", method = RequestMethod.POST)
	@ResponseBody
	public Object saveTemplate(VoucherTemplateSaveDto dto, BindingResult bindingResult) {
		logger.info("save VoucherTemplate, param is : {}", JSON.toJSONString(dto));
		BaseRespDto respDto = new BaseRespDto(ReturnEnum.SUCCESS);

		VoucherInfoDto voucherInfoDto = new VoucherInfoDto();
		BeanUtils.copyProperties(dto, voucherInfoDto);
		voucherInfoDto.setTemplateFlag(true);
		voucherInfoDto.setSystemCode(getCurrentSystemInfo().getSystemCode());
		voucherInfoDto.setCreatorId(getCurrentUser().getUserId());
		voucherInfoDto.setCreatorName(getCurrentUser().getUserName());
		voucherInfoDto.setVoucherType(VoucherTypeEnum.T.getCode());
		Long voucherId = voucherInfoService.saveOrUpdate(voucherInfoDto);
		for (VoucherSubInfoSaveReqDto voucherSubInfoSaveReqDto : dto.getVoucherSubInfoDtos()) {
			if (!voucherSubInfoNullValid(voucherSubInfoSaveReqDto)) {
				voucherSubInfoSaveReqDto.setVoucherId(voucherId);
				// 如果不需要设置金额，清空金额
				if (dto.getSaveAmount() == null || !dto.getSaveAmount()) {
					voucherSubInfoSaveReqDto.setCreditAmount(null);
					voucherSubInfoSaveReqDto.setDebitAmount(null);
				}
				VoucherSubInfoDto voucherSubInfoDto = new VoucherSubInfoDto();
				BeanUtils.copyProperties(voucherSubInfoSaveReqDto, voucherSubInfoDto);
				voucherSubInfoService.saveOrUpdate(voucherSubInfoDto);
			}
		}
		return respDto;
	}

	/**
	 * 判断凭证子表信息是否为空
	 * 
	 * @param voucherSubInfoSaveReqDto
	 * @return
	 */
	public Boolean voucherSubInfoNullValid(VoucherSubInfoSaveReqDto voucherSubInfoSaveReqDto) {
		return voucherSubInfoSaveReqDto.getId() == null && StringUtils.isBlank(voucherSubInfoSaveReqDto.getSubjectCode())
				&& StringUtils.isBlank(voucherSubInfoSaveReqDto.getSummary());
	}

	/*
	 * 详情展示
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detailIndex(Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("voucher/voucherDetail");
		VoucherInfoDto voucherInfoDto = voucherInfoService.selectById(id);
		mav.addObject("dto", voucherInfoDto);
		return mav;
	}

	/*
	 * 模版列表页面
	 */
	@RequestMapping(value = "/templateIndex", method = RequestMethod.GET)
	public ModelAndView templateIndex() {
		ModelAndView mav = new ModelAndView("voucher/voucherTemplateIndex");

		return mav;
	}

	/*
	 * 使用模版
	 */
	@RequestMapping(value = "/useTemplate", method = RequestMethod.GET)
	public ModelAndView useTemplate(Long id) {
		// ModelAndView mav = new ModelAndView("voucher/voucherTemplateIndex");
		return editIndex(id);
	}

	/*
	 * 模版列表页面
	 */
	@RequestMapping(value = "/operate", method = RequestMethod.GET)
	public ModelAndView templateIndex(Long id, String operate) {
		ModelAndView mav = new ModelAndView("redirect:/voucher/index");
		VoucherInfoDto voucherInfoDto = voucherInfoService.selectById(id);
		if (MethodEnum.AUDIT.getCode().equals(operate)) {
			voucherInfoDto.setAuditorId(getCurrentUser().getUserId());
			voucherInfoDto.setAuditorName(getCurrentUser().getUserName());
			voucherInfoDto.setStatus(DataStatusEnum.AUDITED.getCode());
		} else if (MethodEnum.UNAUDIT.getCode().equals(operate)) {
			voucherInfoDto.setAuditorId(null);
			voucherInfoDto.setAuditorName(null);
			voucherInfoDto.setStatus(DataStatusEnum.NORMAL.getCode());
		}
		voucherInfoService.saveOrUpdate(voucherInfoDto);
		return mav;

	}

	/*
	 * 期末凭证
	 */
	@RequestMapping(value = "/closingIndex", method = RequestMethod.GET)
	public ModelAndView subjectOpeningInfoIndex() {
		ModelAndView mav = new ModelAndView("voucher/voucherClosingIndex");
		return mav;
	}

	/*
	 * 生成期末凭证
	 */
	@RequestMapping(value = "/genClosing", method = RequestMethod.GET)
	public ModelAndView genClosing(Long id) {
		ModelAndView mav = new ModelAndView("voucher/voucherEdit");
		VoucherSaveDto dto = new VoucherSaveDto();
		VoucherInfoDto voucherInfoDto = voucherInfoService.selectById(id);
		List<VoucherSubInfoDto> voucherSubInfoDtos = voucherSubInfoService.selectByVoucherId(id);
		BeanUtils.copyProperties(voucherInfoDto, dto);
		List<VoucherSubInfoSaveReqDto> list = new ArrayList<VoucherSubInfoSaveReqDto>();
		for (VoucherSubInfoDto voucherSubInfoDto : voucherSubInfoDtos) {
			VoucherSubInfoSaveReqDto voucherSubInfoSaveReqDto = new VoucherSubInfoSaveReqDto();
			BeanUtils.copyProperties(voucherSubInfoDto, voucherSubInfoSaveReqDto);
			list.add(voucherSubInfoSaveReqDto);
		}
		dto.setVoucherSubInfoDtos(list);

		// 设置凭证默认
		dto.setAccountPeriod(DateUtils.getMonthLastDay(getCurrentSystemInfo().getAccountMonth()));
		dto.setVoucherPapers(0);
		Integer defSerialNum = voucherInfoService.selectDefaultSerialNum(getCurrentSystemInfo().getSystemCode(), getCurrentSystemInfo()
				.getAccountMonth());
		dto.setSerialNum(defSerialNum == null ? 1 : defSerialNum);

		/*
		 * 计算发生额
		 */
		// 计提固定资产折旧
		if (voucherInfoDto.getSerialNum() == 1) {
			Amount amount = new Amount();
			// 查询当期折旧列表
			FindPreDeprecitionInfoReqDto reqDto = new FindPreDeprecitionInfoReqDto();
			reqDto.setDeprecitionMonth(getCurrentSystemInfo().getAccountMonth());
			reqDto.setSystemCode(getCurrentSystemInfo().getSystemCode());
			reqDto.setCostType(AssetEnum.COST_TYPE_DEPRECITION.getCode());
			List<AssetDeprecitionInfoDto> deprecitionList = assetDeprecitionInfoService.findPreDeprecition(reqDto);
			for (AssetDeprecitionInfoDto assetDeprecitionInfoDto : deprecitionList) {
				amount = amount.add(assetDeprecitionInfoDto.getDeprecitionAmount());
			}
			// 设置金额
			for (VoucherSubInfoSaveReqDto saveDto : dto.getVoucherSubInfoDtos()) {
				if ("560202".equals(saveDto.getSubjectCode())) {
					saveDto.setDebitAmount(amount);
				} else if ("1602".equals(saveDto.getSubjectCode())) {
					saveDto.setCreditAmount(amount);
				}
			}

		} else if (voucherInfoDto.getSerialNum() == 2) {
			Amount amount = new Amount();
			// 查询当期摊销列表
			FindPreDeprecitionInfoReqDto reqDto = new FindPreDeprecitionInfoReqDto();
			reqDto.setDeprecitionMonth(getCurrentSystemInfo().getAccountMonth());
			reqDto.setSystemCode(getCurrentSystemInfo().getSystemCode());
			reqDto.setCostType(AssetEnum.COST_TYPE_EXPENSE.getCode());
			List<AssetDeprecitionInfoDto> deprecitionList = assetDeprecitionInfoService.findPreDeprecition(reqDto);
			for (AssetDeprecitionInfoDto assetDeprecitionInfoDto : deprecitionList) {
				amount = amount.add(assetDeprecitionInfoDto.getDeprecitionAmount());
			}
			// 设置金额
			dto.getVoucherSubInfoDtos().get(0).setDebitAmount(amount);
			dto.getVoucherSubInfoDtos().get(1).setCreditAmount(amount);

		}

		mav.addObject("dto", dto);
		List<SubjectInfoDto> subjectList = subjectInfoService.findBySyscode(getCurrentSystemInfo().getSystemCode());
		mav.addObject("subjectList", subjectList);
		return mav;
	}
}
