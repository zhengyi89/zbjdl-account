package com.zbjdl.account.enumtype;

/**
 * 数据状态
 * 
 * @author zhengy
 * @date: 2018年11月23日 下午5:24:35
 */
public enum AccountSettleStatusEnum {
	NORMAL("NORMAL", "正常"),INIT("INIT", "初始化"), SETTLE("SETTLE", "已结账");

	/**
	 * 判断enum值是否合法
	 * 
	 * @param code
	 * @return
	 */
	public static boolean isEnum(String code) {
		AccountSettleStatusEnum[] items = AccountSettleStatusEnum.values();
		for (AccountSettleStatusEnum item : items) {
			if (item.name().equals(code)) {
				return true;
			}
		}
		return false;
	}

	public static AccountSettleStatusEnum toEnum(String code) {
		AccountSettleStatusEnum[] items = AccountSettleStatusEnum.values();
		for (AccountSettleStatusEnum item : items) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
		return null;
	}

	private AccountSettleStatusEnum(String code, String msg) {
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
