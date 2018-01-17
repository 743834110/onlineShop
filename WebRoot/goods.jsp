<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri = "/struts-tags"  prefix = "s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>商品详细页面</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop_common.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop_header.css" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop_list.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop_goods.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop_goodPic.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/productSearch.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/comment.css" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/topNav.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/shop_goods.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/productSearch.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js" ></script>
     
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
								<a href="#" class="topNavHover">我的商城<i></i></a>
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
			<a href="">首页</a>&nbsp;›&nbsp;
			<a href="">商品分类</a>&nbsp;›&nbsp;
			<a href="">男装女装</a>&nbsp;›&nbsp;
			<a href="">男装</a>
		</span>
	</div>
	<div class="clear"></div>
	<!-- 面包屑 End -->

	<!-- Header End -->
	
	<!-- Goods Body -->
	<div class="shop_goods_bd clear">

		<!-- 商品展示 -->
		<div class="shop_goods_show">
			<div class="shop_goods_show_left">
				<!-- 京东商品展示 -->
				<link rel="stylesheet" href="css/shop_goodPic.css" type="${pageContext.request.contextPath}/text/css" />
				<script type="text/javascript" src="${pageContext.request.contextPath}/js/shop_goodPic_base.js"></script>
				<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib.js"></script>
				<script type="text/javascript" src="${pageContext.request.contextPath}/js/163css.js"></script>
				<div id="preview">
					<div class=jqzoom id="spec-n1" ><IMG height="350" src="<s:property value = "productOrigin.productImages.get(0).path"/>"
							 jqimg="
							 	<s:if test="%{productOrigin.productImages.size() != 0}">
										<s:if test="productOrigin.productImages.get(0).path.startsWith('http') == false">
											${pageContext.request.contextPath }/upload
										</s:if>	
										<s:property value = "productOrigin.productImages.get(0).path"/>
								</s:if>
							 " width="350">
						</div>
						<div id="spec-n5">
							<div class=control id="spec-left">
								<img src="images/left.gif" />
							</div>
							<div id="spec-list">
								<ul class="list-h">
									<s:iterator value="productOrigin.productImages">
									<li>
										<img src="
											<s:if test="path.startsWith('http') == false">
												${pageContext.request.contextPath }/upload
											</s:if>	
											<s:property value = "path"/>"/>
									</li>
									</s:iterator>
								</ul>
							</div>
							<div class=control id="spec-right">
								<img src="images/right.gif" />
							</div>
							
					    </div>
					</div>

			</div>
			<div class="shop_goods_show_right">
				<ul>
					<li>
						<strong style="font-size:14px; font-weight:bold;">${productOrigin.name }</strong>
					</li>
					<li>
						<label>价格：</label>
						<span><strong>${productOrigin.price }</strong>元</span>
					</li>
					<li>
						<label>运费：</label>
						
						<span>
							<s:if test="productOrigin.transfee == 0">卖家承担费用</s:if>
							<s:else>${productOrigin.transfee } 元</s:else>
						</span>
					</li>
					<li>
						<label>累计售出：</label>
						<span><s:property value = "productOrigin.userOrders.size()"/>件</span>
					</li>
					<li>
						<label>评价：</label>
						<span><s:property value = "productOrigin.commentses.size()"/>条评论</span>
					</li>
					<li class="goods_num">
						<label>购买数量：</label>
						<span title="${productOrigin.surplus }"><a class="good_num_jian" id="good_num_jian" href="javascript:void(0);"></a><input type="text" value="1" id="good_nums" class="good_nums" /><a href="javascript:void(0);" id="good_num_jia" class="good_num_jia"></a>(当前库存${productOrigin.surplus }件)</span>
					</li>
					<li style="padding:20px 0;">
						<label>&nbsp;</label>						
						<span><a id = "buy" href="javascript:void(0)" class="goods_sub" >立即购买</a></span>
						<span><a id = "cart" href="javascript:void(0)" class="goods_sub_gou goods_sub">加入购物车</a></span>
						<script>
							function getGoodNums(){
								return $("#good_nums").val();
							}
							function validateStore(){
								var max = ${productOrigin.surplus};
								var goodNums = getGoodNums();
								if (goodNums > max){
									alert("购买的商品数量超过指定限制")
									$("#good_nums").val(1);
									return false;
								}
								return true;
							}
							function isLogin(){
								var userId = '<s:property value = "#session.user.id"/>'
								if (userId == ""){
									alert("亲,你还没有登陆呢")
									return false;
								}	
								return true;
							}
							$("#buy").click(function(){
								if (isLogin() == false)
									return ;
								var good_nums = getGoodNums();
								if (validateStore())
									window.location = '${pageContext.request.contextPath }/buyImmediate?productId=${productOrigin.id}&num=' + good_nums
							})
							//购物车
							$("#cart").click(function(){
								var good_nums = getGoodNums();
								if (isLogin() == false)
									return ;
								if (validateStore() == false)
									return ;
								var url = "${pageContext.request.contextPath }/addToCart";
								ajaxFunction(url, function(res, status, xhr){
									var data = eval("(" + res + ")")
									if (data.status == 'false'){//添加失败时
										alert("添加至购物车失败, 请重试")
									}
									else{//添加成功时
										if (data.cartId == 0)
											alert("添加至购物车成功")
										else
											alert("更新购物车已成功")
									}
								})
								
							})
							//obj:发送过去的参数, url, 成功时回调的函数
							function ajaxFunction(url, callback){
								var obj = {
									productId:"<s:property value = "productOrigin.id"/>",
									num:getGoodNums()
								};
								$.ajax({
									url:url,
									data:obj,
									success:callback
								})
							}
						</script>
					</li>
				</ul>
			</div>
		</div>
		<!-- 商品展示 End -->

		<div class="clear mt15"></div>
		<!-- Goods Left -->
		<div class="shop_bd_list_left clearfix">
			<!-- 左边商品分类 -->
			<div class="shop_bd_list_bk clearfix">
				<div class="title">商品分类</div>
				<div class="contents clearfix">
					<dl class="shop_bd_list_type_links clearfix">
						<dt><strong>女装</strong></dt>
						<dd>
							<span><a href="">风衣</a></span>
						</dd>
					</dl>
				</div>
			</div>
			<!-- 左边商品分类 End -->

			<!-- 热卖推荐商品 -->
			<div class="shop_bd_list_bk clearfix">
				<div class="title">热卖推荐商品</div>
				<div class="contents clearfix">
					<ul class="clearfix">
						
						<li class="clearfix">
							<div class="goods_name"><a href="">Gap经典弹力纯色长袖T恤|000891347|原价149元</a></div>
							<div class="goods_pic"><span class="goods_price">¥ 279.00 </span><a href=""><img src="images/89a6d6466b00ae32d3c826b9ec639084.jpg_small.jpg" /></a></div>
							<div class="goods_xiaoliang">
								<span class="goods_xiaoliang_link"><a href="">去看看</a></span>
								<span class="goods_xiaoliang_nums">已销售<strong>99</strong>笔</span>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<!-- 热卖推荐商品 -->
			<div class="clear"></div>

			<!-- 浏览过的商品 -->
			<div class="shop_bd_list_bk clearfix">
				<div class="title">浏览过的商品</div>
				<div class="contents clearfix">
					<ul class="clearfix">
						
						<li class="clearfix">
							<div class="goods_name"><a href="">Gap经典弹力纯色长袖T恤|000891347|原价149元</a></div>
							<div class="goods_pic"><span class="goods_price">¥ 279.00 </span><a href=""><img src="images/89a6d6466b00ae32d3c826b9ec639084.jpg_small.jpg" /></a></div>
							<div class="goods_xiaoliang">
								<span class="goods_xiaoliang_link"><a href="">去看看</a></span>
								<span class="goods_xiaoliang_nums">已销售<strong>99</strong>笔</span>
							</div>
						</li>

					</ul>
				</div>
			</div>
			<!-- 浏览过的商品 -->

		</div>
		<!-- Goods Left End -->

		<!-- 商品详情 -->
		<script type="text/javascript" src="js/shop_goods_tab.js"></script>
		<div class="shop_goods_bd_xiangqing clearfix">
			<div class="shop_goods_bd_xiangqing_tab">
				<ul>
					<li id="xiangqing_tab_1" onmouseover="shop_goods_easytabs('1', '1');" onfocus="shop_goods_easytabs('1', '1');" onclick="return false;"><a href=""><span>商品详情</span></a></li>
					<li id="xiangqing_tab_2" onmouseover="shop_goods_easytabs('1', '2');" onfocus="shop_goods_easytabs('1', '2');" onclick="return false;"><a href=""><span>商品评论</span></a></li>
					<li id="xiangqing_tab_3" onmouseover="shop_goods_easytabs('1', '3');" onfocus="shop_goods_easytabs('1', '3');" onclick="return false;"><a href=""><span>商品咨询</span></a></li>
				</ul>
			</div>
			<div class="shop_goods_bd_xiangqing_content clearfix">
				<div id="xiangqing_content_1" class="xiangqing_contents clearfix">
					<p>商品详情</p>ffffffffffff
					<s:if test="productOrigin.category.id"></s:if>
					<s:property value = "productOrigin.category.id"/>
					<script>
						$(function(){
							var id = <s:property value = "productOrigin.category.id"/>
							var data = "productClassify/" + id + ".json";
							$.getJSON(data, function(res, status, xhr){
								console.log(res)
							})
						})
					</script>
				</div>
				<div id="xiangqing_content_2" class=" xiangqing_contents clearfix">

					<div class="main">
    					<div class="publish">
			        		<textarea  cols="64" rows="3" style = "resize:none" name = "comments.content" placeHolder = "评论" ></textarea>
			        		<button  type="submit">发表评论</button>
			        		<script>
			        			$(".publish button").click(function(){
			        				var content = $(".publish textarea").val().toString();
			        				var productId = '${productOrigin.id }';
			        				var userId = '${sessionScope.user.id}';
			        				
			        				if (userId == ""){
			        					alert("亲, 你还没有登陆呢")
			        					return;
			        				}
			        				if(content == ""){
			        					alert("亲, 你还没有评论呢,添加些评论吧")
			        					return;
			        				}
			        				if (content.length < 5 || content.length > 250){
			        					alert("亲,评论的长度应在5和250之间")
			        					return;
			        				}
			        				var obj = {
			        					"comments.content":content,
			        					"productId":productId
			        				};
			        				$.ajax({
			        					url:'${pageContext.request.contextPath}' + "/addComment",
			        					data:obj,
			        					success:function(res, status, xhr){
			        						var data=eval("("+res+")");
			        						console.log(data)
			        						if (data.status == "false"){
			        							alert(data.reason)
			        						}
			        						else{
			        							var comment = $('<div class="comment"></div>');
			        							var image = '${user.pic }';
			        							if (image == "")
			        								image = "'upload/goods/夏目.jpg'";
			        							var img = "<img src = " + image + "/>";
			        							comment.append(img)
			        							var ul = '<ul class="data"><li><a href="#">${sessionScope.user.username }</a></li><li>' + content + '</li>'
			        							var lastDiv = '<div class="time">时间: ' + data.date + '</div></ul>';
			        							console.log(ul);
			        							console.log(lastDiv);
			        							comment.append(ul);
			        							comment.append(lastDiv);
			        							$('.publish button').after(comment)
			        							$('.main div span').remove();
			        						}
			        					},
			        					
			        					
			        				})
			        				
			        			})
			        		</script>
			    		</div>
					    <div>
					    	<s:if test="productOrigin.commentses.size() == 0">
					    		<span style = "font-family:Courier New;font-size:12px;display:block;margin-top:50px;margin-left:20px;color:#011">暂无评论</span>
					    	</s:if>
					    	<s:else>
					    	<s:iterator value = "productOrigin.commentses">
					        <div class="comment">
					        	<s:if test="user.pic != null">
					            <img src="${user.pic }">
					            </s:if>
					            <s:else>
					            	<img src="upload/goods/夏目.jpg">
					            </s:else>
					            <ul class="data">
					                <li><a href="#">${user.username }</a></li>
					                <li>${content }</li>
					                <s:if test="commentses.size() != 0">
					            	<div class="comment">
					            		<img src="upload/goods/夏目.jpg">
					            		<ul class="data">
					                		<li><a href="#">店家回复</a></li>
					                		<li><s:property value = "commentses.get(0).content"/></li>
					            		</ul>
					        		</div>
					        		</s:if>
					        		<div class="time">时间:<s:property value = "commentdate"/></div>					        		
					            </ul>					           
					        </div>
					        </s:iterator>
					        </s:else>
					    </div>
					    <div class="paging">
					        <a href="#"><span>首页</span></a>
					        <a href="#"><span>&lt;</span></a>
					        <a href="#"><span>1</span></a>
					        <a href="#"><span>尾页</span></a>
					    </div>
					</div>
				</div>

				<div id="xiangqing_content_3" class="xiangqing_contents clearfix">
					<ul style="">
					<s:iterator value="productOrigin.detail.split(',')">
						<li style="margin-top10px;border-bottom: #eee solid 1px;padding: 10px"><s:property /></li>
					</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<!-- 商品详情 End -->

	</div>
	<!-- Goods Body End -->

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
</html>