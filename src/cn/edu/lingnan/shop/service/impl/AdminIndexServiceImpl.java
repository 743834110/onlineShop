package cn.edu.lingnan.shop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lingnan.shop.dao.CategoryDao;
import cn.edu.lingnan.shop.dao.CommentsDao;
import cn.edu.lingnan.shop.dao.DownProductDao;
import cn.edu.lingnan.shop.dao.ProductDao;
import cn.edu.lingnan.shop.dao.UserDao;
import cn.edu.lingnan.shop.dao.UserOrderDao;
import cn.edu.lingnan.shop.pojo.Category;
import cn.edu.lingnan.shop.pojo.Comments;
import cn.edu.lingnan.shop.pojo.DownProduct;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.pojo.UserOrder;
import cn.edu.lingnan.shop.service.AdminIndexService;

/**
 * 管理员主页数据加载实现类
 * @author 刘瑜
 *
 */

@Service
@Transactional
public class AdminIndexServiceImpl implements AdminIndexService {
	
	@Autowired //绑定
	private UserDao userDao;
	
	@Autowired 
	private CategoryDao categoryDao;
	
	@Autowired 
	private ProductDao productDao;
	
	@Autowired 
	private UserOrderDao userOrderDao;
	
	@Autowired 
	private DownProductDao downProductDao;
	
	@Autowired 
	private CommentsDao commentsDao;

	@Override  //统计注册用户数
	public User countUser(int userId) {
		return this.userDao.findById(userId);
	}

	@Override   //商品种类数
	public Category countCategory(int categoryId) {
		return this.categoryDao.findById(categoryId);
	}

	@Override  //商品数目
	public Product countProduct(int productId) {
		return this.productDao.findById(productId);
	}

	@Override  //用户订单量
	public UserOrder countUerOrder(int userOrderId) {
		return this.userOrderDao.findById(userOrderId);
	}

	@Override   //查看商品信息
	public Product getProduct(int productId) {
		return this.productDao.findById(productId);
	}

	@Override  //添加商品
	public void addProduct(Product product) {
		this.productDao.save(product);
	}
	

	@Override  //查看用户信息
	public User getUser(int userId) {
		return this.userDao.findById(userId);
	}

	@Override  //商品上架
	public void updateDownProduct(DownProduct downProduct) {
		this.downProductDao.update(downProduct);
	}

	@Override //以分页的形式展示用户
	public List<User> loadUsers(int pageSize, int page, User userEaxample) {
		List<User> list = null;
		list = this.userDao.
				queryListObjecgtAllForPage(pageSize, page, userEaxample,Order.desc("username"));
		return list;
	}

	@Override //以分页的形式展示商品种类
	public List<Category> loadCategorys(int pageSize, int page,
			Category categoryEaxample) {
		List<Category> list = null;
		list = this.categoryDao.
				queryListObjecgtAllForPage(pageSize, page, categoryEaxample, Order.desc("categoryof"));
		return list;
	}

	@Override //以分页的形式展示商品
	public List<Product> loadProduct(int pageSize, int page, Product productEaxample) {
		List<Product> list = null;
		list = this.productDao.
				queryListObjecgtAllForPage(pageSize, page, productEaxample, Order.desc("name"));
		return list;
	}

	@Override //以分页的形式展示订单
	public List<UserOrder> loadUserOrder(int pageSize, int page,
			UserOrder userOrderEaxample) {
		List<UserOrder> list = null;
		list = this.userOrderDao.
				queryListObjecgtAllForPage(pageSize, page, userOrderEaxample, Order.desc("ordernum"));
		return list;
	}

	@Override //读取下架商品数量
	public List<DownProduct> loadDownProduct(int pageSize, int page,
			DownProduct downProductEaxample) {
		List<DownProduct> list = null;
		list = this.downProductDao.
				queryListObjecgtAllForPage(pageSize, page, downProductEaxample, Order.desc("name"));
		return null;
	}

	@Override //读取用户数
	public long loadUsersCount(User userEaxample) {
		long count = (long) this.userDao.uniqueResultForPages(userEaxample);
		return count;
	}

	@Override //读取商品种类数目
	public long loadCategorysCount(Category categoryEaxample) {
		long count = (long) this.categoryDao.uniqueResultForPages(categoryEaxample);
		return count;
	}

	@Override  //读取商品数量
	public long loadProductsCount(Product productEaxample) {
		long count = (long) this.productDao.uniqueResultForPages(productEaxample);
		return count;
	}

	@Override  //读取用户订单数目
	public long loadUserOrdersCount(UserOrder userOrderEaxample) {
		long count = (long) this.userOrderDao.uniqueResultForPages(userOrderEaxample);
		return count;
	}

	@Override //读取下架商品数目
	public long loadDownProductsCount(DownProduct downProductEaxample) {
		long count = (long) this.downProductDao.uniqueResultForPages(downProductEaxample);
		return count;
	}

	@Override  //获取商品种类
	public Category getCategory(int categoryId) { 
		return this.categoryDao.findById(categoryId);
	}

	@Override  //获取用户订单
	public UserOrder getUserOrder(int userOrderId) {    
		return this.userOrderDao.findById(userOrderId);
	}

	@Override  //获取下架商品
	public DownProduct getDownProduct(int downProductId) {
		return this.downProductDao.findById(downProductId);
	}

	@Override   //以分页的方式展示评论
	public List<Comments> loadComments(int pageSize, int page, Comments commentsEaxample) {
		List<Comments> list = null;
		list = this.commentsDao.
				queryListObjecgtAllForPage(pageSize, page, commentsEaxample, Order.desc("commentdate"));
		return list;
	}

	@Override  //统计评论的数量
	public long loadCommentsCount(Comments commentsEaxample) {
		long count = (long) this.commentsDao.uniqueResultForPages(commentsEaxample);
		return count;
	}

	@Override  //获取评论
	public Comments getComments(int commentsId) {
		return this.commentsDao.findById(commentsId);
	}

}
