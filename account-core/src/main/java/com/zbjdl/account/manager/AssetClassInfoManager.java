/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager;

import java.util.List;

import com.zbjdl.account.model.AssetClassInfo;

public interface AssetClassInfoManager {

	Integer save(AssetClassInfo assetClassInfo);
	
	Integer update(AssetClassInfo assetClassInfo);
	
	AssetClassInfo selectById(Long id);
	
	List<AssetClassInfo> findList(AssetClassInfo assetClassInfo);

	void initAssetClass(String systemCode);
	
}
