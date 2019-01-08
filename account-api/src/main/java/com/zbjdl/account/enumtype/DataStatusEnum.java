package com.zbjdl.account.enumtype;

/**
 * 数据状态
 * 
 * @author zhengy
 * @date: 2018年11月23日 下午5:24:35
 */
public enum DataStatusEnum {
	NORMAL("NORMAL", "正常"),AUDITED("AUDITED", "已审核"), DISABLE("DISABLE", "禁用"), DELETE("DELETE", "删除"),INIT("INIT", "初始化");

	/**
	 * 判断enum值是否合法
	 * 
	 * @param code
	 * @return
	 */
	public static boolean isEnum(String code) {
		DataStatusEnum[] items = DataStatusEnum.values();
		for (DataStatusEnum item : items) {
			if (item.name().equals(code)) {
				return true;
			}
		}
		return false;
	}

	public static DataStatusEnum toEnum(String code) {
		DataStatusEnum[] items = DataStatusEnum.values();
		for (DataStatusEnum item : items) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
		return null;
	}

	private DataStatusEnum(String code, String msg) {
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
