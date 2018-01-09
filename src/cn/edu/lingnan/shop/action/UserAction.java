package cn.edu.lingnan.shop.action;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.UserService;

public class UserAction extends BaseAction {
	
	@Autowired
	private UserService userService;
	
	private User registerUser;//注册用户
	private String repassword;//注册确认密码
	
	//用户登录传来的对象
	private User loginUser;
	

	
	//用户登录的验证码
	private String code;
	
	//用户注册
	public String register() {
		userService.register(registerUser);
		return SUCCESS;
	}
	
	//用户注册验证码验证
	public void validateRegister() {
		if(!code.equals(this.session.get("numrand"))){
			super.addFieldError("code","验证码不正确");
		}
	}

	//用户登录
	public String login(){
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
	
	//用户注销
	public String logout(){
		this.session.clear();
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