package cn.edu.lingnan.shop.service;

import java.util.List;

import cn.edu.lingnan.shop.pojo.Category;

public interface ProductService {
	
	//获取商品类型
	public List<Category> findAllCates();
	
}
