package cn.edu.lingnan.shop.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.pojo.UserOrder;
import cn.edu.lingnan.shop.service.OrderService;
import cn.edu.lingnan.shop.service.ProductService;
import cn.edu.lingnan.shop.service.UserService;

/**
 * 订单action
 * 负责和订单有关的数据控制交互
 * @author Administrator
 *
 */
public class OrderAction extends BaseAction {

	
	private List<UserOrder> userOrderList;
	
	private List<UserOrder> orderList;
	
	@Autowired
	private OrderService OrderService;
		
	@Autowired
	private UserService userService;
	
	private List<Product> productList;
	
	private int id;
	
	private String msg;
	
	private String commentId;
	
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

	public String toSendProduct(){
		UserOrder userOder = OrderService.findOrderById((long) id);
		userOder.setStatus(3);
		OrderService.updateOrder(userOder);
		return SUCCESS;
	}
	
	public String toGetProduct(){
		UserOrder userOder = OrderService.findOrderById((long) id);
		userOder.setStatus(4);
		OrderService.updateOrder(userOder);
		return SUCCESS;
	}
	
	//卖家的订单管理
	public String toUserOrder(){
		orderList = new ArrayList<>();
		User user = (User) this.session.get("user");
		productList = OrderService.getUserProductById(user.getId());
		userOrderList = OrderService.finaAllUserOrder();
		for (Product product: productList){
			for(UserOrder userOrder : userOrderList){
				if(product.getId() == userOrder.getProduct().getId()){
					orderList.add(userOrder);
				}
			}
		}
		if(orderList.size() == 0){
			this.request.setAttribute("error", "error");
			return ERROR;
		}
		return SUCCESS;
	}
	
	//用户已购买的商品
	public String toBuy(){
		User user = (User) this.session.get("user");
		userOrderList = OrderService.getOrderById(user.getId());
		if(userOrderList.size() == 0){
			//this.request.setAttribute("error", "error");
			msg = "error";
			return ERROR;
		}
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
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	public List<Product> getProductList() {
		return productList;
	}

	public List<UserOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<UserOrder> orderList) {
		this.orderList = orderList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	
}
