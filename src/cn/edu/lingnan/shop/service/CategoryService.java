package cn.edu.lingnan.shop.service;

import java.util.List;

import cn.edu.lingnan.shop.pojo.Category;

public interface CategoryService {
	
	public List<Category> getCategoriesByIds(List<Long> ids);
	
	public void savaCategory(Category category);
}
