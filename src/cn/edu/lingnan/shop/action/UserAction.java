package cn.edu.lingnan.shop.action;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.UserService;

public class UserAction extends BaseAction {
	
	@Autowired
	private UserService userService;
	
	private User registerUser;	//注册用户
	private String repassword;	//注册确认密码框数据
	
	/**
	 * 用户注册
	 * @author huang
	 */
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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	
	

}
