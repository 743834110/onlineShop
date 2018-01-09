package cn.edu.lingnan.shop.service.impl;

import java.util.List;

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

	/**
	 * 用户登录
	 * @author Tao
	 * @param user
	 */
	@Override
	public User login(User user) {
		List<User> list = userdao.find(user);
		if(list != null && list.size() > 0)
			return list.get(0);
		else return null;
	}



}
