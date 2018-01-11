package cn.edu.lingnan.shop.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Order;

public interface BaseDao<T> {
	public Serializable save(T entity);

	public void delete(T entity);

	public void update(T entity);
	
	void merge(T entity);
	
	public List<T> find(T condition);
	
	public T findById(Serializable id);

	// param... �ɱ���� , �൱�� object[]    getByHQL("from Emp","jack","clerk",1000)
	// ���ص������󣨷�װ��ǰ��� ��
	public T getByHQL(String hqlString, Object... values);

	public T getBySQL(String sqlString, Object... values);

	public List<T> getListByHQL(String hqlString, Object... values);

	public List<T> getListBySQL(String sqlString, Object... values);

	public List<T> queryListObjectAllForPage(int pageSize, int page,
			String hqlString, Object... values);

	//��ֵ��ѯ   select count()
	public Object uniqueResult(String sqlString, Object... values);
	
	public Object uniqueResultForPages(String hqlString,int pageSize,int page, Object... values);
	
	//根据组合条件进行组合分页
	public  <E> List<E> getResultForPage(E cond, int pageSize, int page, Order order);
	//根据组合条件查询符合分页的条数
	public <T> long getUniqueResultForPage(T cond);
}
