package com.zbjdl.account.enumtype;

/**
 * 系统枚举类
 * 
 * @author zhengy
 * @date: 2018年11月23日 下午5:24:35
 */
public enum SystemEnum {
	/*
	 * 会计制度
	 */
	ACCOUNT_TYPE_SMALL("SMALL", "小企业会计准则"), ACCOUNT_TYPE_GENERAL("GENERAL", "企业会计准则"), ACCOUNT_TYPE_NONPROFIT("NONPROFIT", "民间非营利组织"),
	
	/*
	 * 纳税人类型
	 */
	TAXPAYER_TYPE_SMALL("SMALL", "小规模纳税人"), TAXPAYER_TYPE_GENERAL("GENERAL", "一般纳税人"),
	
	/*
	 * 记账类型
	 */
	DEBIT("DEBIT", "借"), CREDIT("CREDIT", "贷"),
	
	/*
	 * 科目预设类型
	 */
	SUBJECT_DEFAULT("DEFAULT", "系统默认"), SUBJECT_COST_DEFAULT("DEFAULT_COST", "期间费用预设科目"),
	
	
	;

	/**
	 * 判断enum值是否合法
	 * 
	 * @param code
	 * @return
	 */
	public static boolean isEnum(String code) {
		SystemEnum[] items = SystemEnum.values();
		for (SystemEnum item : items) {
			if (item.name().equals(code)) {
				return true;
			}
		}
		return false;
	}

	public static SystemEnum toEnum(String code) {
		SystemEnum[] items = SystemEnum.values();
		for (SystemEnum item : items) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
		return null;
	}

	private SystemEnum(String code, String msg) {
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
