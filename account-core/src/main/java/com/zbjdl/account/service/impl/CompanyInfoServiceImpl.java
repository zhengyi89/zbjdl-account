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
import com.zbjdl.account.manager.CompanyInfoManager;
import com.zbjdl.account.service.CompanyInfoService;
import com.zbjdl.account.model.CompanyInfo;
import com.zbjdl.account.dto.CompanyInfoDto;
import com.zbjdl.account.dto.request.CompanyInfoSaveReqDto;
import com.zbjdl.account.enumtype.CompanyStatusEnum;

@Service("companyInfoService")
public class CompanyInfoServiceImpl implements CompanyInfoService {
	
	@Autowired
	private CompanyInfoManager companyInfoManager;
	
	@Override
	public Integer saveOrUpdate(CompanyInfoDto companyInfoDto) {
		if (companyInfoDto.getId()!=null) {
			CompanyInfo companyInfo = companyInfoManager.selectById(companyInfoDto.getId());
			BeanUtils.copyProperties(companyInfoDto, companyInfo);
			return companyInfoManager.update(companyInfo);
		}else {
			CompanyInfo companyInfo = new CompanyInfo();
			BeanUtils.copyProperties(companyInfoDto, companyInfo);
			return companyInfoManager.save(companyInfo);
		}
	}
	
	@Override
	public CompanyInfoDto selectById(Long id) {
		CompanyInfo companyInfo = companyInfoManager.selectById(id);
		CompanyInfoDto companyInfoDto = new CompanyInfoDto();
		BeanUtils.copyProperties(companyInfo, companyInfoDto);
		return companyInfoDto;
	}
	
	@Override
	public List<CompanyInfoDto> findList(CompanyInfoDto companyInfoDto) {
		CompanyInfo companyInfo = new CompanyInfo();
		BeanUtils.copyProperties(companyInfoDto, companyInfo);
		List<CompanyInfo> companyInfoList = companyInfoManager.findList(companyInfo);
		
		List<CompanyInfoDto> companyInfoDtoList = new ArrayList<CompanyInfoDto>();
		for(CompanyInfo dto : companyInfoList){
			CompanyInfoDto respDto = new CompanyInfoDto();
			BeanUtils.copyProperties(dto, respDto);
			companyInfoDtoList.add(respDto);
		}
		return companyInfoDtoList;
	}

	@Override
	public void assign(CompanyInfoSaveReqDto companyInfoSaveReqDto) {
		CompanyInfo companyInfo = companyInfoManager.selectById(companyInfoSaveReqDto.getId());
		companyInfo.setAccountantId(companyInfoSaveReqDto.getAccountantId());
		companyInfo.setAccountantName(companyInfoSaveReqDto.getAccountantName());
		companyInfo.setStatus(CompanyStatusEnum.ASSIGN.getCode());
		companyInfoManager.update(companyInfo);
	}
	
}

