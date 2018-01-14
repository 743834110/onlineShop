package cn.edu.lingnan.shop.service;

import java.util.List;

import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.User;

public interface AdminService {
	
	/***
	 * 管理员登录
	 * @param yu
	 * @return
	 */
	
	public User login(User admin);
	
	public List<User> findAllCommonUser();
	public List<Product> findAllSellProduct();
	public List<Product> findAllNoSellProduct();
	
}
