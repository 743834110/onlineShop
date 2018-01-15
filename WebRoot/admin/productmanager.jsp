<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap-responsive.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/colorpicker.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/datepicker.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/uniform.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/select2.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/unicorn.main.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/unicorn.grey.css"
	class="skin-color" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/fullcalendar.css" />
</head>
<body>


	<div id="header">
		<h1>
			<a href="javascript:void(0)">网上商城管理员后台界面</a>
		</h1>
	</div>

	<div id="search">
		<input type="text" placeholder="Search here..." />
		<button type="submit" class="tip-right" title="Search">
			<i class="icon-search icon-white"></i>
		</button>
	</div>
	<div id="user-nav" class="navbar navbar-inverse">
		<ul class="nav btn-group">
			<li class="btn btn-inverse"><a title="" href="#"><i
					class="icon icon-user"></i> <span class="text">Profile</span></a></li>
			<li class="btn btn-inverse dropdown" id="menu-messages"><a
				href="#" data-toggle="dropdown" data-target="#menu-messages"
				class="dropdown-toggle"><i class="icon icon-envelope"></i> <span
					class="text">Messages</span> <span class="label label-important">5</span>
					<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a class="sAdd" title="" href="javascript:void(0)">new
							message</a></li>
					<li><a class="sInbox" title="" href="javascript:void(0)">inbox</a></li>
					<li><a class="sOutbox" title="" href="javascript:void(0)">outbox</a></li>
					<li><a class="sTrash" title="" href="javascript:void(0)">trash</a></li>
				</ul></li>
			<li class="btn btn-inverse"><a title="" href="#"><i
					class="icon icon-cog"></i> <span class="text">Settings</span></a></li>
			<li class="btn btn-inverse"><a title=""
				href="${pageContext.request.contextPath }/admin/logoutAction"><i
					class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
		</ul>
	</div>

	<div id="sidebar">
		<a href="#" class="visible-phone"><i class="icon icon-home"></i>网上商城管理员后台界面</a>
		<ul>
			<li class="active"><a href="javascript:void(0)"><i
					class="icon icon-home"></i> <span>网上商城管理员后台界面</span></a></li>
			<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>商品管理</span> <span class="label">3</span></a>
					<ul>
						<li><a href="${pageContext.request.contextPath }/admin/loadsellproduct">商品信息管理</a></li>
						<li><a href="${pageContext.request.contextPath }/admin/adminCategory.jsp">商品分类管理</a></li>
						<li><a href="${pageContext.request.contextPath }/admin/loadComments">商品评论管理</a></li>
					</ul>
				</li>
				<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>用户管理</span> <span class="label">2</span></a>
					<ul>
						<li><a href="${pageContext.request.contextPath }/admin/loadcommonuser">用户信息管理</a></li>
						<li><a href="${pageContext.request.contextPath }/admin/loadauditseller">申请卖家审核</a></li>
					</ul>
				</li>
			<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
					<span>订单管理</span> <span class="label">3</span></a>
				<ul>
					<li><a href="javascript:void(0)">订单信息管理</a></li>
					<li><a href="javascript:void(0)">商品分类管理</a></li>
					<li><a href="javascript:void(0)">商品评论管理</a></li>
				</ul></li>
			<li><a href="javascript:void(0)"><i class="icon icon-th"></i>
					<span>Tables</span></a></li>
			<li><a href="javascript:void(0)"><i class="icon icon-inbox"></i>
					<span>Widgets</span></a></li>
		</ul>

	</div>

	<div id="style-switcher">
		<i class="icon-arrow-left icon-white"></i> <span>Style:</span> <a
			href="#grey" style="background-color: #555555;border-color: #aaaaaa;"></a>
		<a href="#blue" style="background-color: #2D2F57;"></a> <a href="#red"
			style="background-color: #673232;"></a>
	</div>
	<div id="content">
		<div id="content-header">
			<h1>管理用户信息</h1>
			<div class="btn-group">
				<a class="btn btn-large tip-bottom" title="Manage Files"><i
					class="icon-file"></i></a> <a class="btn btn-large tip-bottom"
					title="Manage Users"><i class="icon-user"></i></a> <a
					class="btn btn-large tip-bottom" title="Manage Comments"><i
					class="icon-comment"></i><span class="label label-important">5</span></a>
				<a class="btn btn-large tip-bottom" title="Manage Orders"><i
					class="icon-shopping-cart"></i></a>
			</div>
		</div>
		<div id="breadcrumb">
			<a href="index.html" title="Go to Home" class="tip-bottom"><i
				class="icon-home"></i> 首页</a> <a href="#" class="tip-bottom">用户管理</a> <a
				href="#" class="current">管理用户信息</a>
		</div>

		<div class="widget-box">
			<div class="widget-title">
				<button type="button" id="sell">上架的商品</button>
				<button type="button" id="nosell">下架的商品</button>
			</div>
			<div class="widget-content nopadding">
				<table class="table table-bordered data-table">
					<thead>
						<tr>
							<th>商品名称</th>
							<th>商品详情</th>
							<c:if test="${productflag == 2 }">
								<th>下架原因</th>
							</c:if>
							<th>商品价格</th>
							<th>当前库存</th>
							<th>累计售出</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="productList">
							<tr class="gradeU">
								<td><s:property value="name" /></td>
								<td><s:property value="detail" /></td>
								<s:if test="productflag == 2">
									<td><s:property value="downProducts.get(0).reason" /></td>
								</s:if>
								<td><s:property value="price" /></td>
								<td><s:property value="surplus" /></td>
								<td><s:property value="accumulate" /></td>
								<td><s:if test="offshelf == 0">
										<a href="javascript:void(0)"
											onclick="shelves(<s:property value="id"/>)">下架</a>
									</s:if> <s:if test="offshelf == 2">
										<a href="javascript:void(0)"
											onclick="upshelves(<s:property value="id"/>)">上架</a>
									</s:if></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
</body>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.ui.custom.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath }/js/bootstrap-colorpicker.js"></script>
<script
	src="${pageContext.request.contextPath }/js/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.uniform.js"></script>
<script src="${pageContext.request.contextPath }/js/select2.min.js"></script>
<script src="${pageContext.request.contextPath }/js/unicorn.js"></script>
<script
	src="${pageContext.request.contextPath }/js/unicorn.form_common.js"></script>
<script
	src="${pageContext.request.contextPath }/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath }/js/unicorn.tables.js"></script>
<script type="text/javascript">
	$(function() {
		$("#nosell").click(function() {
			window.location.href = "${pageContext.request.contextPath }/admin/loadnosellproduct";
		});
		$("#sell").click(function() {
			window.location.href = "${pageContext.request.contextPath }/admin/loadsellproduct";
		});
	})
</script>

<script type="text/javascript">
function shelves(id) {
	var reason = prompt("请输入删除原因", "");
	if (reason != null) {
		if (reason == "")
			alert("需要输入下架原因才能下架商品");
		else {
			var uri = "tonosellproduct.action";
			var params = {
				id : id,
				reason : reason
			}
			$.getJSON(uri, params, function(data) {
				if (data.success == "成功") {
					alert("下架成功");
					window.location.href = "";
				}
			});
		}
	}
}
	
function upshelves(id) {
	if (window.confirm("确定重新上架该商品吗？")) {
		var uri = "tosellproduct.action";
		var params = {
			id : id
		};
		$.getJSON(uri, params, function(data) {
			if (data.success == "成功") {
				alert("上架成功");
				window.location.href = "";
			}
		});
	}
}
</script>
</html>