package cn.edu.lingnan.shop.dao;

import java.util.List;

import cn.edu.lingnan.shop.pojo.Category;

public interface CategoryDao extends BaseDao<Category> {
	
	public List<Category>getListByHQLNamedParameters(String hqlString,
			String parametersName,List<Long> ids);
}
