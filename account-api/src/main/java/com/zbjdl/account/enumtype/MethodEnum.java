package com.zbjdl.account.enumtype;

/**
 * 操作方法枚举
 * 
 * @author zhengy
 * @date: 2018年11月29日 下午9:38:32
 */
public enum MethodEnum {
	ADD("ADD", "新增"), UPDATE("UPDATE", "修改"), DELETE("DELETE", "删除"), AUDIT("AUDIT", "审核"), UNAUDIT("UNAUDIT", "反审核");

	/**
	 * 判断enum值是否合法
	 * 
	 * @param code
	 * @return
	 */
	public static boolean isEnum(String code) {
		MethodEnum[] items = MethodEnum.values();
		for (MethodEnum item : items) {
			if (item.name().equals(code)) {
				return true;
			}
		}
		return false;
	}

	public static MethodEnum toEnum(String code) {
		MethodEnum[] items = MethodEnum.values();
		for (MethodEnum item : items) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
		return null;
	}

	private MethodEnum(String code, String msg) {
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
