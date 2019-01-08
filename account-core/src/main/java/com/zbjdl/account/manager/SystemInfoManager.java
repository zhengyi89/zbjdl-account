/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager;

import java.util.List;

import com.zbjdl.account.model.SystemInfo;

public interface SystemInfoManager {

	Integer save(SystemInfo systemInfo);
	
	Integer update(SystemInfo systemInfo);
	
	SystemInfo selectById(Long id);
	
	List<SystemInfo> findList(SystemInfo systemInfo);
	
}
