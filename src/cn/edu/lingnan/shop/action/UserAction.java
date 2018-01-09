package cn.edu.lingnan.shop.action;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
	
	private User updateUSer;  //用户资料修改传来的对象
	
	private String sex; 	 //用户修改传来的性别
	private String realName; //用户修改传来的真实姓名
	
	private String to;    //传送的对象
	private static String email = "975023517@qq.com";     //第三方邮箱
	private static String password = "euvqaxmppdwkbdej";  //邮箱密码
	public static final String subject = "找回密码";
	private String body;                                  //发送的内容
	private String idcard;
	
	
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

	//用户资料修改
	public String updateUser(){
		updateUSer = (User) this.session.get("user");
		updateUSer.setRealname(realName);
		updateUSer.setSex(sex);
		userService.updateUser(updateUSer);
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
	
	static Properties properties = new Properties();
	static
	   {
	      properties.put("mail.smtp.host", "smtp.qq.com");
	      properties.put("mail.smtp.socketFactory.port", "465");
	      properties.put("mail.smtp.socketFactory.class",
	                     "javax.net.ssl.SSLSocketFactory");
	      properties.put("mail.smtp.auth", "true");
	      properties.put("mail.smtp.port", "465");
	   }
	
	//发送邮件
	public String emailSend(){
		String ret = SUCCESS;
		
	      try
	      {
	         Session session = Session.getDefaultInstance(properties,  
	            new javax.mail.Authenticator() {
	            protected PasswordAuthentication 
	            getPasswordAuthentication() {
	            return new 
	            PasswordAuthentication(email, password);
	            }});

	         Message message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(email));
	         message.setRecipients(Message.RecipientType.TO, 
	            InternetAddress.parse(to));
	         message.setSubject(subject);
	         message.setText(body);
	         Transport.send(message);
	      }
	      catch(Exception e)
	      {
	         ret = ERROR;
	         e.printStackTrace();
	      }
	      return ret;
	}
	
	//修改密码验证器
	public void validateUpdatepassword() {
		if(oldpassword==null || oldpassword.trim().equals(""))
			super.addFieldError("oldpassword", "原密码不能为空");
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

	public User getUpdateUSer() {
		return updateUSer;
	}

	public void setUpdateUSer(User updateUSer) {
		this.updateUSer = updateUSer;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}


	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public static Properties getProperties() {
		return properties;
	}

	public static void setProperties(Properties properties) {
		UserAction.properties = properties;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	
	
}
