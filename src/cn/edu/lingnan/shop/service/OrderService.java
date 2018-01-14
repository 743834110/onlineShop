package cn.edu.lingnan.shop.service;

import cn.edu.lingnan.shop.pojo.Address;
import cn.edu.lingnan.shop.pojo.Cart;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.pojo.UserOrder;

public interface OrderService {
	
	public String saveUserOreder(Cart cart, Address address, User user);
	public UserOrder findOrderByOrdernum(String ordernum);
	public void updateOrder(UserOrder order);
	
	public UserOrder findOrderById(Long id);
	
}
