package cn.edu.lingnan.shop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.edu.lingnan.shop.dao.CategoryDao;
import cn.edu.lingnan.shop.pojo.Category;

@Repository
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

	@Override
	public List<Category> getListByHQLNamedParameters(String hqlString,
			String parametersName, List<Long> ids) {
		Session session = this.getCurrentSession();
		Query query = session.createQuery(hqlString);
		query.setParameterList(parametersName, ids);
		return query.list();
	}

}
