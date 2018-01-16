package cn.edu.lingnan.shop.service;

import java.util.List;

import cn.edu.lingnan.shop.pojo.Category;
import cn.edu.lingnan.shop.pojo.Comments;
import cn.edu.lingnan.shop.pojo.DownProduct;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.pojo.UserOrder;

public interface AdminIndexService {
	
	/***
	 * 刘瑜
	 * 实现管理员登录的页面连接
	 * 访问量，有多少个注册用户，订单量，商品量
	 */
	
	
	//分页显示
	public List<User> loadUsers(int pageSize,int page,User userEaxample);
	public List<Category> loadCategorys(int pageSize,int page,Category categoryEaxample);
	public List<Product> loadProduct(int pageSize,int page,Product productEaxample);
	public List<UserOrder> loadUserOrder(int pageSize,int page,UserOrder userOrderEaxample);
	public List<DownProduct> loadDownProduct(int pageSize,int page,DownProduct downProductEaxample);
	public List<Comments> loadComments(int pageSize,int page,Comments comments);
	
	//计算
	public long loadUsersCount(User userEaxample);
	public long loadCategorysCount(Category categoryEaxample);
	public long loadProductsCount(Product productEaxample);
	public long loadUserOrdersCount(UserOrder userOrderEaxample);
	public long loadDownProductsCount(DownProduct downProductEaxample);
	public long loadCommentsCount(Comments comments);
	
	//注册用户数量
	public User countUser(int userId);
	
	//商品种类量
	public Category countCategory(int categoryId);
	
	//商品量
	public Product countProduct(int productId);
	
	//订单量——针对用户的订单量
	public UserOrder countUerOrder(int userOrderId);
	
	public Comments countComments(int commentsId);
	
	//那卖家呢？卖家如何查看订单量？
	
	//访问量-访问量不是指用户数，更不是评论数，应该是点击率
	//public Click countClick();
	
	
	//2018.1.11添加
	//查看所有商家的商品信息
	public Product getProduct(int productId);
	
	//添加商品，上架新商品
	public void addProduct(Product product);
	
	//上架新商品
	public void updateDownProduct(DownProduct downProduct);
	
	//查看信息
	public User getUser(int userId);
	
	public Category getCategory(int categoryId);
	
	public UserOrder getUserOrder(int userOrderId);
	
	public DownProduct getDownProduct(int downProductId);
	
	public Comments getComments(int commentsId);
	
	//2018.1.15添加
	public List<User> findAllUser();
	public List<Category> findAllCategory();
	public List<Comments> findAllComments();
	public List<UserOrder> findAllUserOrder();
	public List<Product> findAllOnsellProduct();
	public List<Product> findAllOffsellProduct();
	
}
