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
import com.zbjdl.account.manager.AssetClassInfoManager;
import com.zbjdl.account.service.AssetClassInfoService;
import com.zbjdl.account.model.AssetClassInfo;
import com.zbjdl.account.dto.AssetClassInfoDto;

@Service("assetClassInfoService")
public class AssetClassInfoServiceImpl implements AssetClassInfoService {
	
	@Autowired
	private AssetClassInfoManager assetClassInfoManager;
	
	@Override
	public Integer saveOrUpdate(AssetClassInfoDto assetClassInfoDto) {
		if (assetClassInfoDto.getId()!=null) {
			AssetClassInfo assetClassInfo = assetClassInfoManager.selectById(assetClassInfoDto.getId());
			BeanUtils.copyProperties(assetClassInfoDto, assetClassInfo);
			return assetClassInfoManager.update(assetClassInfo);
		}else {
			AssetClassInfo assetClassInfo = new AssetClassInfo();
			BeanUtils.copyProperties(assetClassInfoDto, assetClassInfo);
			return assetClassInfoManager.save(assetClassInfo);
		}
	}
	
	@Override
	public AssetClassInfoDto selectById(Long id) {
		AssetClassInfo assetClassInfo = assetClassInfoManager.selectById(id);
		AssetClassInfoDto assetClassInfoDto = new AssetClassInfoDto();
		BeanUtils.copyProperties(assetClassInfo, assetClassInfoDto);
		return assetClassInfoDto;
	}
	
	@Override
	public List<AssetClassInfoDto> findList(AssetClassInfoDto assetClassInfoDto) {
		AssetClassInfo assetClassInfo = new AssetClassInfo();
		BeanUtils.copyProperties(assetClassInfoDto, assetClassInfo);
		List<AssetClassInfo> assetClassInfoList = assetClassInfoManager.findList(assetClassInfo);
		
		List<AssetClassInfoDto> assetClassInfoDtoList = new ArrayList<AssetClassInfoDto>();
		for(AssetClassInfo dto : assetClassInfoList){
			AssetClassInfoDto respDto = new AssetClassInfoDto();
			BeanUtils.copyProperties(dto, respDto);
			assetClassInfoDtoList.add(respDto);
		}
		return assetClassInfoDtoList;
	}

	@Override
	public List<AssetClassInfoDto> findBySyscode(String systemCode) {
		AssetClassInfoDto assetClassInfoDto = new AssetClassInfoDto();
		assetClassInfoDto.setSystemCode(systemCode);
		return this.findList(assetClassInfoDto);
	}

	@Override
	public void initAssetClass(String systemCode) {
		assetClassInfoManager.initAssetClass(systemCode);
	}

	@Override
	public AssetClassInfoDto assetClassCode(String systemCode, String assetClassCode) {
		AssetClassInfoDto assetClassInfoDto = new AssetClassInfoDto();
		assetClassInfoDto.setSystemCode(systemCode);
		assetClassInfoDto.setAssetClassCode(assetClassCode);
		return this.findList(assetClassInfoDto).get(0);
	}

	@Override
	public List<AssetClassInfoDto> findByDeprecitionType(String systemCode, String deprecitionType) {
		AssetClassInfoDto assetClassInfoDto = new AssetClassInfoDto();
		assetClassInfoDto.setSystemCode(systemCode);
		assetClassInfoDto.setDeprecitionType(deprecitionType);
		return this.findList(assetClassInfoDto);
	}

	@Override
	public void delete(Long id) {
		assetClassInfoManager.delete(id);
	}
	
}

