package com.zbjdl.account.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zbjdl.account.constant.Constants;
import com.zbjdl.account.constant.DataConstants;
import com.zbjdl.account.controller.frame.AccountBaseController;
import com.zbjdl.account.dto.AssetClassInfoDto;
import com.zbjdl.account.dto.CompanyInfoDto;
import com.zbjdl.account.dto.CurrentSystemDto;
import com.zbjdl.account.dto.SystemInfoDto;
import com.zbjdl.account.dto.request.CompanyInfoSaveReqDto;
import com.zbjdl.account.dto.request.SystemInfoSaveReqDto;
import com.zbjdl.account.enumtype.CompanyStatusEnum;
import com.zbjdl.account.enumtype.SystemInfoEnum;
import com.zbjdl.account.service.AccountSettleInfoService;
import com.zbjdl.account.service.AssetClassInfoService;
import com.zbjdl.account.service.CompanyInfoService;
import com.zbjdl.account.service.SubjectInfoService;
import com.zbjdl.account.service.SystemInfoService;
import com.zbjdl.account.util.DateUtils;
import com.zbjdl.common.utility.service.IdGenerateService;
import com.zbjdl.common.utils.BeanUtils;

/**
 * SystemInfoController
 * 
 * @author code-generator
 * @date 2018-11-22 21:52:44 
 * 
 */
@Controller
@RequestMapping("system")
public class SystemInfoController extends AccountBaseController{
	private static final Logger logger = LoggerFactory.getLogger(SystemInfoController.class);
	@Autowired
	private SystemInfoService systemInfoService;
	
	@Autowired
	private CompanyInfoService companyInfoService;
	
	@Autowired
	private SubjectInfoService subjectInfoService;
	
	@Autowired
	private IdGenerateService idGenerateService;
	
	@Autowired
	private AccountSettleInfoService accountSettleInfoService;
	
	@Autowired
	private AssetClassInfoService assetClassInfoService;
	
	/*
	 * 工作台页面
	 */
	@RequestMapping(value = "/console", method = RequestMethod.GET)
	public ModelAndView index(Long companyId, HttpServletRequest request) {
		CurrentSystemDto currentSystemDto = new CurrentSystemDto();
		if (companyId==null) {
			currentSystemDto = getCurrentSystemInfo();
		}else {
			SystemInfoDto systemInfoDto = systemInfoService.selectByCompanyId(companyId);
			BeanUtils.copyProperties(systemInfoDto, currentSystemDto);
			currentSystemDto.setSystemId(systemInfoDto.getId());
			currentSystemDto.setStartMonth(DateUtils.DATE_MONTH_FORMAT.format(systemInfoDto.getServerStartDate()));
			currentSystemDto.setAccountMonth(systemInfoDto.getServerMonth());
			currentSystemDto.setLatestMonth(systemInfoDto.getServerMonth());
			setCurrentSystemInfo(currentSystemDto);
		}
		
		ModelAndView mav = new ModelAndView("system/systemConsole");
		mav.addObject("dto", currentSystemDto);
		return mav;
	}
	
	/*
	 * 列表页面
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("system/systemIndex");
		SystemInfoDto systemInfoDto = systemInfoService.selectByCompanyId(getCurrentSystemInfo().getCompanyId());
		mav.addObject("dto", systemInfoDto);
		return mav;
	}

	/*
	 * 进入新增页面
	 */
	@RequestMapping(value = "/edit/index", method = RequestMethod.GET)
	public ModelAndView addIndex(Long id) {
		ModelAndView mav = new ModelAndView("system/systemEdit");
		if (id != null) {
			SystemInfoDto systemInfoDto = systemInfoService.selectById(id);
			mav.addObject("dto", systemInfoDto);
		}
		return mav;
	}

	/*
	 * 创建帐套
	 */
	@RequestMapping(value = "/createSetBook", method = RequestMethod.POST)
	public ModelAndView editPartner(SystemInfoSaveReqDto systemInfoSaveReqDto, BindingResult bindingResult) {
		logger.info("save SystemInfo, param is : {}", JSON.toJSONString(systemInfoSaveReqDto));
		
		// 设置客户服务状态
		CompanyInfoDto companyInfoDto = companyInfoService.selectById(systemInfoSaveReqDto.getCompanyId());
		companyInfoDto.setStatus(CompanyStatusEnum.ACCOUNTING.getCode());
		companyInfoService.saveOrUpdate(companyInfoDto);
		
		// 生成系统编码
		String syscode = idGenerateService.generateSequence("ACCOUNT_SYSTEM_CODE", "%06d");
		systemInfoSaveReqDto.setSystemCode(syscode);
		// 设置代帐月份为开始服务月份
		systemInfoSaveReqDto.setServerMonth(DateUtils.DATE_MONTH_FORMAT.format(systemInfoSaveReqDto.getServerStartDate()));
		
		// 保存系统信息
		SystemInfoDto dto = new SystemInfoDto();
		BeanUtils.copyProperties(systemInfoSaveReqDto, dto);
		systemInfoService.saveOrUpdate(dto);
		
		// 根据纳税人类型，预设科目
		subjectInfoService.initSubjectForSystem(systemInfoSaveReqDto.getSystemCode(), SystemInfoEnum.SUBJECT_DEFAULT.getCode());
		
		// 是否 预置期间费用明细科目
		if (systemInfoSaveReqDto.getCommonSubjectInit()) {
			subjectInfoService.initSubjectForSystem(systemInfoSaveReqDto.getSystemCode(), SystemInfoEnum.SUBJECT_COST_DEFAULT.getCode());
		}
		
		// 初始化科目期初
		accountSettleInfoService.initSubjectOpening(syscode, DateUtils.DATE_MONTH_FORMAT.format(systemInfoSaveReqDto.getServerStartDate()));
		
		// 初始化资产类别
		assetClassInfoService.initAssetClass(syscode);
		
		//删除系统参数session
		deleteCurrentSystemInfo();
		
		ModelAndView mav = new ModelAndView("redirect:/company/serve/index");
		return mav;
	}
	
	
	/*
	 * 创建帐套
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(SystemInfoSaveReqDto systemInfoSaveReqDto, BindingResult bindingResult) {
		logger.info("save SystemInfo, param is : {}", JSON.toJSONString(systemInfoSaveReqDto));
		
		ModelAndView mav = new ModelAndView("redirect:/company/serve/index");
		return mav;
	}

	/*
	 * 详情展示
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detailIndex(Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("system/systemDetail");
		SystemInfoDto systemInfoDto = systemInfoService.selectById(id);
		mav.addObject("dto", systemInfoDto);
		return mav;
	}
	
}
