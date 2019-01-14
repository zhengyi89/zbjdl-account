/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.repository;

import java.util.List;

import com.zbjdl.account.model.VoucherInfo;
import com.zbjdl.common.respository.mybatis.GenericRepository;

import org.springframework.stereotype.Repository;

/**
 * VoucherInfo
 * @author code-generator
 *
 */
@Repository
public interface VoucherInfoRepository extends GenericRepository {

	List<VoucherInfo> findListByMonth(String systemCode, String accountMonth);

	Integer selectDefaultSerialNum(String systemCode, String accountMonth);

	List<VoucherInfo> findListMonthBetween(String systemCode, String startDate, String endDate);
	
}