/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.model;

/**
 * AssetInfo
 * @author code-generator
 *
 */
public class AssetInfo {
	
	private java.lang.Long id;
	private java.lang.String systemCode;
	private java.lang.String assetCode;
	private java.lang.String assetName;
	private java.lang.String assetClassCode;
	private java.lang.String assistCode;
	private java.lang.String subjectCode1;
	private java.lang.String subjectCode2;
	private java.lang.String subjectCode3;
	private java.lang.String subjectCode4;
	private java.lang.String subjectCode5;
	private java.lang.String subjectCode6;
	private com.zbjdl.common.amount.Amount initialWorth;
	private com.zbjdl.common.amount.Amount assetWorth;
	private java.lang.Integer useAge;
	private java.lang.Integer hasUseAge;
	private java.lang.String deprecitionType;
	private com.zbjdl.common.amount.Amount netSalvage;
	private com.zbjdl.common.amount.Amount monthLossAmount;
	private java.util.Date beginDate;
	private java.util.Date beginUseDate;
	private java.lang.String costType;
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
	 * 资产编码
	 * @param assetCode
	 */
	public void setAssetCode(java.lang.String assetCode) {
		this.assetCode = assetCode;
	}
	
	/**
	 * 资产编码
	 * @return
	 */
	public java.lang.String getAssetCode() {
		return this.assetCode;
	}
	/**
	 * 资产名称
	 * @param assetName
	 */
	public void setAssetName(java.lang.String assetName) {
		this.assetName = assetName;
	}
	
	/**
	 * 资产名称
	 * @return
	 */
	public java.lang.String getAssetName() {
		return this.assetName;
	}
	/**
	 * 资产类别
	 * @param assetClassCode
	 */
	public void setAssetClassCode(java.lang.String assetClassCode) {
		this.assetClassCode = assetClassCode;
	}
	
	/**
	 * 资产类别
	 * @return
	 */
	public java.lang.String getAssetClassCode() {
		return this.assetClassCode;
	}
	/**
	 * 使用部门
	 * @param assistCode
	 */
	public void setAssistCode(java.lang.String assistCode) {
		this.assistCode = assistCode;
	}
	
	/**
	 * 使用部门
	 * @return
	 */
	public java.lang.String getAssistCode() {
		return this.assistCode;
	}
	/**
	 * 
	 * @param subjectCode1
	 */
	public void setSubjectCode1(java.lang.String subjectCode1) {
		this.subjectCode1 = subjectCode1;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSubjectCode1() {
		return this.subjectCode1;
	}
	/**
	 * 
	 * @param subjectCode2
	 */
	public void setSubjectCode2(java.lang.String subjectCode2) {
		this.subjectCode2 = subjectCode2;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSubjectCode2() {
		return this.subjectCode2;
	}
	/**
	 * 
	 * @param subjectCode3
	 */
	public void setSubjectCode3(java.lang.String subjectCode3) {
		this.subjectCode3 = subjectCode3;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSubjectCode3() {
		return this.subjectCode3;
	}
	/**
	 * 
	 * @param subjectCode4
	 */
	public void setSubjectCode4(java.lang.String subjectCode4) {
		this.subjectCode4 = subjectCode4;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSubjectCode4() {
		return this.subjectCode4;
	}
	/**
	 * 
	 * @param subjectCode5
	 */
	public void setSubjectCode5(java.lang.String subjectCode5) {
		this.subjectCode5 = subjectCode5;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSubjectCode5() {
		return this.subjectCode5;
	}
	/**
	 * 
	 * @param subjectCode6
	 */
	public void setSubjectCode6(java.lang.String subjectCode6) {
		this.subjectCode6 = subjectCode6;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSubjectCode6() {
		return this.subjectCode6;
	}
	/**
	 * 资产初始价值
	 * @param initialWorth
	 */
	public void setInitialWorth(com.zbjdl.common.amount.Amount initialWorth) {
		this.initialWorth = initialWorth;
	}
	
	/**
	 * 资产初始价值
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getInitialWorth() {
		return this.initialWorth;
	}
	/**
	 * 资产当前价值
	 * @param assetWorth
	 */
	public void setAssetWorth(com.zbjdl.common.amount.Amount assetWorth) {
		this.assetWorth = assetWorth;
	}
	
	/**
	 * 资产当前价值
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getAssetWorth() {
		return this.assetWorth;
	}
	/**
	 * 预计使用期限（月）
	 * @param useAge
	 */
	public void setUseAge(java.lang.Integer useAge) {
		this.useAge = useAge;
	}
	
	/**
	 * 预计使用期限（月）
	 * @return
	 */
	public java.lang.Integer getUseAge() {
		return this.useAge;
	}
	/**
	 * 
	 * @param hasUseAge
	 */
	public void setHasUseAge(java.lang.Integer hasUseAge) {
		this.hasUseAge = hasUseAge;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.Integer getHasUseAge() {
		return this.hasUseAge;
	}
	/**
	 * 折旧方法
	 * @param deprecitionType
	 */
	public void setDeprecitionType(java.lang.String deprecitionType) {
		this.deprecitionType = deprecitionType;
	}
	
	/**
	 * 折旧方法
	 * @return
	 */
	public java.lang.String getDeprecitionType() {
		return this.deprecitionType;
	}
	/**
	 * 预计净残值
	 * @param netSalvage
	 */
	public void setNetSalvage(com.zbjdl.common.amount.Amount netSalvage) {
		this.netSalvage = netSalvage;
	}
	
	/**
	 * 预计净残值
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getNetSalvage() {
		return this.netSalvage;
	}
	/**
	 * 月损益额
	 * @param monthLossAmount
	 */
	public void setMonthLossAmount(com.zbjdl.common.amount.Amount monthLossAmount) {
		this.monthLossAmount = monthLossAmount;
	}
	
	/**
	 * 月损益额
	 * @return
	 */
	public com.zbjdl.common.amount.Amount getMonthLossAmount() {
		return this.monthLossAmount;
	}
	/**
	 * 创建时间
	 * @param beginDate
	 */
	public void setBeginDate(java.util.Date beginDate) {
		this.beginDate = beginDate;
	}
	
	/**
	 * 创建时间
	 * @return
	 */
	public java.util.Date getBeginDate() {
		return this.beginDate;
	}
	/**
	 * 开始使用时间
	 * @param beginUseDate
	 */
	public void setBeginUseDate(java.util.Date beginUseDate) {
		this.beginUseDate = beginUseDate;
	}
	
	/**
	 * 开始使用时间
	 * @return
	 */
	public java.util.Date getBeginUseDate() {
		return this.beginUseDate;
	}
	/**
	 * 损耗类型
	 * @param costType
	 */
	public void setCostType(java.lang.String costType) {
		this.costType = costType;
	}
	
	/**
	 * 损耗类型
	 * @return
	 */
	public java.lang.String getCostType() {
		return this.costType;
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