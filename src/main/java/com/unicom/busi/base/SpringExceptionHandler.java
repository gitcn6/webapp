package com.unicom.busi.base;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class SpringExceptionHandler {
	
	@ResponseBody
	@ExceptionHandler({AuthorizationException.class,UnauthorizedException.class})
	public String handleException(HttpServletRequest request,Exception ex){
		ex.printStackTrace();
		return "权限不够";
	}
}
