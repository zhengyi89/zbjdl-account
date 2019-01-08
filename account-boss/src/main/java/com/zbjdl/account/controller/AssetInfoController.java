package com.zbjdl.account.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zbjdl.account.controller.frame.AccountBaseController;
import com.zbjdl.account.dto.AssetClassInfoDto;
import com.zbjdl.account.dto.AssetInfoDto;
import com.zbjdl.account.dto.AssistAccountInfoDto;
import com.zbjdl.account.dto.SubjectInfoDto;
import com.zbjdl.account.enumtype.AssetEnum;
import com.zbjdl.account.enumtype.AssistAccountTypeEnum;
import com.zbjdl.account.enumtype.DataStatusEnum;
import com.zbjdl.account.service.AssetClassInfoService;
import com.zbjdl.account.service.AssetDeprecitionInfoService;
import com.zbjdl.account.service.AssetInfoService;
import com.zbjdl.account.service.AssistAccountInfoService;
import com.zbjdl.account.service.SubjectInfoService;

/**
 * AssetInfoController
 * 
 * @author code-generator
 * @date 2018-12-7 11:30:18
 * 
 */
@Controller
@RequestMapping("asset")
public class AssetInfoController extends AccountBaseController {
	private static final Logger logger = LoggerFactory.getLogger(AssetInfoController.class);
	@Autowired
	private AssetInfoService assetInfoService;

	@Autowired
	private SubjectInfoService subjectInfoService;

	@Autowired
	private AssetClassInfoService assetClassInfoService;

	@Autowired
	private AssistAccountInfoService assistAccountInfoService;
	
	@Autowired
	private AssetDeprecitionInfoService assetDeprecitionInfoService;

	/*
	 * 列表页面
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView assetInfoIndex() {
		ModelAndView mav = new ModelAndView("asset/assetIndex");
		return mav;
	}

	/*
	 * 进入新增页面
	 */
	@RequestMapping(value = "/edit/index", method = RequestMethod.GET)
	public ModelAndView assetInfoEditIndex(Long id, String costType) {

		String pageIndex;
		if (AssetEnum.COST_TYPE_DEPRECITION.getCode().equals(costType)) {
			pageIndex = "/asset/assetEdit";
		} else {
			pageIndex = "/asset/assetCostEdit";
		}

		ModelAndView mav = new ModelAndView(pageIndex);

		if (id != null) {
			AssetInfoDto assetInfoDto = assetInfoService.selectById(id);
			mav.addObject("dto", assetInfoDto);
		}

		List<SubjectInfoDto> subjectList = subjectInfoService.findBySyscode(getCurrentSystemInfo().getSystemCode());
		mav.addObject("subjectList", subjectList);

		List<AssetClassInfoDto> assetClassList = assetClassInfoService.findByDeprecitionType(getCurrentSystemInfo().getSystemCode(),
				costType);
		mav.addObject("assetClassList", assetClassList);

		List<AssistAccountInfoDto> assistAccountInfoDtos = assistAccountInfoService.findByAssistType(
				getCurrentSystemInfo().getSystemCode(), AssistAccountTypeEnum.DEPARTMENT.getCode());
		mav.addObject("departmentList", assistAccountInfoDtos);

		return mav;
	}

	/*
	 * 编辑保存
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView assetInfoSave(AssetInfoDto assetInfoDto, BindingResult bindingResult) {
		assetInfoDto.setSystemCode(getCurrentSystemInfo().getSystemCode());
		logger.info("save AssetInfo, param is : {}", JSON.toJSONString(assetInfoDto));
		assetInfoDto = assetInfoService.saveOrUpdate(assetInfoDto);
		String pageIndex;
		if (AssetEnum.COST_TYPE_DEPRECITION.getCode().equals(assetInfoDto.getCostType())) {
			pageIndex = "/asset/index";
		} else {
			pageIndex = "/asset/cost/index";
		}
		assetInfoDto.setStatus(AssetEnum.STATUS_USING.getCode());
		// 预生成折旧明细
		assetDeprecitionInfoService.genDeprecitionRecord(assetInfoDto);
		
		ModelAndView mav = new ModelAndView("redirect:" + pageIndex);
		return mav;
	}

	/*
	 * 详情展示
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView assetInfoDetail(Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("asset/assetDetail");
		AssetInfoDto assetInfoDto = assetInfoService.selectById(id);
		mav.addObject("dto", assetInfoDto);
		return mav;
	}

	/*
	 * 列表页面
	 */
	@RequestMapping(value = "/cost/index", method = RequestMethod.GET)
	public ModelAndView assetInfoCostIndex() {
		ModelAndView mav = new ModelAndView("asset/assetCostIndex");
		return mav;
	}
}
