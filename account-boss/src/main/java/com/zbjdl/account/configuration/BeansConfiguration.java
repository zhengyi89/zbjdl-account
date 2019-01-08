package com.zbjdl.account.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.zbjdl.common.utils.config.ConfigurationUtils;
/**
 * Bean 配置类
 * @author yejiyong
 *
 */
@Configuration
public class BeansConfiguration {


	@Bean
	public ConfigurationUtils configurationUtils(){
		ConfigurationUtils cfg = new ConfigurationUtils();
		cfg.init();
		return cfg;
	}

}
