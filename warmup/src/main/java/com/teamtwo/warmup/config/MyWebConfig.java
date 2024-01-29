package com.teamtwo.warmup.config;

import com.teamtwo.warmup.handler.MyWebHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author shaoxiawjc
 * @ 2024/1/28
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.config
 **/
public class MyWebConfig implements WebMvcConfigurer {
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new MyWebHandler())
//				.addPathPatterns("/**")
//				.excludePathPatterns("/user/login","/user/register");
//	}
}
