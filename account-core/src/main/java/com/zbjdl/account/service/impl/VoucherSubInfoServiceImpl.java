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
import com.zbjdl.account.manager.VoucherSubInfoManager;
import com.zbjdl.account.service.VoucherSubInfoService;
import com.zbjdl.account.model.VoucherSubInfo;
import com.zbjdl.account.dto.VoucherSubDetailDto;
import com.zbjdl.account.dto.VoucherSubInfoDto;
import com.zbjdl.account.dto.request.DetailAccountReportReqDto;

@Service("voucherSubInfoService")
public class VoucherSubInfoServiceImpl implements VoucherSubInfoService {

	@Autowired
	private VoucherSubInfoManager voucherSubInfoManager;

	@Override
	public Integer saveOrUpdate(VoucherSubInfoDto voucherSubInfoDto) {
		if (voucherSubInfoDto.getId() != null) {
			VoucherSubInfo voucherSubInfo = voucherSubInfoManager.selectById(voucherSubInfoDto.getId());
			BeanUtils.copyProperties(voucherSubInfoDto, voucherSubInfo);
			return voucherSubInfoManager.update(voucherSubInfo);
		} else {
			VoucherSubInfo voucherSubInfo = new VoucherSubInfo();
			BeanUtils.copyProperties(voucherSubInfoDto, voucherSubInfo);
			return voucherSubInfoManager.save(voucherSubInfo);
		}
	}

	@Override
	public VoucherSubInfoDto selectById(Long id) {
		VoucherSubInfo voucherSubInfo = voucherSubInfoManager.selectById(id);
		VoucherSubInfoDto voucherSubInfoDto = new VoucherSubInfoDto();
		BeanUtils.copyProperties(voucherSubInfo, voucherSubInfoDto);
		return voucherSubInfoDto;
	}

	@Override
	public List<VoucherSubInfoDto> findList(VoucherSubInfoDto voucherSubInfoDto) {
		VoucherSubInfo voucherSubInfo = new VoucherSubInfo();
		BeanUtils.copyProperties(voucherSubInfoDto, voucherSubInfo);
		List<VoucherSubInfo> voucherSubInfoList = voucherSubInfoManager.findList(voucherSubInfo);

		List<VoucherSubInfoDto> voucherSubInfoDtoList = new ArrayList<VoucherSubInfoDto>();
		for (VoucherSubInfo dto : voucherSubInfoList) {
			VoucherSubInfoDto respDto = new VoucherSubInfoDto();
			BeanUtils.copyProperties(dto, respDto);
			voucherSubInfoDtoList.add(respDto);
		}
		return voucherSubInfoDtoList;
	}

	@Override
	public List<VoucherSubInfoDto> selectByVoucherId(Long voucherId) {
		VoucherSubInfoDto voucherSubInfoDto = new VoucherSubInfoDto();
		voucherSubInfoDto.setVoucherId(voucherId);
		return this.findList(voucherSubInfoDto);
	}

	@Override
	public List<VoucherSubInfoDto> findListByMonth(String systemCode, String accountMonth) {
		List<VoucherSubInfo> voucherSubList = voucherSubInfoManager.findListByMonth(systemCode, accountMonth);
		List<VoucherSubInfoDto> voucherSubInfoDtoList = new ArrayList<VoucherSubInfoDto>();
		for (VoucherSubInfo dto : voucherSubList) {
			VoucherSubInfoDto respDto = new VoucherSubInfoDto();
			BeanUtils.copyProperties(dto, respDto);
			voucherSubInfoDtoList.add(respDto);
		}
		return voucherSubInfoDtoList;
	}

	@Override
	public List<VoucherSubDetailDto> findListByParamOrder(DetailAccountReportReqDto reqDto) {
		return voucherSubInfoManager.findListByParamOrder(reqDto);
	}

	@Override
	public void delete(Long id) {
		voucherSubInfoManager.delete(id);
	}

}
