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
import com.zbjdl.account.dto.AssistAccountInfoDto;
import com.zbjdl.account.service.AssistAccountInfoService;

/**
 * AssistAccountInfoController
 * 
 * @author code-generator
 * @date 2018-11-22 21:52:37
 * 
 */
@Controller
@RequestMapping("assistAccount")
public class AssistAccountInfoController extends AccountBaseController {
	private static final Logger logger = LoggerFactory.getLogger(AssistAccountInfoController.class);
	@Autowired
	private AssistAccountInfoService assistAccountInfoService;

	/*
	 * 列表页面
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("assistAccount/assistAccountIndex");
		return mav;
	}

	/*
	 * 进入新增页面
	 */
	@RequestMapping(value = "/edit/index", method = RequestMethod.GET)
	public ModelAndView addIndex(Long id) {
		ModelAndView mav = new ModelAndView("assistAccount/assistAccountEdit");
		if (id != null) {
			AssistAccountInfoDto assistAccountInfoDto = assistAccountInfoService.selectById(id);
			mav.addObject("dto", assistAccountInfoDto);
		}
		return mav;
	}

	/*
	 * 编辑保存
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView editPartner(AssistAccountInfoDto assistAccountInfoDto) {
		logger.info("save AssistAccountInfo, param is : {}",
				JSON.toJSONString(assistAccountInfoDto));
		assistAccountInfoDto.setSystemCode(getCurrentSystemInfo().getSystemCode());
		assistAccountInfoService.saveOrUpdate(assistAccountInfoDto);
		ModelAndView mav = new ModelAndView("redirect:/assistAccount/index");
		return mav;
	}

	/*
	 * 详情展示
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detailIndex(Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("assistAccount/assistAccountDetail");
		AssistAccountInfoDto assistAccountInfoDto = assistAccountInfoService.selectById(id);
		mav.addObject("dto", assistAccountInfoDto);
		return mav;
	}

	/*
	 * 修改状态
	 */
	@RequestMapping(value = "/opreate", method = RequestMethod.GET)
	public ModelAndView subjectInfoDetail(Long id, String status) {
		assistAccountInfoService.changeStatus(id, status);
		ModelAndView mav = new ModelAndView("subject/index");
		return mav;
	}

	/*
	 * 查询系统所有
	 */
	@RequestMapping(value = "/findByType", method = RequestMethod.POST)
	@ResponseBody
	public Object findByType(String assistType) {
		AssistAccountInfoDto assistAccountInfoDto = new AssistAccountInfoDto();
		assistAccountInfoDto.setSystemCode(getCurrentSystemInfo().getSystemCode());
		assistAccountInfoDto.setAssistType(assistType);
		List<AssistAccountInfoDto> accountInfoDtos = assistAccountInfoService.findList(assistAccountInfoDto);
		return accountInfoDtos;
	}

}
