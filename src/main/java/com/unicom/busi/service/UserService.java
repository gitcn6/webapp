package com.unicom.busi.service;

import com.unicom.busi.entity.SysUser;

public interface UserService {

	SysUser getUserById(int id);

	void deleteById(int id);

	void save(SysUser user);

	SysUser update(SysUser user);

	SysUser getUserByName(String username);

}