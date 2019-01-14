/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.dto.request;

import java.io.Serializable;

/**
 * VoucherInfoSaveReqDto
 * 
 * @author code-generator
 *
 */
public class FindPreDeprecitionInfoReqDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String systemCode;
	private String deprecitionMonth;
	private String costType;

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getDeprecitionMonth() {
		return deprecitionMonth;
	}

	public void setDeprecitionMonth(String deprecitionMonth) {
		this.deprecitionMonth = deprecitionMonth;
	}

	public String getCostType() {
		return costType;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}

}