package cn.edu.lingnan.shop.service;


import cn.edu.lingnan.shop.pojo.User;

public interface UserService {
	//用户注册
	public void register(User user);
	
	//用户登录
	public User login(User user);
}
