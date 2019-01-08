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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zbjdl.account.controller.frame.AccountBaseController;
import com.zbjdl.account.dto.CompanyInfoDto;
import com.zbjdl.account.dto.request.CompanyInfoSaveReqDto;
import com.zbjdl.account.dto.response.BaseRespDto;
import com.zbjdl.account.enumtype.CompanyStatusEnum;
import com.zbjdl.account.enumtype.ReturnEnum;
import com.zbjdl.account.service.CompanyInfoService;
import com.zbjdl.boss.admin.facade.UserFacade;
import com.zbjdl.boss.admin.user.dto.UserDTO;

/**
 * CompanyInfoController
 * 
 * @author code-generator
 * @date 2018-11-22 21:52:50 
 * 
 */
@Controller
@RequestMapping("company")
public class CompanyInfoController extends AccountBaseController{
	private static final Logger logger = LoggerFactory.getLogger(CompanyInfoController.class);
	@Autowired
	private CompanyInfoService companyInfoService;
	
	@Autowired
	private UserFacade userFacade;

	/*
	 * 列表页面
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("company/companyIndex");
		return mav;
	}

	/*
	 * 进入新增页面
	 */
	@RequestMapping(value = "/edit/index", method = RequestMethod.GET)
	public ModelAndView addIndex(Long id) {
		ModelAndView mav = new ModelAndView("company/companyEdit");
		if (id != null) {
			CompanyInfoDto companyInfoDto = companyInfoService.selectById(id);
			mav.addObject("dto", companyInfoDto);
		}
		return mav;
	}

	/*
	 * 编辑保存
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(CompanyInfoDto companyInfoDto, BindingResult bindingResult) {
		companyInfoDto.setCreatorId(getCurrentUser().getUserId());
		companyInfoDto.setCreatorName(getCurrentUser().getUserName());
		companyInfoDto.setStatus(CompanyStatusEnum.CREATE.getCode());
		logger.info("save CompanyInfo, param is : {}", JSON.toJSONString(companyInfoDto));
		companyInfoService.saveOrUpdate(companyInfoDto);
		ModelAndView mav = new ModelAndView("redirect:/company/index");
		return mav;
	}

	/*
	 * 详情展示
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detailIndex(Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("company/companyDetail");
		CompanyInfoDto companyInfoDto = companyInfoService.selectById(id);
		mav.addObject("dto", companyInfoDto);
		return mav;
	}
	
	
	/*
	 * 分配页面
	 */
	@RequestMapping(value = "/assign/index", method = RequestMethod.GET)
	public ModelAndView assignIndex(Long id) {
		ModelAndView mav = new ModelAndView("company/companyAssignIndex");
		
		List<UserDTO> users = userFacade.queryDepartmentUsers(getCurrentUser().getPrimaryDepartmentId());
		mav.addObject("users", users);
		if (id != null) {
			CompanyInfoDto companyInfoDto = companyInfoService.selectById(id);
			mav.addObject("dto", companyInfoDto);
		}
		return mav;
	}
	
	/*
	 * 分配
	 */
	@RequestMapping(value = "/assign", method = RequestMethod.POST)
	@ResponseBody
	public Object assign(CompanyInfoSaveReqDto companyInfoSaveReqDto) {
		companyInfoService.assign(companyInfoSaveReqDto);
		BaseRespDto respDto = new BaseRespDto(ReturnEnum.SUCCESS);
		return respDto;
	}
	
	
	/*
	 * 我的客户页面
	 */
	@RequestMapping(value = "/serve/index", method = RequestMethod.GET)
	public ModelAndView serveIndex() {
		ModelAndView mav = new ModelAndView("company/companyServeIndex");
		return mav;
	}
	
	/*
	 * 创建帐套页面
	 */
	@RequestMapping(value = "/accountbook/edit", method = RequestMethod.GET)
	public ModelAndView accountbookEdit(Long id) {
		ModelAndView mav = new ModelAndView("company/accountbookEdit");
		CompanyInfoDto companyInfoDto = companyInfoService.selectById(id);
		mav.addObject("dto", companyInfoDto);
		return mav;
	}
	
}
