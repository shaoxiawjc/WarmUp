package com.teamtwo.warmup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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
public class TaskSelectDTO {
	private List<TaskSelect> items;
	private Integer total;
}
