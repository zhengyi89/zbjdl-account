package com.zbjdl.account.enumtype;

/**
 * 资产通用枚举
 * 
 * @author zhengy
 * @date: 2018年11月23日 下午5:24:35
 */
public enum VoucherTypeEnum {
	T("T", "模版"), SETTLE("SETTLE", "期末模版");

	/**
	 * 判断enum值是否合法
	 * 
	 * @param code
	 * @return
	 */
	public static boolean isEnum(String code) {
		VoucherTypeEnum[] items = VoucherTypeEnum.values();
		for (VoucherTypeEnum item : items) {
			if (item.name().equals(code)) {
				return true;
			}
		}
		return false;
	}

	public static VoucherTypeEnum toEnum(String code) {
		VoucherTypeEnum[] items = VoucherTypeEnum.values();
		for (VoucherTypeEnum item : items) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
		return null;
	}

	private VoucherTypeEnum(String code, String msg) {
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
