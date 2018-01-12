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
	<!--顶部信息start-->
	<div id="topnav">
		<div class="topwrap">
			<dl class="user-entry">
				<dt>您好，欢迎来到网上商城<a href=""></a></dt>
				<dd>[<a href="">登录</a>]</dd>
				<dd>[<a href="">注册</a>]</dd>
				<dd></dd>
			</dl>
			<ul class="quick-menu">
				<li class="user-center">
					<div class="menu">
						<a href="" class="menu-hd">我的商城</a>
						<div class="menu-bd">
							<ul>
								<li><a href="">已买到的商品</a></li>
								<li><a href="">我的空间</a></li>
								<li><a href="">我的好友</a></li>
							</ul>
						</div>
					</div>
				</li>
				<li class="cart">
					<div class="menu">
						<span class="menu-hd">购物车<strong>0</strong>种商品</span>
						<div class="menu-bd">
							<div class="no-order">
								<span>您的购物车中暂无商品，赶快选择心爱的商品吧！</span>
								<a href="" class="button">查看购物车</a>
							</div>
						</div>
					</div>
				</li>
				<li class="favorite">
					<div class="menu">
						<a href="" class="menu-hd">我的收藏</a>
						<div class="menu-bd">
							<ul>
								<li><a href="">收藏的商品</a></li>
								<li><a href="">收藏的店铺</a></li>
							</ul>
						</div>
					</div>
				</li>
				<li class="pm">
					<a href="">站内信</a>
				</li>
			</ul>
		</div>
	</div>

	<!--顶部信息end-->
	
	<div class="header wrap1000">
		<a href=""><img src="${pageContext.request.contextPath}/images/logo.png" alt="" /></a>
	</div>
	
	
	<div class="main">
		<div class="login-form fr">
			<div class="form-hd">
				<h3>用户登录</h3>
			</div>
			<div class="form-bd">
				<form action="login" method="post">
					<dl>
						<dt>用户名</dt>
						<dd><input type="text" name="loginUser.username" class="text" /></dd>
						
						<dt></dt>
						<dd>
							<span style="color:red; font-weight: bold; font-size: 18px">
           						<s:fielderror>
           							<s:param>loginUser.username</s:param>
           						</s:fielderror>
          					</span>
						</dd>
					</dl>
					<dl>
						<dt>密&nbsp;&nbsp;&nbsp;&nbsp;码</dt>
						<dd><input type="password" name="loginUser.password" class="text"/></dd>
					
						<dt></dt>
						<dd>
							<span style="color:red; font-weight: bold; font-size: 18px">
           						<s:fielderror>
           							<s:param>loginUser.password</s:param>
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
						<dd><input type="text" name="code" class="text" size="10" style="width:58px;"> 
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
						<a href="${pageContext.request.contextPath}/user/forgetPassword.jsp" class="forget">忘记密码?</a></dd>
					</dl>
				</form>
				<dl>
					<dt>&nbsp;</dt>
					<dd> 还不是本站会员？立即 <a href="${pageContext.request.contextPath}/user/register.jsp" class="register">注册</a></dd>
				</dl>
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
		<p>Copyright 2009-2018 itcast Inc.,All rights reserved.</p>
	</div>
	
	
</body>
</html>