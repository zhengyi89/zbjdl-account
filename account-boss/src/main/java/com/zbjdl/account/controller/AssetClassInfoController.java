package com.zbjdl.account.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zbjdl.account.controller.frame.AccountBaseController;
import com.zbjdl.account.dto.AssetClassInfoDto;
import com.zbjdl.account.dto.SubjectInfoDto;
import com.zbjdl.account.service.AssetClassInfoService;
import com.zbjdl.account.service.SubjectInfoService;

/**
 * AssetClassInfoController
 * 
 * @author code-generator
 * @date 2018-12-7 11:30:17 
 * 
 */
@Controller
@RequestMapping("assetClass")
public class AssetClassInfoController extends AccountBaseController {
	private static final Logger logger = LoggerFactory.getLogger(AssetClassInfoController.class);
	@Autowired
	private AssetClassInfoService assetClassInfoService;
	
	@Autowired
	private SubjectInfoService subjectInfoService;

	/*
	 * 列表页面
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView assetClassInfoIndex() {
		ModelAndView mav = new ModelAndView("assetClass/assetClassIndex");
		return mav;
	}

	/*
	 * 进入新增页面
	 */
	@RequestMapping(value = "/edit/index", method = RequestMethod.GET)
	public ModelAndView assetClassInfoEditIndex(Long id) {
		ModelAndView mav = new ModelAndView("assetClass/assetClassEdit");
		
		List<SubjectInfoDto> subjectList = subjectInfoService.findBySyscode(getCurrentSystemInfo().getSystemCode());
		mav.addObject("subjectList", subjectList);
		
		if (id != null) {
			AssetClassInfoDto assetClassInfoDto = assetClassInfoService.selectById(id);
			mav.addObject("dto", assetClassInfoDto);
		}
		return mav;
	}

	/*
	 * 编辑保存
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView assetClassInfoSave(AssetClassInfoDto assetClassInfoDto) {
		logger.info("save AssetClassInfo, param is : {}", JSON.toJSONString(assetClassInfoDto));
		assetClassInfoService.saveOrUpdate(assetClassInfoDto);
		ModelAndView mav = new ModelAndView("redirect:/assetClass/index");
		return mav;
	}

	/*
	 * 详情展示
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView assetClassInfoDetail(Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("assetClass/assetClassDetail");
		AssetClassInfoDto assetClassInfoDto = assetClassInfoService.selectById(id);
		mav.addObject("dto", assetClassInfoDto);
		return mav;
	}
	
	
	/*
	 * 详情展示
	 */
	@RequestMapping(value = "/selectByCode", method = RequestMethod.POST)
	@ResponseBody
	public Object selectByCode(String assetClassCode) {
		AssetClassInfoDto assetClassInfoDto = assetClassInfoService.assetClassCode(getCurrentSystemInfo().getSystemCode(), assetClassCode);
		return assetClassInfoDto;
	}
	
	/*
	 * 详情展示
	 */
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public ModelAndView delete(Long id) {
//		assetClassInfoService.delete(id);
//		ModelAndView mav = new ModelAndView("redirect:/assetClass/index");
//		return mav;
//	}
	
}
