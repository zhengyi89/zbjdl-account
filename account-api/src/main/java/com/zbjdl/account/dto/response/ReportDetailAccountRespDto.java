package com.zbjdl.account.dto.response;

import java.io.Serializable;

import com.zbjdl.common.amount.Amount;

/**
 * 报表－明细账
 * 
 * @author zhengy
 * @date: 2019年1月15日 上午10:30:12
 */
@SuppressWarnings("serial")
public class ReportDetailAccountRespDto implements Serializable {

	private java.lang.Long voucherId;
	private String accountMonth;
	private Integer serialNum;
	private String summary;
	private Amount debitAmount;
	private Amount creditAmount;
	private String balanceDirect;
	private Amount remainAmount;

	public String getAccountMonth() {
		return accountMonth;
	}

	public void setAccountMonth(String accountMonth) {
		this.accountMonth = accountMonth;
	}

	public Integer getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(Integer serialNum) {
		this.serialNum = serialNum;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Amount getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Amount debitAmount) {
		this.debitAmount = debitAmount;
	}

	public Amount getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Amount creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getBalanceDirect() {
		return balanceDirect;
	}

	public void setBalanceDirect(String balanceDirect) {
		this.balanceDirect = balanceDirect;
	}

	public Amount getRemainAmount() {
		return remainAmount;
	}

	public void setRemainAmount(Amount remainAmount) {
		this.remainAmount = remainAmount;
	}

	public java.lang.Long getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(java.lang.Long voucherId) {
		this.voucherId = voucherId;
	}

}