/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.repository;

import com.zbjdl.common.respository.mybatis.GenericRepository;

import org.springframework.stereotype.Repository;

/**
 * AssetClassInfo
 * @author code-generator
 *
 */
@Repository
public interface AssetClassInfoRepository extends GenericRepository {

	void initAssetClass(String systemCode);
	
}