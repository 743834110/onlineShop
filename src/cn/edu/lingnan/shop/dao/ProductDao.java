package cn.edu.lingnan.shop.dao;

import java.util.List;

import org.hibernate.criterion.Order;

import cn.edu.lingnan.shop.pojo.Product;

public interface ProductDao extends BaseDao<Product> {

	List<Product> getResultForPage(Product cond, int size, int pageNo,
			Order order);
	
//	public void insertByHQL(Product products);
}
