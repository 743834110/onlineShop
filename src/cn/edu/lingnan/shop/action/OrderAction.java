package cn.edu.lingnan.shop.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.pojo.UserOrder;
import cn.edu.lingnan.shop.service.OrderService;
import cn.edu.lingnan.shop.service.UserService;

/**
 * 订单action
 * 负责和订单有关的数据控制交互
 * @author Administrator
 *
 */
public class OrderAction extends BaseAction {

	
	private List<UserOrder> userOrderList;
	
	@Autowired
	private OrderService OrderService;
	
	@Autowired
	private UserService userService;
	
	private int id;
	
	public String toOrder(){
		User user = (User) this.session.get("user");
		user = userService.getUserById(user.getId());
		userOrderList = new ArrayList<>(user.getUserOrders());
		return SUCCESS;
	}
	
	public String toPay(){
		UserOrder userOder = OrderService.findOrderById((long) id);
		userOder.setStatus(2);
		OrderService.updateOrder(userOder);
		return SUCCESS;
	}

	public List<UserOrder> getUserOrderList() {
		return userOrderList;
	}

	public void setUserOrderList(List<UserOrder> userOrderList) {
		this.userOrderList = userOrderList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
