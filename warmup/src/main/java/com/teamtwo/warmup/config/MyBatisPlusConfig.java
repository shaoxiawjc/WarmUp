package com.teamtwo.warmup.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author shaoxiawjc
 * @ 2024/1/28
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.config
 **/
@Configuration
@EnableTransactionManagement
@MapperScan("com.teamtwo.warmup.mapper")
public class MyBatisPlusConfig {
}
