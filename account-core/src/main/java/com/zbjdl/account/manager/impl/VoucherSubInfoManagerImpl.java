/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zbjdl.account.repository.VoucherSubInfoRepository;
import com.zbjdl.account.dto.VoucherSubDetailDto;
import com.zbjdl.account.dto.VoucherSubInfoDto;
import com.zbjdl.account.dto.request.DetailAccountReportReqDto;
import com.zbjdl.account.manager.VoucherSubInfoManager;
import com.zbjdl.account.model.VoucherSubInfo;

@Component
public class VoucherSubInfoManagerImpl implements VoucherSubInfoManager {
	
	@Autowired
	private VoucherSubInfoRepository voucherSubInfoRepository;
	
	@Override
	public Integer save(VoucherSubInfo voucherSubInfo) {
		return voucherSubInfoRepository.save(voucherSubInfo);
	}
	
	@Override
	public Integer update(VoucherSubInfo voucherSubInfo) {
		return voucherSubInfoRepository.update(voucherSubInfo);
	}
	
	@Override
	public VoucherSubInfo selectById(Long id) {
		return voucherSubInfoRepository.selectById(id);
	}
	
	@Override
	public List<VoucherSubInfo> findList(VoucherSubInfo voucherSubInfo) {
		return voucherSubInfoRepository.findList(voucherSubInfo);
	}

	@Override
	public List<VoucherSubInfo> findListByMonth(String systemCode, String accountMonth) {
		return voucherSubInfoRepository.findListByMonth(systemCode,accountMonth);
	}

	@Override
	public List<VoucherSubDetailDto> findListByParamOrder(DetailAccountReportReqDto reqDto) {
		return voucherSubInfoRepository.findListByParamOrder(reqDto);
	}

}

