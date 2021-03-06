/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.model;

/**
 * VoucherSubInfo
 * @author code-generator
 *
 */
public class VoucherSubInfo {
	
	private java.lang.Long id;
	private java.lang.Long voucherId;
	private java.lang.String summary;
	private java.lang.String subjectCode;
	private java.lang.String balanceDirect;
	private java.lang.String assistCode;
	private com.zbjdl.common.amount.Amount amount;
	private com.zbjdl.common.amount.Amount debitAmount;
	private com.zbjdl.common.amount.Amount creditAmount;
	private java.lang.Boolean delFlag;
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
	 * 关联凭证主表id
	 * @param voucherId
	 */
	public void setVoucherId(java.lang.Long voucherId) {
		this.voucherId = voucherId;
	}
	
	/**
	 * 关联凭证主表id
	 * @return
	 */
	public java.lang.Long getVoucherId() {
		return this.voucherId;
	}
	/**
	 * 摘要
	 * @param summary
	 */
	public void setSummary(java.lang.String summary) {
		this.summary = summary;
	}
	
	/**
	 * 摘要
	 * @return
	 */
	public java.lang.String getSummary() {
		return this.summary;
	}
	/**
	 * 会计科目
	 * @param subjectCode
	 */
	public void setSubjectCode(java.lang.String subjectCode) {
		this.subjectCode = subjectCode;
	}
	
	/**
	 * 会计科目
	 * @return
	 */
	public java.lang.String getSubjectCode() {
		return this.subjectCode;
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
	 * 辅助核算
	 * @param assistCode
	 */
	public void setAssistCode(java.lang.String assistCode) {
		this.assistCode = assistCode;
	}
	
	/**
	 * 辅助核算
	 * @return
	 */
	public java.lang.String getAssistCode() {
		return this.assistCode;
	}
	/**
	 * 金额
	 * @param amount
	 */
	public void setAmount(com.zbjdl.common.amount.Amount amount) {
		this.amount = amount;
	}
	
	/**
	 * 金额
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getAmount() {
		return this.amount;
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
	 * 删除标示
	 * @param delFlag
	 */
	public void setDelFlag(java.lang.Boolean delFlag) {
		this.delFlag = delFlag;
	}
	
	/**
	 * 删除标示
	 * @return
	 */
	public java.lang.Boolean getDelFlag() {
		return this.delFlag;
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