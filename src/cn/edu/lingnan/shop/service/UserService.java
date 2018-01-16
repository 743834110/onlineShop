package cn.edu.lingnan.shop.service;


import java.util.List;

import cn.edu.lingnan.shop.pojo.CheckUser;
import cn.edu.lingnan.shop.pojo.User;

public interface UserService {
	//用户注册
	public void register(User user);
	
	//用户登录
	public User login(User user);
	
	//修改用户信息
	public int updateUser(User user);
	
	//根据id获取用户信息
	public User getUserById(long id);
	
	//根据身份证和邮箱查对象
	public User getUserByIdcardEmail(String idCard,String email);
	
	//保存申请卖家记录
	public void saveCheckUser(CheckUser checkUser);
	
	//检查有无申请卖家的记录
	public CheckUser findCheckUserByUserid(long id);

	//
	public Long getAllUserWithoutAdmin();

}
