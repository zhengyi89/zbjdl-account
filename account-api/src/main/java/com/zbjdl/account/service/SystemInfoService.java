/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.service;

import java.util.List;

import com.zbjdl.account.dto.SystemInfoDto;

public interface SystemInfoService {
	Integer saveOrUpdate(SystemInfoDto systemInfoDto);

	SystemInfoDto selectById(Long id);
	
	SystemInfoDto selectByCompanyId(Long companyId);
	
	List<SystemInfoDto> findList(SystemInfoDto systemInfoDto);
	
}
