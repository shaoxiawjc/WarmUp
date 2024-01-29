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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	@TableId(type = IdType.ID_WORKER)
	private Long id;
	private String username;
	private String password;
	@TableField(fill = FieldFill.INSERT)
	private Date gmtCreate;
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date gmtModified;
	@Version
	private Integer version;

	public User(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
