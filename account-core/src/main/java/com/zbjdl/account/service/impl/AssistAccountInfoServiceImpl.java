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
import com.zbjdl.account.manager.AssistAccountInfoManager;
import com.zbjdl.account.service.AssistAccountInfoService;
import com.zbjdl.account.model.AssistAccountInfo;
import com.zbjdl.account.dto.AssistAccountInfoDto;
import com.zbjdl.account.enumtype.DataStatusEnum;

@Service("assistAccountInfoService")
public class AssistAccountInfoServiceImpl implements AssistAccountInfoService {
	
	@Autowired
	private AssistAccountInfoManager assistAccountInfoManager;
	
	@Override
	public Integer saveOrUpdate(AssistAccountInfoDto assistAccountInfoDto) {
		if (assistAccountInfoDto.getId()!=null) {
			AssistAccountInfo assistAccountInfo = assistAccountInfoManager.selectById(assistAccountInfoDto.getId());
			BeanUtils.copyProperties(assistAccountInfoDto, assistAccountInfo);
			return assistAccountInfoManager.update(assistAccountInfo);
		}else {
			AssistAccountInfo assistAccountInfo = new AssistAccountInfo();
			BeanUtils.copyProperties(assistAccountInfoDto, assistAccountInfo);
			assistAccountInfo.setStatus(DataStatusEnum.NORMAL.getCode());
			return assistAccountInfoManager.save(assistAccountInfo);
		}
	}
	
	@Override
	public AssistAccountInfoDto selectById(Long id) {
		AssistAccountInfo assistAccountInfo = assistAccountInfoManager.selectById(id);
		AssistAccountInfoDto assistAccountInfoDto = new AssistAccountInfoDto();
		BeanUtils.copyProperties(assistAccountInfo, assistAccountInfoDto);
		return assistAccountInfoDto;
	}
	
	@Override
	public List<AssistAccountInfoDto> findList(AssistAccountInfoDto assistAccountInfoDto) {
		AssistAccountInfo assistAccountInfo = new AssistAccountInfo();
		BeanUtils.copyProperties(assistAccountInfoDto, assistAccountInfo);
		List<AssistAccountInfo> assistAccountInfoList = assistAccountInfoManager.findList(assistAccountInfo);
		
		List<AssistAccountInfoDto> assistAccountInfoDtoList = new ArrayList<AssistAccountInfoDto>();
		for(AssistAccountInfo dto : assistAccountInfoList){
			AssistAccountInfoDto respDto = new AssistAccountInfoDto();
			BeanUtils.copyProperties(dto, respDto);
			assistAccountInfoDtoList.add(respDto);
		}
		return assistAccountInfoDtoList;
	}

	@Override
	public List<AssistAccountInfoDto> findBySyscode(String syscode) {
		AssistAccountInfoDto assistAccountInfoDto = new AssistAccountInfoDto();
		assistAccountInfoDto.setSystemCode(syscode);
		assistAccountInfoDto.setStatus(DataStatusEnum.NORMAL.getCode());
		return this.findList(assistAccountInfoDto);
	}

	@Override
	public void changeStatus(Long id, String status) {
		AssistAccountInfo assistAccountInfo = assistAccountInfoManager.selectById(id);
		assistAccountInfo.setStatus(status);
		assistAccountInfoManager.update(assistAccountInfo);
		
	}

	@Override
	public List<AssistAccountInfoDto> findByAssistType(String systemCode, String assistType) {
		AssistAccountInfoDto assistAccountInfoDto = new AssistAccountInfoDto();
		assistAccountInfoDto.setSystemCode(systemCode);
		assistAccountInfoDto.setStatus(DataStatusEnum.NORMAL.getCode());
		assistAccountInfoDto.setAssistType(assistType);
		return this.findList(assistAccountInfoDto);
	}

	
}

