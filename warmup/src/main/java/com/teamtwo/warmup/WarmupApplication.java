package com.teamtwo.warmup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.teamtwo.warmup.mapper")
public class WarmupApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarmupApplication.class, args);
	}

}
