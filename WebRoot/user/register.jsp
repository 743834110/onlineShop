<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login-register.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>

</head>
<body>
	<div class="header wrap1000">
		<a href=""><img src="images/logo.png" alt="" /></a>
	</div>
	<div class="main">
		<div class="login-form fr">
			<div class="form-hd">
				<h3>用户注册</h3>
			</div>
			
			<div class="form-bd">
				<form action="${pageContext.request.contextPath}/user/register" method="post">
					<dl>
						<dt>用户名</dt>
						<dd><input type="text" name="registerUser.username" class="text" /></dd>
					</dl>
					<dl>
						<dt>密码</dt>
						<dd><input type="password" name="registerUser.password" class="text"/></dd>
					</dl>
					<dl>
						<dt>确认密码</dt>
						<dd><input type="password" name="repwd" class="text"/></dd>
					</dl>
					<dl>
						<dt>真实姓名</dt>
						<dd><input type="text" name="registerUser.realname" class="text"/></dd>
					</dl>
					<dl>
						<dt>身份证</dt>
						<dd><input type="text" name="registerUser.idcard" class="text"/></dd>
					</dl>
					<dl>
						<dt>验证码</dt>
						<dd>
							<input type="text" name="code" class="text" size="10" style="width:58px;"> 
							<img id="validateCode" src="${pageContext.request.contextPath}/user/Number.jsp" alt="" align="absmiddle" style="position:relative;top:-2px;"/> 
							<a id="changeCode" href="javascript:(0);" style="color: #999">看不清，换一张</a>
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd><input type="submit" value="立即注册" class="submit"/> <input type= "checkbox" checked="checked"/>阅读并同意<a href="" class="forget">服务协议</a></dd>
					</dl>
				</form>
				
			</div>
			
			<div class="form-ft">
			
			</div>	
		</div>
		
		
		<div class="login-form-left fl">
			<dl class="func clearfix">
				<dt>注册之后您可以</dt>
				<dd class="ico05"><i></i>购买商品支付订单</dd>
				<dd class="ico01"><i></i>申请开店销售商品</dd>
				<dd class="ico03"><i></i>空间好友推送分享</dd>
				<dd class="ico02"><i></i>收藏商品关注店铺</dd>
				<dd class="ico06"><i></i>商品资讯服务评价</dd>
				<dd class="ico04"><i></i>安全交易诚信无忧</dd>
			</dl>
			
			<div class="if">
				<h2>如果您是本站用户</h2>
				<p>我已经注册过账号，立即 <a href="" class="register">登录</a> 或是 <a href="" class="findpwd">找回密码？</a></p>
			</div>
		</div>
	</div>
	
	<div class="footer clear wrap1000">
		<p> <a href="">首页</a> | <a href="">招聘英才</a> | <a href="">广告合作</a> | <a href="">关于ShopCZ</a> | <a href="">联系我们</a></p>
		<p>Copyright 2004-2013 itcast Inc.,All rights reserved.</p>
	</div>
	
	
</body>
</html>