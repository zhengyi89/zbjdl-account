/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zbjdl.account.repository.AssistAccountInfoRepository;
import com.zbjdl.account.manager.AssistAccountInfoManager;
import com.zbjdl.account.model.AssistAccountInfo;

@Component
public class AssistAccountInfoManagerImpl implements AssistAccountInfoManager {
	
	@Autowired
	private AssistAccountInfoRepository assistAccountInfoRepository;
	
	@Override
	public Integer save(AssistAccountInfo assistAccountInfo) {
		return assistAccountInfoRepository.save(assistAccountInfo);
	}
	
	@Override
	public Integer update(AssistAccountInfo assistAccountInfo) {
		return assistAccountInfoRepository.update(assistAccountInfo);
	}
	
	@Override
	public AssistAccountInfo selectById(Long id) {
		return assistAccountInfoRepository.selectById(id);
	}
	
	@Override
	public List<AssistAccountInfo> findList(AssistAccountInfo assistAccountInfo) {
		return assistAccountInfoRepository.findList(assistAccountInfo);
	}

}

