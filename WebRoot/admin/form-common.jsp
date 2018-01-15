<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息管理</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/colorpicker.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/datepicker.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/uniform.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/select2.css" />		
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/unicorn.main.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/unicorn.grey.css" class="skin-color" />	
</head>
<body>
		
		
		<div id="header">
			<h1><a href="javascript:void(0)">网上商城管理员后台界面</a></h1>		
		</div>
		
		<div id="search">
			<input type="text" placeholder="Search here..." /><button type="submit" class="tip-right" title="Search"><i class="icon-search icon-white"></i></button>
		</div>
		<div id="user-nav" class="navbar navbar-inverse">
            <ul class="nav btn-group">
                <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-user"></i> <span class="text">Profile</span></a></li>
                <li class="btn btn-inverse dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important">5</span> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a class="sAdd" title="" href="javascript:void(0)">new message</a></li>
                        <li><a class="sInbox" title="" href="javascript:void(0)">inbox</a></li>
                        <li><a class="sOutbox" title="" href="javascript:void(0)">outbox</a></li>
                        <li><a class="sTrash" title="" href="javascript:void(0)">trash</a></li>
                    </ul>
                </li>
                <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">Settings</span></a></li>
                <li class="btn btn-inverse"><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
            </ul>
        </div>
            
		<div id="sidebar">
			<a href="#" class="visible-phone"><i class="icon icon-home"></i>网上商城管理员后台界面</a>
			<ul>
				<li class="active"><a href="javascript:void(0)"><i class="icon icon-home"></i> <span>网上商城管理员后台界面</span></a></li>
				<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>商品管理</span> <span class="label">3</span></a>
					<ul>
						<li><a href="javascript:void(0)">商品信息管理</a></li>
						<li><a href="javascript:void(0)">商品分类管理</a></li>
						<li><a href="javascript:void(0)">商品评论管理</a></li>
					</ul>
				</li>
				<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>用户管理</span> <span class="label">2</span></a>
					<ul>
						<li><a href="javascript:void(0)">用户信息管理</a></li>
						<li><a href="javascript:void(0)">申请卖家审核</a></li>
					</ul>
				</li>		
				<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>订单管理</span> <span class="label">3</span></a>
					<ul>
						<li><a href="javascript:void(0)">订单信息管理</a></li>
						<li><a href="javascript:void(0)">商品分类管理</a></li>
						<li><a href="javascript:void(0)">商品评论管理</a></li>
					</ul>
				</li>					
				<li><a href="javascript:void(0)"><i class="icon icon-th"></i> <span>Tables</span></a></li>
				<li>
					<a href="javascript:void(0)"><i class="icon icon-inbox"></i> <span>Widgets</span></a>
				</li>
			</ul>
		
		</div>
		
		<div id="style-switcher">
			<i class="icon-arrow-left icon-white"></i>
			<span>Style:</span>
			<a href="#grey" style="background-color: #555555;border-color: #aaaaaa;"></a>
			<a href="#blue" style="background-color: #2D2F57;"></a>
			<a href="#red" style="background-color: #673232;"></a>
		</div>
		<div id="content">
			<div id="content-header">
				<h1>管理用户信息</h1>
				<div class="btn-group">
					<a class="btn btn-large tip-bottom" title="Manage Files"><i class="icon-file"></i></a>
					<a class="btn btn-large tip-bottom" title="Manage Users"><i class="icon-user"></i></a>
					<a class="btn btn-large tip-bottom" title="Manage Comments"><i class="icon-comment"></i><span class="label label-important">5</span></a>
					<a class="btn btn-large tip-bottom" title="Manage Orders"><i class="icon-shopping-cart"></i></a>
				</div>
			</div>
			<div id="breadcrumb">
				<a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> 首页</a>
				<a href="#" class="tip-bottom">用户管理</a>
				<a href="#" class="current">管理用户信息</a>
			</div>
			
			<div class="widget-content nopadding">
								<table class="table table-bordered table-striped">
									<thead>
										<tr>
											<th>用户名</th>
											<th>email</th>
											<th>真实姓名</th>
											<th>性别</th>
											<th>注册时间</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>用户1</td>
											<td>111@qq.com</td>
											<td>王丽</td>
											<td>女</td>
											<td>2016-01-10 11:05:08</td>
										</tr>
										<tr>
											<td>用户2</td>
											<td>222@qq.com</td>
											<td>张三</td>
											<td>男</td>
											<td>2016-02-19 16:09:26</td>
										</tr>
										<tr>
											<td>用户3</td>
											<td>333@qq.com</td>
											<td>王五</td>
											<td>男</td>
											<td>2016-09-02 06:56:03</td>
										</tr>
										<tr>
											<td>用户4</td>
											<td>444@qq.com</td>
											<td>李司</td>
											<td>男</td>
											<td>2017-03-19 09:13:35</td>
										</tr>
										<tr>
											<td>用户5</td>
											<td>555@qq.com</td>
											<td>张微微</td>
											<td>女</td>
											<td>2017-08-25 18:20:58</td>
										</tr>
										<tr>
											<td>用户6</td>
											<td>666@qq.com</td>
											<td>林吉吉</td>
											<td>女</td>
											<td>2017-12-31 20:20:20</td>
										</tr>
									</tbody>
								</table>							
							</div>
						</div>
			
			
			
			<div class="row-fluid">
				<div id="footer" class="span12">
				2018 &copy; Unicorn Admin. Brought to you by <a href="https://wrapbootstrap.com/user/diablo9983">diablo9983</a>
				</div>
			</div>
		</div>
</body>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.ui.custom.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap-colorpicker.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.uniform.js"></script>
<script src="${pageContext.request.contextPath }/js/select2.min.js"></script>
<script src="${pageContext.request.contextPath }/js/unicorn.js"></script>
<script src="${pageContext.request.contextPath }/js/unicorn.form_common.js"></script>
</html>