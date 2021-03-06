package com.unicom.busi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicom.busi.entity.Address;
import com.unicom.busi.entity.SysUser;
import com.unicom.busi.service.UserService;

@Controller
@RequestMapping("/init")
public class InitController {
	
	
	@Autowired
	private UserService us;
	
	@Value("${mail.address}")
	private String mailAddr;
	
	@RequestMapping(value="/test")
	public String testFrm(HttpServletRequest request,ModelMap model){
		model.put("addr", mailAddr);
		SysUser user = us.getUserById(2);
		model.put("user", user);
		return "test";
	}
	
	@RequestMapping(value="/json")
	@ResponseBody
	@SuppressWarnings("unchecked")
	public List testJson(){
		List addrs = new ArrayList();
		String str;
		addrs.add(new Address("山东","济宁","汶上"));
		addrs.add(new Address("山东","济南","历城区"));
		ObjectMapper om = new ObjectMapper();
		try {
			str = om.writeValueAsString(addrs);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return addrs;
	}
	
	@RequestMapping("/testJ2O")
	public String testJson2Obj(){
		
		System.out.println(Runtime.getRuntime().freeMemory());
		return "hello";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(@RequestParam String username,@RequestParam String password){
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//认证失败返回到登陆页面
			return "login";
		}
		return "main";
	}
	
	@RequestMapping("/findUserById")
	@ResponseBody
	@RequiresPermissions({"user:view"})
	public SysUser findUserById(@RequestParam Integer userId){
		SysUser user = us.getUserById(userId);
		return user;
	}
	
	@RequestMapping("/unauthorized")
	public String unauthorized(){

		return "unauthorized";
	}
	
	/*
	 * 登出
	 */
	@RequestMapping("/logout")
	public String logout(){
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.logout();
			System.out.println(subject.isAuthenticated());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main";
	}

	@GetMapping("/signin")
	public String index(){
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()){
			return "main";
		}else{
			return "login";
		}
	}
	
}
