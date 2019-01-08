package com.zbjdl.account;

import java.net.MalformedURLException;

import com.alibaba.fastjson.JSON;
import com.caucho.hessian.client.HessianProxyFactory;
import com.zbjdl.boss.admin.dto.sso.SSOLoginInfoDTO;
import com.zbjdl.boss.admin.facade.SecurityFacade;
import com.zbjdl.boss.admin.facade.UserLoginFacade;
import com.zbjdl.boss.admin.frame.utils.Constants;
import com.zbjdl.boss.admin.function.dto.MenuModel;
import com.zbjdl.common.dubbo.proxy.SoaServiceRepository;

public class TestMain {
	public static void main(String[] args) {
		String serviceUrl = "http://188.131.141.60:8081/admin-web/soa/com.zbjdl.boss.admin.facade.SecurityFacade";
		HessianProxyFactory factory = new HessianProxyFactory();
		
		try {
//			SecurityFacade securityFacade = (SecurityFacade) factory.create(
//					SecurityFacade.class, serviceUrl);
//			MenuModel result = securityFacade.getMenuTreeByUserId(6L);
//			System.out.println(JSON.toJSONString(result));
			
			UserLoginFacade ecurityFacade =  SoaServiceRepository.getService(UserLoginFacade.class,Constants.DUBBO_DEFAULT_GROUP,Constants.DUBBO_DEFAULT_VERSION);
			SSOLoginInfoDTO result1 = ecurityFacade.getUserIdByToken("1111111");
			
			System.out.println(JSON.toJSONString(result1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
//	public static void main(String[] args) {
//		UserLoginFacade securityFacade =  SoaServiceRepository.getService(UserLoginFacade.class,Constants.DUBBO_DEFAULT_GROUP,Constants.DUBBO_DEFAULT_VERSION);
//		SSOLoginInfoDTO result = securityFacade.getUserIdByToken("1111111");
//		System.out.println(JSON.toJSONString(result));
//	}
}
