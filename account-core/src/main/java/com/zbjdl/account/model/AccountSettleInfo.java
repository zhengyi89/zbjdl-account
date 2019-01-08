/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.model;

/**
 * AccountSettleInfo
 * @author code-generator
 *
 */
public class AccountSettleInfo {
	
	private java.lang.Long id;
	private java.lang.Long subjectId;
	private java.lang.String accountMonth;
	private com.zbjdl.common.amount.Amount debitAmount;
	private com.zbjdl.common.amount.Amount creditAmount;
	private com.zbjdl.common.amount.Amount openingBalance;
	private com.zbjdl.common.amount.Amount closingBalance;
	private com.zbjdl.common.amount.Amount sumAmount;
	private com.zbjdl.common.amount.Amount yearOpeningBalance;
	private com.zbjdl.common.amount.Amount sumRemainAmount;
	private com.zbjdl.common.amount.Amount yearCreditAmount;
	private com.zbjdl.common.amount.Amount yearDebitAmount;
	private java.lang.String settleType;
	private java.lang.String status;
	private java.util.Date createTime;
	private java.util.Date lastUpdateTime;
	private java.lang.String extend;

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
	 * 科目id
	 * @param subjectId
	 */
	public void setSubjectId(java.lang.Long subjectId) {
		this.subjectId = subjectId;
	}
	
	/**
	 * 科目id
	 * @return
	 */
	public java.lang.Long getSubjectId() {
		return this.subjectId;
	}
	/**
	 * 记账月份
	 * @param accountMonth
	 */
	public void setAccountMonth(java.lang.String accountMonth) {
		this.accountMonth = accountMonth;
	}
	
	/**
	 * 记账月份
	 * @return
	 */
	public java.lang.String getAccountMonth() {
		return this.accountMonth;
	}
	/**
	 * 借方金额
	 * @param debitAmount
	 */
	public void setDebitAmount(com.zbjdl.common.amount.Amount debitAmount) {
		this.debitAmount = debitAmount;
	}
	
	/**
	 * 借方金额
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getDebitAmount() {
		return this.debitAmount;
	}
	/**
	 * 贷方金额
	 * @param creditAmount
	 */
	public void setCreditAmount(com.zbjdl.common.amount.Amount creditAmount) {
		this.creditAmount = creditAmount;
	}
	
	/**
	 * 贷方金额
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getCreditAmount() {
		return this.creditAmount;
	}
	/**
	 * 期初余额
	 * @param openingBalance
	 */
	public void setOpeningBalance(com.zbjdl.common.amount.Amount openingBalance) {
		this.openingBalance = openingBalance;
	}
	
	/**
	 * 期初余额
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getOpeningBalance() {
		return this.openingBalance;
	}
	/**
	 * 累积金额
	 * @param sumAmount
	 */
	public void setSumAmount(com.zbjdl.common.amount.Amount sumAmount) {
		this.sumAmount = sumAmount;
	}
	
	/**
	 * 累积金额
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getSumAmount() {
		return this.sumAmount;
	}
	/**
	 * 年初余额
	 * @param yearOpeningBalance
	 */
	public void setYearOpeningBalance(com.zbjdl.common.amount.Amount yearOpeningBalance) {
		this.yearOpeningBalance = yearOpeningBalance;
	}
	
	/**
	 * 年初余额
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getYearOpeningBalance() {
		return this.yearOpeningBalance;
	}
	/**
	 * 余额
	 * @param sumRemainAmount
	 */
	public void setSumRemainAmount(com.zbjdl.common.amount.Amount sumRemainAmount) {
		this.sumRemainAmount = sumRemainAmount;
	}
	
	/**
	 * 余额
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getSumRemainAmount() {
		return this.sumRemainAmount;
	}
	/**
	 * 本年累积借方
	 * @param yearCreditAmount
	 */
	public void setYearCreditAmount(com.zbjdl.common.amount.Amount yearCreditAmount) {
		this.yearCreditAmount = yearCreditAmount;
	}
	
	/**
	 * 本年累积借方
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getYearCreditAmount() {
		return this.yearCreditAmount;
	}
	/**
	 * 累积贷方
	 * @param yearDebitAmount
	 */
	public void setYearDebitAmount(com.zbjdl.common.amount.Amount yearDebitAmount) {
		this.yearDebitAmount = yearDebitAmount;
	}
	
	/**
	 * 累积贷方
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getYearDebitAmount() {
		return this.yearDebitAmount;
	}
	/**
	 * 结算类型 INIT：科目期初  SETTLE：结算 
	 * @param settleType
	 */
	public void setSettleType(java.lang.String settleType) {
		this.settleType = settleType;
	}
	
	/**
	 * 结算类型 INIT：科目期初  SETTLE：结算 
	 * @return
	 */
	public java.lang.String getSettleType() {
		return this.settleType;
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
	/**
	 * 
	 * @param extend
	 */
	public void setExtend(java.lang.String extend) {
		this.extend = extend;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getExtend() {
		return this.extend;
	}

	public com.zbjdl.common.amount.Amount getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(com.zbjdl.common.amount.Amount closingBalance) {
		this.closingBalance = closingBalance;
	}
	
	
}
