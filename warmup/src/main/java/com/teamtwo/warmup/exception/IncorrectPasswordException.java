package com.teamtwo.warmup.exception;

/**
 * @author shaoxiawjc
 * @ 2024/1/28
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.exception
 **/
public class IncorrectPasswordException extends RuntimeException{
	public IncorrectPasswordException(String message) {
		super(message);
	}
}