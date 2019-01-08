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
import com.zbjdl.account.controller.frame.AccountBaseController;
import com.zbjdl.account.dto.CurrencyInfoDto;
import com.zbjdl.account.service.CurrencyInfoService;

/**
 * CurrencyInfoController
 * 
 * @author code-generator
 * @date 2018-11-23 15:46:41
 * 
 */
@Controller
@RequestMapping("currency")
public class CurrencyInfoController extends AccountBaseController {
	private static final Logger logger = LoggerFactory.getLogger(CurrencyInfoController.class);
	@Autowired
	private CurrencyInfoService currencyInfoService;

	/*
	 * 列表页面
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("currency/currencyIndex");
		return mav;
	}

	/*
	 * 进入新增页面
	 */
	@RequestMapping(value = "/edit/index", method = RequestMethod.GET)
	public ModelAndView addIndex(Long id) {
		ModelAndView mav = new ModelAndView("currency/currencyEdit");
		if (id != null) {
			CurrencyInfoDto currencyInfoDto = currencyInfoService.selectById(id);
			mav.addObject("dto", currencyInfoDto);
		}
		return mav;
	}

	/*
	 * 编辑保存
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView editPartner(CurrencyInfoDto currencyInfoDto) {
		logger.info("save CurrencyInfo, param is : {}", JSON.toJSONString(currencyInfoDto));
		currencyInfoDto.setSystemCode(getCurrentSystemInfo().getSystemCode());
		currencyInfoService.saveOrUpdate(currencyInfoDto);
		ModelAndView mav = new ModelAndView("redirect:/currency/index");
		return mav;
	}

	/*
	 * 详情展示
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detailIndex(Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("currency/currencyDetail");
		CurrencyInfoDto currencyInfoDto = currencyInfoService.selectById(id);
		mav.addObject("dto", currencyInfoDto);
		return mav;
	}

	// /*
	// * 删除
	// */
	// @RequestMapping(value = "/delete", method = RequestMethod.GET)
	// public ModelAndView editPartner(Long id) {
	// currencyInfoService.delete(id);
	// ModelAndView mav = new ModelAndView("redirect:/currency/index");
	// return mav;
	// }
}
