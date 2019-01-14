package com.zbjdl.account.dto.response;

import com.zbjdl.account.enumtype.ReturnEnum;

@SuppressWarnings("serial")
public class AccountSettleCheckRespDto extends BaseRespDto {
	
	public AccountSettleCheckRespDto(ReturnEnum returnEnum) {
		super(returnEnum);
		this.balanceSheetFlag = true;
		this.deprecitionFlag = true;
		this.vocherSerialNumFlag = true;
		this.profitLossFlag = true;
		this.voucherAuditFlag = true;
	}
	
	private boolean voucherAuditFlag; //凭证漏审 
	private boolean profitLossFlag; //结转损益
	private boolean vocherSerialNumFlag;//凭证断号
	private boolean deprecitionFlag;//计提固定资产折旧
	private boolean balanceSheetFlag;//资产负债表
	public boolean isVoucherAuditFlag() {
		return voucherAuditFlag;
	}
	public void setVoucherAuditFlag(boolean voucherAuditFlag) {
		this.voucherAuditFlag = voucherAuditFlag;
	}
	public boolean isProfitLossFlag() {
		return profitLossFlag;
	}
	public void setProfitLossFlag(boolean profitLossFlag) {
		this.profitLossFlag = profitLossFlag;
	}
	public boolean isVocherSerialNumFlag() {
		return vocherSerialNumFlag;
	}
	public void setVocherSerialNumFlag(boolean vocherSerialNumFlag) {
		this.vocherSerialNumFlag = vocherSerialNumFlag;
	}
	public boolean isDeprecitionFlag() {
		return deprecitionFlag;
	}
	public void setDeprecitionFlag(boolean deprecitionFlag) {
		this.deprecitionFlag = deprecitionFlag;
	}
	public boolean isBalanceSheetFlag() {
		return balanceSheetFlag;
	}
	public void setBalanceSheetFlag(boolean balanceSheetFlag) {
		this.balanceSheetFlag = balanceSheetFlag;
	}
	
	

}