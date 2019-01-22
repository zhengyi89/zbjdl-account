/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.repository;

import com.zbjdl.common.respository.mybatis.GenericRepository;

import org.springframework.stereotype.Repository;

/**
 * CurrencyInfo
 * @author code-generator
 *
 */
@Repository
public interface CurrencyInfoRepository extends GenericRepository {

	void initCurrencyForSystem(String systemCode);
	
}