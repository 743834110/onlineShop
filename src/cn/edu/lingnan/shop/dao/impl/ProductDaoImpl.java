package cn.edu.lingnan.shop.dao.impl;


import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.internal.CriteriaImpl;
import org.springframework.stereotype.Repository;

import cn.edu.lingnan.shop.dao.ProductDao;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.utils.MyCriteria;

@Repository
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

	//根据某一页进行排序
	//根据何种字段进行排序：人气,价格,销量
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getResultForPage(Product cond, int size, int pageNo,
			Order order) {
		CriteriaImpl  temp = (CriteriaImpl) this.getCurrentSession().createCriteria(this.getEntityClass());
		MyCriteria criteria = new MyCriteria(this.getEntityClass().getName(),temp.getSession());
		criteria.add(cond);
		criteria.setFirstResult((pageNo - 1) * size);
		criteria.setMaxResults(size);
		if (order != null)
			criteria.addOrder(order);
		return criteria.list();
	}

//	@Override
//	public void insertByHQL(Product product) {
//		String hql = "insert into product values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
//		SQLQuery query = this.getCurrentSession().createSQLQuery(hql);
//		query.setLong(0, product.getId());
//		query.setString(1, product.getName());
//		query.setDouble(2, product.getPrice());
//		query.setDouble(3, product.getOginprice());
//		
//		query.setInteger(4, product.getTransfee());
//		query.setLong(5, product.getAccumulate());
//		
//		query.setLong(6, product.getSurplus());
//		query.setString(7, product.getDetail());
//		
//		query.setDate(8, product.getProductdate());
//		
//		query.setString(9, product.getMadein());
//		query.setString(10, product.getFromtable());
//		
//		query.setLong(11, product.getCategory().getId());
//		query.setLong(12, product.getOffshelf());
//
//		query.executeUpdate();
//		
//	}

	

}
