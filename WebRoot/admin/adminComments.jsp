<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品评论信息</title>
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
                <li class="btn btn-inverse"><a title="" href="${pageContext.request.contextPath }/admin/logoutAction"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
            </ul>
        </div>
            
		<div id="sidebar">
			<a href="#" class="visible-phone"><i class="icon icon-home"></i>网上商城管理员后台界面</a>
			<ul>
				<li class="active"><a href="javascript:void(0)"><i class="icon icon-home"></i> <span>网上商城管理员后台界面</span></a></li>
				<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>商品管理</span> <span class="label">3</span></a>
					<ul>
						<li><a href="${pageContext.request.contextPath }/admin/loadsellproduct">商品信息管理</a></li>
						<li><a href="${pageContext.request.contextPath }/admin/loadCategory">商品分类管理</a></li>
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
				<h1>商品评论信息</h1>
				<div class="btn-group">
					<a class="btn btn-large tip-bottom" title="Manage Files"><i class="icon-file"></i></a>
					<a class="btn btn-large tip-bottom" title="Manage Users"><i class="icon-user"></i></a>
					<a class="btn btn-large tip-bottom" title="Manage Comments"><i class="icon-comment"></i><span class="label label-important">5</span></a>
					<a class="btn btn-large tip-bottom" title="Manage Orders"><i class="icon-shopping-cart"></i></a>
				</div>
			</div>
			<div id="breadcrumb">
				<a href="loadStatistic" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> 首页</a>
				<a href="#" class="tip-bottom">商品管理</a>
				<a href="#" class="current">商品评论管理</a>
			</div>
			
			<div class="widget-box">
							<div class="widget-title">
								<h5>商品评论管理</h5>								  
							</div>
							<div class="widget-content nopadding">
							
								<table class="table table-bordered data-table">
									<thead>
										<tr>
											<th>评论内容</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${commentsList}" var="comment" varStatus="statu">
											<tr class="gradeU">
												<input value="${comment.id}" id="commentid_${statu.index}" type="hidden" >
												<td><p id="comment_${statu.index}">${comment.content}</p></td>
												<td>
													<a href="javascript:void(0)" cid="${statu.index}" id="editcom">编辑</a>
													<a href="javascript:void(0)" id="agreeComment" cid="${statu.index}">通过</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>  
							</div>
						</div>
			<div class="row-fluid">
				<div id="footer" class="span12">
				2018 &copy; Unicorn Admin. Brought to you by <a href="javascript:void(0)">diablo9983</a>
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
<script src="${pageContext.request.contextPath }/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath }/js/unicorn.tables.js"></script>
<script type="text/javascript">
$(function(){
	$("#editcom").click(function(){
		var cid = $(this).attr("cid");
		cid = "comment_" + cid;
		var e_obj = $("#" + cid);
		var com = prompt("请修改内容",e_obj.text());
		e_obj.text(com);
	});
	$("#agreeComment").click(function(){
		var cid = $(this).attr("cid");
		var e_obj = $("#commentid_" + cid);
		var c_obj = $("#comment_" + cid);
		
		var id = e_obj.val();
		
		var uri = "agreeComments.action";
		var params = {
			id : id,
			content : c_obj.text()
		};
		$.getJSON(uri,params,function(){
			window.location.href = "";
		});
		
		 
		
	});
	
});
</script>
</html>