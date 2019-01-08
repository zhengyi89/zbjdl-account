/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbjdl.common.utils.BeanUtils;
import com.zbjdl.account.manager.SubjectInfoManager;
import com.zbjdl.account.service.SubjectInfoService;
import com.zbjdl.account.model.SubjectInfo;
import com.zbjdl.account.dto.SubjectInfoDto;
import com.zbjdl.account.enumtype.DataStatusEnum;

@Service("subjectInfoService")
public class SubjectInfoServiceImpl implements SubjectInfoService {

	@Autowired
	private SubjectInfoManager subjectInfoManager;

	@Override
	public Integer saveOrUpdate(SubjectInfoDto subjectInfoDto) {
		if (subjectInfoDto.getId() != null) {
			SubjectInfo subjectInfo = subjectInfoManager.selectById(subjectInfoDto.getId());
			BeanUtils.copyProperties(subjectInfoDto, subjectInfo);
			return subjectInfoManager.update(subjectInfo);
		} else {
			SubjectInfo subjectInfo = new SubjectInfo();
			BeanUtils.copyProperties(subjectInfoDto, subjectInfo);
			subjectInfo.setStatus(DataStatusEnum.NORMAL.getCode());
			return subjectInfoManager.save(subjectInfo);
		}
	}

	@Override
	public SubjectInfoDto selectById(Long id) {
		SubjectInfo subjectInfo = subjectInfoManager.selectById(id);
		SubjectInfoDto subjectInfoDto = new SubjectInfoDto();
		BeanUtils.copyProperties(subjectInfo, subjectInfoDto);
		return subjectInfoDto;
	}

	@Override
	public List<SubjectInfoDto> findList(SubjectInfoDto subjectInfoDto) {
		SubjectInfo subjectInfo = new SubjectInfo();
		BeanUtils.copyProperties(subjectInfoDto, subjectInfo);
		List<SubjectInfo> subjectInfoList = subjectInfoManager.findList(subjectInfo);

		List<SubjectInfoDto> subjectInfoDtoList = new ArrayList<SubjectInfoDto>();
		for (SubjectInfo dto : subjectInfoList) {
			SubjectInfoDto respDto = new SubjectInfoDto();
			BeanUtils.copyProperties(dto, respDto);
			subjectInfoDtoList.add(respDto);
		}
		return subjectInfoDtoList;
	}

	@Override
	public List<SubjectInfoDto> findBySyscode(String systemCode) {
		SubjectInfoDto subjectInfoDto = new SubjectInfoDto();
		subjectInfoDto.setSystemCode(systemCode);
		return this.findList(subjectInfoDto);
	}

	@Override
	public void initSubjectForSystem(String systemCode, String defaultType) {
		subjectInfoManager.initSubjectForSystem(systemCode, defaultType);
	}

	@Override
	public Integer findMaxCodeByParentCode(String subjectCode, String systemCode) {
		return subjectInfoManager.findMaxCodeByParentCode(subjectCode, systemCode);
	}

	@Override
	public void changeStatus(Long id, String status) {
		SubjectInfo subjectInfo = subjectInfoManager.selectById(id);
		subjectInfo.setStatus(status);
		subjectInfoManager.update(subjectInfo);
	}

	@Override
	public SubjectInfoDto selectByCode(String subjectCode, String systemCode) {
		SubjectInfoDto subjectInfoDto = new SubjectInfoDto();
		subjectInfoDto.setSystemCode(systemCode);
		subjectInfoDto.setSubjectCode(subjectCode);
		return this.findList(subjectInfoDto).get(0);
	}

	@Override
	public List<SubjectInfoDto> findListWithAssist(String systemCode) {
		List<SubjectInfoDto> subjectInfoDtoList = new ArrayList<SubjectInfoDto>();
		List<SubjectInfo> subjectInfoList = subjectInfoManager.findListWithAssist(systemCode);
		for (SubjectInfo dto : subjectInfoList) {
			SubjectInfoDto respDto = new SubjectInfoDto();
			BeanUtils.copyProperties(dto, respDto);
			subjectInfoDtoList.add(respDto);
		}
		return subjectInfoDtoList;
	}

}
