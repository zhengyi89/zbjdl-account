/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.service;

import java.util.List;

import com.zbjdl.account.dto.VoucherInfoDto;

public interface VoucherInfoService {
	Long saveOrUpdate(VoucherInfoDto voucherInfoDto);

	VoucherInfoDto selectById(Long id);

	List<VoucherInfoDto> findList(VoucherInfoDto voucherInfoDto);

	List<VoucherInfoDto> findListByMonth(String systemCode, String accountMonth);

	String selectDefaultSerialNum(String systemCode, String accountMonth);

}
