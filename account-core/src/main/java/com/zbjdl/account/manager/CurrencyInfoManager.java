/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager;

import java.util.List;

import com.zbjdl.account.model.CurrencyInfo;

public interface CurrencyInfoManager {

	Integer save(CurrencyInfo currencyInfo);
	
	Integer update(CurrencyInfo currencyInfo);
	
	CurrencyInfo selectById(Long id);
	
	List<CurrencyInfo> findList(CurrencyInfo currencyInfo);

	void initCurrencyForSystem(String systemCode);
	
}
