package com.zbjdl.account.dto;

import java.io.Serializable;

public class CurrentSystemDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String systemName; // 系统名称

	private Long companyId; // 客户id

	private Long systemId; // 系统id

	private String systemCode; // 系统编码

	private String accountMonth; // 记账月份

	private String startMonth; // 起始记账月份
	
	private String latestMonth; // 最新记账月份
	
	private String accountType; // 企业性质

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getAccountMonth() {
		return accountMonth;
	}

	public void setAccountMonth(String accountMonth) {
		this.accountMonth = accountMonth;
	}

	public Long getSystemId() {
		return systemId;
	}

	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getLatestMonth() {
		return latestMonth;
	}

	public void setLatestMonth(String latestMonth) {
		this.latestMonth = latestMonth;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	
}
