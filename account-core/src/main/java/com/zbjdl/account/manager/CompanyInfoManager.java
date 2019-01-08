/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager;

import java.util.List;

import com.zbjdl.account.model.CompanyInfo;

public interface CompanyInfoManager {

	Integer save(CompanyInfo companyInfo);
	
	Integer update(CompanyInfo companyInfo);
	
	CompanyInfo selectById(Long id);
	
	List<CompanyInfo> findList(CompanyInfo companyInfo);
	
}
