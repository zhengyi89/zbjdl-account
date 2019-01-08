/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zbjdl.account.repository.AssetClassInfoRepository;
import com.zbjdl.account.manager.AssetClassInfoManager;
import com.zbjdl.account.model.AssetClassInfo;

@Component
public class AssetClassInfoManagerImpl implements AssetClassInfoManager {
	
	@Autowired
	private AssetClassInfoRepository assetClassInfoRepository;
	
	@Override
	public Integer save(AssetClassInfo assetClassInfo) {
		return assetClassInfoRepository.save(assetClassInfo);
	}
	
	@Override
	public Integer update(AssetClassInfo assetClassInfo) {
		return assetClassInfoRepository.update(assetClassInfo);
	}
	
	@Override
	public AssetClassInfo selectById(Long id) {
		return assetClassInfoRepository.selectById(id);
	}
	
	@Override
	public List<AssetClassInfo> findList(AssetClassInfo assetClassInfo) {
		return assetClassInfoRepository.findList(assetClassInfo);
	}

	@Override
	public void initAssetClass(String systemCode) {
		assetClassInfoRepository.initAssetClass(systemCode);
	}

}

