/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.dto;

import java.io.Serializable;

/**
 * TaxInfoDto
 * @author code-generator
 *
 */
public class TaxInfoDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String taxName;
	private java.lang.String taxCode;
	private java.lang.String taxSubject;
	private com.zbjdl.common.amount.Amount rate;
	private com.zbjdl.common.amount.Amount taxRate;
	private java.lang.String parentId;
	private java.lang.String status;

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
	 * 税收名称
	 * @param taxName
	 */
	public void setTaxName(java.lang.String taxName) {
		this.taxName = taxName;
	}
	
	/**
	 * 税收名称
	 * @return
	 */
	public java.lang.String getTaxName() {
		return this.taxName;
	}
	/**
	 * 税收编码
	 * @param taxCode
	 */
	public void setTaxCode(java.lang.String taxCode) {
		this.taxCode = taxCode;
	}
	
	/**
	 * 税收编码
	 * @return
	 */
	public java.lang.String getTaxCode() {
		return this.taxCode;
	}
	/**
	 * 税收科目
	 * @param taxSubject
	 */
	public void setTaxSubject(java.lang.String taxSubject) {
		this.taxSubject = taxSubject;
	}
	
	/**
	 * 税收科目
	 * @return
	 */
	public java.lang.String getTaxSubject() {
		return this.taxSubject;
	}
	/**
	 * 税率
	 * @param rate
	 */
	public void setRate(com.zbjdl.common.amount.Amount rate) {
		this.rate = rate;
	}
	
	/**
	 * 税率
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getRate() {
		return this.rate;
	}
	/**
	 * 征税率
	 * @param taxRate
	 */
	public void setTaxRate(com.zbjdl.common.amount.Amount taxRate) {
		this.taxRate = taxRate;
	}
	
	/**
	 * 征税率
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getTaxRate() {
		return this.taxRate;
	}
	/**
	 * 父节点id
	 * @param parentId
	 */
	public void setParentId(java.lang.String parentId) {
		this.parentId = parentId;
	}
	
	/**
	 * 父节点id
	 * @return
	 */
	public java.lang.String getParentId() {
		return this.parentId;
	}
	/**
	 * 
	 * @param status
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getStatus() {
		return this.status;
	}
}