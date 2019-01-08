/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager;

import java.util.List;

import com.zbjdl.account.model.AssetInfo;

public interface AssetInfoManager {

	Integer save(AssetInfo assetInfo);
	
	Integer update(AssetInfo assetInfo);
	
	AssetInfo selectById(Long id);
	
	List<AssetInfo> findList(AssetInfo assetInfo);
	
}
