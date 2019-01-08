package com.zbjdl.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
@ImportResource({ "classpath:web-spring/applicationContext-provider.xml",
		"classpath:web-spring/applicationContext-consumer.xml" })
public class WebApplication {
	private static final Logger logger = LoggerFactory.getLogger(WebApplication.class);

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(WebApplication.class);
		springApplication.run(args);
		logger.info("Spring boot loaded----------account-web-----");
	}
	
}
