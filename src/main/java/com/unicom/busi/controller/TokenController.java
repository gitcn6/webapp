package com.unicom.busi.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name="/token")
public class TokenController {
	
	/*
	 * 测试字体
	 */
	@RequestMapping(name="/hello")
	private String test(HttpServletRequest request,HttpServletResponse response){
		Cookie cookie = new Cookie("hello","world");
		return "";
	}
}
