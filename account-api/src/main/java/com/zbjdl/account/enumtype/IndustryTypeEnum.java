package com.zbjdl.account.enumtype;

/**
 * 资产通用枚举
 * 
 * @author zhengy
 * @date: 2018年11月23日 下午5:24:35
 */
public enum IndustryTypeEnum {
	/*
	 * 行业类型
	 */
	INDUSTRY_TYPE_1("1", "批发零售"), INDUSTRY_TYPE_2("2", "租赁和商业服务业"), INDUSTRY_TYPE_3("3", "信息传输、计算机服务和软件业"), 
	INDUSTRY_TYPE_4("4", "住宿、餐饮业"), INDUSTRY_TYPE_5("5", "农、林、牧、渔业"), INDUSTRY_TYPE_6("6", "采矿业"), 
	INDUSTRY_TYPE_7("7", "制造业"), INDUSTRY_TYPE_8("8", "建筑业");

	/**
	 * 判断enum值是否合法
	 * 
	 * @param code
	 * @return
	 */
	public static boolean isEnum(String code) {
		IndustryTypeEnum[] items = IndustryTypeEnum.values();
		for (IndustryTypeEnum item : items) {
			if (item.name().equals(code)) {
				return true;
			}
		}
		return false;
	}

	public static IndustryTypeEnum toEnum(String code) {
		IndustryTypeEnum[] items = IndustryTypeEnum.values();
		for (IndustryTypeEnum item : items) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
		return null;
	}

	private IndustryTypeEnum(String code, String msg) {
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
