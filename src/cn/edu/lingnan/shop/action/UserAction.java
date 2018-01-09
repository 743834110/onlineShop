package cn.edu.lingnan.shop.action;


import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.UserService;

public class UserAction extends BaseAction {
	
	@Autowired
	private UserService userService;

	private User registerUser;//注册用户
	private String repassword;//注册确认密码
	private String oldpassword;	//修改密码原密码
	private String newpassword;	//修改密码新密码
	private String reqnewpassword;	//确认修改新密码


	private User loginUser;		//用户登录传来的对象
	private String code;		//页面的验证码

	
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


	//修改密码方法
	public String updatepassword() {
		User user = (User) this.session.get("user");
		if (!user.getPassword().equals(oldpassword)) {
			super.addActionMessage("原密码不正确");
			return ERROR;
		}
		else {
			user.setPassword(newpassword);
			userService.updateUser(user);
			return SUCCESS;
		}
	}
	
	//修改密码验证器
	public void validateUpdatepassword() {
		if(oldpassword==null || oldpassword.trim().equals(""))
			super.addFieldError("oldpassword", "原密码不能为空");
		System.out.println("ol");
		if (newpassword==null || newpassword.trim().equals(""))
			super.addFieldError("newpassword", "新密码不能为空");
		if (reqnewpassword==null || reqnewpassword.trim().equals(""))
			super.addFieldError("reqpassword", "确认密码不能为空");
		else if( !reqnewpassword.equals(newpassword) )
			super.addFieldError("reqpassword", "密码和确认密码不一致");
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

	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getReqnewpassword() {
		return reqnewpassword;
	}
	public void setReqnewpassword(String reqnewpassword) {
		this.reqnewpassword = reqnewpassword;
	}

	
}
