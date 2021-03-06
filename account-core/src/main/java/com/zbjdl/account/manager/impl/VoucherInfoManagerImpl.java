/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zbjdl.account.repository.VoucherInfoRepository;
import com.zbjdl.account.dto.VoucherInfoDto;
import com.zbjdl.account.manager.VoucherInfoManager;
import com.zbjdl.account.model.VoucherInfo;

@Component
public class VoucherInfoManagerImpl implements VoucherInfoManager {
	
	@Autowired
	private VoucherInfoRepository voucherInfoRepository;
	
	@Override
	public Integer save(VoucherInfo voucherInfo) {
		return voucherInfoRepository.save(voucherInfo);
	}
	
	@Override
	public Integer update(VoucherInfo voucherInfo) {
		return voucherInfoRepository.update(voucherInfo);
	}
	
	@Override
	public VoucherInfo selectById(Long id) {
		return voucherInfoRepository.selectById(id);
	}
	
	@Override
	public List<VoucherInfo> findList(VoucherInfo voucherInfo) {
		return voucherInfoRepository.findList(voucherInfo);
	}

	@Override
	public List<VoucherInfo> findListByMonth(String systemCode, String accountMonth) {
		return voucherInfoRepository.findListByMonth(systemCode, accountMonth);
	}


	@Override
	public Integer selectDefaultSerialNum(String systemCode, String accountMonth) {
		return voucherInfoRepository.selectDefaultSerialNum(systemCode, accountMonth);
	}

	@Override
	public List<VoucherInfo> findListMonthBetween(String systemCode, String startDate, String endDate) {
		return voucherInfoRepository.findListMonthBetween(systemCode, startDate, endDate);
	}

	@Override
	public VoucherInfo selectBySubId(Long id) {
		return voucherInfoRepository.selectBySubId(id);
	}

	@Override
	public void batchAudit(List<VoucherInfoDto> param) {
		voucherInfoRepository.batchAudit(param);
	}

}

