/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager;

import java.util.List;

import com.zbjdl.account.dto.VoucherInfoDto;
import com.zbjdl.account.model.VoucherInfo;

public interface VoucherInfoManager {

	Integer save(VoucherInfo voucherInfo);
	
	Integer update(VoucherInfo voucherInfo);
	
	VoucherInfo selectById(Long id);
	
	List<VoucherInfo> findList(VoucherInfo voucherInfo);

	List<VoucherInfo> findListByMonth(String systemCode, String accountMonth);

	Integer selectDefaultSerialNum(String systemCode, String accountMonth);

	List<VoucherInfo> findListMonthBetween(String systemCode, String startDate, String endDate);

	VoucherInfo selectBySubId(Long id);

	void batchAudit(List<VoucherInfoDto> param);
}
