/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zbjdl.account.repository.TaxInfoRepository;
import com.zbjdl.account.manager.TaxInfoManager;
import com.zbjdl.account.model.TaxInfo;

@Component
public class TaxInfoManagerImpl implements TaxInfoManager {
	
	@Autowired
	private TaxInfoRepository taxInfoRepository;
	
	@Override
	public Integer save(TaxInfo taxInfo) {
		return taxInfoRepository.save(taxInfo);
	}
	
	@Override
	public Integer update(TaxInfo taxInfo) {
		return taxInfoRepository.update(taxInfo);
	}
	
	@Override
	public TaxInfo selectById(Long id) {
		return taxInfoRepository.selectById(id);
	}
	
	@Override
	public List<TaxInfo> findList(TaxInfo taxInfo) {
		return taxInfoRepository.findList(taxInfo);
	}

}

