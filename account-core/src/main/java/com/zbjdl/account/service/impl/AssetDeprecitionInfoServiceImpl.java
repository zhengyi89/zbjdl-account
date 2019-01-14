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

import com.zbjdl.common.amount.Amount;
import com.zbjdl.common.utils.BeanUtils;
import com.zbjdl.account.manager.AssetDeprecitionInfoManager;
import com.zbjdl.account.service.AssetDeprecitionInfoService;
import com.zbjdl.account.util.DateUtils;
import com.zbjdl.account.model.AssetDeprecitionInfo;
import com.zbjdl.account.dto.AssetDeprecitionInfoDto;
import com.zbjdl.account.dto.AssetInfoDto;
import com.zbjdl.account.dto.request.FindPreDeprecitionInfoReqDto;
import com.zbjdl.account.enumtype.AssetEnum;
import com.zbjdl.account.enumtype.DataStatusEnum;

@Service("assetDeprecitionInfoService")
public class AssetDeprecitionInfoServiceImpl implements AssetDeprecitionInfoService {
	
	@Autowired
	private AssetDeprecitionInfoManager assetDeprecitionInfoManager;
	
	@Override
	public Integer saveOrUpdate(AssetDeprecitionInfoDto assetDeprecitionInfoDto) {
		if (assetDeprecitionInfoDto.getId()!=null) {
			AssetDeprecitionInfo assetDeprecitionInfo = assetDeprecitionInfoManager.selectById(assetDeprecitionInfoDto.getId());
			BeanUtils.copyProperties(assetDeprecitionInfoDto, assetDeprecitionInfo);
			return assetDeprecitionInfoManager.update(assetDeprecitionInfo);
		}else {
			AssetDeprecitionInfo assetDeprecitionInfo = new AssetDeprecitionInfo();
			BeanUtils.copyProperties(assetDeprecitionInfoDto, assetDeprecitionInfo);
			return assetDeprecitionInfoManager.save(assetDeprecitionInfo);
		}
	}
	
	@Override
	public AssetDeprecitionInfoDto selectById(Long id) {
		AssetDeprecitionInfo assetDeprecitionInfo = assetDeprecitionInfoManager.selectById(id);
		AssetDeprecitionInfoDto assetDeprecitionInfoDto = new AssetDeprecitionInfoDto();
		BeanUtils.copyProperties(assetDeprecitionInfo, assetDeprecitionInfoDto);
		return assetDeprecitionInfoDto;
	}
	
	@Override
	public List<AssetDeprecitionInfoDto> findList(AssetDeprecitionInfoDto assetDeprecitionInfoDto) {
		AssetDeprecitionInfo assetDeprecitionInfo = new AssetDeprecitionInfo();
		BeanUtils.copyProperties(assetDeprecitionInfoDto, assetDeprecitionInfo);
		List<AssetDeprecitionInfo> assetDeprecitionInfoList = assetDeprecitionInfoManager.findList(assetDeprecitionInfo);
		
		List<AssetDeprecitionInfoDto> assetDeprecitionInfoDtoList = new ArrayList<AssetDeprecitionInfoDto>();
		for(AssetDeprecitionInfo dto : assetDeprecitionInfoList){
			AssetDeprecitionInfoDto respDto = new AssetDeprecitionInfoDto();
			BeanUtils.copyProperties(dto, respDto);
			assetDeprecitionInfoDtoList.add(respDto);
		}
		return assetDeprecitionInfoDtoList;
	}

	@Override
	public void genDeprecitionRecord(AssetInfoDto assetInfoDto) {
		String beginDate = null;
		// 判断开始使用时间和创建时间
		if (assetInfoDto.getBeginUseDate()!=null) {
			int month = DateUtils.getMonthSpace(assetInfoDto.getBeginDate(), assetInfoDto.getBeginUseDate());
			if (month>=1) {
				// 折旧日期从开始月份计算
				beginDate = DateUtils.DATE_MONTH_FORMAT.format(assetInfoDto.getBeginDate());
				
			}else {
				// 折旧日期从开始时间的下一个月计算
				beginDate = DateUtils.addMonth(DateUtils.DATE_MONTH_FORMAT.format(assetInfoDto.getBeginDate()), 1);
			}
		}
		
		
		
		Amount openingWorth = assetInfoDto.getAssetWorth();
		// 循环折旧
		for (int i = 0; i < assetInfoDto.getUseAge()-assetInfoDto.getHasUseAge(); i++) {
			AssetDeprecitionInfo assetDeprecitionInfo = new AssetDeprecitionInfo();
			assetDeprecitionInfo.setAssetId(assetInfoDto.getId());
			assetDeprecitionInfo.setInitialWorth(assetInfoDto.getInitialWorth());
			assetDeprecitionInfo.setOpeningNetWorth(openingWorth);
			openingWorth = openingWorth.subtract(assetInfoDto.getMonthLossAmount());
			assetDeprecitionInfo.setClosingNetWorth(openingWorth);
			assetDeprecitionInfo.setDeprecitionAmount(assetInfoDto.getMonthLossAmount());
			assetDeprecitionInfo.setDeprecitionMonth(beginDate);
			assetDeprecitionInfo.setStatus(DataStatusEnum.INIT.getCode());
			
			assetDeprecitionInfoManager.save(assetDeprecitionInfo);
			beginDate = DateUtils.addMonth(beginDate, 1);
		}
	}

	@Override
	public void doDeprecition(FindPreDeprecitionInfoReqDto reqDto) {
		// 查询待折旧
		List<AssetDeprecitionInfo> list = assetDeprecitionInfoManager.findPreDeprecition(reqDto);
		for (AssetDeprecitionInfo assetDeprecitionInfo2 : list) {
			assetDeprecitionInfo2.setStatus(DataStatusEnum.NORMAL.getCode());
			assetDeprecitionInfoManager.update(assetDeprecitionInfo2);
		}
	}

	@Override
	public List<AssetDeprecitionInfoDto> findPreDeprecition(FindPreDeprecitionInfoReqDto reqDto) {
		List<AssetDeprecitionInfo> assetDeprecitionInfoList = assetDeprecitionInfoManager.findPreDeprecition(reqDto);
		List<AssetDeprecitionInfoDto> assetDeprecitionInfoDtoList = new ArrayList<AssetDeprecitionInfoDto>();
		for(AssetDeprecitionInfo dto : assetDeprecitionInfoList){
			AssetDeprecitionInfoDto respDto = new AssetDeprecitionInfoDto();
			BeanUtils.copyProperties(dto, respDto);
			assetDeprecitionInfoDtoList.add(respDto);
		}
		return assetDeprecitionInfoDtoList;
	}
	
}

