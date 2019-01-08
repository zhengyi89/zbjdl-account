package com.zbjdl.account.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Product
 * @author tangyj
 *
 */
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String productName;//产品名称
	private String productLogoUrl;//产品图标url
	private String productLogoName;//产品图标名字
	private BigDecimal amountRangeStart;//贷款金额范围－start
	private BigDecimal amountRangeEnd;//贷款金额范围－end
	private BigDecimal perAmountLimit;//单笔限额
	private BigDecimal serviceRate;//服务费％
	private BigDecimal penaltyRate;//罚息％
	private String productNo;//产品编号
	private String gracePeriod;//宽限天数，整数
	private String outerProductType;//外部产品类型
	private String outerProductCode;//外部产品编码
	private String repaymentType;//还款方式
	private String interestType;//计息方式
	private String summary; //摘要
	private String context;//正文
	private String contextUrl;//正文url
	private String status;//状态
	private Date publishTime;//发布时间
	private Date createTime;//创建时间
	private Date modifyTime;//修改时间
	private String remark;//备注
	private String operator;//操作者
	private String extend1;//扩展字段1
	private String extend2;//扩展字段2
	private String period;//期限选择
	private BigDecimal productRate;//利率
	
	private String authorization;//必做授权
	private String lowestAmountLimit;//单笔下限
	private String singlePeriodRule;//单期的服务费规则
	private String userType;//客户人群
	private String institution;//所属机构标识
	private String baseProductCredit;//是否基于产品授信
	private BigDecimal breachRate;//违约金利率
	private String productNameAlias;//产品别名
	private String maxAge;//最大年龄
	private String minAge;//最小年龄
	private String comprehensiveRate;//综合费率


	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Long getId() {
		return this.id;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductName() {
		return this.productName;
	}
	
	public void setProductLogoUrl(String productLogoUrl) {
		this.productLogoUrl = productLogoUrl;
	}
	
	
	public String getProductLogoUrl() {
		return this.productLogoUrl;
	}
	
	public void setProductLogoName(String productLogoName) {
		this.productLogoName = productLogoName;
	}
	
	
	public String getProductLogoName() {
		return this.productLogoName;
	}
	
	
	public void setServiceRate(BigDecimal serviceRate) {
		this.serviceRate = serviceRate;
	}
	
	public BigDecimal getServiceRate() {
		return this.serviceRate;
	}
	
	public void setOuterProductType(String outerProductType) {
		this.outerProductType = outerProductType;
	}
	
	
	public String getOuterProductType() {
		return this.outerProductType;
	}
	
	public void setOuterProductCode(String outerProductCode) {
		this.outerProductCode = outerProductCode;
	}
	
	public String getOuterProductCode() {
		return this.outerProductCode;
	}
	
	public void setRepaymentType(String repaymentType) {
		this.repaymentType = repaymentType;
	}
	
	
	public String getRepaymentType() {
		return this.repaymentType;
	}
	
	public String getInterestType() {
		return interestType;
	}

	public void setInterestType(String interestType) {
		this.interestType = interestType;
	}

	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	
	public String getSummary() {
		return this.summary;
	}
	
	public void setContext(String context) {
		this.context = context;
	}
	
	
	public String getContext() {
		return this.context;
	}
	
	public void setContextUrl(String contextUrl) {
		this.contextUrl = contextUrl;
	}
	
	public String getContextUrl() {
		return this.contextUrl;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setPublishTime(java.util.Date publishTime) {
		this.publishTime = publishTime;
	}
	
	public java.util.Date getPublishTime() {
		return this.publishTime;
	}
	
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setModifyTime(java.util.Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	public java.util.Date getModifyTime() {
		return this.modifyTime;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getRemark() {
		return this.remark;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getOperator() {
		return this.operator;
	}
	
	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}
	
	public String getExtend1() {
		return this.extend1;
	}
	
	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}
	
	public String getExtend2() {
		return this.extend2;
	}
	
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	
	public void setProductRate(BigDecimal productRate) {
		this.productRate = productRate;
	}
	
	
	public BigDecimal getProductRate() {
		return this.productRate;
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