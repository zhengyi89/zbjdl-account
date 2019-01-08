/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zbjdl.account.repository.SystemInfoRepository;
import com.zbjdl.account.manager.SystemInfoManager;
import com.zbjdl.account.model.SystemInfo;

@Component
public class SystemInfoManagerImpl implements SystemInfoManager {
	
	@Autowired
	private SystemInfoRepository systemInfoRepository;
	
	@Override
	public Integer save(SystemInfo systemInfo) {
		return systemInfoRepository.save(systemInfo);
	}
	
	@Override
	public Integer update(SystemInfo systemInfo) {
		return systemInfoRepository.update(systemInfo);
	}
	
	@Override
	public SystemInfo selectById(Long id) {
		return systemInfoRepository.selectById(id);
	}
	
	@Override
	public List<SystemInfo> findList(SystemInfo systemInfo) {
		return systemInfoRepository.findList(systemInfo);
	}

}

