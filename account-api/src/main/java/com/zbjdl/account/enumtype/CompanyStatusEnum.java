package com.zbjdl.account.enumtype;

/**
 * 服务状态
 * 
 * @author zhengy
 * @date: 2018年11月23日 下午5:24:35
 */
public enum CompanyStatusEnum {
	
	
	CREATE("CREATE", "新建"), ASSIGN("ASSIGN", "已分配"), ACCEPT("ACCEPT", "已受理"), 
	ACCOUNTING("ACCOUNTING", "代帐中"), DISABLE("DISABLE", "停用");

	/**
	 * 判断enum值是否合法
	 * 
	 * @param code
	 * @return
	 */
	public static boolean isEnum(String code) {
		CompanyStatusEnum[] items = CompanyStatusEnum.values();
		for (CompanyStatusEnum item : items) {
			if (item.name().equals(code)) {
				return true;
			}
		}
		return false;
	}

	public static CompanyStatusEnum toEnum(String code) {
		CompanyStatusEnum[] items = CompanyStatusEnum.values();
		for (CompanyStatusEnum item : items) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
		return null;
	}

	private CompanyStatusEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	private String code;
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
