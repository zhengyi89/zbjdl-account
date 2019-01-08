/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.dto;


/**
 * AccountSettleInfoDto
 * 
 * @author code-generator
 *
 */
public class AccountSettleWithSubjectInfoDto extends AccountSettleInfoDto{
	private static final long serialVersionUID = 1L;

	private String subjectCode;
	private String balanceDirect;
	private java.lang.String basicSubject;
	private java.lang.String assistAccount;
	private java.lang.Boolean lastLevel;
	private java.lang.String parentCode;
	
	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getBalanceDirect() {
		return balanceDirect;
	}

	public void setBalanceDirect(String balanceDirect) {
		this.balanceDirect = balanceDirect;
	}

	public java.lang.String getBasicSubject() {
		return basicSubject;
	}

	public void setBasicSubject(java.lang.String basicSubject) {
		this.basicSubject = basicSubject;
	}

	public java.lang.String getAssistAccount() {
		return assistAccount;
	}

	public void setAssistAccount(java.lang.String assistAccount) {
		this.assistAccount = assistAccount;
	}

	public java.lang.Boolean getLastLevel() {
		return lastLevel;
	}

	public void setLastLevel(java.lang.Boolean lastLevel) {
		this.lastLevel = lastLevel;
	}

	public java.lang.String getParentCode() {
		return parentCode;
	}

	public void setParentCode(java.lang.String parentCode) {
		this.parentCode = parentCode;
	}

	
}