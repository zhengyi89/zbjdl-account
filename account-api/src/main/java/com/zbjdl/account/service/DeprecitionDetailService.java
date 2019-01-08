/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.service;

import java.util.List;

import com.zbjdl.account.dto.DeprecitionDetailDto;

public interface DeprecitionDetailService {
	Integer saveOrUpdate(DeprecitionDetailDto deprecitionDetailDto);

	DeprecitionDetailDto selectById(Long id);
	
	List<DeprecitionDetailDto> findList(DeprecitionDetailDto deprecitionDetailDto);
	
}
