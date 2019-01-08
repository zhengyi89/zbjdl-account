/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.dto;

import java.io.Serializable;

/**
 * InvoiceInfoDto
 * @author code-generator
 *
 */
public class InvoiceInfoDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String invoiceCode;
	private java.lang.String invoiceName;
	private java.lang.String companyName;
	private java.util.Date invoiceTime;
	private com.zbjdl.common.amount.Amount invoiceAmount;
	private java.lang.String status;
	private java.util.Date createTime;

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
	 * 发票代码
	 * @param invoiceCode
	 */
	public void setInvoiceCode(java.lang.String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}
	
	/**
	 * 发票代码
	 * @return
	 */
	public java.lang.String getInvoiceCode() {
		return this.invoiceCode;
	}
	/**
	 * 发票名称
	 * @param invoiceName
	 */
	public void setInvoiceName(java.lang.String invoiceName) {
		this.invoiceName = invoiceName;
	}
	
	/**
	 * 发票名称
	 * @return
	 */
	public java.lang.String getInvoiceName() {
		return this.invoiceName;
	}
	/**
	 * 单位名称
	 * @param companyName
	 */
	public void setCompanyName(java.lang.String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * 单位名称
	 * @return
	 */
	public java.lang.String getCompanyName() {
		return this.companyName;
	}
	/**
	 * 开票时间
	 * @param invoiceTime
	 */
	public void setInvoiceTime(java.util.Date invoiceTime) {
		this.invoiceTime = invoiceTime;
	}
	
	/**
	 * 开票时间
	 * @return
	 */
	public java.util.Date getInvoiceTime() {
		return this.invoiceTime;
	}
	/**
	 * 发票金额
	 * @param invoiceAmount
	 */
	public void setInvoiceAmount(com.zbjdl.common.amount.Amount invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	
	/**
	 * 发票金额
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getInvoiceAmount() {
		return this.invoiceAmount;
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
	 * 创建时间
	 * @param createTime
	 */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * 创建时间
	 * @return
	 */
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
}