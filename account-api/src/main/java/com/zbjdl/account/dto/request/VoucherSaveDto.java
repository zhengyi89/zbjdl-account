/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.dto.request;

import java.io.Serializable;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.zbjdl.account.dto.VoucherSubInfoDto;

/**
 * VoucherInfoSaveReqDto
 * @author code-generator
 *
 */
public class VoucherSaveDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String systemCode;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date accountPeriod;
	private java.lang.String voucherType;
	private java.lang.Integer serialNum;
	private java.lang.Integer voucherPapers;
	private java.lang.String voucherSource;
	private List<VoucherSubInfoSaveReqDto> voucherSubInfoDtos;
	public java.lang.Long getId() {
		return id;
	}
	public void setId(java.lang.Long id) {
		this.id = id;
	}
	public java.lang.String getSystemCode() {
		return systemCode;
	}
	public void setSystemCode(java.lang.String systemCode) {
		this.systemCode = systemCode;
	}
	
	public java.util.Date getAccountPeriod() {
		return accountPeriod;
	}
	public void setAccountPeriod(java.util.Date accountPeriod) {
		this.accountPeriod = accountPeriod;
	}
	public java.lang.String getVoucherType() {
		return voucherType;
	}
	public void setVoucherType(java.lang.String voucherType) {
		this.voucherType = voucherType;
	}
	public java.lang.Integer getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(java.lang.Integer serialNum) {
		this.serialNum = serialNum;
	}
	public java.lang.Integer getVoucherPapers() {
		return voucherPapers;
	}
	public void setVoucherPapers(java.lang.Integer voucherPapers) {
		this.voucherPapers = voucherPapers;
	}
	public java.lang.String getVoucherSource() {
		return voucherSource;
	}
	public void setVoucherSource(java.lang.String voucherSource) {
		this.voucherSource = voucherSource;
	}
	public List<VoucherSubInfoSaveReqDto> getVoucherSubInfoDtos() {
		return voucherSubInfoDtos;
	}
	public void setVoucherSubInfoDtos(List<VoucherSubInfoSaveReqDto> voucherSubInfoDtos) {
		this.voucherSubInfoDtos = voucherSubInfoDtos;
	}
	
}