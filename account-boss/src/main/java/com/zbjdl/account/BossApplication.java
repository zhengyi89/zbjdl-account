package com.zbjdl.account;

import javax.servlet.MultipartConfigElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author zhengy
 *
 */
@Controller
@SpringBootApplication
@ImportResource({"classpath:spring/applicationContext-consumer.xml","classpath:spring/applicationContext-account-query.xml"})
public class BossApplication  {
	
	private static final Logger logger = LoggerFactory
			.getLogger(BossApplication.class);
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize("26246327KB");
		factory.setMaxRequestSize("26246327KB");
		return factory.createMultipartConfig();
	}
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(BossApplication.class);
		springApplication.addListeners(new ApplicationEventListener());
        springApplication.run(args);
        logger.info("Spring boot loaded");
	}

    @Bean
    public StartupRunner schedulerRunner() {
        return new StartupRunner();
    }	
    /*
	 * 列表页面
	 */
	@RequestMapping(value = "/test")
	public String test() {
	
		return "index";
	}
	
}
