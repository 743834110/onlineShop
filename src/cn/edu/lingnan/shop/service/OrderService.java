package cn.edu.lingnan.shop.service;

import java.util.List;

import cn.edu.lingnan.shop.pojo.Address;
import cn.edu.lingnan.shop.pojo.Cart;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.pojo.UserOrder;

public interface OrderService {
	
	public String saveUserOreder(Cart cart, Address address, User user);
	public UserOrder findOrderByOrdernum(String ordernum);
	public void updateOrder(UserOrder order);
	
	//根据用户id查订单信息
	public UserOrder findOrderById(Long id);
	
	//获取卖家发布的商品订单信息
	public List<Product> getUserProductById(Long id);
	
	//查全部订单信息
	public List<UserOrder> finaAllUserOrder();
	
	//查询已购买的商品信息
	public List<UserOrder> getOrderById(Long id);
}
