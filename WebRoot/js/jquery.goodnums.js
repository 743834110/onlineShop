/**
 * 商品数量加减插件
 * wll-2013/03/29
 * jquery.goodnums.js
 *
 *
 *
 
 */
 jQuery(function(){
 
	/**
     * 删除商品 
	 *
	 * 使用说明：
	 * 元素必须具备以下属性
	 * 必须：zid 总价ID
	 * 必须：xclass 每个商品小计的 class
	 * 必须：ValId input:text 当前改变商品数量的ID
	 *
	 * Demo：
	 * jQuery(".shop_good_delete").goodDelete({zid:'good_zongjia',xclass:'good_xiaojis'});
	 */
	jQuery.fn.goodDelete = function(options){
		var defaults = {
			Event : "click",
			zid : 'goods_zongjia',
			xclass : 'xclass'
		};
		
		var options = jQuery.extend(defaults,options);
		var obj = jQuery(this);
		var id = $(this).attr("cartid");
		obj.live(options.Event,function(e){
			if(confirm('确认删除该商品吗？')){
				goods_zongjia(options.zid,options.xclass);
				var uri = "deletecart.action";
				var params= {
					id : id
				};
				/*$.getJSON(uri,params,function(){
					window.location.href = "";
				});*/
				alert(id);
			}
		});
	};
	
    
    function addCartNumber(id) {
    	var uri = "addCartNumber.action";
    	var params = {
    			cartId : id
    	};	
		$.getJSON(uri, params, function(){
		
		});
    }
    
    function declineCartNumber(id) {
    	var uri = "declineCartNumber.action";
		var params = {
			cartId : id
		};		
		$.getJSON(uri, params, function(){
			
		});
    }
    
	
	/**
	 * 购物车数量加减
	 *
	 * 使用说明：
	 * 元素必须具备以下属性
	 * 必须：zid 总价ID
	 * 必须：xclass 每个商品小计的 class
	 * 必须：ValId input:text 当前改变商品数量的ID
	 * 必须：ty 进行的运算类型 可选值： '+'或'-'
	 * 可选：max 允许最大商品数量	注：也可在调用时批量定义
	 * 可选：min 允许最少商品数量	注：也可在调用时批量定义
	 *
	 * Demo：
	 * jQuery(".this_good_nums").goodnums({zid:'good_zongjia',xclass:'good_xiaojis',max:5,min:1,typ:'+'});
	 */
	jQuery.fn.goodnums = function(options){
		var defaults = {
			Event : "click",
			zid : 'goods_zongjia',
			xclass : 'xclass',
			type : '+',
			min : 1
		};
		
		var options = jQuery.extend(defaults,options);
		var obj = jQuery(this);
		obj.live(options.Event,function(e){
		
			var valId = jQuery(this).attr('valId');
			var did = jQuery(this).attr('did');
			var xid = jQuery(this).attr('xid');
			var cid = jQuery(this).attr('youji');

			var type = jQuery(this).attr('ty') ? jQuery(this).attr('ty') : options.type;
			var max = jQuery(this).attr('max') ? jQuery(this).attr('max') : options.max;
			var min = jQuery(this).attr('min') ? jQuery(this).attr('min') : options.min;
			
			//var max = options.max;
			//var min = options.min;
			
			//判断 Value 对象是否存在
			if( !jQuery("#"+valId) ){
				alert('参数错误');
				return false;
			}
			
			if( !jQuery("#"+did) ){
				alert('参数错误');
				return false;
			}
			
			if( !jQuery("#"+xid) ){
				alert('参数错误');
				return false;
			}
			
			if( !jQuery("#"+cid) ){
				alert('cid参数错误');
				return false;
			}
			
			// 获取当前 Value 对象
			var num_obj = jQuery("#"+valId);
			var danjia_obj = jQuery("#"+did);
			var xiaoji_obj = jQuery("#"+xid);
			var cid_obj = jQuery("#"+cid);
			
			// 获取 选购数量，及单价
			var nums = num_obj.val();
			var danjia = danjia_obj.text();
			var id = cid_obj.text();
			
			// 将需要处理的 数据全部转换为 Int
			nums = parseInt(nums);
			max = parseInt(max);
			min = parseInt(min);
			cid = parseInt(cid);
			danjia = parseFloat(danjia);
			
			//ajax参数
			if(type == '+'){
				if(nums < max){
					nums += 1;
					num_obj.val(nums);
					var xiaoji = danjia*nums;
					xiaoji_obj.text(xiaoji.toFixed(2));
					goods_zongjia(options.zid,options.xclass);
					addCartNumber(id);
				} else {
					alert("库存不足");
				}
				
			}
			else if( type == '-'){
				if(nums > min){
					nums -= 1;
					num_obj.val(nums);
					var xiaoji = danjia*nums;
					xiaoji_obj.text(xiaoji.toFixed(2));
					goods_zongjia(options.zid,options.xclass);
					declineCartNumber(id);
				}
			}
		});
	}
	
   /**
	* Public Function
	*/
	 
   /**
	* 计算购物车总价
	*
	* zid: 总价ID 
	* xclass 单个商品小计class
	* 
	* Demo: goods_zongjia(options.zid,options.xclass);
	*/
	function goods_zongjia(zid,xclass){
		var zongjia = 0.00;
		jQuery('.'+xclass).each(function(){
			zongjia += parseFloat(jQuery(this).text());
		});
		jQuery('#'+zid).text(zongjia.toFixed(2));
	}
	 
 });