/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zbjdl.account.repository.SubjectInfoRepository;
import com.zbjdl.account.manager.SubjectInfoManager;
import com.zbjdl.account.model.SubjectInfo;

@Component
public class SubjectInfoManagerImpl implements SubjectInfoManager {
	
	@Autowired
	private SubjectInfoRepository subjectInfoRepository;
	
	@Override
	public Integer save(SubjectInfo subjectInfo) {
		return subjectInfoRepository.save(subjectInfo);
	}
	
	@Override
	public Integer update(SubjectInfo subjectInfo) {
		return subjectInfoRepository.update(subjectInfo);
	}
	
	@Override
	public SubjectInfo selectById(Long id) {
		return subjectInfoRepository.selectById(id);
	}
	
	@Override
	public List<SubjectInfo> findList(SubjectInfo subjectInfo) {
		return subjectInfoRepository.findList(subjectInfo);
	}

	@Override
	public void initSubjectForSystem(String systemCode, String defaultType) {
		subjectInfoRepository.initSubjectForSystem(systemCode, defaultType);
	}

	@Override
	public Integer findMaxCodeByParentCode(String subjectCode, String systemCode) {
		return subjectInfoRepository.findMaxCodeByParentCode(subjectCode, systemCode);
	}

	@Override
	public List<SubjectInfo> findListWithAssist(String systemCode) {
		return subjectInfoRepository.findListWithAssist(systemCode);
	}

}

