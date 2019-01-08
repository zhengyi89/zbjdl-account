package com.zbjdl.account.enumtype;

/**
 * 资产通用枚举
 * 
 * @author zhengy
 * @date: 2018年11月23日 下午5:24:35
 */
public enum AssetEnum {
	COST_TYPE_DEPRECITION("DEPRECITION", "固定资产折旧"), COST_TYPE_EXPENSE("EXPENSE", "费用摊销")
	, STATUS_USING("USING", "使用中"), STATUS_EXPIRE("EXPIRE", "到期");

	/**
	 * 判断enum值是否合法
	 * 
	 * @param code
	 * @return
	 */
	public static boolean isEnum(String code) {
		AssetEnum[] items = AssetEnum.values();
		for (AssetEnum item : items) {
			if (item.name().equals(code)) {
				return true;
			}
		}
		return false;
	}

	public static AssetEnum toEnum(String code) {
		AssetEnum[] items = AssetEnum.values();
		for (AssetEnum item : items) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
		return null;
	}

	private AssetEnum(String code, String msg) {
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
