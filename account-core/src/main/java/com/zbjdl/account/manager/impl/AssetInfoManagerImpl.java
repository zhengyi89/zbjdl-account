/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zbjdl.account.repository.AssetInfoRepository;
import com.zbjdl.account.manager.AssetInfoManager;
import com.zbjdl.account.model.AssetInfo;

@Component
public class AssetInfoManagerImpl implements AssetInfoManager {
	
	@Autowired
	private AssetInfoRepository assetInfoRepository;
	
	@Override
	public Integer save(AssetInfo assetInfo) {
		return assetInfoRepository.save(assetInfo);
	}
	
	@Override
	public Integer update(AssetInfo assetInfo) {
		return assetInfoRepository.update(assetInfo);
	}
	
	@Override
	public AssetInfo selectById(Long id) {
		return assetInfoRepository.selectById(id);
	}
	
	@Override
	public List<AssetInfo> findList(AssetInfo assetInfo) {
		return assetInfoRepository.findList(assetInfo);
	}

}

