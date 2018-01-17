<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的购物车</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/base.css" type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/shop_common.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/shop_header.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/shop_gouwuche.css"
	type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/topNav.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.goodnums.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/shop_gouwuche.js"></script>
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
		<strong>当前位置：</strong> <span> <a href="${pageContext.request.contextPath}/index.jsp">首页</a>&nbsp;›&nbsp;  <a href="${pageContext.request.contextPath}/user/tocart">我的购物车</a>
		</span>
	</div>
	<div class="clear"></div>
	<!-- 面包屑 End -->

	<!-- Header End -->

	<!-- 购物车 Body -->
	<div class="shop_gwc_bd clearfix">
		<!-- 在具体实现的时候，根据情况选择其中一种情况 -->
		<!-- 购物车为空 -->
		<c:if test="${fn:length(cartList) == 0}">
			<div class="empty_cart mb10">
				<div class="message">
					<p>
						购物车内暂时没有商品，您可以<a href="${pageContext.request.contextPath}/index.jsp">去首页</a>挑选喜欢的商品
					</p>
				</div>
			</div>
		</c:if>
		<!-- 购物车为空 end-->

		<!-- 购物车有商品 -->
		<c:if test="${fn:length(cartList) != 0}">
			<div class="shop_gwc_bd_contents clearfix">
				<!-- 购物流程导航 -->

				<div class="shop_gwc_bd_contents_lc clearfix">
					<ul>
						<li class="step_a hover_a">确认购物清单</li>
						<li class="step_b">确认收货人资料及送货方式</li>
						<li class="step_c">购买完成</li>
					</ul>
				</div>
				<!-- 购物流程导航 End -->

				<!-- 购物车列表 -->
				<table>
					<thead>
						<tr>
							<th colspan="2"><span>商品</span></th>
							<th><span>单价(元)</span></th>
							<th><span>数量</span></th>
							<th><span>小计</span>
								<p>邮寄费</p></th>
							<th><span>操作</span></th>
						</tr>
					</thead>
					<tbody>
						<form name="myform" id="myform" action="${pageContext.request.contextPath}/user/topay" method="post">
							<s:iterator value="cartList" status="statu" var="cartExample">
								<tr>
									<td class="gwc_list_pic"><input type="checkbox"
										id="${statu.index }" name="chooseproduct"
										value="${cartExample.cart.id}" class="myinput"> 
										<a href="${pageContext.request.contextPath }/productDetail?productId=${cartExample.cart.product.id}"> <img
											src='<s:if test="%{#cartExample.cart.product.productImages.size() != 0}">
										<s:if test="#cartExample.cart.product.productImages.get(0).path.startsWith('http') == false">
											${pageContext.request.contextPath }/upload/
										</s:if>	
										<s:property value = "#cartExample.cart.product.productImages.get(0).path"/>
									</s:if>
									<s:else>${pageContext.request.contextPath }/upload/goods/夏目.jpg</s:else>'
											width="100px" height="100px" />
									</a></td>
									<td class="gwc_list_title"><a href="${pageContext.request.contextPath }/productDetail?productId=${cartExample.cart.product.id}">${cartExample.cart.product.name }</a></td>
									<td class="gwc_list_danjia"><span>￥<strong
											id="danjia_${statu.index }">${cartExample.cart.product.price}</strong></span></td>
									<td class="gwc_list_shuliang"><span> <a
											class="good_num_jian this_good_nums"
											youji="cart_${statu.index}" did="danjia_${statu.index }"
											xid="xiaoji_${statu.index }" ty="-"
											valId="goods_${statu.index }" href="javascript:void(0);">-</a>
											<input type="text" value="${cartExample.cart.num }"
											id="goods_${statu.index }" class="good_nums" /> <a
											href="javascript:void(0);"
											max="${cartExample.cart.product.surplus }"
											youji="cart_${statu.index}" did="danjia_${statu.index }"
											xid="xiaoji_${statu.index }" ty="+"
											class="good_num_jia this_good_nums"
											valId="goods_${statu.index }">+</a>
									</span></td>
									<td class="gwc_list_xiaoji"><span><strong
											id="cart_${statu.index}" style="display: none;">${cartExample.cart.id}</strong></span>
										<span>￥<strong id="xiaoji_${statu.index }" class="">${cartExample.cart.product.price * cartExample.cart.num}
										</strong></span> <span><br />￥ <strong id="youfei_${statu.index }"
											class=""> <c:if
													test="${cartExample.cart.product.transfee == 0}">0.00(免邮费)</c:if>
												<c:if test="${cartExample.cart.product.transfee != 0}">${cartExample.cart.product.transfee}(邮费)</c:if>
										</strong> </span></td>
									<td class="gwc_list_caozuo"><a
										href="javascript:void(0);" class="shop_good_delete"
										cartid="${cartExample.cart.id}">删除</a></td>
								</tr>
							</s:iterator>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="6">
								<div class="gwc_foot_zongjia">
									商品总价(含运费)<span>￥<strong id="good_zongjia">0.00</strong></span>
								</div>
								<div class="clear"></div>
								<div class="gwc_foot_links">
									<a href="${pageContext.request.contextPath}/index.jsp" class="go">继续购物</a> <a href="javascript:void(0)"
										class="op" id="cartsubmit">确认收货地址</a>
								</div>
							</td>
						</tr>
					</tfoot>
					</form>
				</table>
				<!-- 购物车列表 End -->
			</div>
		</c:if>
		<!-- 购物车有商品 end -->

	</div>
	<!-- 购物车 Body End -->

	<!-- Footer - wll - 2013/3/24 -->
	<div class="clear"></div>
	<div class="shop_footer">
		<div class="shop_footer_link">
			<p>
				<a href="">首页</a>| <a href="">招聘英才</a>| <a href="">广告合作</a>| <a
					href="">关于ShopCZ</a>| <a href="">关于我们</a>
			</p>
		</div>
		<div class="shop_footer_copy">
			<p>Copyright 2004-2013 itcast Inc.,All rights reserved.</p>
		</div>
	</div>
	<!-- Footer End -->
</body>
<script type="text/javascript">
	$(function() {
		$('input:checkbox').click(function() {
			var textval = $(this).attr("id");
			if (!jQuery("#xiaoji_" + textval)) {
				alert("xiaoji错误");
				return false;
			}
			if (!jQuery("#youfei_" + textval)) {
				alert("youfei错误");
				return false;
			}
			var xiaoji_obj = jQuery("#xiaoji_" + textval);
			var youfei_obj = jQuery("#youfei_" + textval);
			//选中和没选中
			if ($(this).is(":checked")) {
				//添加class : good_xiaojis
				xiaoji_obj.attr("class", "good_xiaojis");
				youfei_obj.attr("class", "good_xiaojis");
				goods_zongjia('good_zongjia', 'good_xiaojis');
			} else {
				xiaoji_obj.attr("class", "");
				youfei_obj.attr("class", "");
				goods_zongjia('good_zongjia', 'good_xiaojis');
			}
		});

		function goods_zongjia(zid, xclass) {
			var zongjia = 0.00;
			jQuery('.' + xclass).each(function() {
				zongjia += parseFloat(jQuery(this).text());
			});
			jQuery('#' + zid).text(zongjia.toFixed(2));
		}

		$("#cartsubmit").click(function() {
			var i = 0;
			$('input:checkbox').each(function() {
				if ($(this).is(":checked"))
					i++;
			});
			if (i == 0) {
				alert("没有选中任何商品");
				return false;
			} else {
				$("#myform").submit();
				return true;
			}
		});
		
		$(".shop_good_delete").click(function(){
			var id = $(this).attr("cartid");
			if(confirm('确认删除该商品吗？')){
				goods_zongjia('good_zongjia', 'good_xiaojis');
				var uri = "deletecart.action";
				var params= {
					id : id
				};
				$.getJSON(uri,params,function(){
					window.location.href = "";
				});
			}
		});
	});
</script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/productSearch.css" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/productSearch.js" ></script>
</html>