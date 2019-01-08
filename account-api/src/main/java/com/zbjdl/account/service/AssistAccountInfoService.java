/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.service;

import java.util.List;

import com.zbjdl.account.dto.AssistAccountInfoDto;

public interface AssistAccountInfoService {
	Integer saveOrUpdate(AssistAccountInfoDto assistAccountInfoDto);

	AssistAccountInfoDto selectById(Long id);
	
	List<AssistAccountInfoDto> findList(AssistAccountInfoDto assistAccountInfoDto);
	
	List<AssistAccountInfoDto> findBySyscode(String syscode);

	void changeStatus(Long id, String status);

	/**
	 * 根据系统编码、辅助核算类型查询
	 * 
	 * @param systemCode
	 * @param assistType
	 * @return
	 */
	List<AssistAccountInfoDto> findByAssistType(String systemCode, String assistType);
	
}
