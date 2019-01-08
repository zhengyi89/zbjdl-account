/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zbjdl.account.repository.InvoiceInfoRepository;
import com.zbjdl.account.manager.InvoiceInfoManager;
import com.zbjdl.account.model.InvoiceInfo;

@Component
public class InvoiceInfoManagerImpl implements InvoiceInfoManager {
	
	@Autowired
	private InvoiceInfoRepository invoiceInfoRepository;
	
	@Override
	public Integer save(InvoiceInfo invoiceInfo) {
		return invoiceInfoRepository.save(invoiceInfo);
	}
	
	@Override
	public Integer update(InvoiceInfo invoiceInfo) {
		return invoiceInfoRepository.update(invoiceInfo);
	}
	
	@Override
	public InvoiceInfo selectById(Long id) {
		return invoiceInfoRepository.selectById(id);
	}
	
	@Override
	public List<InvoiceInfo> findList(InvoiceInfo invoiceInfo) {
		return invoiceInfoRepository.findList(invoiceInfo);
	}

}

