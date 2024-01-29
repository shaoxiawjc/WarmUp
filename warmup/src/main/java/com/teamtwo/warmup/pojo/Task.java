package com.teamtwo.warmup.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author shaoxiawjc
 * @ 2024/1/27
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.pojo
 **/
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Task implements Serializable {
	@TableId(type = IdType.ID_WORKER)
	private Long id;
	private Long userId;
	private String title;
	private String content;
	private Date startTime;
	private Date endTime;
	private Integer status;
	@TableField(fill = FieldFill.INSERT)
	private Date gmtCreate;
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date gmtModified;
	@Version
	private Integer version;

	public Task(Long userId, String title, String content, Date startTime, Date endTime, Integer status) {
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}

	public Task(Long id, Long userId, String title, String content, Date startTime, Date endTime, Integer status) {
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}
}
