package com.teamtwo.warmup.service;

import com.teamtwo.warmup.dto.ResponseCode;
import com.teamtwo.warmup.dto.ResultRespWithoutPayload;
import com.teamtwo.warmup.dto.TaskSelectDTO;
import com.teamtwo.warmup.dto.ResultResp;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author shaoxiawjc
 * @ 2024/1/28
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.service
 **/
@Service
public interface TaskService {
	ResultRespWithoutPayload addTask(Long userId,
						 String title,
						 String content,
						 String startTime,
						 String endTime,
						 Integer status);

	ResultResp<TaskSelectDTO> selectTasks(Long userId);

	ResultRespWithoutPayload delete(Long taskId,Long userId);

	ResultRespWithoutPayload update(Long taskId,Long userId,Integer status);
}
