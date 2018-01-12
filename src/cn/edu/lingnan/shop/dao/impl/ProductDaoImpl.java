package cn.edu.lingnan.shop.dao.impl;


import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import cn.edu.lingnan.shop.dao.ProductDao;
import cn.edu.lingnan.shop.pojo.Product;

@Repository
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

	@Override
	public List<Product> getResultForPage(Product cond, int size, int pageNo,
			Order order) {
		// TODO Auto-generated method stub
		return null;
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
