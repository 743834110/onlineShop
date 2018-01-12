<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login-register.css" />
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
 <body>
	<div class="header wrap1000">
		<a href=""><img src="${pageContext.request.contextPath}/images/logo.png" alt="" /></a>
	</div>
	
	
	<div class="main">
		<div class="login-form fr">
			<div class="form-hd">
				<h3>管理员登录</h3>
			</div>
			<div class="form-bd">
				<form action="admin/adminlogin" method="post">
					<dl>
						<dt>用户名</dt>
						<dd><input type="text" name="admin.username" class="text" /></dd>
						
						<dt></dt>
						<dd>
							<span style="color:red; font-weight: bold; font-size: 18px">
           						<s:fielderror>
           							<s:param>admin.username</s:param>
           						</s:fielderror>
          					</span>
						</dd>
					</dl>
					<dl>
						<dt>密&nbsp;&nbsp;&nbsp;&nbsp;码</dt>
						<dd><input type="password" name="admin.password" class="text"/></dd>
					
						<dt></dt>
						<dd>
							<span style="color:red; font-weight: bold; font-size: 18px">
           						<s:fielderror>
           							<s:param>admin.password</s:param>
           						</s:fielderror>
          					</span>
						</dd>
					
						<dt></dt>
						<dd>
							<span style="color:red; font-weight: bold; font-size: 18px">
           						<s:fielderror fieldName="userError"></s:fielderror>
          					</span>
						</dd>
					
					</dl>
						
					<dl>
						<dt>验证码</dt>
						<dd><input type="text" name="inputCode" class="text" size="10" style="width:58px;"> 
							<img id="validateCode1" src="${pageContext.request.contextPath}/example.jsp" alt="" align="absmiddle" style="position:relative;top:-2px;"/> 
							<a id="changeCode1" href="javascript:(0);" style="color: #999">看不清，换一张</a>
							
						</dd>
						<dt></dt>
						<dd>
							<span style="color:red; font-weight: bold; font-size: 18px">
           						<s:fielderror fieldName="code"></s:fielderror>
          					</span>
						</dd>
						
					</dl>
					
					<dl>
						<dt>&nbsp;</dt>
						<dd><input type="submit" value="登  录" class="submit"/> 
						<a href="" class="forget">忘记密码?</a></dd>
					</dl>
				</form>
				<!--  
				<dl>
					<dt>&nbsp;</dt>
					<dd> 还不是本站管理员？立即 <a href="${pageContext.request.contextPath}/user/register.jsp" class="register">注册</a></dd>
				</dl>
				-->
				
				<dl class="other">
					<dt>&nbsp;</dt>
					<dd>
						<p>您可以用合作伙伴账号登录：</p>
						<a href="" class="qq"></a>
						<a href="" class="sina"></a>
					</dd>
				</dl>
				
			</div>
			<div class="form-ft">
			
			</div>		
		</div>
		
		<div class="login-form-left fl">
			<img src="${pageContext.request.contextPath}/images/left.jpg" alt="" />
		</div>
	</div>
	
	<div class="footer clear wrap1000">
		<p> <a href="">首页</a> | <a href="">招聘英才</a> | <a href="">广告合作</a> | <a href="">关于网上商城</a> | <a href="">联系我们</a></p>
		<p>Copyright 2018-2050 itcast Inc.All rights reserved.</p>
	</div>
	
	
</body>
</html>