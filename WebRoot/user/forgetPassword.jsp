<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找回密码</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login-register.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>



<script type="text/javascript">

	window.onload = function(){
		var message = "${requestScope.send}";
		if(message == "发送成功") {
			alert("密码找回成功，请留意邮箱。");
			window.location.href = "${pageContext.request.contextPath}/user/login.jsp";
		} else if(message == "发送失败"){
			alert("密码找回失败。");
		}
	}
	
	
</script>


</head>
<body>
	<div class="header wrap1000">
		<a href=""><img src="${pageContext.request.contextPath}/images/logo.png" alt="" /></a>
	</div>
	<div class="main">
		<div class="login-form fr">
			<div class="form-hd">
				<h3>找回密码</h3>
			</div>
			
			<div class="form-bd">
				<form action="${pageContext.request.contextPath}/user/emailSend" method="post">
					
				
					
					<dl>
						<dt>你的邮箱</dt>
						<dd>
							<input type="text" name="to" class="text"/>
						</dd>
						
						<dt></dt>
						<dd>
							<span style="color:red; font-weight: bold; font-size: 18px">
           						<s:fielderror>
           							<s:param>to</s:param>
           						</s:fielderror>
          					</span>
						</dd>
					</dl>
					
					
					
					<dl>
						<dt>身份证</dt>
						<dd>
							<input type="text" name="idcard" class="text"/>
						</dd>
						
						<dt></dt>
						<dd>
							<span style="color:red; font-weight: bold; font-size: 18px">
           						<s:fielderror>
           							<s:param>idcard</s:param>
           						</s:fielderror>
          					</span>
						</dd>
					</dl>
					
				
					<dl>
						<dt>&nbsp;</dt>
						<dd><input type="submit" value="马上找回" class="submit"/> <input type= "checkbox" checked="checked"/>阅读并同意<a href="" class="forget">服务协议</a></dd>
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
				<p>我已经注册过账号，立即 <a href="${pageContext.request.contextPath}/user/login.jsp" class="register">登录</a> </p>
			</div>
		</div>
	</div>
	
	<div class="footer clear wrap1000">
		<p> <a href="${pageContext.request.contextPath}/index.jsp">首页</a> | <a href="">招聘英才</a> | <a href="">广告合作</a> | <a href="">关于ShopCZ</a> | <a href="">联系我们</a></p>
		<p>Copyright 2004-2013 itcast Inc.,All rights reserved.</p>
	</div>
	
	
</body>
</html>