package com.zbjdl.account.dto.response;

import com.zbjdl.account.enumtype.ReturnEnum;
import com.zbjdl.common.amount.Amount;

@SuppressWarnings("serial")
public class TrialBalanceRespDto extends BaseRespDto {

	private Amount sumDebitOpeningAmount;
	private Amount sumCreditOpeningAmount;
	private Amount sumYearDebitAmount;
	private Amount sumYearCreditAmount;

	public TrialBalanceRespDto(ReturnEnum returnEnum) {
		super(returnEnum);
	}

	public Amount getSumDebitOpeningAmount() {
		return sumDebitOpeningAmount;
	}

	public void setSumDebitOpeningAmount(Amount sumDebitOpeningAmount) {
		this.sumDebitOpeningAmount = sumDebitOpeningAmount;
	}

	public Amount getSumCreditOpeningAmount() {
		return sumCreditOpeningAmount;
	}

	public void setSumCreditOpeningAmount(Amount sumCreditOpeningAmount) {
		this.sumCreditOpeningAmount = sumCreditOpeningAmount;
	}

	public Amount getSumYearDebitAmount() {
		return sumYearDebitAmount;
	}

	public void setSumYearDebitAmount(Amount sumYearDebitAmount) {
		this.sumYearDebitAmount = sumYearDebitAmount;
	}

	public Amount getSumYearCreditAmount() {
		return sumYearCreditAmount;
	}

	public void setSumYearCreditAmount(Amount sumYearCreditAmount) {
		this.sumYearCreditAmount = sumYearCreditAmount;
	}

}