/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.dto;

import java.io.Serializable;

/**
 * AssistAccountInfoDto
 * @author code-generator
 *
 */
public class AssistAccountInfoDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String systemCode;
	private java.lang.String assistCode;
	private java.lang.String assistName;
	private java.lang.String taxNum;
	private java.lang.String assistType;
	private java.lang.String status;
	private java.util.Date createTime;
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
	 * 系统编码
	 * @param systemCode
	 */
	public void setSystemCode(java.lang.String systemCode) {
		this.systemCode = systemCode;
	}
	
	/**
	 * 系统编码
	 * @return
	 */
	public java.lang.String getSystemCode() {
		return this.systemCode;
	}
	/**
	 * 编码
	 * @param assistCode
	 */
	public void setAssistCode(java.lang.String assistCode) {
		this.assistCode = assistCode;
	}
	
	/**
	 * 编码
	 * @return
	 */
	public java.lang.String getAssistCode() {
		return this.assistCode;
	}
	/**
	 * 名称
	 * @param assistName
	 */
	public void setAssistName(java.lang.String assistName) {
		this.assistName = assistName;
	}
	
	/**
	 * 名称
	 * @return
	 */
	public java.lang.String getAssistName() {
		return this.assistName;
	}
	/**
	 * 企业税号
	 * @param taxNum
	 */
	public void setTaxNum(java.lang.String taxNum) {
		this.taxNum = taxNum;
	}
	
	/**
	 * 企业税号
	 * @return
	 */
	public java.lang.String getTaxNum() {
		return this.taxNum;
	}
	/**
	 * 类别
	 * @param assistType
	 */
	public void setAssistType(java.lang.String assistType) {
		this.assistType = assistType;
	}
	
	/**
	 * 类别
	 * @return
	 */
	public java.lang.String getAssistType() {
		return this.assistType;
	}
	/**
	 * 状态
	 * @param status
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	
	/**
	 * 状态
	 * @return
	 */
	public java.lang.String getStatus() {
		return this.status;
	}
	/**
	 * 创建时间
	 * @param createTime
	 */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * 创建时间
	 * @return
	 */
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	/**
	 * 最后修改时间
	 * @param lastUpdateTime
	 */
	public void setLastUpdateTime(java.util.Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	/**
	 * 最后修改时间
	 * @return
	 */
	public java.util.Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}
}