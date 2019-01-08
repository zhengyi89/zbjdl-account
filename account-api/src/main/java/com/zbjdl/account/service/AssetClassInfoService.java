/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.service;

import java.util.List;

import com.zbjdl.account.dto.AssetClassInfoDto;

public interface AssetClassInfoService {
	Integer saveOrUpdate(AssetClassInfoDto assetClassInfoDto);

	AssetClassInfoDto selectById(Long id);

	List<AssetClassInfoDto> findList(AssetClassInfoDto assetClassInfoDto);

	List<AssetClassInfoDto> findBySyscode(String systemCode);

	List<AssetClassInfoDto> findByDeprecitionType(String systemCode, String deprecitionType);

	void initAssetClass(String systemCode);

	AssetClassInfoDto assetClassCode(String systemCode, String assetClassCode);

}
