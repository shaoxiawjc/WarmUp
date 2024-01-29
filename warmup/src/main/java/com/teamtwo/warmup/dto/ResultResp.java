package com.teamtwo.warmup.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author shaoxiawjc
 * @ 2024/1/28
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.pojo
 **/
@Data
public class ResultResp<T> {
	private Integer code;
	private String message;
	private T data;

	public ResultResp(ResponseCode responseCode) {
		this.code = responseCode.getCode();
		this.message = responseCode.getMessage();
	}

	public ResultResp(ResponseCode responseCode, T data) {
		this.code = responseCode.getCode();
		this.message = responseCode.getMessage();
		this.data = data;
	}
}
