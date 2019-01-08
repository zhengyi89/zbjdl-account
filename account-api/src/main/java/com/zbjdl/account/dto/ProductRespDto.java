/*
 * Powered By chanjetpay-code-generator
 * Web Site: http://www.chanjetpay.com
 * Since 2014 - 2016
 */

package com.zbjdl.account.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

/**
 * Product
 * @author tangyj
 *
 */
public class ProductRespDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String productName;
	private String productLogoUrl;
	private String productLogoName;
	private BigDecimal amountRangeStart;
	private BigDecimal amountRangeEnd;
	private BigDecimal perAmountLimit;
	private BigDecimal serviceRate;
	private BigDecimal penaltyRate;//罚息
	private String productNo;//产品编号
	private String gracePeriod;//宽限天数
	private String outerProductType;
	private String outerProductCode;
	private String repaymentType;
	private String interestType;
	private String summary;
	private String context;
	private String contextUrl;
	private String status;
	private Date publishTime;
	private Date createTime;
	private Date modifyTime;
	private String remark;
	private String operator;
	private String extend1;
	private String extend2;
	
	private String period;
	
	private String authorization;//必做授权
	private String lowestAmountLimit;//单笔下限
	private String singlePeriodRule;//单期的服务费规则
	private String userType;//客户人群
	private String institution;//所属机构标识
	private String baseProductCredit;//是否基于产品授信
	private BigDecimal breachRate;//违约金利率

    
    @NumberFormat(style=Style.NUMBER)  
	private BigDecimal productRate;
	private String productNameAlias;//产品别名
	private String maxAge;//最大年龄
	private String minAge;//最小年龄
	private String comprehensiveRate;//综合费率

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductLogoUrl() {
		return productLogoUrl;
	}

	public void setProductLogoUrl(String productLogoUrl) {
		this.productLogoUrl = productLogoUrl;
	}

	public String getProductLogoName() {
		return productLogoName;
	}

	public void setProductLogoName(String productLogoName) {
		this.productLogoName = productLogoName;
	}

	public BigDecimal getServiceRate() {
		return serviceRate;
	}

	public void setServiceRate(BigDecimal serviceRate) {
		this.serviceRate = serviceRate;
	}

	public String getOuterProductType() {
		return outerProductType;
	}

	public void setOuterProductType(String outerProductType) {
		this.outerProductType = outerProductType;
	}

	public String getOuterProductCode() {
		return outerProductCode;
	}

	public void setOuterProductCode(String outerProductCode) {
		this.outerProductCode = outerProductCode;
	}

	public String getRepaymentType() {
		return repaymentType;
	}

	public void setRepaymentType(String repaymentType) {
		this.repaymentType = repaymentType;
	}

	

	public String getInterestType() {
		return interestType;
	}

	public void setInterestType(String interestType) {
		this.interestType = interestType;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getContextUrl() {
		return contextUrl;
	}

	public void setContextUrl(String contextUrl) {
		this.contextUrl = contextUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public java.util.Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(java.util.Date publishTime) {
		this.publishTime = publishTime;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(java.util.Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getExtend1() {
		return extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	public String getExtend2() {
		return extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public BigDecimal getProductRate() {
		return productRate;
	}

	public void setProductRate(BigDecimal productRate) {
		this.productRate = productRate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BigDecimal getPenaltyRate() {
		return penaltyRate;
	}

	public void setPenaltyRate(BigDecimal penaltyRate) {
		this.penaltyRate = penaltyRate;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getGracePeriod() {
		return gracePeriod;
	}

	public void setGracePeriod(String gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	public BigDecimal getAmountRangeStart() {
		return amountRangeStart;
	}

	public void setAmountRangeStart(BigDecimal amountRangeStart) {
		this.amountRangeStart = amountRangeStart;
	}

	public BigDecimal getAmountRangeEnd() {
		return amountRangeEnd;
	}

	public void setAmountRangeEnd(BigDecimal amountRangeEnd) {
		this.amountRangeEnd = amountRangeEnd;
	}

	public BigDecimal getPerAmountLimit() {
		return perAmountLimit;
	}

	public void setPerAmountLimit(BigDecimal perAmountLimit) {
		this.perAmountLimit = perAmountLimit;
	}

	public String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

	public String getLowestAmountLimit() {
		return lowestAmountLimit;
	}

	public void setLowestAmountLimit(String lowestAmountLimit) {
		this.lowestAmountLimit = lowestAmountLimit;
	}

	public String getSinglePeriodRule() {
		return singlePeriodRule;
	}

	public void setSinglePeriodRule(String singlePeriodRule) {
		this.singlePeriodRule = singlePeriodRule;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getBaseProductCredit() {
		return baseProductCredit;
	}

	public void setBaseProductCredit(String baseProductCredit) {
		this.baseProductCredit = baseProductCredit;
	}

	public BigDecimal getBreachRate() {
		return breachRate;
	}

	public void setBreachRate(BigDecimal breachRate) {
		this.breachRate = breachRate;
	}

	public String getProductNameAlias() {
		return productNameAlias;
	}

	public void setProductNameAlias(String productNameAlias) {
		this.productNameAlias = productNameAlias;
	}

	public String getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(String maxAge) {
		this.maxAge = maxAge;
	}

	public String getMinAge() {
		return minAge;
	}

	public void setMinAge(String minAge) {
		this.minAge = minAge;
	}

	public String getComprehensiveRate() {
		return comprehensiveRate;
	}

	public void setComprehensiveRate(String comprehensiveRate) {
		this.comprehensiveRate = comprehensiveRate;
	}

	
}