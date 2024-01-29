package com.teamtwo.warmup.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.teamtwo.warmup.dto.*;
import com.teamtwo.warmup.exception.IncorrectStatusException;
import com.teamtwo.warmup.exception.TimeBackwardException;
import com.teamtwo.warmup.mapper.TaskMapper;
import com.teamtwo.warmup.pojo.Task;
import com.teamtwo.warmup.service.TaskService;
import com.teamtwo.warmup.utils.TimeChangeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @author shaoxiawjc
 * @ 2024/1/28
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.service.Impl
 **/
@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskMapper taskMapper;

	@Override
	public ResultRespWithoutPayload addTask(Long userId,
											String title,
											String content,
											String startTime,
											String endTime,
											Integer status) {
		Date st = TimeChangeUtil.change(startTime);
		Date et = TimeChangeUtil.change(endTime);
		Task task = new Task(userId, title, content, st, et, status);
		try {
			if (st.compareTo(et) > 0){
				throw new TimeBackwardException("开始时间晚于结束时间");
			}
			taskMapper.insert(task);
			return new ResultRespWithoutPayload(ResponseCode.SUCCESS);
		}catch (TimeBackwardException e){
			e.printStackTrace();
			return new ResultRespWithoutPayload(ResponseCode.TIME_BACKWARD);
		}catch (Exception e){
			e.printStackTrace();
			return new ResultRespWithoutPayload(ResponseCode.SYSTEM_ERROR);
		}

	}

	@Override
	public ResultResp<TaskSelectDTO> selectTasks(Long userId) {
		try{
			List<TaskSelect> taskSelects = taskMapper.selectAllTask(userId);
			int total = taskSelects.size();
			TaskSelectDTO dto = new TaskSelectDTO(taskSelects, total);
			return new ResultResp<>(ResponseCode.SUCCESS,dto);
		}catch (Exception e){
			e.printStackTrace();
			return new ResultResp<>(ResponseCode.SYSTEM_ERROR);
		}
	}

	@Override
	public ResultRespWithoutPayload delete(Long taskId,Long userId) {
		try {
			UpdateWrapper<Task> wrapper = new UpdateWrapper<>();
			wrapper.eq("user_id",userId)
					.eq("id",taskId);
			taskMapper.delete(wrapper);
			return new ResultRespWithoutPayload(ResponseCode.SUCCESS);
		}catch (Exception e){
			e.printStackTrace();
			return new ResultRespWithoutPayload(ResponseCode.SYSTEM_ERROR);
		}
	}

	@Override
	public ResultRespWithoutPayload update(Long taskId, Long userId,Integer status) {

		try {
			if (!(status == 0 || status == 1)){
				throw new IncorrectStatusException("status参数异常");
			}
			UpdateWrapper<Task> wrapper = new UpdateWrapper<Task>();
			wrapper.eq("id",taskId)
					.eq("user_id",userId)
					.set("status",status);
			taskMapper.update(null,wrapper);
			return new ResultRespWithoutPayload(ResponseCode.SUCCESS);
		}catch (IncorrectStatusException e){
			e.printStackTrace();
			return new ResultRespWithoutPayload(ResponseCode.STATUS_ERROR);
		} catch (Exception e){
			e.printStackTrace();
			return new ResultRespWithoutPayload(ResponseCode.SYSTEM_ERROR);
		}
	}
}
