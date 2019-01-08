/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.repository;

import java.util.List;

import com.zbjdl.account.dto.VoucherInfoDto;
import com.zbjdl.common.respository.mybatis.GenericRepository;

import org.springframework.stereotype.Repository;

/**
 * VoucherInfo
 * @author code-generator
 *
 */
@Repository
public interface VoucherInfoRepository extends GenericRepository {

	List<VoucherInfoDto> findListByMonth(String systemCode, String accountMonth);

	String selectDefaultSerialNum(String systemCode, String accountMonth);
	
}