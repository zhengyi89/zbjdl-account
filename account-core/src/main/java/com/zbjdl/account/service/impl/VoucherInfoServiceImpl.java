/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbjdl.common.utils.BeanUtils;
import com.zbjdl.account.manager.VoucherInfoManager;
import com.zbjdl.account.service.VoucherInfoService;
import com.zbjdl.account.model.VoucherInfo;
import com.zbjdl.account.dto.VoucherInfoDto;
import com.zbjdl.account.enumtype.DataStatusEnum;

@Service("voucherInfoService")
public class VoucherInfoServiceImpl implements VoucherInfoService {
	
	@Autowired
	private VoucherInfoManager voucherInfoManager;
	
	@Override
	public Long saveOrUpdate(VoucherInfoDto voucherInfoDto) {
		VoucherInfo voucherInfo;
		if (voucherInfoDto.getId()!=null) {
			voucherInfo = voucherInfoManager.selectById(voucherInfoDto.getId());
//			try {
//				org.apache.commons.beanutils.BeanUtils.copyProperties(voucherInfo, voucherInfoDto);
//			} catch (IllegalAccessException | InvocationTargetException e) {
//				e.printStackTrace();
//			}
			BeanUtils.copyProperties(voucherInfoDto, voucherInfo);;
			voucherInfoManager.update(voucherInfo);
		}else {
			voucherInfo = new VoucherInfo();
//			try {
//				org.apache.commons.beanutils.BeanUtils.copyProperties(voucherInfo,voucherInfoDto);
//			} catch (IllegalAccessException | InvocationTargetException e) {
//				e.printStackTrace();
//			}
			BeanUtils.copyProperties(voucherInfoDto, voucherInfo);;
			voucherInfo.setStatus(DataStatusEnum.NORMAL.getCode());
			voucherInfoManager.save(voucherInfo);
		}
		return voucherInfo.getId();
	}
	
	@Override
	public VoucherInfoDto selectById(Long id) {
		VoucherInfo voucherInfo = voucherInfoManager.selectById(id);
		VoucherInfoDto voucherInfoDto = new VoucherInfoDto();
		BeanUtils.copyProperties(voucherInfo, voucherInfoDto);
		return voucherInfoDto;
	}
	
	@Override
	public List<VoucherInfoDto> findList(VoucherInfoDto voucherInfoDto) {
		VoucherInfo voucherInfo = new VoucherInfo();
		BeanUtils.copyProperties(voucherInfoDto, voucherInfo);
		List<VoucherInfo> voucherInfoList = voucherInfoManager.findList(voucherInfo);
		
		List<VoucherInfoDto> voucherInfoDtoList = new ArrayList<VoucherInfoDto>();
		for(VoucherInfo dto : voucherInfoList){
			VoucherInfoDto respDto = new VoucherInfoDto();
			BeanUtils.copyProperties(dto, respDto);
			voucherInfoDtoList.add(respDto);
		}
		return voucherInfoDtoList;
	}

	@Override
	public List<VoucherInfoDto> findListByMonth(String systemCode, String accountMonth) {
		List<VoucherInfo> voucherInfoList  = voucherInfoManager.findListByMonth(systemCode, accountMonth);
		List<VoucherInfoDto> voucherInfoDtoList = new ArrayList<VoucherInfoDto>();
		for(VoucherInfo dto : voucherInfoList){
			VoucherInfoDto respDto = new VoucherInfoDto();
			BeanUtils.copyProperties(dto, respDto);
			voucherInfoDtoList.add(respDto);
		}
		return voucherInfoDtoList;
	}
	
	@Override
	public Integer selectDefaultSerialNum(String systemCode, String accountMonth) {
		return voucherInfoManager.selectDefaultSerialNum(systemCode, accountMonth);
	}

	@Override
	public List<VoucherInfoDto> findListMonthBetween(String systemCode, String startDate, String endDate) {
		List<VoucherInfo> voucherInfoList  = voucherInfoManager.findListMonthBetween(systemCode, startDate, endDate);
				List<VoucherInfoDto> voucherInfoDtoList = new ArrayList<VoucherInfoDto>();
		for(VoucherInfo dto : voucherInfoList){
			VoucherInfoDto respDto = new VoucherInfoDto();
			BeanUtils.copyProperties(dto, respDto);
			voucherInfoDtoList.add(respDto);
		}
		return voucherInfoDtoList;
	}

	@Override
	public VoucherInfoDto selectBySubId(Long id) {
		VoucherInfo voucherInfo = voucherInfoManager.selectBySubId(id);
		VoucherInfoDto voucherInfoDto = new VoucherInfoDto();
		BeanUtils.copyProperties(voucherInfo, voucherInfoDto);
		return voucherInfoDto;
	}

	@Override
	public void batchAudit(List<VoucherInfoDto> param) {
		voucherInfoManager.batchAudit(param);
	}
	
}

