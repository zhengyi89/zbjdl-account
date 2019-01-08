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

import com.zbjdl.account.dto.InvoiceInfoDto;
import com.zbjdl.account.service.InvoiceInfoService;

/**
 * InvoiceInfoController
 * 
 * @author code-generator
 * @date 2018-11-22 21:52:40 
 * 
 */
@Controller
@RequestMapping("invoice")
public class InvoiceInfoController{
	private static final Logger logger = LoggerFactory.getLogger(InvoiceInfoController.class);
	@Autowired
	private InvoiceInfoService invoiceInfoService;

	/*
	 * 列表页面
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("invoice/invoiceIndex");
		return mav;
	}

	/*
	 * 进入新增页面
	 */
	@RequestMapping(value = "/edit/index", method = RequestMethod.GET)
	public ModelAndView addIndex(Long id) {
		ModelAndView mav = new ModelAndView("invoice/invoiceEdit");
		if (id != null) {
			InvoiceInfoDto invoiceInfoDto = invoiceInfoService.selectById(id);
			mav.addObject("dto", invoiceInfoDto);
		}
		return mav;
	}

	/*
	 * 编辑保存
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(InvoiceInfoDto invoiceInfoDto) {
		logger.info("save InvoiceInfo, param is : {}", JSON.toJSONString(invoiceInfoDto));
		ModelAndView mav = new ModelAndView("invoice/invoiceIndex");
		invoiceInfoService.saveOrUpdate(invoiceInfoDto);
		return mav;
	}

	/*
	 * 详情展示
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detailIndex(Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("invoice/invoiceDetail");
		InvoiceInfoDto invoiceInfoDto = invoiceInfoService.selectById(id);
		mav.addObject("dto", invoiceInfoDto);
		return mav;
	}
	
}
