/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager;

import java.util.List;

import com.zbjdl.account.model.SubjectInfo;

public interface SubjectInfoManager {

	Integer save(SubjectInfo subjectInfo);
	
	Integer update(SubjectInfo subjectInfo);
	
	SubjectInfo selectById(Long id);
	
	List<SubjectInfo> findList(SubjectInfo subjectInfo);

	void initSubjectForSystem(String systemCode, String defaultType);

	Integer findMaxCodeByParentCode(String subjectCode, String systemCode);

	List<SubjectInfo> findListWithAssist(String systemCode);
	
}
