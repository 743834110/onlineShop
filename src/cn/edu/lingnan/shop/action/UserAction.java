package cn.edu.lingnan.shop.action;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.UserService;

public class UserAction extends BaseAction {
	
	@Autowired
	private UserService userService;
	
	private User registerUser;
	
	//用户登录传来的对象
	private User loginUser;
	
	//用户登录的验证码
	private String code;
	
	//用户注册
	public String register() {
		userService.register(registerUser);
		return SUCCESS;
	}

	//用户登录
	public String login(){
		System.out.println(loginUser.getPassword());
		User user = userService.login(loginUser);
		if(user != null) {
			this.session.put("user", user);
			return SUCCESS;
		} else {
			super.addFieldError("userError", "用户名或密码不正确");
			return ERROR;
		}
	}
	
	public void validateLogin() {
		if(!code.equals(this.session.get("numrand"))){
			super.addFieldError("code","验证码不正确");
		}
	}
	
	
	//getter and setter
	public User getRegisterUser() {
		return registerUser;
	}

	public void setRegisterUser(User registerUser) {
		this.registerUser = registerUser;
	}


	public User getLoginUser() {
		return loginUser;
	}


	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	
	

}
