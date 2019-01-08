package com.zbjdl.account.enumtype;

/**
 * 会计科目类别
 * 
 * @author zhengy
 * @date: 2018年11月23日 下午5:24:35
 */
public enum SubjectTypeEnum {
	ASSET("ASSET", "资产"), LIABILITIES("LIABILITIES", "负债"), EQUITY("EQUITY", "权益"), 
	COST("COST", "成本"), PROFIT_LOSS("PROFIT_LOSS", "损益");

	/**
	 * 判断enum值是否合法
	 * 
	 * @param code
	 * @return
	 */
	public static boolean isEnum(String code) {
		SubjectTypeEnum[] items = SubjectTypeEnum.values();
		for (SubjectTypeEnum item : items) {
			if (item.name().equals(code)) {
				return true;
			}
		}
		return false;
	}

	public static SubjectTypeEnum toEnum(String code) {
		SubjectTypeEnum[] items = SubjectTypeEnum.values();
		for (SubjectTypeEnum item : items) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
		return null;
	}

	private SubjectTypeEnum(String code, String msg) {
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
