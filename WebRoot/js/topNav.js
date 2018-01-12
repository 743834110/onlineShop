$(function(){
    
    /* Header TopNav */
    $(".topNav_menu").hover(function(){
        $(this).find('a.topNavHover').addClass('aHover').next('.topNav_menu_bd').show();
    },function(){
        $(this).find('a.topNavHover').removeClass('aHover').next('.topNav_menu_bd').hide();
    });
    
    /* search Form */
    $("ul.shop_hd_header_search_tab li").click(function(){
        $("ul.shop_hd_header_search_tab li").removeClass("current");
        $(this).addClass("current");
    });
    
    $("#shop_hd_menu_all_category").hover(function(){
        $(this).addClass('shop_hd_menu_hover');
    },function(){
        $(this).removeClass('shop_hd_menu_hover');
    });
    
    $(".shop_hd_menu_all_category_hd_menu li").hover(function(){
        $(this).addClass('hover');
    },function(){
        $(this).removeClass('hover');
    });
    
});