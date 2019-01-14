/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.dto;

import java.io.Serializable;

import com.zbjdl.common.amount.Amount;

/**
 * AccountSettleInfoDto
 * 
 * @author code-generator
 *
 */
public class AssistAccountSettleInfoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String assistCode;
	private com.zbjdl.common.amount.Amount debitAmount;
	private com.zbjdl.common.amount.Amount creditAmount;
	private com.zbjdl.common.amount.Amount openingBalance;
	private com.zbjdl.common.amount.Amount closingBalance;
	private com.zbjdl.common.amount.Amount yearOpeningBalance;

	public com.zbjdl.common.amount.Amount getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(com.zbjdl.common.amount.Amount debitAmount) {
		this.debitAmount = debitAmount;
	}

	public com.zbjdl.common.amount.Amount getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(com.zbjdl.common.amount.Amount creditAmount) {
		this.creditAmount = creditAmount;
	}

	public com.zbjdl.common.amount.Amount getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(com.zbjdl.common.amount.Amount openingBalance) {
		this.openingBalance = openingBalance;
	}

	public com.zbjdl.common.amount.Amount getYearOpeningBalance() {
		return yearOpeningBalance;
	}

	public void setYearOpeningBalance(com.zbjdl.common.amount.Amount yearOpeningBalance) {
		this.yearOpeningBalance = yearOpeningBalance;
	}

	public String getAssistCode() {
		return assistCode;
	}

	public void setAssistCode(String assistCode) {
		this.assistCode = assistCode;
	}

	public com.zbjdl.common.amount.Amount getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(com.zbjdl.common.amount.Amount closingBalance) {
		this.closingBalance = closingBalance;
	}

}