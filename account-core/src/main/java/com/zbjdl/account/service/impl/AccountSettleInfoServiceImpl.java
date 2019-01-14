/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbjdl.common.utils.BeanUtils;
import com.zbjdl.common.utils.StringUtils;
import com.zbjdl.account.manager.AccountSettleInfoManager;
import com.zbjdl.account.service.AccountSettleInfoService;
import com.zbjdl.account.model.AccountSettleInfo;
import com.zbjdl.account.dto.AccountSettleInfoDto;
import com.zbjdl.account.dto.AccountSettleWithSubjectInfoDto;

@Service("accountSettleInfoService")
public class AccountSettleInfoServiceImpl implements AccountSettleInfoService {
	
	@Autowired
	private AccountSettleInfoManager accountSettleInfoManager;
	
	@Override
	public Integer saveOrUpdate(AccountSettleInfoDto accountSettleInfoDto) {
		if (accountSettleInfoDto.getId()!=null) {
			AccountSettleInfo accountSettleInfo = accountSettleInfoManager.selectById(accountSettleInfoDto.getId());
			BeanUtils.copyProperties(accountSettleInfoDto, accountSettleInfo);
			return accountSettleInfoManager.update(accountSettleInfo);
		}else {
			AccountSettleInfo accountSettleInfo = new AccountSettleInfo();
			BeanUtils.copyProperties(accountSettleInfoDto, accountSettleInfo);
			return accountSettleInfoManager.save(accountSettleInfo);
		}
	}
	
	@Override
	public AccountSettleInfoDto selectById(Long id) {
		AccountSettleInfo accountSettleInfo = accountSettleInfoManager.selectById(id);
		AccountSettleInfoDto accountSettleInfoDto = new AccountSettleInfoDto();
		BeanUtils.copyProperties(accountSettleInfo, accountSettleInfoDto);
		return accountSettleInfoDto;
	}
	
	@Override
	public List<AccountSettleInfoDto> findList(AccountSettleInfoDto accountSettleInfoDto) {
		AccountSettleInfo accountSettleInfo = new AccountSettleInfo();
		BeanUtils.copyProperties(accountSettleInfoDto, accountSettleInfo);
		List<AccountSettleInfo> accountSettleInfoList = accountSettleInfoManager.findList(accountSettleInfo);
		
		List<AccountSettleInfoDto> accountSettleInfoDtoList = new ArrayList<AccountSettleInfoDto>();
		for(AccountSettleInfo dto : accountSettleInfoList){
			AccountSettleInfoDto respDto = new AccountSettleInfoDto();
			BeanUtils.copyProperties(dto, respDto);
			accountSettleInfoDtoList.add(respDto);
		}
		return accountSettleInfoDtoList;
	}

	@Override
	public void initSubjectOpening(String syscode, String accountMonth) {
		// TODO Auto-generated method stub
		accountSettleInfoManager.initSubjectOpening(syscode, accountMonth);
	}

	@Override
	public List<AccountSettleWithSubjectInfoDto> findInitBySystemCode(String systemCode) {
		return accountSettleInfoManager.findInitBySystemCode(systemCode);
	}

	@Override
	public List<AccountSettleWithSubjectInfoDto> findListByMonth(String systemCode, String accountMonth) {
		return accountSettleInfoManager.findListByMonth(systemCode, accountMonth);
		
	}

	@Override
	public AccountSettleInfoDto findBySubjectIdAndMonth(Long subjectId, String prevMonth) {
		AccountSettleInfoDto accountSettleInfoDto = new AccountSettleInfoDto();
		accountSettleInfoDto.setAccountMonth(prevMonth);
		accountSettleInfoDto.setSubjectId(subjectId);
		List<AccountSettleInfoDto> list = this.findList(accountSettleInfoDto);
		// 如果查询到辅助核算
		if (list.size()>0) {
			for (AccountSettleInfoDto accountSettleInfoDto2 : list) {
				if (accountSettleInfoDto2.getParentId()==null) {
					return accountSettleInfoDto2;
				}
			}
		}
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public List<AccountSettleWithSubjectInfoDto> findBySubjectCode(String systemCode, String subjectCode) {
		return accountSettleInfoManager.findBySubjectCode(systemCode,subjectCode);
	}

	@Override
	public Boolean isSettle(String systemCode, String accountMonth) {
		return accountSettleInfoManager.isSettle(systemCode, accountMonth);
	}

	@Override
	public void deleteChildren(Long id) {
		accountSettleInfoManager.deleteChildren(id);
	}

	@Override
	public List<AccountSettleWithSubjectInfoDto> findListByParentId(Long parentId) {
		return accountSettleInfoManager.findListByParentId(parentId);
	}

	@Override
	public AccountSettleInfoDto findAssistRecord(Long subjectId, String assistCode, String nextMonth) {
		AccountSettleInfoDto accountSettleInfoDto = new AccountSettleInfoDto();
		accountSettleInfoDto.setAccountMonth(nextMonth);
		accountSettleInfoDto.setSubjectId(subjectId);
		if (StringUtils.isNotBlank(assistCode)) {
			accountSettleInfoDto.setAssistCode(assistCode);
		}
		List<AccountSettleInfoDto> list = this.findList(accountSettleInfoDto);
		
		if (StringUtils.isNotBlank(assistCode)) {
			return list.isEmpty()?null:list.get(0);
		}else {
			// 如果assistcode为空，返回汇总信息
			for (AccountSettleInfoDto accountSettleInfoDto2 : list) {
				if (accountSettleInfoDto2.getParentId()==null) {
					return accountSettleInfoDto2;
				}
			}
		}
		return null;
	}
	
}

