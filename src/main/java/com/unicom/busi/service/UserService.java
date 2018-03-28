package com.unicom.busi.service;

import com.unicom.busi.entity.SysUser;

import java.util.List;

public interface UserService {

	SysUser getUserById(int id);

	void deleteById(int id);

	void save(SysUser user);

	SysUser update(SysUser user);

	SysUser getUserByName(String username);

	List<SysUser> getUsersByName(String username);

}