package com.unicom.busi.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.unicom.busi.entity.SysUser;
import com.unicom.busi.service.UserService;

public class MyRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService us;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		String username = (String)principals.getPrimaryPrincipal();
		SysUser user = (SysUser)getSession().getAttribute("currentUser");
		System.out.println(user.getSalt());
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
		simpleAuthorInfo.addStringPermission("user:view1");
		return simpleAuthorInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
		String username = token.getUsername();
		SysUser user = us.getUserByName(username);
		
		AuthenticationInfo authInfo = null;
		if(user != null){
			authInfo = new SimpleAuthenticationInfo(user.getName(),user.getPassword(),ByteSource.Util.bytes(user.getSalt()),getName());
		}
		
		//将登陆用户保存到shiro提供的session中
		getSession().setAttribute("currentUser", user);
		
		return authInfo;
	}
	
	public static Session getSession(){
		return SecurityUtils.getSubject().getSession();
	}
}
