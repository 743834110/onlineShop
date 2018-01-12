package cn.edu.lingnan.shop.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.internal.CriteriaImpl;
import org.springframework.stereotype.Repository;

import cn.edu.lingnan.shop.dao.BaseDao;
import cn.edu.lingnan.shop.utils.MyCriteria;



@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	@Resource
	private SessionFactory sessionFactory;
	
	protected Class<T> entityClass;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	protected Class getEntityClass() {
		if (entityClass == null) {
			entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];
		}
		return entityClass;
	}

	@Override
	public Serializable save(T entity) {
		return this.getCurrentSession().save(entity);

	}

	@Override
	public void delete(T entity) {
		this.getCurrentSession().delete(entity);
	}

	@Override
	public void update(T entity) {
		this.getCurrentSession().update(entity);
	}
	
	@Override
	public void merge(T entity) {
		this.getCurrentSession().merge(entity);
	}
	
	@Override //ʵ���ѯ
	public List<T> find(T condition) {
		Criteria criteria = this.getCurrentSession().createCriteria(getEntityClass());
		criteria.add(Example.create(condition));
		return criteria.list();
	}

	@Override
	public T findById(Serializable id) {
		T load = (T) this.getCurrentSession().get(getEntityClass(), id);
		return load;
	}

	/**
	 * <���HQL������Ψһʵ��>
	 * 
	 * @param hqlString
	 *            HQL���
	 * @param values
	 *            ���������Object����
	 * @return ��ѯʵ��
	 * @see com.itv.launcher.util.IBaseDao#getByHQL(java.lang.String,
	 *      java.lang.Object[])
	 */
	@Override  //  "from Auction a a.name=? and a.xxx=?"  
	public T getByHQL(String hqlString, Object... values) {
		Query query = this.getCurrentSession().createQuery(hqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);  //����ռλ��
			}
		}
		return (T) query.uniqueResult();
	}

	/**
	 * <���SQL������Ψһʵ��>
	 * 
	 * @param sqlString
	 *            SQL���
	 * @param values
	 *            ���������Object����
	 * @return ��ѯʵ��
	 * @see com.itv.launcher.util.IBaseDao#getBySQL(java.lang.String,
	 *      java.lang.Object[])
	 */
	@Override
	public T getBySQL(String sqlString, Object... values) {
		Query query = this.getCurrentSession().createSQLQuery(sqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return (T) query.uniqueResult();
	}

	/**
	 * <���HQL��䣬�õ���Ӧ��list>
	 * 
	 * @param hqlString
	 *            HQL���
	 * @param values
	 *            ���������Object����
	 * @return ��ѯ���ʵ���List����
	 * @see com.itv.launcher.util.IBaseDao#getListByHQL(java.lang.String,
	 *      java.lang.Object[])
	 */
	@Override
	public List<T> getListByHQL(String hqlString, Object... values) {
		Query query = this.getCurrentSession().createQuery(hqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query.list();
	}

	/**
	 * <���SQL��䣬�õ���Ӧ��list>
	 * 
	 * @param sqlString
	 *            HQL���
	 * @param values
	 *            ���������Object����
	 * @return ��ѯ���ʵ���List����
	 * @see com.itv.launcher.util.IBaseDao#getListBySQL(java.lang.String,
	 *      java.lang.Object[])
	 */
	@Override
	public List<T> getListBySQL(String sqlString, Object... values) {
		Query query = this.getCurrentSession().createSQLQuery(sqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query.list();
	}

	@Override
	public List<T> queryListObjectAllForPage(int pageSize, int page, String hqlString, Object... values) {

		Query query = this.getCurrentSession().createQuery(hqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		query.setFirstResult((page - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	@Override //��ֵ��ѯ
	public Object uniqueResult(String hqlString, Object... values) {
		Query query = this.getCurrentSession().createQuery(hqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query.uniqueResult();
	}
	
	@Override //��ҳ��ֵ��ѯ, ���ҳ
	public Object uniqueResultForPages(String hqlString, int pageSize,
			int page, Object... values) {
		Query query = this.getCurrentSession().createQuery(hqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		query.setFirstResult((page - 1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.uniqueResult();
	}

	public <E> List<E> getResultForPage(E cond, int pageSize, int page, Order order) {
		
		CriteriaImpl criteria = (CriteriaImpl) this.getCurrentSession().createCriteria(this.getEntityClass());
		MyCriteria myCriteria = new MyCriteria(this.getEntityClass().getName(), criteria.getSession());
		myCriteria.setFirstResult((page - 1) * pageSize);
		myCriteria.setMaxResults(pageSize);
		myCriteria.add(cond);
		if (order != null)
			myCriteria.addOrder(order);
		return myCriteria.list();
	
	}
	@Override
	public <T> long getUniqueResultForPage(T cond) {
		CriteriaImpl criteria = (CriteriaImpl) this.getCurrentSession().createCriteria(this.getEntityClass());
		MyCriteria myCriteria = new MyCriteria(this.getEntityClass().getName(), criteria.getSession());
		myCriteria.add(cond);
		myCriteria.setProjection(Projections.rowCount());
		return (long) myCriteria.uniqueResult();
	}

}
