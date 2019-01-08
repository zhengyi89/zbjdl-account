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

import com.zbjdl.account.manager.SystemInfoManager;
import com.zbjdl.account.service.SystemInfoService;
import com.zbjdl.account.model.SystemInfo;
import com.zbjdl.account.dto.SystemInfoDto;

@Service("systemInfoService")
public class SystemInfoServiceImpl implements SystemInfoService {
	
	@Autowired
	private SystemInfoManager systemInfoManager;
	
	@Override
	public Integer saveOrUpdate(SystemInfoDto systemInfoDto) {
		if (systemInfoDto.getId()!=null) {
			SystemInfo systemInfo = systemInfoManager.selectById(systemInfoDto.getId());
			BeanUtils.copyProperties(systemInfoDto, systemInfo);
			return systemInfoManager.update(systemInfo);
		}else {
			SystemInfo systemInfo = new SystemInfo();
			BeanUtils.copyProperties(systemInfoDto, systemInfo);
			return systemInfoManager.save(systemInfo);
		}
	}
	
	@Override
	public SystemInfoDto selectById(Long id) {
		SystemInfo systemInfo = systemInfoManager.selectById(id);
		SystemInfoDto systemInfoDto = new SystemInfoDto();
		BeanUtils.copyProperties(systemInfo, systemInfoDto);
		return systemInfoDto;
	}
	
	@Override
	public SystemInfoDto selectByCompanyId(Long companyId) {
		SystemInfo systemInfo =  new SystemInfo();
		systemInfo.setCompanyId(companyId);
		systemInfo = systemInfoManager.findList(systemInfo).get(0);
		SystemInfoDto systemInfoDto = new SystemInfoDto();
		BeanUtils.copyProperties(systemInfo, systemInfoDto);
		return systemInfoDto;
	}
	
	@Override
	public List<SystemInfoDto> findList(SystemInfoDto systemInfoDto) {
		SystemInfo systemInfo = new SystemInfo();
		BeanUtils.copyProperties(systemInfoDto, systemInfo);
		List<SystemInfo> systemInfoList = systemInfoManager.findList(systemInfo);
		
		List<SystemInfoDto> systemInfoDtoList = new ArrayList<SystemInfoDto>();
		for(SystemInfo dto : systemInfoList){
			SystemInfoDto respDto = new SystemInfoDto();
			BeanUtils.copyProperties(dto, respDto);
			systemInfoDtoList.add(respDto);
		}
		return systemInfoDtoList;
	}
	
}

