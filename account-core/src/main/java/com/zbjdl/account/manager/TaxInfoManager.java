/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager;

import java.util.List;

import com.zbjdl.account.model.TaxInfo;

public interface TaxInfoManager {

	Integer save(TaxInfo taxInfo);
	
	Integer update(TaxInfo taxInfo);
	
	TaxInfo selectById(Long id);
	
	List<TaxInfo> findList(TaxInfo taxInfo);
	
}
