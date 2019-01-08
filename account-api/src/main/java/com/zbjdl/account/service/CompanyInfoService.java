/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.service;

import java.util.List;

import com.zbjdl.account.dto.CompanyInfoDto;
import com.zbjdl.account.dto.request.CompanyInfoSaveReqDto;

public interface CompanyInfoService {
	Integer saveOrUpdate(CompanyInfoDto companyInfoDto);

	CompanyInfoDto selectById(Long id);
	
	List<CompanyInfoDto> findList(CompanyInfoDto companyInfoDto);

	void assign(CompanyInfoSaveReqDto companyInfoSaveReqDto);
	
}
