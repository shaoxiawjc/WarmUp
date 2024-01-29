package com.teamtwo.warmup.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author shaoxiawjc
 * @ 2024/1/28
 * @ IntelliJ IDEA
 * @ warmup
 * @ com.teamtwo.warmup.utils
 **/
public class TimeChangeUtil {
	public static Date change(String time){
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime t = LocalDateTime.parse(time, dateTimeFormatter);
		return Date.from(t.atZone(ZoneId.systemDefault()).toInstant());
	}
}
