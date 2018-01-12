<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<title>管理员页面</title>
		<meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fullcalendar.css" />	
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/unicorn.main.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/unicorn.grey.css" class="skin-color" />
	<script src="${pageContext.request.contextPath}/js/excanvas.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.ui.custom.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.flot.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.flot.resize.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.peity.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/fullcalendar.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/unicorn.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/unicorn.dashboard.js" type="text/javascript"></script>
		
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
	<body>
		
		
		<div id="header">
			<h1><a href="${pageContext.request.contextPath}/goods/index">Unicorn Admin</a></h1>		
		</div>
		
		<div id="sidebar">
			<a href="#" class="visible-phone"><i class="icon icon-home"></i> 商城后台管理</a>
			<ul>
				<li class="active"><a href="${pageContext.request.contextPath}/goods/index"><i class="icon icon-home"></i> <span>商城后台管理</span></a></li>
				<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>商品管理</span></a>
					<ul>
						<li><a href="${pageContext.request.contextPath}/goods/queryGoods">商品信息管理</a></li>
						<li><a href="${pageContext.request.contextPath}/goods/queryTypes">商品分类管理</a></li>
						<li><a href="${pageContext.request.contextPath}/goods/queryComments">商品评论管理</a></li>
						<li><a href="${pageContext.request.contextPath}/goods/queryReply">评论回复管理</a></li>
					</ul>
				</li>
				<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>用户管理</span></a>
					<ul>
						<li><a href="${pageContext.request.contextPath}/users/queryUsers">用户信息管理</a></li>
						<li><a href="${pageContext.request.contextPath}/users/queryFavorite">用户收藏管理</a></li>
						<li><a href="${pageContext.request.contextPath}/users/queryAddress">用户收货地址管理</a></li>
						<li><a href="${pageContext.request.contextPath}/users/queryBusinessmen">商家信息管理</a></li>
					</ul>
				</li>
				<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>订单管理</span> </a>
					<ul>
						<li><a href="${pageContext.request.contextPath}/lists/queryLists">订单信息管理</a></li>
					</ul>
				</li>
				<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>销售信息管理</span></a>
					<ul>
						<li><a href="${pageContext.request.contextPath}/lists/queryHistory">历史销售情况</a></li>
					</ul>
				</li>
			</ul>
		</div>		
		<div id="content">
			<div id="content-header">
				<h1>欢迎来到商城管理后台</h1>
				<div class="btn-group">
					<a href="${pageContext.request.contextPath}/goods/login" class="btn btn-large tip-bottom" title="注销登陆"><i class="icon-user"></i></a>
				</div>
			</div>
			<div id="breadcrumb">
				<a href="${pageContext.request.contextPath}/goods/index" title="主页" class="tip-bottom"><i class="icon-home"></i>主页</a>
			</div>
		</div>
		<div class="row-fluid">
			<div id="footer" class="span12">
				2018 &copy; 网上商城。 由 <a href="http://www.lingnan.edu.cn/">岭南师范学院</a>为您提供。
			</div>
		</div>
	</body>
</html>