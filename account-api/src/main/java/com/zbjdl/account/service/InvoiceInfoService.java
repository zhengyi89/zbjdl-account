/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.service;

import java.util.List;

import com.zbjdl.account.dto.InvoiceInfoDto;

public interface InvoiceInfoService {
	Integer saveOrUpdate(InvoiceInfoDto invoiceInfoDto);

	InvoiceInfoDto selectById(Long id);
	
	List<InvoiceInfoDto> findList(InvoiceInfoDto invoiceInfoDto);
	
}
