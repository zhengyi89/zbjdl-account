/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager;

import java.util.List;

import com.zbjdl.account.model.AssetDeprecitionInfo;

public interface AssetDeprecitionInfoManager {

	Integer save(AssetDeprecitionInfo assetDeprecitionInfo);
	
	Integer update(AssetDeprecitionInfo assetDeprecitionInfo);
	
	AssetDeprecitionInfo selectById(Long id);
	
	List<AssetDeprecitionInfo> findList(AssetDeprecitionInfo assetDeprecitionInfo);


	List<AssetDeprecitionInfo> findPreDeprecition(String systemCode, String accountMonth);
	
}
