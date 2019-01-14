package com.zbjdl.account.dto.response;

import java.io.Serializable;

import com.zbjdl.common.amount.Amount;

@SuppressWarnings("serial")
public class CashFlowStatementRespDto implements Serializable {

	private Amount sumAmount;
	private Amount sumYearAmount;

	public Amount getSumAmount() {
		return sumAmount;
	}

	public void setSumAmount(Amount sumAmount) {
		this.sumAmount = sumAmount;
	}

	public Amount getSumYearAmount() {
		return sumYearAmount;
	}

	public void setSumYearAmount(Amount sumYearAmount) {
		this.sumYearAmount = sumYearAmount;
	}

}