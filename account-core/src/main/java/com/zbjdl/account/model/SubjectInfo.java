/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.model;

/**
 * SubjectInfo
 * @author code-generator
 *
 */
public class SubjectInfo {
	
	private java.lang.Long id;
	private java.lang.String systemCode;
	private java.lang.String subjectCode;
	private java.lang.String subjectName;
	private java.lang.Integer subjectLevel;
	private java.lang.String parentCode;
	private java.lang.Boolean lastLevel;
	private java.lang.String balanceDirect;
	private java.lang.String balanceShow;
	private java.lang.String assistAccount;
	private java.lang.String basicSubject;
	private java.lang.String currencyCode;
	private java.lang.String accountUnit;
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
	 * 单位ID
	 * @param systemCode
	 */
	public void setSystemCode(java.lang.String systemCode) {
		this.systemCode = systemCode;
	}
	
	/**
	 * 单位ID
	 * @return
	 */
	public java.lang.String getSystemCode() {
		return this.systemCode;
	}
	/**
	 * 科目编码
	 * @param subjectCode
	 */
	public void setSubjectCode(java.lang.String subjectCode) {
		this.subjectCode = subjectCode;
	}
	
	/**
	 * 科目编码
	 * @return
	 */
	public java.lang.String getSubjectCode() {
		return this.subjectCode;
	}
	/**
	 * 科目名称
	 * @param subjectName
	 */
	public void setSubjectName(java.lang.String subjectName) {
		this.subjectName = subjectName;
	}
	
	/**
	 * 科目名称
	 * @return
	 */
	public java.lang.String getSubjectName() {
		return this.subjectName;
	}
	/**
	 * 科目层级
	 * @param subjectLevel
	 */
	public void setSubjectLevel(java.lang.Integer subjectLevel) {
		this.subjectLevel = subjectLevel;
	}
	
	/**
	 * 科目层级
	 * @return
	 */
	public java.lang.Integer getSubjectLevel() {
		return this.subjectLevel;
	}
	/**
	 * 上级ID
	 * @param parentCode
	 */
	public void setParentCode(java.lang.String parentCode) {
		this.parentCode = parentCode;
	}
	
	/**
	 * 上级ID
	 * @return
	 */
	public java.lang.String getParentCode() {
		return this.parentCode;
	}
	/**
	 * 末级标示
	 * @param lastLevel
	 */
	public void setLastLevel(java.lang.Boolean lastLevel) {
		this.lastLevel = lastLevel;
	}
	
	/**
	 * 末级标示
	 * @return
	 */
	public java.lang.Boolean getLastLevel() {
		return this.lastLevel;
	}
	/**
	 * 余额方向
	 * @param balanceDirect
	 */
	public void setBalanceDirect(java.lang.String balanceDirect) {
		this.balanceDirect = balanceDirect;
	}
	
	/**
	 * 余额方向
	 * @return
	 */
	public java.lang.String getBalanceDirect() {
		return this.balanceDirect;
	}
	/**
	 * 余额显示
	 * @param balanceShow
	 */
	public void setBalanceShow(java.lang.String balanceShow) {
		this.balanceShow = balanceShow;
	}
	
	/**
	 * 余额显示
	 * @return
	 */
	public java.lang.String getBalanceShow() {
		return this.balanceShow;
	}
	/**
	 * 辅助核算
	 * @param assistAccount
	 */
	public void setAssistAccount(java.lang.String assistAccount) {
		this.assistAccount = assistAccount;
	}
	
	/**
	 * 辅助核算
	 * @return
	 */
	public java.lang.String getAssistAccount() {
		return this.assistAccount;
	}
	/**
	 * 基础标示
	 * @param basicSubject
	 */
	public void setBasicSubject(java.lang.String basicSubject) {
		this.basicSubject = basicSubject;
	}
	
	/**
	 * 基础标示
	 * @return
	 */
	public java.lang.String getBasicSubject() {
		return this.basicSubject;
	}
	/**
	 * 外币编码
	 * @param currencyCode
	 */
	public void setCurrencyCode(java.lang.String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	/**
	 * 外币编码
	 * @return
	 */
	public java.lang.String getCurrencyCode() {
		return this.currencyCode;
	}
	/**
	 * 核算单位
	 * @param accountUnit
	 */
	public void setAccountUnit(java.lang.String accountUnit) {
		this.accountUnit = accountUnit;
	}
	
	/**
	 * 核算单位
	 * @return
	 */
	public java.lang.String getAccountUnit() {
		return this.accountUnit;
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