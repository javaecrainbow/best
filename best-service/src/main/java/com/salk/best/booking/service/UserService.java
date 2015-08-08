package com.salk.best.booking.service;

import java.util.List;

import com.salk.best.domain.User;

public interface UserService {
	// 添加记录
	boolean addUser(User user);

	// 修改记录
	boolean editUser(User user);

	// 查找单条记录使用find
	User findUser(String id);

	// 删除记录
	boolean deleteUser(String ids);

	// 查找记录列表
	List<User> queryUsers(User user);

	// 获取数量
	long countUser(User user);

	User login(User user);
}
