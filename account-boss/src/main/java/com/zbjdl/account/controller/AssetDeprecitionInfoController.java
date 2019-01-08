package com.zbjdl.account.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import com.zbjdl.account.dto.AssetDeprecitionInfoDto;
import com.zbjdl.account.service.AssetDeprecitionInfoService;

/**
 * AssetDeprecitionInfoController
 * 
 * @author code-generator
 * @date 2019-1-7 16:00:34 
 * 
 */
@Controller
@RequestMapping("assetDeprecition")
public class AssetDeprecitionInfoController{
	private static final Logger logger = LoggerFactory.getLogger(AssetDeprecitionInfoController.class);
	@Autowired
	private AssetDeprecitionInfoService assetDeprecitionInfoService;

	/*
	 * 列表页面
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView assetDeprecitionInfoIndex() {
		ModelAndView mav = new ModelAndView("asset/assetDeprecitionIndex");
		return mav;
	}

	/*
	 * 进入新增页面
	 */
	@RequestMapping(value = "/edit/index", method = RequestMethod.GET)
	public ModelAndView assetDeprecitionInfoEditIndex(Long id) {
		ModelAndView mav = new ModelAndView("assetDeprecition/assetDeprecitionEdit");
		if (id != null) {
			AssetDeprecitionInfoDto assetDeprecitionInfoDto = assetDeprecitionInfoService.selectById(id);
			mav.addObject("dto", assetDeprecitionInfoDto);
		}
		return mav;
	}

	/*
	 * 编辑保存
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView assetDeprecitionInfoSave(AssetDeprecitionInfoDto assetDeprecitionInfoDto) {
		logger.info("save AssetDeprecitionInfo, param is : {}", JSON.toJSONString(assetDeprecitionInfoDto));
		assetDeprecitionInfoService.saveOrUpdate(assetDeprecitionInfoDto);
		ModelAndView mav = new ModelAndView("redirect:/assetDeprecition/index");
		return mav;
	}

	/*
	 * 详情展示
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView assetDeprecitionInfoDetail(Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("assetDeprecition/assetDeprecitionDetail");
		AssetDeprecitionInfoDto assetDeprecitionInfoDto = assetDeprecitionInfoService.selectById(id);
		mav.addObject("dto", assetDeprecitionInfoDto);
		return mav;
	}
	
	
}
