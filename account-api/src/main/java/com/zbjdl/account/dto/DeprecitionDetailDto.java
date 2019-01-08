/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.dto;

import java.io.Serializable;

/**
 * DeprecitionDetailDto
 * @author code-generator
 *
 */
public class DeprecitionDetailDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String assetId;
	private com.zbjdl.common.amount.Amount deprecitionTotalAmount;
	private com.zbjdl.common.amount.Amount closeAmount;
	private java.util.Date settleTime;
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
	 * 资产ID
	 * @param assetId
	 */
	public void setAssetId(java.lang.String assetId) {
		this.assetId = assetId;
	}
	
	/**
	 * 资产ID
	 * @return
	 */
	public java.lang.String getAssetId() {
		return this.assetId;
	}
	/**
	 * 期末累计折旧(摊销)
	 * @param deprecitionTotalAmount
	 */
	public void setDeprecitionTotalAmount(com.zbjdl.common.amount.Amount deprecitionTotalAmount) {
		this.deprecitionTotalAmount = deprecitionTotalAmount;
	}
	
	/**
	 * 期末累计折旧(摊销)
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getDeprecitionTotalAmount() {
		return this.deprecitionTotalAmount;
	}
	/**
	 * 期末净值
	 * @param closeAmount
	 */
	public void setCloseAmount(com.zbjdl.common.amount.Amount closeAmount) {
		this.closeAmount = closeAmount;
	}
	
	/**
	 * 期末净值
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getCloseAmount() {
		return this.closeAmount;
	}
	/**
	 * 结算时间
	 * @param settleTime
	 */
	public void setSettleTime(java.util.Date settleTime) {
		this.settleTime = settleTime;
	}
	
	/**
	 * 结算时间
	 * @return
	 */
	public java.util.Date getSettleTime() {
		return this.settleTime;
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