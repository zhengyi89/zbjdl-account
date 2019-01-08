package com.zbjdl.account.enumtype;

/**
 * 辅助核算类别
 * 
 * @author zhengy
 * @date: 2018年11月23日 下午5:24:35
 */
public enum AssistAccountTypeEnum {
	CUSTOMER("CUSTOMER", "客户"), SUPPLIER("SUPPLIER", "供应商"), DEPARTMENT("DEPARTMENT", "部门"), 
	EMPLOYEE("EMPLOYEE", "职员"), PROJECT("PROJECT", "项目"), STOCK("STOCK", "存货");

	/**
	 * 判断enum值是否合法
	 * 
	 * @param code
	 * @return
	 */
	public static boolean isEnum(String code) {
		AssistAccountTypeEnum[] items = AssistAccountTypeEnum.values();
		for (AssistAccountTypeEnum item : items) {
			if (item.name().equals(code)) {
				return true;
			}
		}
		return false;
	}

	public static AssistAccountTypeEnum toEnum(String code) {
		AssistAccountTypeEnum[] items = AssistAccountTypeEnum.values();
		for (AssistAccountTypeEnum item : items) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
		return null;
	}

	private AssistAccountTypeEnum(String code, String msg) {
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
