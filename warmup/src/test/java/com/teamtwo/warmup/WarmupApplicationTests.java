package com.teamtwo.warmup;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.teamtwo.warmup.mapper.TaskMapper;
import com.teamtwo.warmup.mapper.UserMapper;
import com.teamtwo.warmup.pojo.Task;
import com.teamtwo.warmup.pojo.User;
import com.teamtwo.warmup.service.TaskService;
import com.teamtwo.warmup.service.UserService;
import com.teamtwo.warmup.utils.JWTUtils;
import com.teamtwo.warmup.utils.TimeChangeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class WarmupApplicationTests {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private TaskMapper taskMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;

	@Test
	void contextLoads() {
	}
	@Test
	void testUserMapper() {
//		User user = new User("shaoxia", "123456");
//		userMapper.insert(user);
//		System.out.println(user);
//		System.out.println(userMapper.selectById(user.getId()));
//		userMapper.deleteById(1751440788402565122l);
	}

	@Test
	void testTaskMapper(){
		Task task = new Task(1751440547154571265L,
				"测试",
				"测试sss",
				new Date(),
				new Date(),
				0);
		taskMapper.insert(task);
		System.out.println(task);
//		System.out.println(taskMapper.selectById(task.getId()));
	}

	@Test
	void  testUserService(){
//		System.out.println(userService.userLogin("shaoxia", "123456"));
		System.out.println(userService.userRegister("shaoxia666", "5851"));
	}


	@Test
	void testTaskService(){
		System.out.println(taskService.selectTasks(1751440547154571265L));
	}

	@Test
	void testToken(){
		DecodedJWT verify = JWTUtils.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MDc2MzMyOTQsInVzZXJJZCI6IjE3NTE0NDA1NDcxNTQ1NzEyNjUiLCJ1c2VybmFtZSI6InNoYW94aWEifQ.bOkBhhl7WkKg-OuzVPB_OpioMV5us7GwSmJoJ4mngxs");
		System.out.println(verify.getClaim("userId").asString());

	}

	@Test
	void testTime(){
		Date t1 = TimeChangeUtil.change("2005-10-22 00:00:00");
		Date t2 = TimeChangeUtil.change("2105-10-22 00:00:00");
		System.out.println(t1.compareTo(t2));
	}

	@Test
	void testjwt(){
		DecodedJWT verify = JWTUtils.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MDc2NTExODEsInVzZXJJZCI6IjE3NTE0NDA1NDcxNTQ1NzEyNjUiLCJ1c2VybmFtZSI6InNoYW94aWEifQ.JQ1Skj4dx6KxKcf1EJAOGxAs1RraybOnHdWmB6eZZSw");
		System.out.println(verify.getClaim("userId").asString());
	}


}
