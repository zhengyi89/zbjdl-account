/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager;

import java.util.List;

import com.zbjdl.account.dto.AccountSettleWithSubjectInfoDto;
import com.zbjdl.account.model.AccountSettleInfo;

public interface AccountSettleInfoManager {

	Integer save(AccountSettleInfo accountSettleInfo);
	
	Integer update(AccountSettleInfo accountSettleInfo);
	
	AccountSettleInfo selectById(Long id);
	
	List<AccountSettleInfo> findList(AccountSettleInfo accountSettleInfo);

	void initSubjectOpening(String syscode, String accountMonth);

	List<AccountSettleWithSubjectInfoDto> findInitBySystemCode(String systemCode);

	List<AccountSettleWithSubjectInfoDto> findListByMonth(String systemCode, String accountMonth);

	List<AccountSettleWithSubjectInfoDto> findBySubjectCode(String systemCode, String subjectCode);

	Boolean isSettle(String systemCode, String accountMonth);

	void deleteChildren(Long id);

	List<AccountSettleWithSubjectInfoDto> findListByParentId(Long parentId);
	
}
