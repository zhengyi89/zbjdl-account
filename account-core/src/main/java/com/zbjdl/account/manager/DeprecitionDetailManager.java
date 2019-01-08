/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager;

import java.util.List;

import com.zbjdl.account.model.DeprecitionDetail;

public interface DeprecitionDetailManager {

	Integer save(DeprecitionDetail deprecitionDetail);
	
	Integer update(DeprecitionDetail deprecitionDetail);
	
	DeprecitionDetail selectById(Long id);
	
	List<DeprecitionDetail> findList(DeprecitionDetail deprecitionDetail);
	
}
