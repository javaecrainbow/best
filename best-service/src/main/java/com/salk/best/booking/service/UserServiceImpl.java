package com.salk.best.booking.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.salk.best.domain.User;
import com.salk.best.domain.UserExample;
import com.salk.best.domain.UserExample.Criteria;
import com.salk.best.product.dao.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean addUser(User user) {
		try {
			return userMapper.insert(user) > 0 ? true : false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public User findUser(String id) {
		Integer it_id = Integer.parseInt(id);
		try {
			return userMapper.selectByPrimaryKey(it_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteUser(String ids) {
		try {
			if (StringUtils.isBlank(ids)) {
				return false;
			}
			int size = ids.split(",").length;
			Integer[] it = new Integer[size];
			String[] str_ids = ids.split(",");
			for (int i = 0; i < str_ids.length; i++) {
				it[i] = Integer.parseInt(str_ids[i]);
			}
			return userMapper.deleteByPrimaryKeys(it) > 0 ? true : false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean editUser(User user) {
		try {
			return userMapper.updateByPrimaryKey(user) > 0 ? true : false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}

	}

	@Override
	public List<User> queryUsers(User user) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		if (StringUtils.isNotBlank(user.getUsername())) {
			createCriteria.andUsernameLike(user.getUsername());
		}
		if (StringUtils.isNotBlank(user.getRole())) {
			createCriteria.andRoleEqualTo(user.getRole());
		}
		List<User> selectByExample = userMapper.selectByExample(example);

		return selectByExample;
	}

	@Override
	public long countUser(User user) {
		UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		if (StringUtils.isNotBlank(user.getUsername())) {
			createCriteria.andUsernameLike(user.getUsername());
		}
		if (StringUtils.isNotBlank(user.getRole())) {
			createCriteria.andRoleEqualTo(user.getRole());
		}

		return userMapper.countByExample(example);
	}

	@Override
	public User login(User user) {
		UserExample userExample = getUserExample(user);
		List<User> selectByExample = userMapper.selectByExample(userExample);
		if (CollectionUtils.isEmpty(selectByExample)) {
			return null;
		}
		return selectByExample.get(0);
	}

	private UserExample getUserExample(User u) {
		UserExample example = new UserExample();
		com.salk.best.domain.UserExample.Criteria createCriteria = example
				.createCriteria();
		if (StringUtils.isNotBlank(u.getUsername())) {
			createCriteria.andUsernameEqualTo(u.getUsername());
		}
		if (StringUtils.isNotBlank(u.getPassword())) {
			createCriteria.andPasswordEqualTo(u.getPassword());
		}
		if (StringUtils.isNotBlank(u.getRole())) {
			createCriteria.andRoleEqualTo(u.getRole());
		}
		return example;
	}
}
