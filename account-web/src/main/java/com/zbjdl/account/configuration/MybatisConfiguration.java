package com.zbjdl.account.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
/**
 * Mybatis配置类
 * @author zhengy
 *
 */
@Configuration
@MapperScan(basePackages="com.zbjdl.account.repository")
public class MybatisConfiguration {

}
