/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.dto;

import java.io.Serializable;

/**
 * CurrencyInfoDto
 * @author code-generator
 *
 */
public class CurrencyInfoDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String currencyCode;
	private java.lang.String currencyName;
	private com.zbjdl.common.amount.Amount exchangeRate;
	private java.lang.String systemCode;
	private java.lang.String status;
	private java.util.Date createTime;
	private java.util.Date lastUpdateTime;

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
	 * 币种编码
	 * @param currencyCode
	 */
	public void setCurrencyCode(java.lang.String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	/**
	 * 币种编码
	 * @return
	 */
	public java.lang.String getCurrencyCode() {
		return this.currencyCode;
	}
	/**
	 * 币种名称
	 * @param currencyName
	 */
	public void setCurrencyName(java.lang.String currencyName) {
		this.currencyName = currencyName;
	}
	
	/**
	 * 币种名称
	 * @return
	 */
	public java.lang.String getCurrencyName() {
		return this.currencyName;
	}
	/**
	 * 汇率
	 * @param exchangeRate
	 */
	public void setExchangeRate(com.zbjdl.common.amount.Amount exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	
	/**
	 * 汇率
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getExchangeRate() {
		return this.exchangeRate;
	}
	/**
	 * 系统编码
	 * @param systemCode
	 */
	public void setSystemCode(java.lang.String systemCode) {
		this.systemCode = systemCode;
	}
	
	/**
	 * 系统编码
	 * @return
	 */
	public java.lang.String getSystemCode() {
		return this.systemCode;
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
	/**
	 * 最后修改时间
	 * @param lastUpdateTime
	 */
	public void setLastUpdateTime(java.util.Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	/**
	 * 最后修改时间
	 * @return
	 */
	public java.util.Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}
}