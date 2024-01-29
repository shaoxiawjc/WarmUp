package com.teamtwo.warmup.service;

import com.teamtwo.warmup.dto.LoginDTO;
import com.teamtwo.warmup.dto.ResponseCode;
import com.teamtwo.warmup.dto.ResultResp;
import com.teamtwo.warmup.dto.ResultRespWithoutPayload;
import org.springframework.stereotype.Service;

/**
 * @author shaoxiawjc
 * @ 2024/1/28
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.service
 **/
@Service
public interface UserService {
	ResultResp<LoginDTO> userLogin(String username,String password);

	ResultRespWithoutPayload userRegister(String username, String password);
}
