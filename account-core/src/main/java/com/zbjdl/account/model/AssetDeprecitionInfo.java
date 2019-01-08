/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.model;

/**
 * AssetDeprecitionInfo
 * @author code-generator
 *
 */
public class AssetDeprecitionInfo {
	
	private java.lang.Long id;
	private java.lang.Long assetId;
	private com.zbjdl.common.amount.Amount openingNetWorth;
	private com.zbjdl.common.amount.Amount closingNetWorth;
	private com.zbjdl.common.amount.Amount initialWorth;
	private com.zbjdl.common.amount.Amount deprecitionAmount;
	private java.lang.String deprecitionMonth;
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
	 * 固定资产主键
	 * @param assetId
	 */
	public void setAssetId(java.lang.Long assetId) {
		this.assetId = assetId;
	}
	
	/**
	 * 固定资产主键
	 * @return
	 */
	public java.lang.Long getAssetId() {
		return this.assetId;
	}
	/**
	 * 期初净值
	 * @param openingNetWorth
	 */
	public void setOpeningNetWorth(com.zbjdl.common.amount.Amount openingNetWorth) {
		this.openingNetWorth = openingNetWorth;
	}
	
	/**
	 * 期初净值
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getOpeningNetWorth() {
		return this.openingNetWorth;
	}
	/**
	 * 期末净值
	 * @param closingNetWorth
	 */
	public void setClosingNetWorth(com.zbjdl.common.amount.Amount closingNetWorth) {
		this.closingNetWorth = closingNetWorth;
	}
	
	/**
	 * 期末净值
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getClosingNetWorth() {
		return this.closingNetWorth;
	}
	/**
	 * 原值
	 * @param initialWorth
	 */
	public void setInitialWorth(com.zbjdl.common.amount.Amount initialWorth) {
		this.initialWorth = initialWorth;
	}
	
	/**
	 * 原值
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getInitialWorth() {
		return this.initialWorth;
	}
	/**
	 * 当期折旧金额
	 * @param deprecitionAmount
	 */
	public void setDeprecitionAmount(com.zbjdl.common.amount.Amount deprecitionAmount) {
		this.deprecitionAmount = deprecitionAmount;
	}
	
	/**
	 * 当期折旧金额
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getDeprecitionAmount() {
		return this.deprecitionAmount;
	}
	/**
	 * 折旧月份
	 * @param deprecitionMonth
	 */
	public void setDeprecitionMonth(java.lang.String deprecitionMonth) {
		this.deprecitionMonth = deprecitionMonth;
	}
	
	/**
	 * 折旧月份
	 * @return
	 */
	public java.lang.String getDeprecitionMonth() {
		return this.deprecitionMonth;
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