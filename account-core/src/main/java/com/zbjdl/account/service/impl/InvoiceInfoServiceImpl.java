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

import com.zbjdl.account.manager.InvoiceInfoManager;
import com.zbjdl.account.service.InvoiceInfoService;
import com.zbjdl.account.model.InvoiceInfo;
import com.zbjdl.account.dto.InvoiceInfoDto;

@Service("invoiceInfoService")
public class InvoiceInfoServiceImpl implements InvoiceInfoService {
	
	@Autowired
	private InvoiceInfoManager invoiceInfoManager;
	
	@Override
	public Integer saveOrUpdate(InvoiceInfoDto invoiceInfoDto) {
		if (invoiceInfoDto.getId()!=null) {
			InvoiceInfo invoiceInfo = invoiceInfoManager.selectById(invoiceInfoDto.getId());
			BeanUtils.copyProperties(invoiceInfoDto, invoiceInfo);
			return invoiceInfoManager.update(invoiceInfo);
		}else {
			InvoiceInfo invoiceInfo = new InvoiceInfo();
			BeanUtils.copyProperties(invoiceInfoDto, invoiceInfo);
			return invoiceInfoManager.save(invoiceInfo);
		}
	}
	
	@Override
	public InvoiceInfoDto selectById(Long id) {
		InvoiceInfo invoiceInfo = invoiceInfoManager.selectById(id);
		InvoiceInfoDto invoiceInfoDto = new InvoiceInfoDto();
		BeanUtils.copyProperties(invoiceInfo, invoiceInfoDto);
		return invoiceInfoDto;
	}
	
	@Override
	public List<InvoiceInfoDto> findList(InvoiceInfoDto invoiceInfoDto) {
		InvoiceInfo invoiceInfo = new InvoiceInfo();
		BeanUtils.copyProperties(invoiceInfoDto, invoiceInfo);
		List<InvoiceInfo> invoiceInfoList = invoiceInfoManager.findList(invoiceInfo);
		
		List<InvoiceInfoDto> invoiceInfoDtoList = new ArrayList<InvoiceInfoDto>();
		for(InvoiceInfo dto : invoiceInfoList){
			InvoiceInfoDto respDto = new InvoiceInfoDto();
			BeanUtils.copyProperties(dto, respDto);
			invoiceInfoDtoList.add(respDto);
		}
		return invoiceInfoDtoList;
	}
	
}

