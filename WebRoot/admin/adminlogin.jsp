<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录页面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/unicorn.login.css" />
<style type="text/css">
	.actionMessage {
		color: red;
		padding: 0;
		margin: 0;
		text-align: center;
	}
	.actionMessage li {
		list-style-type: none;
	}
	.errorMessage {
		color: red;
		padding: 0;
		text-align: center;
	}
	.errorMessage li {
		list-style-type: none;
	}
	.btn1{
		margin-right: 20px;
	}

</style>
</head>

<body>
    <div id="logo">
        <img src="${pageContext.request.contextPath }/images/admin/logo.png" alt="" />
    </div>
    <div id="loginbox">            
        <form id="loginform" class="form-vertical" action="adminlogin" method="post" />
			<p>Enter username and password to continue.</p>
	            <div class="control-group">
	                <div class="controls">
	                    <div class="input-prepend">
	                        <span class="add-on"><i class="icon-user"></i></span>
	                        <input type="text" placeholder="Username" name="adminlogin.username" />
	                        <s:fielderror fieldName="username" />
	                    </div>
	                </div>
	            </div>
	            <div class="control-group">
	                <div class="controls">
	                    <div class="input-prepend">
	                        <span class="add-on"><i class="icon-lock"></i></span>
	                        <input type="password" placeholder="Password" name="adminlogin.password" />
	                    </div>
	                </div>
	            </div>
	            <s:fielderror fieldName="username" />
	            <s:fielderror fieldName="password" />
	            <s:actionmessage/>
	            <div class="form-actions">
	                <span class="pull-right"><input type="submit" class="btn btn-inverse btn1" value="Login" /></span>
	            </div>
    	</form>
</div>
    </body>
</html>