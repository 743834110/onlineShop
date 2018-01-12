package cn.edu.lingnan.shop.service;

import cn.edu.lingnan.shop.pojo.User;

public interface AdminService {
	
	/***
	 * 管理员登录
	 * @param yu
	 * @return
	 */
	
	public User login(User admin);
	
	
}
