package cn.edu.lingnan.shop.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lingnan.shop.dao.UserOrderDao;
import cn.edu.lingnan.shop.pojo.Address;
import cn.edu.lingnan.shop.pojo.Cart;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.pojo.UserOrder;
import cn.edu.lingnan.shop.service.OrderService;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private UserOrderDao userOrderDao;
	
	/**
	 * 生成订单
	 * @author huang
	 * @param cart 购物车对象
	 * @param address 收货地址
	 * @param user	用户
	 * @return String 订单号
	 */
	@Override
	public String saveUserOreder(Cart cart, Address address, User user) {
		Product product = cart.getProduct();
		UserOrder userorder = new UserOrder();
		userorder.setAddress(address);
		userorder.setProduct(product);
		userorder.setUser(user);
		userorder.setNum(cart.getNum());
		double price = cart.getNum() * cart.getPrice();
		userorder.setPrice(price);
		Date date = new Date();
		userorder.setStartdate(date);
		//默认订单有效期为3天
		userorder.setValid(3);
		//默认订单为未付款
		userorder.setStatus(1);
		//生成订单号 格式时间+用户id+商品id
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		String ordernum = dateFormat.format(date) + user.getId() + product.getId();
		userorder.setOrdernum(ordernum);
		userOrderDao.save(userorder);
		return ordernum;
	}

	/**
	 * 根据id获得订单
	 * @author huang
	 * @param id 订单号
	 */
	@Override
	public UserOrder findOrderByOrdernum(String ordernum) {
		String hql = "select o from UserOrder o where ordernum = ?";
		return userOrderDao.getByHQL(hql, ordernum);
	}

	@Override
	public void updateOrder(UserOrder order) {
		userOrderDao.update(order);
	}

	@Override
	public UserOrder findOrderById(Long id) {
		return userOrderDao.findById(id);
	}
}
