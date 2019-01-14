/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.service;

import java.util.List;

import com.zbjdl.account.dto.AssetDeprecitionInfoDto;
import com.zbjdl.account.dto.AssetInfoDto;
import com.zbjdl.account.dto.request.FindPreDeprecitionInfoReqDto;

public interface AssetDeprecitionInfoService {
	Integer saveOrUpdate(AssetDeprecitionInfoDto assetDeprecitionInfoSaveReqDto);

	AssetDeprecitionInfoDto selectById(Long id);
	
	List<AssetDeprecitionInfoDto> findList(AssetDeprecitionInfoDto assetDeprecitionInfoDto);

	void genDeprecitionRecord(AssetInfoDto assetInfoDto);

	void doDeprecition(FindPreDeprecitionInfoReqDto reqDto);

	List<AssetDeprecitionInfoDto> findPreDeprecition(FindPreDeprecitionInfoReqDto reqDto);
	
}
