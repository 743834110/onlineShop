package cn.edu.lingnan.shop.action;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.UserService;

public class UserAction extends BaseAction {
	
	@Autowired
	private UserService userService;
	
	private User registerUser;
	
	//用户注册
	public String register() {
		userService.register(registerUser);
		return SUCCESS;
	}

	
	//getter and setter
	public User getRegisterUser() {
		return registerUser;
	}

	public void setRegisterUser(User registerUser) {
		this.registerUser = registerUser;
	}
	
	

}
