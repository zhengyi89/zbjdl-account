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
 * 凭证模版保存
 * 
 * @author zhengy
 * @date: 2018年12月27日 上午10:25:02
 */
public class VoucherTemplateSaveDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String systemCode;
	private java.lang.String voucherType;
	private List<VoucherSubInfoSaveReqDto> voucherSubInfoDtos;
	
	private java.lang.Boolean saveAmount;
	private java.lang.Boolean templateFlag;
	private java.lang.String templateName;
	
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
	
	public java.lang.String getVoucherType() {
		return voucherType;
	}
	public void setVoucherType(java.lang.String voucherType) {
		this.voucherType = voucherType;
	}

	public List<VoucherSubInfoSaveReqDto> getVoucherSubInfoDtos() {
		return voucherSubInfoDtos;
	}
	public void setVoucherSubInfoDtos(List<VoucherSubInfoSaveReqDto> voucherSubInfoDtos) {
		this.voucherSubInfoDtos = voucherSubInfoDtos;
	}
	public java.lang.Boolean getTemplateFlag() {
		return templateFlag;
	}
	public void setTemplateFlag(java.lang.Boolean templateFlag) {
		this.templateFlag = templateFlag;
	}
	public java.lang.String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(java.lang.String templateName) {
		this.templateName = templateName;
	}
	public java.lang.Boolean getSaveAmount() {
		return saveAmount;
	}
	public void setSaveAmount(java.lang.Boolean saveAmount) {
		this.saveAmount = saveAmount;
	}
	
	
	
}