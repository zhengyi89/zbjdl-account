/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zbjdl.account.repository.CurrencyInfoRepository;
import com.zbjdl.account.manager.CurrencyInfoManager;
import com.zbjdl.account.model.CurrencyInfo;

@Component
public class CurrencyInfoManagerImpl implements CurrencyInfoManager {
	
	@Autowired
	private CurrencyInfoRepository currencyInfoRepository;
	
	@Override
	public Integer save(CurrencyInfo currencyInfo) {
		return currencyInfoRepository.save(currencyInfo);
	}
	
	@Override
	public Integer update(CurrencyInfo currencyInfo) {
		return currencyInfoRepository.update(currencyInfo);
	}
	
	@Override
	public CurrencyInfo selectById(Long id) {
		return currencyInfoRepository.selectById(id);
	}
	
	@Override
	public List<CurrencyInfo> findList(CurrencyInfo currencyInfo) {
		return currencyInfoRepository.findList(currencyInfo);
	}

	@Override
	public void initCurrencyForSystem(String systemCode) {
		currencyInfoRepository.initCurrencyForSystem(systemCode);
	}

}

