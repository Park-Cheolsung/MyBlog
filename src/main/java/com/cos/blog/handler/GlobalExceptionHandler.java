package com.cos.blog.handler;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice		//모든 Exception 이 발생하면 이 class로 들어온다.ㅣ
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e) {
		
		return "<h1>" + e.getMessage() + "</h1>";
	}
}
