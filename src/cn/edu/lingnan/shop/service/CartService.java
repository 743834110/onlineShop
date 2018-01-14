package cn.edu.lingnan.shop.service;

import java.io.Serializable;
import java.util.List;

import cn.edu.lingnan.shop.pojo.Address;
import cn.edu.lingnan.shop.pojo.Cart;
import cn.edu.lingnan.shop.pojo.CartExample;
import cn.edu.lingnan.shop.pojo.User;

public interface CartService {
	
	public List<CartExample> getAllCart(User user);
	
	public void addCartNumber(long id);
	public void declineCartNumber(long id);
	public List<CartExample> getCartByIdArray(long[] id);
	
	public Cart findCartById(long id);
	public void deleteCart(Cart cart);
	
	//添加商品到购物车当中:应该避免商品的重复
	public void mergeCart(Cart cart);
	
	//查看用户的购物车中是否有productid和userid相同的商品
	public Serializable isTheSameProductInCart(Cart cart);

}
