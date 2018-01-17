package cn.edu.lingnan.shop.action;


import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.Comments;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.pojo.UserOrder;
import cn.edu.lingnan.shop.service.CommentService;
import cn.edu.lingnan.shop.service.OrderService;
import cn.edu.lingnan.shop.service.ProductService;
import cn.edu.lingnan.shop.utils.DateFormatUtils;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.CommentService;


/**
 * 评论action
 * 负责评论和用户和商品的交互有关的数据控制
 */
public class CommentAction extends BaseAction {
	
	@Autowired
	private OrderService OrderService;
	
	private Comments comments;
	private Long productId;
	private String result;//JSON返回结果
	private Long orderId;//修改订单的状态
	
	@Autowired
	private CommentService commentService; 
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	
	private List<Comments> commentsList;
	
	private List<Comments> userCommentsList;
	
	private int id;
	//添加评论+修改订单状态
	public String addComment(){
		System.out.println("添加评论：" + comments.getContent());
		Product product = this.productService.getProductById(this.productId);
		User user = (User) this.session.get("user");
		if (user == null){
			this.result = "{'status':'false','reason':'未登录'}";
		}
		else{
				//查看此用户是否买过该商品(收到货4才能进行评论),是否对商品进行了评论
				System.out.println("大小：" + product.getUserOrders().size());
				for (UserOrder order: product.getUserOrders()){
					System.out.println(order.getId());
					if (order.getUser().getId() == user.getId() && order.getStatus() >= 4){
						for (Comments comment: product.getCommentses()){
							System.out.println(comment.getContent());
							if (comment.getUser().getId() == user.getId()){//已经评论
								this.result = String.format("{'status':'false',"
										+ " 'reason':'已经评论完成'}");
								return SUCCESS;
							}
						}
						//当没有orderId过来时为空时,
						Date date = new Date();
						this.comments.setCommentdate(date);
						this.comments.setProduct(product);
						this.comments.setUser(user);
						this.commentService.addComment(this.comments);
						this.result = String.format("{"
								+ " 'date': '%s',"
								+ "'status': '%s'"
								+ "}", DateFormatUtils.format(date), "success");
						//暂时就这个样子
						System.out.println("订单id:" +  this.orderId);
					    UserOrder userOrder = this.orderService.findOrderById(this.orderId);
					    userOrder.setStatus(6);//修改状态为6
					    this.orderService.updateOrder(userOrder);
						return SUCCESS;
					}
					
				}
				
				this.result = String.format("{'status':'false',"
									+ " 'reason':'未购买或该商品未交易完成'}");
		}
		return SUCCESS;
	}

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	//评价管理
	public String toComments(){
		userCommentsList = new ArrayList<>();
		User user = (User) this.session.get("user");
		commentsList = commentService.findAllComments();
		for (Comments comment : commentsList) {
			if(comment.getUser().getId() == user.getId()){
				userCommentsList.add(comment);
			}
		}
		if(userCommentsList.size() == 0){
			this.request.setAttribute("error", "error");
			return ERROR;
		}
		return SUCCESS;
	}
	
	//普通用户删除评论
	public String deleteComment(){
		Comments comment = commentService.getCommentById((long) id);
		commentService.deleteComments(comment);
		return SUCCESS;
	}
	
	public List<Comments> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(List<Comments> commentsList) {
		this.commentsList = commentsList;
	}

	public List<Comments> getUserCommentsList() {
		return userCommentsList;
	}

	public void setUserCommentsList(List<Comments> userCommentsList) {
		this.userCommentsList = userCommentsList;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
		
}
