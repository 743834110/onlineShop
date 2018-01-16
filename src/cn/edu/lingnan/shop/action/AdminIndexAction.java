package cn.edu.lingnan.shop.action;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.Category;
import cn.edu.lingnan.shop.pojo.Comments;
import cn.edu.lingnan.shop.pojo.DownProduct;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.Tally;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.pojo.UserOrder;
import cn.edu.lingnan.shop.service.AdminIndexService;
import cn.edu.lingnan.shop.service.AdminService;
import cn.edu.lingnan.shop.service.CategoryService;
import cn.edu.lingnan.shop.service.CommentService;
import cn.edu.lingnan.shop.service.DownProductService;
import cn.edu.lingnan.shop.service.OrderService;
import cn.edu.lingnan.shop.service.ProductService;
import cn.edu.lingnan.shop.service.TallyService;
import cn.edu.lingnan.shop.service.UserService;

/**
 * 管理员主页加载页面action
 * @author 刘瑜
 *
 */
public class AdminIndexAction extends BaseAction {
	
	@Autowired
	public TallyService tallyService;
	@Autowired
	public ProductService productService;
	@Autowired
	public OrderService orderService;
	@Autowired
	public CommentService commentService;
	@Autowired
	public UserService userService;
	
	public List<Tally> tallys;
	//评论的数量
	public Long commentCount;
	//订单量
	public Long orderCount;
	//商品量
	public Long productCount;
	//用户量
	public Long userCount;
	
	/**
	 * 读取统计信息
	 */
	public String loadStatistic(){
		
		this.tallys = this.tallyService.getAllTally();
		this.commentCount = this.commentService.getCommentCount();
		this.orderCount = this.orderService.getAllOrderCount();
		this.productCount = this.productService.getAllCount();
		this.userCount = this.userService.getAllUserWithoutAdmin();
		return SUCCESS;
	}
	public List<Tally> getTallys() {
		return tallys;
	}
	public void setTallys(List<Tally> tallys) {
		this.tallys = tallys;
	}
	public Long getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}
	public Long getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(Long orderCount) {
		this.orderCount = orderCount;
	}
	public Long getProductCount() {
		return productCount;
	}
	public void setProductCount(Long productCount) {
		this.productCount = productCount;
	}
	public Long getUserCount() {
		return userCount;
	}
	public void setUserCount(Long userCount) {
		this.userCount = userCount;
	}
	
}
