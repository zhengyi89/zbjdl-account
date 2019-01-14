package com.zbjdl.account.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.zbjdl.account.dto.AssistAccountSettleInfoDto;

public class Test {
	
	public static void main(String[] args) {
		String s = "[{'assistCode':'kh001','creditAmount':{'negative':false,'positive':false,'value':0.00,'zero':true},'debitAmount':{'negative':false,'positive':false,'value':0.00,'zero':true},'openingBalance':{'negative':false,'positive':true,'value':9300.00,'zero':false},'yearOpeningBalance':{'negative':false,'positive':true,'value':9300.00,'zero':false}},{'assistCode':'kh002','creditAmount':{'negative':false,'positive':false,'value':0.00,'zero':true},'debitAmount':{'negative':false,'positive':false,'value':0.00,'zero':true},'openingBalance':{'negative':false,'positive':true,'value':369.00,'zero':false},'yearOpeningBalance':{'negative':false,'positive':true,'value':369.00,'zero':false}}]";
		//json字符串转List
		List<AssistAccountSettleInfoDto> list = JSON.parseArray(s, AssistAccountSettleInfoDto.class);
		for (AssistAccountSettleInfoDto assistAccountSettleInfoDto : list) {
			System.out.println(JSON.toJSONString(assistAccountSettleInfoDto));
		}
	}

}
