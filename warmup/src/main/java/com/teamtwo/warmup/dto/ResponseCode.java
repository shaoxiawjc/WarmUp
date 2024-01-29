package com.teamtwo.warmup.dto;

import lombok.Data;

/**
 * @author shaoxiawjc
 * @ 2024/1/28
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.pojo
 **/
public enum ResponseCode {
	SUCCESS(0, "成功"),
	INVALID_USERNAME_PASSWORD(1001, "密码不正确"),
	ACCOUNT_NOT_FOUND(1002, "账号不存在"),
	ACCOUNT_EXIST(1003,"用户已存在"),
	SYSTEM_ERROR(0001,"服务端出错"),
	TIME_BACKWARD(2001,"开始时间晚于结束时间"),
	STATUS_ERROR(2002,"status参数异常");


	private final Integer code;
	private final String message;

	ResponseCode(ResponseCode responseCode){
		this.code = responseCode.getCode();
		this.message = responseCode.getMessage();
	}

	ResponseCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}


}
