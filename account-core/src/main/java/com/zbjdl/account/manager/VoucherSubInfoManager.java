/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager;

import java.util.List;

import com.zbjdl.account.model.VoucherSubInfo;

public interface VoucherSubInfoManager {

	Integer save(VoucherSubInfo voucherSubInfo);
	
	Integer update(VoucherSubInfo voucherSubInfo);
	
	VoucherSubInfo selectById(Long id);
	
	List<VoucherSubInfo> findList(VoucherSubInfo voucherSubInfo);

	List<VoucherSubInfo> findListByMonth(String systemCode, String accountMonth);
	
}
