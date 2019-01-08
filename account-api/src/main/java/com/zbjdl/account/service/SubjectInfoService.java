/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.service;

import java.util.List;

import com.zbjdl.account.dto.SubjectInfoDto;

public interface SubjectInfoService {
	Integer saveOrUpdate(SubjectInfoDto subjectInfoDto);

	SubjectInfoDto selectById(Long id);
	
	List<SubjectInfoDto> findList(SubjectInfoDto subjectInfoDto);

	List<SubjectInfoDto> findBySyscode(String systemCode);

	void initSubjectForSystem(String systemCode, String defaultType);

	Integer findMaxCodeByParentCode(String subjectCode, String systemCode);

	void changeStatus(Long id, String status);

	SubjectInfoDto selectByCode(String subjectCode, String systemCode);

	List<SubjectInfoDto> findListWithAssist(String systemCode);
	
}
