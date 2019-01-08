/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager;

import java.util.List;

import com.zbjdl.account.model.AssistAccountInfo;

public interface AssistAccountInfoManager {

	Integer save(AssistAccountInfo assistAccountInfo);
	
	Integer update(AssistAccountInfo assistAccountInfo);
	
	AssistAccountInfo selectById(Long id);
	
	List<AssistAccountInfo> findList(AssistAccountInfo assistAccountInfo);
	
}
