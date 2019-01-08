/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.service;

import java.util.List;

import com.zbjdl.account.dto.AssetInfoDto;

public interface AssetInfoService {
	AssetInfoDto saveOrUpdate(AssetInfoDto assetInfoDto);

	AssetInfoDto selectById(Long id);
	
	List<AssetInfoDto> findList(AssetInfoDto assetInfoDto);
	
}
