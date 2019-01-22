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
import com.zbjdl.account.manager.CurrencyInfoManager;
import com.zbjdl.account.service.CurrencyInfoService;
import com.zbjdl.account.model.CurrencyInfo;
import com.zbjdl.account.dto.CurrencyInfoDto;
import com.zbjdl.account.enumtype.DataStatusEnum;

@Service("currencyInfoService")
public class CurrencyInfoServiceImpl implements CurrencyInfoService {
	
	@Autowired
	private CurrencyInfoManager currencyInfoManager;
	
	@Override
	public Integer saveOrUpdate(CurrencyInfoDto currencyInfoDto) {
		if (currencyInfoDto.getId()!=null) {
			CurrencyInfo currencyInfo = currencyInfoManager.selectById(currencyInfoDto.getId());
			BeanUtils.copyProperties(currencyInfoDto, currencyInfo);
			return currencyInfoManager.update(currencyInfo);
		}else {
			CurrencyInfo currencyInfo = new CurrencyInfo();
			BeanUtils.copyProperties(currencyInfoDto, currencyInfo);
			currencyInfo.setStatus(DataStatusEnum.NORMAL.getCode());
			return currencyInfoManager.save(currencyInfo);
		}
	}
	
	@Override
	public CurrencyInfoDto selectById(Long id) {
		CurrencyInfo currencyInfo = currencyInfoManager.selectById(id);
		CurrencyInfoDto currencyInfoDto = new CurrencyInfoDto();
		BeanUtils.copyProperties(currencyInfo, currencyInfoDto);
		return currencyInfoDto;
	}
	
	@Override
	public List<CurrencyInfoDto> findList(CurrencyInfoDto currencyInfoDto) {
		CurrencyInfo currencyInfo = new CurrencyInfo();
		BeanUtils.copyProperties(currencyInfoDto, currencyInfo);
		List<CurrencyInfo> currencyInfoList = currencyInfoManager.findList(currencyInfo);
		
		List<CurrencyInfoDto> currencyInfoDtoList = new ArrayList<CurrencyInfoDto>();
		for(CurrencyInfo dto : currencyInfoList){
			CurrencyInfoDto respDto = new CurrencyInfoDto();
			BeanUtils.copyProperties(dto, respDto);
			currencyInfoDtoList.add(respDto);
		}
		return currencyInfoDtoList;
	}

	@Override
	public void initCurrencyForSystem(String systemCode) {
		currencyInfoManager.initCurrencyForSystem(systemCode);
	}
	
}

