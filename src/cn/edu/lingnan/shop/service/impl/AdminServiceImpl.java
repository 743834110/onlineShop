package cn.edu.lingnan.shop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lingnan.shop.dao.UserDao;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	/***
	 * 管理员登录 刘瑜
	 */
	
	@Autowired //绑定
	private UserDao adminDao;
	
	@Autowired
	private UserDao userDao;
	

	@Override
	public User login(User admin) {
		List<User> list = this.adminDao.find(admin);
		if (list == null || list.size() == 0) 
			return null;
		return list.get(1);
	}
	
	//验证其是否是管理员
	public boolean isExistsUser(String username){
		User admin = new User();
		this.adminDao.find(admin);
		return false;
	}

}
