package com.teamtwo.warmup.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.teamtwo.warmup.dto.ResponseCode;
import com.teamtwo.warmup.dto.ResultRespWithoutPayload;
import com.teamtwo.warmup.dto.TaskSelectDTO;
import com.teamtwo.warmup.dto.ResultResp;
import com.teamtwo.warmup.service.TaskService;
import com.teamtwo.warmup.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author shaoxiawjc
 * @ 2024/1/28
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.controller
 **/
@RestController
public class TaskController {
	@Autowired
	private TaskService taskService;

	@CrossOrigin
	@PostMapping("/task/add")
	public ResponseEntity<ResultRespWithoutPayload> add(HttpServletRequest servletRequest,
														@RequestParam(name = "title") String title,
														@RequestParam(name = "content") String content,
														@RequestParam(name = "start_time") String startTime,
														@RequestParam(name = "end_time") String endTime,
														@RequestParam(name = "status") Integer status){
		System.out.println("执行了add");
		String token = servletRequest.getHeader("token");
		System.out.println("token is \n"+token+"\n-------------------------------------------------------------------");
		DecodedJWT verify = JWTUtils.verify(token);
		Long userId = Long.parseLong(verify.getClaim("userId").asString());
		System.out.println("token is \n"+token+"\n-------------------------------------------------------------------");
		ResultRespWithoutPayload result = taskService.addTask(userId, title, content, startTime, endTime, status);
		return ResponseEntity.ok(result);


	}

	@CrossOrigin
	@GetMapping("/task/query")
	public ResponseEntity<ResultResp<TaskSelectDTO>> query(HttpServletRequest servletRequest){
		System.out.println("query");
		String token = servletRequest.getHeader("token");
		System.out.println("token is \n"+token+"\n-------------------------------------------------------------------");
		Long userId = Long.parseLong(JWTUtils.verify(token).getClaim("userId").asString());
		System.out.println("userId is "+userId);
		return ResponseEntity.ok(taskService.selectTasks(userId));
	}

	@CrossOrigin
	@DeleteMapping("/task/del")
	public ResponseEntity<ResultRespWithoutPayload> delete(@RequestParam("task_id") String task_id,
														   HttpServletRequest request){
		System.out.println("delete");
		Long taskId = Long.parseLong(task_id);
		// 获取token
		String token = request.getHeader("token");
		System.out.println("token is \n"+token+"\n-------------------------------------------------------------------");
		DecodedJWT verify = JWTUtils.verify(token);
		Long userId = Long.parseLong(verify.getClaim("userId").asString());
		System.out.println("userId is "+userId);
		ResultRespWithoutPayload delete = taskService.delete(taskId,userId);
		return ResponseEntity.ok(delete);
	}

	@CrossOrigin
	@PutMapping("/task/update")
	public ResponseEntity<ResultRespWithoutPayload> update(@RequestParam("status") String status,
														   @RequestParam("task_id") String task_id,
														   HttpServletRequest request){
		System.out.println("update");
		// 获取token
		String token = request.getHeader("token");
		System.out.println("token is \n"+token+"\n-------------------------------------------------------------------");
		DecodedJWT verify = JWTUtils.verify(token);
		Long userId = Long.parseLong(verify.getClaim("userId").asString());
		System.out.println("userId is "+userId);
		long taskId = Long.parseLong(task_id);
		ResultRespWithoutPayload result = taskService.update(taskId,userId, Integer.parseInt(status));
		return ResponseEntity.ok(result);
	}

}
