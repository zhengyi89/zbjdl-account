/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.dto.request;

import java.io.Serializable;
import java.util.List;

/**
 * AccountSettleInfoSaveReqDto
 * 
 * @author code-generator
 *
 */
public class AccountSettleWithAssistSaveReqDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private java.lang.Long id;
	private Long subjectId;
	private String accountMonth;
	private String extend;

	List<AccountSettleInfoSaveReqDto> accountSettleInfoSaveReqDto;

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getAccountMonth() {
		return accountMonth;
	}

	public void setAccountMonth(String accountMonth) {
		this.accountMonth = accountMonth;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public List<AccountSettleInfoSaveReqDto> getAccountSettleInfoSaveReqDto() {
		return accountSettleInfoSaveReqDto;
	}

	public void setAccountSettleInfoSaveReqDto(List<AccountSettleInfoSaveReqDto> accountSettleInfoSaveReqDto) {
		this.accountSettleInfoSaveReqDto = accountSettleInfoSaveReqDto;
	}

	

}