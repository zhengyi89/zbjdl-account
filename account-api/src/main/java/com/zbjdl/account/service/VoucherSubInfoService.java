/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.service;

import java.util.List;

import com.zbjdl.account.dto.VoucherSubDetailDto;
import com.zbjdl.account.dto.VoucherSubInfoDto;
import com.zbjdl.account.dto.request.DetailAccountReportReqDto;

public interface VoucherSubInfoService {
	Integer saveOrUpdate(VoucherSubInfoDto voucherSubInfoDto);

	VoucherSubInfoDto selectById(Long id);
	
	List<VoucherSubInfoDto> findList(VoucherSubInfoDto voucherSubInfoDto);

	List<VoucherSubInfoDto> selectByVoucherId(Long voucherId);

	List<VoucherSubInfoDto> findListByMonth(String systemCode, String accountMonth);

	List<VoucherSubDetailDto> findListByParamOrder(DetailAccountReportReqDto reqDto);

	void delete(Long id);
}
