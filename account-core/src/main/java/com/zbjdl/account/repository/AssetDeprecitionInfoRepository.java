/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.repository;

import java.util.List;

import com.zbjdl.account.dto.request.FindPreDeprecitionInfoReqDto;
import com.zbjdl.account.model.AssetDeprecitionInfo;
import com.zbjdl.common.respository.mybatis.GenericRepository;

import org.springframework.stereotype.Repository;

/**
 * AssetDeprecitionInfo
 * @author code-generator
 *
 */
@Repository
public interface AssetDeprecitionInfoRepository extends GenericRepository {

	void doDeprecition(String systemCode, String accountMonth);

	List<AssetDeprecitionInfo> findPreDeprecition(FindPreDeprecitionInfoReqDto reqDto);
	
}