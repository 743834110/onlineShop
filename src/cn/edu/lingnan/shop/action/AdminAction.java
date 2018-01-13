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
	
	
	private User adminlogin;//表单提交数据的对象
	
	/***
	 * 账号密码的验证
	 */
	public String login(){
		User loginAdmin = adminService.login(adminlogin);
		if (loginAdmin != null) {
			if (loginAdmin.getType()==null || loginAdmin.getType() != 3){
				super.addActionMessage("您不是管理员");
				return ERROR;
			}
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
		if (adminlogin.getUsername()!=null && adminlogin.getUsername().trim().equals(""))
			super.addFieldError("username", "The username is not allowed to be empty.");
		if (adminlogin.getPassword()!=null && adminlogin.getPassword().trim().equals(""))
			super.addFieldError("password", "The password is not allowed to be empty.");
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

	//getter and setter 
	public User getAdminlogin() {
		return adminlogin;
	}

	public void setAdminlogin(User adminlogin) {
		this.adminlogin = adminlogin;
	}
	
}
