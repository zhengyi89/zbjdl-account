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

import com.zbjdl.account.manager.DeprecitionDetailManager;
import com.zbjdl.account.service.DeprecitionDetailService;
import com.zbjdl.account.model.DeprecitionDetail;
import com.zbjdl.account.dto.DeprecitionDetailDto;

@Service("deprecitionDetailService")
public class DeprecitionDetailServiceImpl implements DeprecitionDetailService {
	
	@Autowired
	private DeprecitionDetailManager deprecitionDetailManager;
	
	@Override
	public Integer saveOrUpdate(DeprecitionDetailDto deprecitionDetailDto) {
		if (deprecitionDetailDto.getId()!=null) {
			DeprecitionDetail deprecitionDetail = deprecitionDetailManager.selectById(deprecitionDetailDto.getId());
			BeanUtils.copyProperties(deprecitionDetailDto, deprecitionDetail);
			return deprecitionDetailManager.update(deprecitionDetail);
		}else {
			DeprecitionDetail deprecitionDetail = new DeprecitionDetail();
			BeanUtils.copyProperties(deprecitionDetailDto, deprecitionDetail);
			return deprecitionDetailManager.save(deprecitionDetail);
		}
	}
	
	@Override
	public DeprecitionDetailDto selectById(Long id) {
		DeprecitionDetail deprecitionDetail = deprecitionDetailManager.selectById(id);
		DeprecitionDetailDto deprecitionDetailDto = new DeprecitionDetailDto();
		BeanUtils.copyProperties(deprecitionDetail, deprecitionDetailDto);
		return deprecitionDetailDto;
	}
	
	@Override
	public List<DeprecitionDetailDto> findList(DeprecitionDetailDto deprecitionDetailDto) {
		DeprecitionDetail deprecitionDetail = new DeprecitionDetail();
		BeanUtils.copyProperties(deprecitionDetailDto, deprecitionDetail);
		List<DeprecitionDetail> deprecitionDetailList = deprecitionDetailManager.findList(deprecitionDetail);
		
		List<DeprecitionDetailDto> deprecitionDetailDtoList = new ArrayList<DeprecitionDetailDto>();
		for(DeprecitionDetail dto : deprecitionDetailList){
			DeprecitionDetailDto respDto = new DeprecitionDetailDto();
			BeanUtils.copyProperties(dto, respDto);
			deprecitionDetailDtoList.add(respDto);
		}
		return deprecitionDetailDtoList;
	}
	
}

