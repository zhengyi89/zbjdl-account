/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbjdl.common.utils.BeanUtils;
import com.zbjdl.account.manager.AssetInfoManager;
import com.zbjdl.account.service.AssetInfoService;
import com.zbjdl.account.model.AssetInfo;
import com.zbjdl.account.dto.AssetInfoDto;
import com.zbjdl.account.enumtype.AssetEnum;

@Service("assetInfoService")
public class AssetInfoServiceImpl implements AssetInfoService {
	
	@Autowired
	private AssetInfoManager assetInfoManager;
	
	@Override
	public AssetInfoDto saveOrUpdate(AssetInfoDto assetInfoDto) {
		if (assetInfoDto.getId()!=null) {
			AssetInfo assetInfo = assetInfoManager.selectById(assetInfoDto.getId());
			BeanUtils.copyProperties(assetInfoDto, assetInfo);
			assetInfoManager.update(assetInfo);
		}else {
			AssetInfo assetInfo = new AssetInfo();
			BeanUtils.copyProperties(assetInfoDto, assetInfo);
			assetInfo.setStatus(AssetEnum.STATUS_USING.getCode());
			assetInfoManager.save(assetInfo);
			assetInfoDto.setId(assetInfo.getId());
		}
		return assetInfoDto;
	}
	
	@Override
	public AssetInfoDto selectById(Long id) {
		AssetInfo assetInfo = assetInfoManager.selectById(id);
		AssetInfoDto assetInfoDto = new AssetInfoDto();
		BeanUtils.copyProperties(assetInfo, assetInfoDto);
		return assetInfoDto;
	}
	
	@Override
	public List<AssetInfoDto> findList(AssetInfoDto assetInfoDto) {
		AssetInfo assetInfo = new AssetInfo();
		BeanUtils.copyProperties(assetInfoDto, assetInfo);
		List<AssetInfo> assetInfoList = assetInfoManager.findList(assetInfo);
		
		List<AssetInfoDto> assetInfoDtoList = new ArrayList<AssetInfoDto>();
		for(AssetInfo dto : assetInfoList){
			AssetInfoDto respDto = new AssetInfoDto();
			BeanUtils.copyProperties(dto, respDto);
			assetInfoDtoList.add(respDto);
		}
		return assetInfoDtoList;
	}
	
}

