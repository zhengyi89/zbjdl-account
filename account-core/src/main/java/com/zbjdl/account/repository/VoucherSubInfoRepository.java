/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.repository;

import java.util.List;

import com.zbjdl.account.dto.VoucherSubDetailDto;
import com.zbjdl.account.dto.request.DetailAccountReportReqDto;
import com.zbjdl.account.model.VoucherSubInfo;
import com.zbjdl.common.respository.mybatis.GenericRepository;

import org.springframework.stereotype.Repository;

/**
 * VoucherSubInfo
 * 
 * @author code-generator
 *
 */
@Repository
public interface VoucherSubInfoRepository extends GenericRepository {

	List<VoucherSubInfo> findListByMonth(String systemCode, String accountMonth);

	List<VoucherSubDetailDto> findListByParamOrder(DetailAccountReportReqDto reqDto);

}