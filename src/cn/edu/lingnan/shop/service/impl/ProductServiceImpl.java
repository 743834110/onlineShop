package cn.edu.lingnan.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.lingnan.shop.dao.CategoryDao;
import cn.edu.lingnan.shop.pojo.Category;
import cn.edu.lingnan.shop.service.ProductService;

@Transactional
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> findAllCates() {
		return categoryDao.getListByHQL("from Category");
	}

}
