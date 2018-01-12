package cn.edu.lingnan.shop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lingnan.shop.dao.CategoryDao;
import cn.edu.lingnan.shop.dao.ProductDao;
import cn.edu.lingnan.shop.dao.UserDao;
import cn.edu.lingnan.shop.dao.UserOrderDao;
import cn.edu.lingnan.shop.pojo.Category;
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
	
	@Autowired 
	private UserDao userDao;
	private CategoryDao categoryDao;
	private ProductDao productDao;
	private UserOrderDao userOrderDao;
	

	@Override  //注册用户数
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
		this.productDao.update(downProduct);
	}

	@Override
	public List<User> loadUsers(int pageSize, int page, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> loadCategorys(int pageSize, int page,
			Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> loadProduct(int pageSize, int page, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserOrder> loadUserOrder(int pageSize, int page,
			UserOrder userOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DownProduct> loadDownProduct(int pageSize, int page,
			DownProduct downProduct) {
		// TODO Auto-generated method stub
		return null;
	}

}
