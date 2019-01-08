/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager;

import java.util.List;

import com.zbjdl.account.model.InvoiceInfo;

public interface InvoiceInfoManager {

	Integer save(InvoiceInfo invoiceInfo);
	
	Integer update(InvoiceInfo invoiceInfo);
	
	InvoiceInfo selectById(Long id);
	
	List<InvoiceInfo> findList(InvoiceInfo invoiceInfo);
	
}
