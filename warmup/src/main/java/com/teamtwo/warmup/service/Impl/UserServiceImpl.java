package com.teamtwo.warmup.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.teamtwo.warmup.dto.ResponseCode;
import com.teamtwo.warmup.dto.ResultRespWithoutPayload;
import com.teamtwo.warmup.exception.AccountExistException;
import com.teamtwo.warmup.exception.AccountNotFoundException;
import com.teamtwo.warmup.exception.IncorrectPasswordException;
import com.teamtwo.warmup.mapper.UserMapper;
import com.teamtwo.warmup.dto.LoginDTO;
import com.teamtwo.warmup.dto.ResultResp;
import com.teamtwo.warmup.pojo.User;
import com.teamtwo.warmup.service.UserService;
import com.teamtwo.warmup.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author shaoxiawjc
 * @ 2024/1/28
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.service.Impl
 **/
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public ResultResp<LoginDTO> userLogin(String username, String password) {
		System.out.println(username+"  "+password);
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("username",username);
		User user = userMapper.selectOne(wrapper);
		try {
			// 判断是否有此账号
			if (user == null) {
				throw new AccountNotFoundException("账号不存在");
			}
			// 判断密码是否正确
			if (!user.getPassword().equals(password)){
				throw new IncorrectPasswordException("密码错误");
			}
			System.out.println();
			// 获取token
			Long userId = user.getId();
			String id = String.valueOf(userId);
			HashMap<String, String> payload = new HashMap<>();
			payload.put("userId",id);
			payload.put("username",username);
			String token = JWTUtils.getToken(payload);
			LoginDTO dto = new LoginDTO();
			dto.setToken(token);
			return new ResultResp<>(ResponseCode.SUCCESS,dto);
		}catch (AccountNotFoundException e){
			e.printStackTrace();
			return new ResultResp<>(ResponseCode.ACCOUNT_NOT_FOUND);
		}catch (IncorrectPasswordException e){
			e.printStackTrace();
			return new ResultResp<>(ResponseCode.INVALID_USERNAME_PASSWORD);
		}
	}

	@Override
	public ResultRespWithoutPayload userRegister(String username, String password) {

		try {
			User user1 = new User(username, password);
			userMapper.insert(user1);
			return new ResultRespWithoutPayload(ResponseCode.SUCCESS);
		}catch (DuplicateKeyException e){
			e.printStackTrace();
			return new ResultRespWithoutPayload(ResponseCode.ACCOUNT_EXIST);
		}catch (RuntimeException e){
			e.printStackTrace();
			return new ResultRespWithoutPayload(ResponseCode.SYSTEM_ERROR);
		}
	}
}
