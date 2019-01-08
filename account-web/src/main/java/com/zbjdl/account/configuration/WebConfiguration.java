package com.zbjdl.account.configuration;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.remoting.http.servlet.DispatcherServlet;

@Configuration
public class WebConfiguration {
	 @Bean
	    public ServletRegistrationBean soaDispatcherServlet(){
	    	//注册Dubbo Servlet
	        DispatcherServlet dispatcherServlet = new DispatcherServlet();   
	        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/soa/*");
	        servletRegistrationBean.setName("soa");
	        return servletRegistrationBean;

	    }
}
