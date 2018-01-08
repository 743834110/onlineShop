package cn.edu.lingnan.shop.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lingnan.shop.dao.UserDao;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userdao;

	/**
	 * 用户注册
	 * @author yuan
	 * @param user
	 */
	@Override
	public void register(User user) {
		userdao.save(user);
	}

}
