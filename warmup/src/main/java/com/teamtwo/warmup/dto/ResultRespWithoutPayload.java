package com.teamtwo.warmup.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shaoxiawjc
 * @ 2024/1/28
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.dto
 **/
@Data
@NoArgsConstructor
public class ResultRespWithoutPayload {
	private Integer code;
	private String message;

	public ResultRespWithoutPayload(ResponseCode responseCode){
		this.code = responseCode.getCode();
		this.message = responseCode.getMessage();
	}
}
