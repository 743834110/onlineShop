package cn.edu.lingnan.shop.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.Cart;
import cn.edu.lingnan.shop.pojo.CartExample;
import cn.edu.lingnan.shop.pojo.Product;
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
	
	private List<CartExample> cartList;	//购物车列表
	private long cartId;	//增加和减少商品数量的商品id
	private double allprice;//购物车列表总价钱
	private long[] chooseproduct;	//购物车Id数组
	
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
	
	/**
	 * 同步网页添加购物车商品的数量
	 * @return
	 */
	public String addCartNumber() {
		cartService.addCartNumber(cartId);
		return SUCCESS;
	}
	
	/**
	 * 同步网页减少数据库购物车商品的数量
	 * @return
	 */
	public String declineCartNumber() {
		cartService.declineCartNumber(cartId);
		return SUCCESS;
	}
	
	/**
	 * 前往支付页面
	 * @return
	 */
	public String toPay() {
		cartList = cartService.getCartByIdArray(chooseproduct);
		allprice = 0.00;
		for (CartExample cartExample : cartList) {
			Product product = cartExample.getCart().getProduct();
			allprice += product.getPrice() * cartExample.getCart().getNum() + product.getOginprice();
		}
		return SUCCESS;
	}
	
	/**
	 * 用户支付生成订单
	 * @return
	 */
	public String mypay() {
		return SUCCESS;
	}

	//getter and setter
	public List<CartExample> getCartList() {
		return cartList;
	}
	public void setCartList(List<CartExample> cartList) {
		this.cartList = cartList;
	}
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public double getAllprice() {
		return allprice;
	}
	public void setAllprice(double allprice) {
		this.allprice = allprice;
	}
	public long[] getChooseproduct() {
		return chooseproduct;
	}
	public void setChooseproduct(long[] chooseproduct) {
		this.chooseproduct = chooseproduct;
	}
	
	
	
}
