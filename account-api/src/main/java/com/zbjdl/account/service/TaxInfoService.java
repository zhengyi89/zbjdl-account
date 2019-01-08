/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.service;

import java.util.List;

import com.zbjdl.account.dto.TaxInfoDto;

public interface TaxInfoService {
	Integer saveOrUpdate(TaxInfoDto taxInfoDto);

	TaxInfoDto selectById(Long id);
	
	List<TaxInfoDto> findList(TaxInfoDto taxInfoDto);
	
}
