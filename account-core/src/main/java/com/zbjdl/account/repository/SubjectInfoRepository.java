/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.repository;

import java.util.List;

import com.zbjdl.account.model.SubjectInfo;
import com.zbjdl.common.respository.mybatis.GenericRepository;

import org.springframework.stereotype.Repository;

/**
 * SubjectInfo
 * @author code-generator
 *
 */
@Repository
public interface SubjectInfoRepository extends GenericRepository {

	void initSubjectForSystem(String systemCode, String defaultType);

	Integer findMaxCodeByParentCode(String subjectCode, String systemCode);

	List<SubjectInfo> findListWithAssist(String systemCode);
	
}