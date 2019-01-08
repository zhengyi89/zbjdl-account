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

import com.zbjdl.account.manager.TaxInfoManager;
import com.zbjdl.account.service.TaxInfoService;
import com.zbjdl.account.model.TaxInfo;
import com.zbjdl.account.dto.TaxInfoDto;

@Service("taxInfoService")
public class TaxInfoServiceImpl implements TaxInfoService {
	
	@Autowired
	private TaxInfoManager taxInfoManager;
	
	@Override
	public Integer saveOrUpdate(TaxInfoDto taxInfoDto) {
		if (taxInfoDto.getId()!=null) {
			TaxInfo taxInfo = taxInfoManager.selectById(taxInfoDto.getId());
			BeanUtils.copyProperties(taxInfoDto, taxInfo);
			return taxInfoManager.update(taxInfo);
		}else {
			TaxInfo taxInfo = new TaxInfo();
			BeanUtils.copyProperties(taxInfoDto, taxInfo);
			return taxInfoManager.save(taxInfo);
		}
	}
	
	@Override
	public TaxInfoDto selectById(Long id) {
		TaxInfo taxInfo = taxInfoManager.selectById(id);
		TaxInfoDto taxInfoDto = new TaxInfoDto();
		BeanUtils.copyProperties(taxInfo, taxInfoDto);
		return taxInfoDto;
	}
	
	@Override
	public List<TaxInfoDto> findList(TaxInfoDto taxInfoDto) {
		TaxInfo taxInfo = new TaxInfo();
		BeanUtils.copyProperties(taxInfoDto, taxInfo);
		List<TaxInfo> taxInfoList = taxInfoManager.findList(taxInfo);
		
		List<TaxInfoDto> taxInfoDtoList = new ArrayList<TaxInfoDto>();
		for(TaxInfo dto : taxInfoList){
			TaxInfoDto respDto = new TaxInfoDto();
			BeanUtils.copyProperties(dto, respDto);
			taxInfoDtoList.add(respDto);
		}
		return taxInfoDtoList;
	}
	
}

