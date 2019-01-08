package com.zbjdl.account.util;

import com.zbjdl.account.enumtype.SystemInfoEnum;
import com.zbjdl.common.amount.Amount;

/**
 * 常用类封装
 * 
 * @author zhengy
 * @date: 2018年12月19日 下午4:29:18
 */
public class AccountUtils {
	/**
	 * 根据科目余额方向，获取发生金额
	 * 
	 * @param balanceDirect 余额方向
	 * @param debitAmount 借方金额
	 * @param creditAmount 贷方金额
	 * @return
	 */
	public static Amount getRealAmount(String balanceDirect, Amount debitAmount, Amount creditAmount) {
		Amount amount = null;
		debitAmount = debitAmount==null?new Amount():debitAmount;
		creditAmount = creditAmount==null?new Amount():creditAmount;
		if (SystemInfoEnum.CREDIT.getCode().equals(balanceDirect)) {
			amount = creditAmount.subtract(debitAmount);
		} else {
			amount = debitAmount.subtract(creditAmount);
		}
		return amount;
	}
}
