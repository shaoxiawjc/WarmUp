package com.teamtwo.warmup.controller;

import com.teamtwo.warmup.dto.LoginDTO;
import com.teamtwo.warmup.dto.ResponseCode;
import com.teamtwo.warmup.dto.ResultResp;
import com.teamtwo.warmup.dto.ResultRespWithoutPayload;
import com.teamtwo.warmup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author shaoxiawjc
 * @ 2024/1/28
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.controller
 **/
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@CrossOrigin
	@PostMapping("/user/login")
	public ResponseEntity<ResultResp<LoginDTO>> userLogin(@RequestParam("username") String username,
									@RequestParam("password") String password){

		ResultResp<LoginDTO> loginDTOResultResp = userService.userLogin(username, password);
		return ResponseEntity.ok(loginDTOResultResp);
	}
	@CrossOrigin
	@PostMapping("/user/register")
	public ResponseEntity<ResultRespWithoutPayload> userRegister(@RequestParam("username") String username,
																 @RequestParam("password") String password){
		ResultRespWithoutPayload result = userService.userRegister(username, password);
		return ResponseEntity.ok(result);
	}
}
