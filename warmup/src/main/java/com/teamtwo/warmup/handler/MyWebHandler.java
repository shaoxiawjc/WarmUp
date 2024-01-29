package com.teamtwo.warmup.handler;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.teamtwo.warmup.exception.NoTokenException;
import com.teamtwo.warmup.utils.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author shaoxiawjc
 * @ 2024/1/28
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.handler
 **/
public class MyWebHandler implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response,
							 Object handler) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		// 获取请求头里的令牌
		String token = request.getHeader("token");
		try {
			if (token == "" || token == null){
				throw new NoTokenException("没token");
			}
			DecodedJWT verify = JWTUtils.verify(token);
			return true;
		}catch (NoTokenException e){
			e.printStackTrace();
			map.put("msg","缺乏token,请先登录,宝贝");
		} catch (SignatureVerificationException e){
			e.printStackTrace();
			map.put("msg","无效签名，你是不是改了token");
		}catch (AlgorithmMismatchException e){
			e.printStackTrace();
			map.put("msg","算法错误");
		}catch (TokenExpiredException e){
			e.printStackTrace();
			map.put("msg","14天的token过期了，请重新登录");
		}catch (Exception e){
			e.printStackTrace();
			map.put("msg","token异常或其他异常");
		}
		map.put("status",false);
		// 将map转化为json放到respond里
		String jsonString = JSON.toJSONString(map);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().println(jsonString);
		return false;
	}
}
