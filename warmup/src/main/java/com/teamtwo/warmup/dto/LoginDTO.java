package com.teamtwo.warmup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author shaoxiawjc
 * @ 2024/1/28
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.pojo.DTO
 **/
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO implements Serializable {
	private String token;
}
