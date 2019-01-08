package com.zbjdl.account.dto.response;

import java.io.Serializable;

import com.zbjdl.common.amount.Amount;

@SuppressWarnings("serial")
public class BalanceSheetRespDto implements Serializable {

	private Amount closingAmount;
	private Amount yearOpeningAmount;
	public Amount getClosingAmount() {
		return closingAmount;
	}
	public void setClosingAmount(Amount closingAmount) {
		this.closingAmount = closingAmount;
	}
	public Amount getYearOpeningAmount() {
		return yearOpeningAmount;
	}
	public void setYearOpeningAmount(Amount yearOpeningAmount) {
		this.yearOpeningAmount = yearOpeningAmount;
	}
	
	
	

}