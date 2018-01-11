package cn.edu.lingnan.shop.service;

import java.util.List;

import cn.edu.lingnan.shop.pojo.Cart;
import cn.edu.lingnan.shop.pojo.CartExample;
import cn.edu.lingnan.shop.pojo.User;

public interface CartService {
	
	public List<CartExample> getAllCart(User user);
	
	public void addCartNumber(long id);
	public void declineCartNumber(long id);
	public List<CartExample> getCartByIdArray(long[] id);

}
