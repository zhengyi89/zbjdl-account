/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.service;

import java.util.List;

import com.zbjdl.account.dto.AssetDeprecitionInfoDto;
import com.zbjdl.account.dto.AssetInfoDto;

public interface AssetDeprecitionInfoService {
	Integer saveOrUpdate(AssetDeprecitionInfoDto assetDeprecitionInfoSaveReqDto);

	AssetDeprecitionInfoDto selectById(Long id);
	
	List<AssetDeprecitionInfoDto> findList(AssetDeprecitionInfoDto assetDeprecitionInfoDto);

	void genDeprecitionRecord(AssetInfoDto assetInfoDto);

	void doDeprecition(String systemCode, String accountMonth);
	
}
