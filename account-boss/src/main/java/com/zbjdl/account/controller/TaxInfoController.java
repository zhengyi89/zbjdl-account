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

import com.zbjdl.account.dto.TaxInfoDto;
import com.zbjdl.account.service.TaxInfoService;

/**
 * TaxInfoController
 * 
 * @author code-generator
 * @date 2018-11-22 21:52:45 
 * 
 */
@Controller
@RequestMapping("tax")
public class TaxInfoController{
	private static final Logger logger = LoggerFactory.getLogger(TaxInfoController.class);
	@Autowired
	private TaxInfoService taxInfoService;

	/*
	 * 列表页面
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("tax/taxIndex");
		return mav;
	}

	/*
	 * 进入新增页面
	 */
	@RequestMapping(value = "/edit/index", method = RequestMethod.GET)
	public ModelAndView addIndex(Long id) {
		ModelAndView mav = new ModelAndView("tax/taxEdit");
		if (id != null) {
			TaxInfoDto taxInfoDto = taxInfoService.selectById(id);
			mav.addObject("dto", taxInfoDto);
		}
		return mav;
	}

	/*
	 * 编辑保存
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView editPartner(TaxInfoDto taxInfoDto) {
		logger.info("save TaxInfo, param is : {}", JSON.toJSONString(taxInfoDto));
		ModelAndView mav = new ModelAndView("tax/taxIndex");
		taxInfoService.saveOrUpdate(taxInfoDto);
		return mav;
	}

	/*
	 * 详情展示
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detailIndex(Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("tax/taxDetail");
		TaxInfoDto taxInfoDto = taxInfoService.selectById(id);
		mav.addObject("dto", taxInfoDto);
		return mav;
	}
	
}
