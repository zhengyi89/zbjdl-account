package com.zbjdl.account.controller;

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
import com.zbjdl.account.dto.SubjectInfoDto;
import com.zbjdl.account.enumtype.AssistAccountTypeEnum;
import com.zbjdl.account.enumtype.MethodEnum;
import com.zbjdl.account.service.SubjectInfoService;
import com.zbjdl.common.utils.StringUtils;

/**
 * SubjectInfoController
 * 
 * @author code-generator
 * @date 2018-11-28 17:11:50 
 * 
 */
@Controller
@RequestMapping("subject")
public class SubjectInfoController extends AccountBaseController {
	private static final Logger logger = LoggerFactory.getLogger(SubjectInfoController.class);
	@Autowired
	private SubjectInfoService subjectInfoService;

	/*
	 * 列表页面
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView subjectInfoIndex() {
		ModelAndView mav = new ModelAndView("subject/subjectIndex");
		return mav;
	}

	/*
	 * 编辑页面
	 */
	@RequestMapping(value = "/edit/index", method = RequestMethod.GET)
	public ModelAndView subjectInfoEditIndex(Long id, String method) {
		ModelAndView mav = new ModelAndView("subject/subjectEdit");
		
		SubjectInfoDto subjectInfoDto = subjectInfoService.selectById(id);
		if (MethodEnum.ADD.getCode().equals(method)) {
			SubjectInfoDto dto = new SubjectInfoDto();
			dto.setParentCode(subjectInfoDto.getSubjectCode());
			dto.setBalanceDirect(subjectInfoDto.getBalanceDirect());
			dto.setAssistAccount(dto.getAssistAccount());
			dto.setAssistAccountName(dto.getAssistAccountName());
			dto.setBasicSubject(subjectInfoDto.getBasicSubject());
			Integer maxCode = subjectInfoService.findMaxCodeByParentCode(subjectInfoDto.getSubjectCode(), getCurrentSystemInfo().getSystemCode());
			if (maxCode==null) {
				dto.setSubjectCode(subjectInfoDto.getSubjectCode()+"01");
			}else {
				dto.setSubjectCode(String.format("%02d", maxCode+1));
			}
			
			mav.addObject("dto", dto);
		}else {
			mav.addObject("dto", subjectInfoDto);
		}
		return mav;
	}

	/*
	 * 编辑保存
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView subjectInfoSave(SubjectInfoDto subjectInfoDto) {
		logger.info("save SubjectInfo, param is : {}", JSON.toJSONString(subjectInfoDto));
		if (subjectInfoDto.getId()==null) {
			SubjectInfoDto parentDto = subjectInfoService.selectByCode(subjectInfoDto.getParentCode(), getCurrentSystemInfo().getSystemCode());
			subjectInfoDto.setLastLevel(true);
			subjectInfoDto.setParentCode(parentDto.getSubjectCode());
			subjectInfoDto.setSystemCode(getCurrentSystemInfo().getSystemCode());
			subjectInfoDto.setSubjectLevel(parentDto.getSubjectLevel()+1);
			// 如果是新增，上级科目是末级科目，修改为非末级
			if (parentDto.getLastLevel()) {
				parentDto.setLastLevel(false);
				subjectInfoService.saveOrUpdate(parentDto);
			}
		}
		subjectInfoService.saveOrUpdate(subjectInfoDto);
		ModelAndView mav = new ModelAndView("redirect:/subject/index");
		return mav;
	}

	/*
	 * 详情展示
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView subjectInfoDetail(Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("subject/subjectDetail");
		SubjectInfoDto subjectInfoDto = subjectInfoService.selectById(id);
		mav.addObject("dto", subjectInfoDto);
		return mav;
	}
	
	/*
	 * 修改状态
	 */
	@RequestMapping(value = "/opreate", method = RequestMethod.GET)
	public ModelAndView subjectInfoDetail(Long id, String status) {
		subjectInfoService.changeStatus(id, status);
		ModelAndView mav = new ModelAndView("subject/index");
		return mav;
	}
	
	
	/*
	 * 修改状态
	 */
	@RequestMapping(value = "/selectByCode", method = RequestMethod.POST)
	@ResponseBody
	public Object selectByCode(String subjectCode) {
		SubjectInfoDto subjectInfoDto = new SubjectInfoDto();
		subjectInfoDto.setSystemCode(getCurrentSystemInfo().getSystemCode());
		subjectInfoDto.setSubjectCode(subjectCode);
		subjectInfoDto = subjectInfoService.findList(subjectInfoDto).get(0);
		if (StringUtils.isNotBlank(subjectInfoDto.getAssistAccount())) {
			subjectInfoDto.setAssistAccountName(AssistAccountTypeEnum.toEnum(subjectInfoDto.getAssistAccount()).getMsg());
		}
		return subjectInfoDto;
	}
}
