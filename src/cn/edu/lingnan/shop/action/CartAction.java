package cn.edu.lingnan.shop.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.Cart;
import cn.edu.lingnan.shop.pojo.CartExample;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.CartService;
import cn.edu.lingnan.shop.service.UserService;

/**
 * 购物车action
 * 负责和购物车和商品的交互有关的数据控制
 * @author Administrator
 *
 */
public class CartAction extends BaseAction {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private UserService userService;//用于测试
	
	private List<CartExample> cartList;
	
	/**
	 *	前往购物车页面 
	 */
	public String toCart() {
//		User user = (User) this.session.get("user");
		//测试数据
		User user = userService.getUserById(11L);
		//测试数据END
		cartList = cartService.getAllCart(user);
		return SUCCESS;
	}

	//getter and setter
	public List<CartExample> getCartList() {
		return cartList;
	}

	public void setCartList(List<CartExample> cartList) {
		this.cartList = cartList;
	}
	
}
