
package com.zbjdl.account.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zbjdl.common.utils.config.ConfigurationUtils;

/**
 * 通用
 * 
 * @author zhengy
 * @date: 2018年11月29日 下午3:00:50
 */
@Controller
@RequestMapping("/bussinessCode")
public class BussinessCodeController {

	private static final Logger logger = LoggerFactory.getLogger(BussinessCodeController.class);

	/*
	 * 根据 配置键 得到下拉框的KEY和VALUE
	 * 
	 * @param configKey
	 * 
	 * @return
	 */
	@RequestMapping(value = "/codeIndex", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @org.springframework.web.bind.annotation.ResponseBody Object memberInfoIndex(
			@RequestParam("configKey") String configKey) {

		Map<String, String> param = (Map<String, String>) ConfigurationUtils
				.getMapConfigParam(ConfigurationUtils.CONFIG_TYPE_SYS, configKey, String.class).getValue();
		if (param != null) {
			Iterator<String> iter = param.keySet().iterator();
			while (iter.hasNext()) {
				String key = iter.next();
				logger.info(key + ":" + param.get(key));
			}
		}
		return param;
	}
	
	@RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
	public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {}
	
}
