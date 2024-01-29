package com.teamtwo.warmup.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author shaoxiawjc
 * @ 2024/1/28
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.handler
 **/
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
	@Override
	public void insertFill(MetaObject metaObject) {
		log.info("insert fill .............");
		this.setFieldValByName("gmtCreate",new Date(),metaObject);
		this.setFieldValByName("gmtModified",new Date(),metaObject);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		log.info("insert fill .............");
		this.setFieldValByName("gmtModified",new Date(),metaObject);
	}
}
