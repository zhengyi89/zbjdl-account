/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.dto;

import java.io.Serializable;

/**
 * VoucherInfoDto
 * @author code-generator
 *
 */
public class VoucherInfoDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String systemCode;
	private java.util.Date accountPeriod;
	private java.lang.String voucherType;
	private java.lang.Integer serialNum;
	private java.lang.Integer voucherPapers;
	private java.lang.String voucherSource;
	private java.lang.String sourceNum;
	private java.lang.Boolean templateFlag;
	private java.lang.String templateName;
	private java.lang.Long creatorId;
	private java.lang.String creatorName;
	private java.lang.Long auditorId;
	private java.lang.String auditorName;
	private java.util.Date createTime;
	private java.util.Date auditTime;
	private java.lang.String status;
	private java.util.Date lastUpdateTime;

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return
	 */
	public Long getId() {
		return this.id;
	}
	/**
	 * 
	 * @param systemCode
	 */
	public void setSystemCode(java.lang.String systemCode) {
		this.systemCode = systemCode;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSystemCode() {
		return this.systemCode;
	}
	/**
	 * 
	 * @param accountPeriod
	 */
	public void setAccountPeriod(java.util.Date accountPeriod) {
		this.accountPeriod = accountPeriod;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.util.Date getAccountPeriod() {
		return this.accountPeriod;
	}
	/**
	 * 
	 * @param voucherType
	 */
	public void setVoucherType(java.lang.String voucherType) {
		this.voucherType = voucherType;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getVoucherType() {
		return this.voucherType;
	}
	/**
	 * 
	 * @param serialNum
	 */
	public void setSerialNum(java.lang.Integer serialNum) {
		this.serialNum = serialNum;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.Integer getSerialNum() {
		return this.serialNum;
	}
	/**
	 * 
	 * @param voucherPapers
	 */
	public void setVoucherPapers(java.lang.Integer voucherPapers) {
		this.voucherPapers = voucherPapers;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.Integer getVoucherPapers() {
		return this.voucherPapers;
	}
	/**
	 * 
	 * @param voucherSource
	 */
	public void setVoucherSource(java.lang.String voucherSource) {
		this.voucherSource = voucherSource;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getVoucherSource() {
		return this.voucherSource;
	}
	/**
	 * 
	 * @param sourceNum
	 */
	public void setSourceNum(java.lang.String sourceNum) {
		this.sourceNum = sourceNum;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSourceNum() {
		return this.sourceNum;
	}
	/**
	 * 
	 * @param templateFlag
	 */
	public void setTemplateFlag(java.lang.Boolean templateFlag) {
		this.templateFlag = templateFlag;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.Boolean getTemplateFlag() {
		return this.templateFlag;
	}
	/**
	 * 
	 * @param creatorId
	 */
	public void setCreatorId(java.lang.Long creatorId) {
		this.creatorId = creatorId;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.Long getCreatorId() {
		return this.creatorId;
	}
	/**
	 * 
	 * @param creatorName
	 */
	public void setCreatorName(java.lang.String creatorName) {
		this.creatorName = creatorName;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getCreatorName() {
		return this.creatorName;
	}
	/**
	 * 
	 * @param auditorId
	 */
	public void setAuditorId(java.lang.Long auditorId) {
		this.auditorId = auditorId;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.Long getAuditorId() {
		return this.auditorId;
	}
	/**
	 * 
	 * @param auditorName
	 */
	public void setAuditorName(java.lang.String auditorName) {
		this.auditorName = auditorName;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getAuditorName() {
		return this.auditorName;
	}
	/**
	 * 
	 * @param createTime
	 */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	/**
	 * 
	 * @param auditTime
	 */
	public void setAuditTime(java.util.Date auditTime) {
		this.auditTime = auditTime;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.util.Date getAuditTime() {
		return this.auditTime;
	}
	/**
	 * 
	 * @param status
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getStatus() {
		return this.status;
	}
	/**
	 * 
	 * @param lastUpdateTime
	 */
	public void setLastUpdateTime(java.util.Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.util.Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public java.lang.String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(java.lang.String templateName) {
		this.templateName = templateName;
	}
	
	
}