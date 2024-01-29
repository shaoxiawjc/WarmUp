package com.teamtwo.warmup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author shaoxiawjc
 * @ 2024/1/28
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.pojo
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskSelect {
	private String id;
	private String content;
	private String title;
	private Date startTime;
	private Date endTime;
	private Integer status;
}
