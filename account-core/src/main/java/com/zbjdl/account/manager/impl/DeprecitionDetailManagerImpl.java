/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zbjdl.account.repository.DeprecitionDetailRepository;
import com.zbjdl.account.manager.DeprecitionDetailManager;
import com.zbjdl.account.model.DeprecitionDetail;

@Component
public class DeprecitionDetailManagerImpl implements DeprecitionDetailManager {
	
	@Autowired
	private DeprecitionDetailRepository deprecitionDetailRepository;
	
	@Override
	public Integer save(DeprecitionDetail deprecitionDetail) {
		return deprecitionDetailRepository.save(deprecitionDetail);
	}
	
	@Override
	public Integer update(DeprecitionDetail deprecitionDetail) {
		return deprecitionDetailRepository.update(deprecitionDetail);
	}
	
	@Override
	public DeprecitionDetail selectById(Long id) {
		return deprecitionDetailRepository.selectById(id);
	}
	
	@Override
	public List<DeprecitionDetail> findList(DeprecitionDetail deprecitionDetail) {
		return deprecitionDetailRepository.findList(deprecitionDetail);
	}

}

