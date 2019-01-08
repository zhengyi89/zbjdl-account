/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.dto.request;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * SystemInfoSaveReqDto
 * @author code-generator
 *
 */
public class SystemInfoSaveReqDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.Long companyId;
	private java.lang.String systemCode;
	private java.lang.String systemName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date serverStartDate;
	private java.lang.String serverMonth;
	private java.lang.String accountType;
	private java.lang.String industryType;
	private java.lang.String taxpayerType;
	private java.lang.String standardCoin;
	private java.lang.Boolean commonSubjectInit;

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
	 * 公司id
	 * @param companyId
	 */
	public void setCompanyId(java.lang.Long companyId) {
		this.companyId = companyId;
	}
	
	/**
	 * 公司id
	 * @return
	 */
	public java.lang.Long getCompanyId() {
		return this.companyId;
	}
	/**
	 * 单位编码
	 * @param systemCode
	 */
	public void setSystemCode(java.lang.String systemCode) {
		this.systemCode = systemCode;
	}
	
	/**
	 * 单位编码
	 * @return
	 */
	public java.lang.String getSystemCode() {
		return this.systemCode;
	}
	/**
	 * 帐套名称
	 * @param systemName
	 */
	public void setSystemName(java.lang.String systemName) {
		this.systemName = systemName;
	}
	
	/**
	 * 帐套名称
	 * @return
	 */
	public java.lang.String getSystemName() {
		return this.systemName;
	}
	/**
	 * 启用年月
	 * @param serverStartDate
	 */
	public void setServerStartDate(java.util.Date serverStartDate) {
		this.serverStartDate = serverStartDate;
	}
	
	/**
	 * 启用年月
	 * @return
	 */
	public java.util.Date getServerStartDate() {
		return this.serverStartDate;
	}
	/**
	 * 服务时长（月）
	 * @param serverMonth
	 */
	public void setServerMonth(java.lang.String serverMonth) {
		this.serverMonth = serverMonth;
	}
	
	/**
	 * 服务时长（月）
	 * @return
	 */
	public java.lang.String getServerMonth() {
		return this.serverMonth;
	}
	/**
	 * 会计制度
	 * @param accountType
	 */
	public void setAccountType(java.lang.String accountType) {
		this.accountType = accountType;
	}
	
	/**
	 * 会计制度
	 * @return
	 */
	public java.lang.String getAccountType() {
		return this.accountType;
	}
	/**
	 * 所属行业
	 * @param industryType
	 */
	public void setIndustryType(java.lang.String industryType) {
		this.industryType = industryType;
	}
	
	/**
	 * 所属行业
	 * @return
	 */
	public java.lang.String getIndustryType() {
		return this.industryType;
	}
	/**
	 * 纳税人类型
	 * @param taxpayerType
	 */
	public void setTaxpayerType(java.lang.String taxpayerType) {
		this.taxpayerType = taxpayerType;
	}
	
	/**
	 * 纳税人类型
	 * @return
	 */
	public java.lang.String getTaxpayerType() {
		return this.taxpayerType;
	}
	/**
	 * 本位币
	 * @param standardCoin
	 */
	public void setStandardCoin(java.lang.String standardCoin) {
		this.standardCoin = standardCoin;
	}
	
	/**
	 * 本位币
	 * @return
	 */
	public java.lang.String getStandardCoin() {
		return this.standardCoin;
	}
	/**
	 * 预置期间费用明细科目
	 * @param commonSubjectInit
	 */
	public void setCommonSubjectInit(java.lang.Boolean commonSubjectInit) {
		this.commonSubjectInit = commonSubjectInit;
	}
	
	/**
	 * 预置期间费用明细科目
	 * @return
	 */
	public java.lang.Boolean getCommonSubjectInit() {
		return this.commonSubjectInit;
	}
}