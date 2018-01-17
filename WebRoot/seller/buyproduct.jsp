<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop_common.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop_header.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop_manager.css" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/topNav.js" ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/productSearch.css" type="text/css" />
	<style type="text/css">
.a_font{
	font-size: 14px;
}
</style>

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
                   	<ul>
                   </ul>
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
			<a href="${pageContext.request.contextPath}/toOrder">个人主页</a>&nbsp;›&nbsp;
			<a href="javascript:void(0)">已购买的商品</a>
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
					<dd><span><a href="${pageContext.request.contextPath}/loadProduct">编辑商品</a></span></dd>
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
				<div class="title"><h3>订单列表</h3></div>
				<table>
					<thead class="tab_title">
						<th style="width:410px;"><span>商品信息</span></th>
						<th style="width:100px;"><span>单价</span></th>
						<th style="width:80px;"><span>数量</span></th>
						<th style="width:100px;"><span>订单总价</span></th>
						<th style="width:115px;"><span>状态与操作</span></th>
					</thead>
					<tbody>
					
					<s:iterator value="userOrderList">
						<tr><td colspan="5">
							<table class="good">
								<thead >
									<tr><th colspan="6">
										<span><strong>订单号码：</strong><s:property value="ordernum"/> </span>
									</th></tr>
								</thead>
								<tbody>
									<tr>
										<td class="dingdan_pic"><img src="
											<s:if test="%{product.productImages.size() != 0}">
											<s:if test="product.productImages.get(0).path.startsWith('http') == false">
												${pageContext.request.contextPath }/upload/
											</s:if>	
											<s:property value = "product.productImages.get(0).path"/>
											</s:if>
											<s:else>${pageContext.request.contextPath }/upload/02.png</s:else>
										" /></td>
										<td class="dingdan_title"><span><a href="productDetail?productId=<s:property value="product.id"/>"><s:property value="product.name"/> </a></span><br /></td>
										<td class="dingdan_danjia">￥<strong><s:property value="product.price"/> </strong></td>
										<td class="dingdan_shuliang"><s:property value="num"/></td>
										<td class="dingdan_zongjia"><strong><s:property value="price"/></strong><br />
											<s:if test="product.transfee == 0">(免运费)</s:if>
											<s:else>(运费￥<s:property value="product.transfee"/>)</s:else>
										</td>
										<td class="digndan_caozuo">
											<s:if test="status == 1"><a href="toPay?id=<s:property value="id"/>">等待买家付款</a></s:if>
											<s:if test="status == 2">待发货</s:if>
											<s:if test="status == 3"><a href="toGetProduct?id=<s:property value="id"/>">代收货</a></s:if>
											<s:if test="status == 4"><a href="productDetail?productId=<s:property value="product.id"/>&orderId=<s:property value="ordernum"/>">待评价</a></s:if>
											<s:if test="status == 5">退货</s:if>
											<s:if test="status == 6">交易完成</s:if>
											<p><a href="${pageContext.request.contextPath}/user/orderindex?ordernum=<s:property value="ordernum"/>" class="a_font">查看订单信息</a></p>
										</td>
									</tr>
								</tbody>
							</table>
						</td></tr>
						</s:iterator>
						
					</tbody>
				</table>
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
<script type="text/javascript">
	
	var error = "<s:property value='msg'/>";
	if(error == "error"){
		window.alert("您暂时没有购买过商品");
	}
	
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/productSearch.js" ></script>
</html>
