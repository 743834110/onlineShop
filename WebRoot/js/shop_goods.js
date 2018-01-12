
/**
 * Goods Page Js
 * wanglele 2013/03/28
 */
$(function(){
	var surplus = $(".goods_num span").attr("title")
 	$("#good_num_jian").click(function(){
 		var num = jQuery("#good_nums").val();
 		num = parseInt(num);
 		num = num-1;
 		if(num<=1){
 			num = 1;
 		}
 		
 		$("#good_nums").val(num);
 	});

 	$("#good_num_jia").click(function(){
 		var num = jQuery("#good_nums").val();
 		num = parseInt(num);
 		num = num+1;
 		if (num >= surplus)
 			num = surplus
 		$("#good_nums").val(num);
 	});
 });