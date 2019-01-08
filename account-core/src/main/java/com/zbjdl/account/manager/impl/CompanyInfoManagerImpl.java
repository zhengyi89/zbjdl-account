/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zbjdl.account.repository.CompanyInfoRepository;
import com.zbjdl.account.manager.CompanyInfoManager;
import com.zbjdl.account.model.CompanyInfo;

@Component
public class CompanyInfoManagerImpl implements CompanyInfoManager {
	
	@Autowired
	private CompanyInfoRepository companyInfoRepository;
	
	@Override
	public Integer save(CompanyInfo companyInfo) {
		return companyInfoRepository.save(companyInfo);
	}
	
	@Override
	public Integer update(CompanyInfo companyInfo) {
		return companyInfoRepository.update(companyInfo);
	}
	
	@Override
	public CompanyInfo selectById(Long id) {
		return companyInfoRepository.selectById(id);
	}
	
	@Override
	public List<CompanyInfo> findList(CompanyInfo companyInfo) {
		return companyInfoRepository.findList(companyInfo);
	}

}

