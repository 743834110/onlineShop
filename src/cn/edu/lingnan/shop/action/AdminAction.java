package cn.edu.lingnan.shop.action;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.UserService;

/**
 * 管理员action
 * 负责和管理员登陆有关的数据控制
 * @author 刘瑜
 *
 */

public class AdminAction extends BaseAction {
	
	@Autowired
	private UserService adminService;
	
	
	private User admin;//表单提交数据的对象
	private String inputCode;//验证码
	
	/***
	 * 账号密码的验证
	 */
	public String login(){
		System.out.println("asdasd");
		User loginAdmin = adminService.login(admin);
		
		if (loginAdmin != null) {
			//保存用户对象到session当中
			this.session.put("admin", loginAdmin);
			return SUCCESS;
		} else {//失效--->login.jsp，并提示
			super.addActionMessage("用户名或密码错误！");
			return ERROR;
		}
	}
	
	/***
	 * 管理员登录时的判断验证码是否正确
	 * @return
	 */
	public void validateLogin(){
		if (!this.session.get("numrand").equals(inputCode)) 
			this.addFieldError("inputCode", "验证码有误");
	}
	
	/***
	 * 注销管理员的登录,即管理员退出登录
	 * @return
	 */
	public String logout(){
		//this.session.put("admin", null);
		this.session.clear();
		return SUCCESS;
	}
	
	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public String getInputCode() {
		return inputCode;
	}

	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}
	
}
