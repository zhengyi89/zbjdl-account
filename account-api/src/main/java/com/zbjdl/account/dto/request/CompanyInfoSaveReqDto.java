/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.dto.request;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * CompanyInfoSaveReqDto
 * @author code-generator
 *
 */
public class CompanyInfoSaveReqDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String companyName;
	private java.lang.String companyAddress;
	private java.lang.String companyMobile;
	private java.lang.String status;
	private java.lang.Long accountantId;
	private java.lang.String accountantName;
	private java.lang.String accountStatus;
	private java.lang.Long creatorId;
	private java.lang.String creatorName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date serveBeginDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date serveEndDate;

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
	 * 公司名称
	 * @param companyName
	 */
	public void setCompanyName(java.lang.String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * 公司名称
	 * @return
	 */
	public java.lang.String getCompanyName() {
		return this.companyName;
	}
	/**
	 * 公司地址
	 * @param companyAddress
	 */
	public void setCompanyAddress(java.lang.String companyAddress) {
		this.companyAddress = companyAddress;
	}
	
	/**
	 * 公司地址
	 * @return
	 */
	public java.lang.String getCompanyAddress() {
		return this.companyAddress;
	}
	/**
	 * 
	 * @param companyMobile
	 */
	public void setCompanyMobile(java.lang.String companyMobile) {
		this.companyMobile = companyMobile;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getCompanyMobile() {
		return this.companyMobile;
	}
	/**
	 * 状态
	 * @param status
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	
	/**
	 * 状态
	 * @return
	 */
	public java.lang.String getStatus() {
		return this.status;
	}
	/**
	 * 记账会计id
	 * @param accountantId
	 */
	public void setAccountantId(java.lang.Long accountantId) {
		this.accountantId = accountantId;
	}
	
	/**
	 * 记账会计id
	 * @return
	 */
	public java.lang.Long getAccountantId() {
		return this.accountantId;
	}
	/**
	 * 
	 * @param accountantName
	 */
	public void setAccountantName(java.lang.String accountantName) {
		this.accountantName = accountantName;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getAccountantName() {
		return this.accountantName;
	}
	/**
	 * 记账状态
	 * @param accountStatus
	 */
	public void setAccountStatus(java.lang.String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	/**
	 * 记账状态
	 * @return
	 */
	public java.lang.String getAccountStatus() {
		return this.accountStatus;
	}
	/**
	 * 创建人id
	 * @param creatorId
	 */
	public void setCreatorId(java.lang.Long creatorId) {
		this.creatorId = creatorId;
	}
	
	/**
	 * 创建人id
	 * @return
	 */
	public java.lang.Long getCreatorId() {
		return this.creatorId;
	}
	/**
	 * 创建人姓名
	 * @param creatorName
	 */
	public void setCreatorName(java.lang.String creatorName) {
		this.creatorName = creatorName;
	}
	
	/**
	 * 创建人姓名
	 * @return
	 */
	public java.lang.String getCreatorName() {
		return this.creatorName;
	}
	/**
	 * 服务开始时间
	 * @param serveBeginDate
	 */
	public void setServeBeginDate(java.util.Date serveBeginDate) {
		this.serveBeginDate = serveBeginDate;
	}
	
	/**
	 * 服务开始时间
	 * @return
	 */
	public java.util.Date getServeBeginDate() {
		return this.serveBeginDate;
	}
	/**
	 * 服务结束时间
	 * @param serveEndDate
	 */
	public void setServeEndDate(java.util.Date serveEndDate) {
		this.serveEndDate = serveEndDate;
	}
	
	/**
	 * 服务结束时间
	 * @return
	 */
	public java.util.Date getServeEndDate() {
		return this.serveEndDate;
	}
}