/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.service;

import java.util.List;

import com.zbjdl.account.dto.CurrencyInfoDto;

public interface CurrencyInfoService {
	Integer saveOrUpdate(CurrencyInfoDto currencyInfoDto);

	CurrencyInfoDto selectById(Long id);
	
	List<CurrencyInfoDto> findList(CurrencyInfoDto currencyInfoDto);
	
}
