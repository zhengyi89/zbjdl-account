/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.service;

import java.util.List;

import com.zbjdl.account.dto.AccountSettleInfoDto;
import com.zbjdl.account.dto.AccountSettleWithSubjectInfoDto;

public interface AccountSettleInfoService {
	
	Integer saveOrUpdate(AccountSettleInfoDto accountSettleInfoDto);

	AccountSettleInfoDto selectById(Long id);
	
	List<AccountSettleInfoDto> findList(AccountSettleInfoDto accountSettleInfoDto);

	void initSubjectOpening(String syscode, String accountMonth);

	List<AccountSettleWithSubjectInfoDto> findInitBySystemCode(String systemCode);

	List<AccountSettleWithSubjectInfoDto> findListByMonth(String systemCode, String accountMonth);

	AccountSettleInfoDto findInitBySubjectAndMonth(Long subjectId, String prevMonth);
	
}
