package cn.edu.lingnan.shop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lingnan.shop.dao.CheckUserDao;
import cn.edu.lingnan.shop.dao.ProductDao;
import cn.edu.lingnan.shop.dao.UserDao;
import cn.edu.lingnan.shop.pojo.CheckUser;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	/***
	 * 管理员登录 刘瑜
	 */
	
	@Autowired //绑定
	private UserDao adminDao;
	@Autowired
	private CheckUserDao checkUserDao;
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private ProductDao productDao;
	

	@Override
	public User login(User admin) {
		List<User> list = this.adminDao.find(admin);
		if (list == null || list.size() == 0) 
			return null;
		return list.get(1);
	}
	
	//验证其是否是管理员
	public boolean isExistsUser(String username){
		User admin = new User();
		this.adminDao.find(admin);
		return false;
	}

	
	/**
	 * 得到所有普通用户信息
	 * @author huang
	 * @return List<User> 普通用户信息列表
	 */
	@Override
	public List<User> findAllCommonUser() {
		String hql = "select u from User u where type = 1 order by username asc";
		return userDao.getListByHQL(hql);
	}

	/**
	 * 得到所有上架的商品
	 * @author huang
	 * @return List<Product> 商品列表
	 */
	@Override
	public List<Product> findAllSellProduct() {
		String hql = "select p from Product p where offshelf = 0";
		return productDao.getListByHQL(hql);
	}

	/**
	 * 得到所有下架的商品
	 * @author huang
	 * @return List<Product> 商品列表
	 */
	@Override
	public List<Product> findAllNoSellProduct() {
		String hql = "select p from Product p where offshelf = 2";
		return productDao.getListByHQL(hql);
	}

	/**
	 * 获取所有的卖家申请
	 * @author huang
	 * @return List<CheckUser>
	 */
	@Override
	public List<CheckUser> getAllCheckUser() {
		String hql = "select c from CheckUser c where msg is null order by requestdate asc";
		return checkUserDao.getListByHQL(hql);
	}

	@Override
	public CheckUser findCheckUserById(long id) {
		return checkUserDao.findById(id);
	}

	@Override
	public void updateCheckUser(CheckUser checkUser) {
		checkUserDao.update(checkUser);
	}

}
