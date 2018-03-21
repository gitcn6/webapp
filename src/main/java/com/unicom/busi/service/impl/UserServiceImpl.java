package com.unicom.busi.service.impl;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.unicom.busi.dao.mapper.SysUserMapper;
import com.unicom.busi.entity.SysUser;
import com.unicom.busi.service.UserService;

@Service
//@CacheConfig(cacheNames="userCache")
public class UserServiceImpl implements UserService{

	@Autowired
	private SysUserMapper um;

	/* (non-Javadoc)
	 * @see com.unicom.busi.service.impl.UserService#getUserById(int)
	 */
	@Override
//	@Cacheable(key="#id")
	public SysUser getUserById(int id) {
		System.out.println("query from db...");
		SysUser user = um.selectByPrimaryKey(id);
		return user;
	}
	
	/* (non-Javadoc)
	 * @see com.unicom.busi.service.impl.UserService#deleteById(int)
	 */
	@Override
//	@CacheEvict(value="userCache",key="#id")
	public void deleteById(int id){
		um.deleteByPrimaryKey(id);
	}
	
	/* (non-Javadoc)
	 * @see com.unicom.busi.service.impl.UserService#save(com.unicom.busi.entity.SysUser)
	 */
	@Override
	public void save(SysUser user){
		RandomNumberGenerator random = new SecureRandomNumberGenerator();
		String salt = random.nextBytes().toHex();
		String saltPwd = new SimpleHash("md5", user.getPassword(), salt, 2).toHex();
		user.setPassword(saltPwd);
		user.setSalt(salt);
		um.insert(user);
	}
	
	/* (non-Javadoc)
	 * @see com.unicom.busi.service.impl.UserService#update(com.unicom.busi.entity.SysUser)
	 */
	@Override
//	@CachePut(value="userCache",key="#user.getId()")
	public SysUser update(SysUser user){
		um.updateByPrimaryKey(user);
		return um.selectByPrimaryKey(user.getId());
	}
	
	/* (non-Javadoc)
	 * @see com.unicom.busi.service.impl.UserService#getUserByName(java.lang.String)
	 */
	@Override
	public SysUser getUserByName(String username){
		SysUser user = um.getUserByName(username);
		return user;
	}
	

}
