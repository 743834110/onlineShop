package cn.edu.lingnan.shop.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/**
 * 购物车扩展类，属性imagesPath代表商品路径
 * @author huang
 *
 */

public class CartExample {
	private Cart cart;
	private String imagesPath;
	
	public CartExample() {}
	public CartExample(Cart c) {
		this.cart = c;
		if (this.cart.getProduct().getProductImages() != null && this.cart.getProduct().getProductImages().size() > 0)
			this.imagesPath = this.cart.getProduct().getProductImages().get(0).getPath();
	}
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public String getImagesPath() {
		return imagesPath;
	}
	public void setImagesPath(String imagesPath) {
		this.imagesPath = imagesPath;
	}
	
	
}
