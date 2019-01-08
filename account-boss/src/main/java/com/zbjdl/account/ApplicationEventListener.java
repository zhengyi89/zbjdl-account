package com.zbjdl.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Spring Boot EventListener
 * @author zhengy
 *
 */
public class ApplicationEventListener implements ApplicationListener<ContextRefreshedEvent> {
	private static final Logger logger = LoggerFactory
			.getLogger(ApplicationEventListener.class);
	@Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//		logger.info(event.toString());
//		try {
//			DataSource dataSource = (DataSource)event.getApplicationContext().getBean("dataSource");
//			logger.info(dataSource.getConnection().toString());
//		} catch (Exception e) {
//			logger.error(e.getMessage(),e);
//		}
	}
}