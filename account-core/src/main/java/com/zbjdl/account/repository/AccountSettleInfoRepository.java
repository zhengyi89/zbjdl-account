/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.repository;

import java.util.List;

import com.zbjdl.account.dto.AccountSettleWithSubjectInfoDto;
import com.zbjdl.account.model.AccountSettleInfo;
import com.zbjdl.common.respository.mybatis.GenericRepository;

import org.springframework.stereotype.Repository;

/**
 * AccountSettleInfo
 * @author code-generator
 *
 */
@Repository
public interface AccountSettleInfoRepository extends GenericRepository {

	void initSubjectOpening(String syscode, String accountMonth);

	List<AccountSettleWithSubjectInfoDto> findInitBySystemCode(String systemCode);

	List<AccountSettleWithSubjectInfoDto> findListByMonth(String systemCode, String accountMonth);

	List<AccountSettleWithSubjectInfoDto> findBySubjectCode(String systemCode, String subjectCode);

	Boolean isSettle(String systemCode, String accountMonth);

	void deleteChildren(Long id);

	List<AccountSettleWithSubjectInfoDto> findListByParentId(Long parentId);
	
}