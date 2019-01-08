/*
 * Powered By zbjdl-code-generator
 * Web Site: http://www.zbjdl.com
 * Since 2018 - 2022
 */

package com.zbjdl.account.dto;

import java.io.Serializable;

/**
 * AssetClassInfoDto
 * @author code-generator
 *
 */
public class AssetClassInfoDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String systemCode;
	private java.lang.String assetClassCode;
	private java.lang.String assetClassName;
	private java.lang.String deprecitionType;
	private java.lang.Integer useAge;
	private java.lang.String subjectCode1;
	private java.lang.String subjectCode2;
	private java.lang.String remark;
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
	 * 类别编码
	 * @param assetClassCode
	 */
	public void setAssetClassCode(java.lang.String assetClassCode) {
		this.assetClassCode = assetClassCode;
	}
	
	/**
	 * 类别编码
	 * @return
	 */
	public java.lang.String getAssetClassCode() {
		return this.assetClassCode;
	}
	/**
	 * 类别名称
	 * @param assetClassName
	 */
	public void setAssetClassName(java.lang.String assetClassName) {
		this.assetClassName = assetClassName;
	}
	
	/**
	 * 类别名称
	 * @return
	 */
	public java.lang.String getAssetClassName() {
		return this.assetClassName;
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
	 * 预计使用年限
	 * @param useAge
	 */
	public void setUseAge(java.lang.Integer useAge) {
		this.useAge = useAge;
	}
	
	/**
	 * 预计使用年限
	 * @return
	 */
	public java.lang.Integer getUseAge() {
		return this.useAge;
	}
	/**
	 * 固定资产科目
	 * @param subjectCode1
	 */
	public void setSubjectCode1(java.lang.String subjectCode1) {
		this.subjectCode1 = subjectCode1;
	}
	
	/**
	 * 固定资产科目
	 * @return
	 */
	public java.lang.String getSubjectCode1() {
		return this.subjectCode1;
	}
	/**
	 * 累计折旧科目
	 * @param subjectCode2
	 */
	public void setSubjectCode2(java.lang.String subjectCode2) {
		this.subjectCode2 = subjectCode2;
	}
	
	/**
	 * 累计折旧科目
	 * @return
	 */
	public java.lang.String getSubjectCode2() {
		return this.subjectCode2;
	}
	/**
	 * 备注
	 * @param remark
	 */
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	
	/**
	 * 备注
	 * @return
	 */
	public java.lang.String getRemark() {
		return this.remark;
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