package cn.edu.lingnan.shop.service;

import java.util.*;

import cn.edu.lingnan.shop.pojo.DownProduct;

public interface DownProductService {

	//查询全部下架记录
	public List<DownProduct> findAllDownProduct();
	 
	//插入下架商品记录
	public void saveDwonProduct(DownProduct downProduct);
	
	//根据id查下架的商品
	public DownProduct getDownProductById(Long id);
	
	//更新下架表
	public void updateDownProduct(DownProduct downProduct);
	
}
