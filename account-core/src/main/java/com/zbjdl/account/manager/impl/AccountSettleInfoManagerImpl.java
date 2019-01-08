/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zbjdl.account.repository.AccountSettleInfoRepository;
import com.zbjdl.account.dto.AccountSettleWithSubjectInfoDto;
import com.zbjdl.account.manager.AccountSettleInfoManager;
import com.zbjdl.account.model.AccountSettleInfo;

@Component
public class AccountSettleInfoManagerImpl implements AccountSettleInfoManager {
	
	@Autowired
	private AccountSettleInfoRepository accountSettleInfoRepository;
	
	@Override
	public Integer save(AccountSettleInfo accountSettleInfo) {
		return accountSettleInfoRepository.save(accountSettleInfo);
	}
	
	@Override
	public Integer update(AccountSettleInfo accountSettleInfo) {
		return accountSettleInfoRepository.update(accountSettleInfo);
	}
	
	@Override
	public AccountSettleInfo selectById(Long id) {
		return accountSettleInfoRepository.selectById(id);
	}
	
	@Override
	public List<AccountSettleInfo> findList(AccountSettleInfo accountSettleInfo) {
		return accountSettleInfoRepository.findList(accountSettleInfo);
	}

	@Override
	public void initSubjectOpening(String syscode, String accountMonth) {
		accountSettleInfoRepository.initSubjectOpening(syscode, accountMonth);
	}

	@Override
	public List<AccountSettleWithSubjectInfoDto> findInitBySystemCode(String systemCode) {
		return accountSettleInfoRepository.findInitBySystemCode(systemCode);
	}

	@Override
	public List<AccountSettleWithSubjectInfoDto> findListByMonth(String systemCode, String accountMonth) {
		return accountSettleInfoRepository.findListByMonth(systemCode, accountMonth);
	}

}

