<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/shop_gouwuche.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop_common.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop_header.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop_manager.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop_shdz_835.css" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/topNav.js" ></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/productSearch.css" type="text/css" />
<style type="text/css">
.empty_cart {
    width: 823px;
   }
</style>
<script type="text/javascript">
	function check() {
		var name = document.getElementById("username");
		if (trim(name.value)==null || trim(name.value)=="") {
			alert("收货人姓名不能为空");
			return false;
		}
		var extra = document.getElementById("extra");
		if (trim(extra.value)==null || trim(extra.value)=="") {
			alert("详细地址不能为空");
			return false;
		}
		var tel = document.getElementById("telephone");
		if (trim(tel.value)==null || trim(tel.value)=="") {
			alert("联系电话不能为空");
			return false;
		}
		return true;
	}
	
	function trim(str) {
		return str.replace(/(^\s*)|(\s*$)/g, "");
	}
	
	function deleteAuction(aucitonId) {
		if(window.confirm("确认要删除该收货地址吗？")){
			window.location = "${pageContext.request.contextPath}/user/deleteaddress?addressid="+aucitonId;
		}
}
</script>
<script type="text/javascript">
	jQuery(function(){
		jQuery("#new_add_shdz_btn").toggle(function(){
			jQuery("#new_add_shdz_contents").show(500);
		},function(){
			jQuery("#new_add_shdz_contents").hide(500);
		});
	});
	</script>
<title>管理收货地址</title>
</head>
<body>
	<!-- Header  -wll-2013/03/24 -->
	<div class="shop_hd">
		<!-- Header TopNav -->
		<div class="shop_hd_topNav">
			<div class="shop_hd_topNav_all">
				<!-- Header TopNav Left -->
			
			<s:if test="#session.user != null">
				<div class="shop_hd_topNav_all_left">
					<p><s:property value = "#session.user.username"/>，您好，欢迎来到<b><a href="/">ShopCZ商城</a></b>[<a href="logout">注销</a>]</p>
				</div>
			</s:if>
			

			<s:if test="#session.user == null">
				<div class="shop_hd_topNav_all_left">
					<p>您好，欢迎来到<b><a href="/">ShopCZ商城</a></b>[<a href="${pageContext.request.contextPath}/user/login.jsp">登录</a>][<a href="">注册</a>]</p>
				</div>
			</s:if>
				<!-- Header TopNav Left End -->

				<!-- Header TopNav Right -->
				<div class="shop_hd_topNav_all_right">
					<ul class="topNav_quick_menu">

						<li>
							<div class="topNav_menu">
								<a href="${pageContext.request.contextPath}/index.jsp" class="topNavHover">我的商城<i></i></a>
								<div class="topNav_menu_bd" style="display:none;" >
						            <ul>
						              <li><a title="已买到的商品" target="_top" href="${pageContext.request.contextPath}/toBuy">已买到的商品</a></li>
						              <li><a title="个人主页" target="_top" href="${pageContext.request.contextPath}/toOrder">个人主页</a></li>
						            </ul>
						        </div>
							</div>
						</li>
                                                <li>
							<div class="topNav_menu">
								<a href="${pageContext.request.contextPath}/toOrder" class="topNavHover">卖家中心<i></i></a>
								<div class="topNav_menu_bd" style="display:none;">
						            <ul>
						              <li><a title="已售出的商品" target="_top" href="${pageContext.request.contextPath}/toOrder">已售出的商品</a></li>
						              <li><a title="销售中的商品" target="_top" href="${pageContext.request.contextPath}/toOrder">销售中的商品</a></li>
						            </ul>
						        </div>
							</div>
						</li>

						<li>
							<div class="topNav_menu">
								<a href="${pageContext.request.contextPath}/user/tocart" class="topNavHover">购物车<i></i></a>
								<div class="topNav_menu_bd" style="display:none;">
									<!--
						            <ul>
						              <li><a title="已售出的商品" target="_top" href="#">已售出的商品</a></li>
						              <li><a title="销售中的商品" target="_top" href="#">销售中的商品</a></li>
						            </ul>
						        	-->
						            <p>还没有商品，赶快去挑选！</p>
						        </div>
							</div>
						</li>


					</ul>
				</div>
				<!-- Header TopNav Right End -->
			</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
		<!-- Header TopNav End -->

		<!-- TopHeader Center -->
		<div class="shop_hd_header">
			<div class="shop_hd_header_logo"><h1 class="logo"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/images/logo.png" alt="ShopCZ" /></a><span>ShopCZ</span></h1></div>
			<div class="shop_hd_header_search">
                            <ul class="shop_hd_header_search_tab">
			        <li id="search" class="current">商品</li>
			        <li id="shop_search">店铺</li>
			    </ul>
                            <div class="clear"></div>
			    <div class="search_form">
			    	<form method="post" action="listProduct">
			    		<div class="search_formstyle" style="position: relative;">
			    			<input type="text" class="search_form_text" autocomplete = "off" id="gover_search_key" name="keyword" placeHolder ="请输入要搜索的商品" />
			    			<input type="submit" class="search_form_sub" name="secrch_submit" value="" title="搜索" />

			    		</div>
			    	</form>
			    </div>
                            <div class="clear">
                      
                            </div>
                   <div class="search_suggest" id="gov_search_suggest">
                   		<ul></ul>
   				</div>
			    <div class="search_tag">
			    	<a href="javascript:void(0)">李宁</a>
			    	<a href="javascript:void(0)">耐克</a>
			    	<a href="javascript:void(0)">Kappa</a>
			    	<a href="javascript:void(0)">双肩包</a>
			    	<a href="javascript:void(0)">手提包</a>
			    </div>

			</div>
		</div>
		<div class="clear"></div>
		<!-- TopHeader Center End -->

		<!-- Header Menu -->
		<div class="shop_hd_menu">
			<!-- 所有商品菜单 -->
                        
			<div id="shop_hd_menu_all_category" class="shop_hd_menu_all_category"><!-- 首页去掉 id="shop_hd_menu_all_category" 加上clsss shop_hd_menu_hover -->
				<div class="shop_hd_menu_all_category_title"><h2 title="所有商品分类"><a href="javascript:void(0);">所有商品分类</a></h2><i></i></div>
				<div id="shop_hd_menu_all_category_hd" class="shop_hd_menu_all_category_hd">
					<ul class="shop_hd_menu_all_category_hd_menu clearfix">
						<!-- 单个菜单项 -->
						<li id="cat_1" class="">
							<h3><a href="" title="男女服装">男女服装</a></h3>
							<div id="cat_1_menu" class="cat_menu clearfix" style="">
								<dl class="clearfix">
									<dt><a href="女装" href="">女装</a></dt>
									<dd>
										<a href="">风衣</a>
										<a href="">长袖连衣裙</a>
										<a href="">毛呢连衣裙</a>
										<a href="">半身裙</a>
										<a href="">小脚裤</a>
										<a href="">加绒打底裤</a>
										<a href="">牛仔裤</a>
										<a href="">打底衫</a>
										<a href="">情侣装</a>
										<a href="">棉衣</a>
										<a href="">毛呢大衣</a>
                                        <a href="">毛呢短裤</a>
									</dd>
								</dl>
							</div>
						</li>
						<!-- 单个菜单项 End -->
						<li id="cat_2" class="">
							<h3><a href="" title="鞋包配饰">鞋包配饰</a></h3>
							<div id="cat_1_menu" class="cat_menu clearfix" style="">
								<dl class="clearfix">
									<dt><a href="鞋子" href="">鞋子</a></dt>
									<dd>
										<a href="">风衣</a>
										<a href="">长袖连衣裙</a>
										<a href="">毛呢连衣裙</a>
										<a href="">半身裙</a>
										<a href="">小脚裤</a>
										<a href="">加绒打底裤</a>
										<a href="">牛仔裤</a>
										<a href="">打底衫</a>
										<a href="">情侣装</a>
										<a href="">棉衣</a>
										<a href="">毛呢大衣</a>
                                        <a href="">毛呢短裤</a>
									</dd>
								</dl>					
                            </div>
                         </li> 
                         <!-- 单个菜单项 -->
						<li id="cat_1" class="">
							<h3><a href="" title="男女服装">男女服装</a></h3>
							<div id="cat_1_menu" class="cat_menu clearfix" style="">
								<dl class="clearfix">
									<dt><a href="女装" href="">女装</a></dt>
									<dd>
										<a href="">风衣</a>
										<a href="">长袖连衣裙</a>
										<a href="">毛呢连衣裙</a>
										<a href="">半身裙</a>
										<a href="">小脚裤</a>
										<a href="">加绒打底裤</a>
										<a href="">牛仔裤</a>
										<a href="">打底衫</a>
										<a href="">情侣装</a>
										<a href="">棉衣</a>
										<a href="">毛呢大衣</a>
                                        <a href="">毛呢短裤</a>
									</dd>
								</dl>
							</div>
						</li>
						<!-- 单个菜单项 End -->
						<li id="cat_2" class="">
							<h3><a href="" title="鞋包配饰">鞋包配饰</a></h3>
							<div id="cat_1_menu" class="cat_menu clearfix" style="">
								<dl class="clearfix">
									<dt><a href="鞋子" href="">鞋子</a></dt>
									<dd>
										<a href="">风衣</a>
										<a href="">长袖连衣裙</a>
										<a href="">毛呢连衣裙</a>
										<a href="">半身裙</a>
										<a href="">小脚裤</a>
										<a href="">加绒打底裤</a>
										<a href="">牛仔裤</a>
										<a href="">打底衫</a>
										<a href="">情侣装</a>
										<a href="">棉衣</a>
										<a href="">毛呢大衣</a>
                                        <a href="">毛呢短裤</a>
									</dd>
								</dl>					
                            </div>
                         </li>  
                         <!-- 单个菜单项 -->
						<li id="cat_1" class="">
							<h3><a href="" title="男女服装">男女服装</a></h3>
							<div id="cat_1_menu" class="cat_menu clearfix" style="">
								<dl class="clearfix">
									<dt><a href="女装" href="">女装</a></dt>
									<dd>
										<a href="">风衣</a>
										<a href="">长袖连衣裙</a>
										<a href="">毛呢连衣裙</a>
										<a href="">半身裙</a>
										<a href="">小脚裤</a>
										<a href="">加绒打底裤</a>
										<a href="">牛仔裤</a>
										<a href="">打底衫</a>
										<a href="">情侣装</a>
										<a href="">棉衣</a>
										<a href="">毛呢大衣</a>
                                        <a href="">毛呢短裤</a>
									</dd>
								</dl>
							</div>
						</li>
						<!-- 单个菜单项 End -->
						<li id="cat_2" class="">
							<h3><a href="" title="鞋包配饰">鞋包配饰</a></h3>
							<div id="cat_1_menu" class="cat_menu clearfix" style="">
								<dl class="clearfix">
									<dt><a href="鞋子" href="">鞋子</a></dt>
									<dd>
										<a href="">风衣</a>
										<a href="">长袖连衣裙</a>
										<a href="">毛呢连衣裙</a>
										<a href="">半身裙</a>
										<a href="">小脚裤</a>
										<a href="">加绒打底裤</a>
										<a href="">牛仔裤</a>
										<a href="">打底衫</a>
										<a href="">情侣装</a>
										<a href="">棉衣</a>
										<a href="">毛呢大衣</a>
                                        <a href="">毛呢短裤</a>
									</dd>
								</dl>					
                            </div>
                         </li>  
                         <!-- 单个菜单项 -->
						<li id="cat_1" class="">
							<h3><a href="" title="男女服装">男女服装</a></h3>
							<div id="cat_1_menu" class="cat_menu clearfix" style="">
								<dl class="clearfix">
									<dt><a href="女装" href="">女装</a></dt>
									<dd>
										<a href="">风衣</a>
										<a href="">长袖连衣裙</a>
										<a href="">毛呢连衣裙</a>
										<a href="">半身裙</a>
										<a href="">小脚裤</a>
										<a href="">加绒打底裤</a>
										<a href="">牛仔裤</a>
										<a href="">打底衫</a>
										<a href="">情侣装</a>
										<a href="">棉衣</a>
										<a href="">毛呢大衣</a>
                                        <a href="">毛呢短裤</a>
									</dd>
								</dl>
							</div>
						</li>
						<!-- 单个菜单项 End -->
						<li id="cat_2" class="">
							<h3><a href="" title="鞋包配饰">鞋包配饰</a></h3>
							<div id="cat_1_menu" class="cat_menu clearfix" style="">
								<dl class="clearfix">
									<dt><a href="鞋子" href="">鞋子</a></dt>
									<dd>
										<a href="">风衣</a>
										<a href="">长袖连衣裙</a>
										<a href="">毛呢连衣裙</a>
										<a href="">半身裙</a>
										<a href="">小脚裤</a>
										<a href="">加绒打底裤</a>
										<a href="">牛仔裤</a>
										<a href="">打底衫</a>
										<a href="">情侣装</a>
										<a href="">棉衣</a>
										<a href="">毛呢大衣</a>
                                        <a href="">毛呢短裤</a>
									</dd>
								</dl>					
                            </div>
                         </li>                                      
                         <li class="more"><a href="">查看更多分类</a></li>
					</ul>
				</div>
			</div>
			<!-- 所有商品菜单 END -->

			<!-- 普通导航菜单 -->
			<ul class="shop_hd_menu_nav">
				<li class="current_link"><a href=""><span>首页</span></a></li>
				<li class="link"><a href=""><span>团购</span></a></li>
				<li class="link"><a href=""><span>品牌</span></a></li>
				<li class="link"><a href=""><span>优惠卷</span></a></li>
				<li class="link"><a href=""><span>积分中心</span></a></li>
				<li class="link"><a href=""><span>运动专场</span></a></li>
				<li class="link"><a href=""><span>微商城</span></a></li>
			</ul>
			<!-- 普通导航菜单 End -->
		</div>
		<!-- Header Menu End -->

	</div>
	<div class="clear"></div>
	<!-- 面包屑 注意首页没有 -->
	<div class="shop_hd_breadcrumb">
		<strong>当前位置：</strong>
		<span>
			<a href="${pageContext.request.contextPath}/index.jsp">首页</a>&nbsp;›&nbsp;
			<a href="${pageContext.request.contextPath}/toOrder">个人中心</a>&nbsp;›&nbsp;
			<a href="${pageContext.request.contextPath}/toaddress">管理收货地址</a>
		</span>
	</div>
	<div class="clear"></div>
	<!-- 面包屑 End -->

	<!-- Header End -->	

	<!-- 我的个人中心 -->
	<div class="shop_member_bd clearfix">
		<!-- 左边导航 -->
		<div class="shop_member_bd_left clearfix">
			
			<div class="shop_member_bd_left_pic">
				<a href="javascript:void(0);"><img src="${pageContext.request.contextPath}/images/avatar.png" /></a>
			</div>
			<div class="clear"></div>

			<dl>
				<dt>我的交易</dt>
				<dd><span><a href="${pageContext.request.contextPath}/toBuy">已购买商品</a></span></dd>
				<dd><span><a href="${pageContext.request.contextPath}/toComments">评价管理</a></span></dd>
			</dl>

			<dl>
				<dt>我的账户</dt>
				<dd><span><a href="${pageContext.request.contextPath}/user/member_inf.jsp">个人资料</a></span></dd>
				<dd><span><a href="${pageContext.request.contextPath}/user/updatepassword.jsp">密码修改</a></span></dd>
				<dd><span><a href="${pageContext.request.contextPath}/user/toaddress">收货地址</a></span></dd>
				<s:if test="#session.user.type != 2">
				<dd><span><a href="${pageContext.request.contextPath}/user/applyseller.jsp" id="applySeller">申请卖家</a></span></dd>
				</s:if>
			</dl>
			
			<s:if test="#session.user.type == 2">
				<dl>
					<dt>商品管理</dt>
					<dd><span><a href="${pageContext.request.contextPath}/toAdd">添加商品</a></span></dd>
					<dd><span><a href="${pageContext.request.contextPath}/loadOnSellProduct">编辑商品</a></span></dd>
				</dl>
				<dl>
					<dt>订单管理</dt>
					<dd><span><a href="${pageContext.request.contextPath}/toUserOrder">编辑订单</a></span></dd>
				</dl>
			</s:if>

		</div>
		<!-- 左边导航 End -->
		
		<!-- 右边购物列表 -->
		<div class="shop_member_bd_right clearfix">
			
			<div class="shop_meber_bd_good_lists clearfix">
				<div class="title"><h3>管理收货地址<a style="float:right;" href="javasrcipt:void(0);" id="new_add_shdz_btn">新增收货地址</a></h3></div>
				<div class="clear"></div>
			<!-- 收货人地址 Title End -->
			<div class="shop_bd_shdz clearfix">
				<div class="shop_bd_shdz_lists clearfix">
					<c:if test="${fn:length(addresslist) == 0}">
						<div class="empty_cart mb10">
							<div class="message">
								<p>您还没有收货地址，请添加一个收货地址</p>
							</div>
						</div>
					</c:if>
					<c:if test="${fn:length(addresslist) != 0}">
						<ul>
							<c:forEach items="${addresslist}" var="address">
								<li>
									<label>
										<span><input type="radio" name="shdz" /></span>
									</label>
									<em>${address.extra }</em>
									<em>${address.username }收</em>
									<em>${address.telephone}</em>
									<span class="admin_shdz_btn">
										<a href="${pageContext.request.contextPath}/user/toupdateaddress?addressid=${address.id}">编辑</a>
										<a href="javascript:deleteAuction(${address.id})">删除</a>
									</span>
								</li>
							</c:forEach>
							<li style="text-align: center;">
								<a href="${pageContext.request.contextPath}/user/toaddress?pageNo=1"><em>首页</em></a>
								<a href="${pageContext.request.contextPath}/user/toaddress?pageNo=${prevpage}"><em>上一页</em></a>
								<a href="${pageContext.request.contextPath}/user/toaddress?pageNo=${nextpage}"><em>下一页</em></a>
								<a href="${pageContext.request.contextPath}/user/toaddress?pageNo=${allpage}"><em>尾页</em></a>
								<em>一共${allpage}页<em>
							</li>
						</ul>
					</c:if>
				</div>
				<!-- 新增收货地址 -->
				<div id="new_add_shdz_contents" style="display:none;" class="shop_bd_shdz_new clearfix">
					<div class="title">新增收货地址</div>
					<div class="shdz_new_form">
						<form action="saveaddress" method="post" onsubmit="return check()">
							<ul>
								<li><label for=""><span>*</span>收货人姓名：</label><input id="username" type="text" class="name" name="address.username" /></li>
								<li><label for=""><span>*</span>详细地址：</label><input id="extra" type="text" class="xiangxi" name="address.extra" /></li>
								<li><label for=""><span>*</span>联系电话：</label><input id="telephone" type="text" class="dianhua" name="address.telephone" /></li>
								<li><label for=""><span></span>邮政编码：</label><input type="text" class="youbian" name="address.postcode" /></li>
								<li><label for="">&nbsp;</label><input type="submit" value="增加收货地址" /></li>
							</ul>
						</from>
					</div>
				</div>
				<!-- 新增收货地址 End -->
			</div>
			<div class="clear"></div>
			</div>
		</div>
		<!-- 右边购物列表 End -->

	</div>
	<!-- 我的个人中心 End -->

	<!-- Footer - wll - 2013/3/24 -->
	<div class="clear"></div>
	<div class="shop_footer">
            <div class="shop_footer_link">
                <p>
                    <a href="">首页</a>|
                    <a href="">招聘英才</a>|
                    <a href="">广告合作</a>|
                    <a href="">关于ShopCZ</a>|
                    <a href="">关于我们</a>
                </p>
            </div>
            <div class="shop_footer_copy">
                <p>Copyright 2004-2013 itcast Inc.,All rights reserved.</p>
            </div>
        </div>
	<!-- Footer End -->
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/productSearch.js" ></script>
</html>