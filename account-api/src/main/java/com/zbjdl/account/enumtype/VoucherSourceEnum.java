package com.zbjdl.account.enumtype;

/**
 * 凭证来源
 * 
 * @author zhengy
 * @date: 2018年11月23日 下午5:24:35
 */
public enum VoucherSourceEnum {
	TYPE_IN("TYPEIN", "凭证录入"), PURCHASE_INVOICE("PURCHASE", "采购发票"), SELL_INVOICE("SELL", "销售发票")
	, COST_INVOICE("COST", "费用发票"), BANK_VOUCHER("BANK", "银行凭证");

	/**
	 * 判断enum值是否合法
	 * 
	 * @param code
	 * @return
	 */
	public static boolean isEnum(String code) {
		VoucherSourceEnum[] items = VoucherSourceEnum.values();
		for (VoucherSourceEnum item : items) {
			if (item.name().equals(code)) {
				return true;
			}
		}
		return false;
	}

	public static VoucherSourceEnum toEnum(String code) {
		VoucherSourceEnum[] items = VoucherSourceEnum.values();
		for (VoucherSourceEnum item : items) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
		return null;
	}

	private VoucherSourceEnum(String code, String msg) {
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
