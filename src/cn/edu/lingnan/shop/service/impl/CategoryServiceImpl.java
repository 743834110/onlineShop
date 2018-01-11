package cn.edu.lingnan.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.lingnan.shop.dao.CategoryDao;
import cn.edu.lingnan.shop.pojo.Category;
import cn.edu.lingnan.shop.service.CategoryService;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {

	/**
	 * 通过id集合获取
	 * 商品类别
	 */
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> getCategoriesByIds(List<Long> ids) {
		String parametersName = "list";
		String hqlString = "from Category where id in (:" + parametersName + ")";
		return this.categoryDao.getListByHQLNamedParameters(hqlString,
				parametersName, ids);
	}

}
