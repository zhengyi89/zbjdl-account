/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zbjdl.account.repository.AssetDeprecitionInfoRepository;
import com.zbjdl.account.manager.AssetDeprecitionInfoManager;
import com.zbjdl.account.model.AssetDeprecitionInfo;

@Component
public class AssetDeprecitionInfoManagerImpl implements AssetDeprecitionInfoManager {
	
	@Autowired
	private AssetDeprecitionInfoRepository assetDeprecitionInfoRepository;
	
	@Override
	public Integer save(AssetDeprecitionInfo assetDeprecitionInfo) {
		return assetDeprecitionInfoRepository.save(assetDeprecitionInfo);
	}
	
	@Override
	public Integer update(AssetDeprecitionInfo assetDeprecitionInfo) {
		return assetDeprecitionInfoRepository.update(assetDeprecitionInfo);
	}
	
	@Override
	public AssetDeprecitionInfo selectById(Long id) {
		return assetDeprecitionInfoRepository.selectById(id);
	}
	
	@Override
	public List<AssetDeprecitionInfo> findList(AssetDeprecitionInfo assetDeprecitionInfo) {
		return assetDeprecitionInfoRepository.findList(assetDeprecitionInfo);
	}


	@Override
	public List<AssetDeprecitionInfo> findPreDeprecition(String systemCode, String accountMonth) {
		return assetDeprecitionInfoRepository.findPreDeprecition(systemCode, accountMonth);
	}

}

