package com.unicom.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroTest {
	
	private static final Logger log = LoggerFactory.getLogger(ShiroTest.class);
	
	public static void main(String[] args) {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager sm = factory.getInstance();
		SecurityUtils.setSecurityManager(sm);
		
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		session.setAttribute("hello", "world");
		String value = (String)session.getAttribute("hello");
		log.info(value);
		if(!subject.isAuthenticated()){
			UsernamePasswordToken token = new UsernamePasswordToken("root1", "123456");
			try {
				subject.login(token);
				
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.info("current user {}",subject.getPrincipal());
		boolean[] is = subject.hasRoles(Arrays.asList("admin","test","manager"));
		for(int i=0,length=is.length;i<length;i++){
			System.out.println(is[i]);
		}
		
		if(subject.isPermitted("user:view:*")){
			log.info("有权限");
		}else{
			log.info("没权限");
		}
		
		subject.logout();
		
	}
}
