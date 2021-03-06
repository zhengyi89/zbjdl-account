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

import com.zbjdl.account.dto.DeprecitionDetailDto;
import com.zbjdl.account.service.DeprecitionDetailService;

/**
 * DeprecitionDetailController
 * 
 * @author code-generator
 * @date 2018-11-22 21:52:39 
 * 
 */
@Controller
@RequestMapping("deprecitionDetail")
public class DeprecitionDetailController{
	private static final Logger logger = LoggerFactory.getLogger(DeprecitionDetailController.class);
	@Autowired
	private DeprecitionDetailService deprecitionDetailService;

	/*
	 * 列表页面
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("deprecitionDetail/deprecitionDetailIndex");
		return mav;
	}

	/*
	 * 进入新增页面
	 */
	@RequestMapping(value = "/edit/index", method = RequestMethod.GET)
	public ModelAndView addIndex(Long id) {
		ModelAndView mav = new ModelAndView("deprecitionDetail/deprecitionDetailEdit");
		if (id != null) {
			DeprecitionDetailDto deprecitionDetailDto = deprecitionDetailService.selectById(id);
			mav.addObject("dto", deprecitionDetailDto);
		}
		return mav;
	}

	/*
	 * 编辑保存
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView editPartner(DeprecitionDetailDto deprecitionDetailDto) {
		logger.info("save DeprecitionDetail, param is : {}", JSON.toJSONString(deprecitionDetailDto));
		ModelAndView mav = new ModelAndView("deprecitionDetail/deprecitionDetailIndex");
		deprecitionDetailService.saveOrUpdate(deprecitionDetailDto);
		return mav;
	}

	/*
	 * 详情展示
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detailIndex(Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("deprecitionDetail/deprecitionDetailDetail");
		DeprecitionDetailDto deprecitionDetailDto = deprecitionDetailService.selectById(id);
		mav.addObject("dto", deprecitionDetailDto);
		return mav;
	}
	
}
