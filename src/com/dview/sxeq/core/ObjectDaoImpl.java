package com.dview.sxeq.core;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

@SuppressWarnings("unchecked")
public class ObjectDaoImpl<T, PK extends Serializable>
		extends HibernateDaoSupport implements ObjectDao<T, PK>{

	private Class<T> entityClass = null;

	public ObjectDaoImpl(Class persistentClass) {

		this.entityClass = persistentClass;

	}

	public void add(T obj) {

		this.getHibernateTemplate().saveOrUpdate(obj);
	}

	public void delete(T obj) {
		this.getHibernateTemplate().delete(obj);
	}

	public void deleteById(PK id) {
		this.getHibernateTemplate().delete(get(id));
	}

	public void update(T obj) {

		this.getHibernateTemplate().update(obj);
	}

	public T get(PK id) {
		return this.getHibernateTemplate().get(entityClass, id);
	}

	public List<T> list(String queryString) {

		return this.getHibernateTemplate().find(queryString);
	}

	public List<T> getListForPage(final int offset, final int length,
			final Map<String, String> equalCondition,
			final Map<String, String> likeCondition) {

		List<T> list = super.getHibernateTemplate().executeFind(new HibernateCallback<List<T>>() {

			public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria crit = session.createCriteria(entityClass);
				try {
					if (equalCondition != null) {
						Set<String> keySet = equalCondition.keySet();
						Iterator<String> it = keySet.iterator();
						while(it.hasNext()) {
							String key = it.next();
							String value = equalCondition.get(key);
							if(entityClass.getDeclaredField(key).getType().getName().equals("int")){
								crit.add(Restrictions.eq(key, Integer.parseInt(value)));
							} else if (entityClass.getDeclaredField(key).getType().getName().equals("double")) {
								crit.add(Restrictions.eq(key, Double.parseDouble(value)));
							} else if(entityClass.getDeclaredField(key).getType().getName().equals("float")) {
								crit.add(Restrictions.eq(key, Float.parseFloat(value)));
							} else {
								crit.add(Restrictions.eq(key, value));
							}
						}
					}
					if(likeCondition != null) {
						Set<String> keySet = likeCondition.keySet();
						Iterator<String> it = keySet.iterator();
						while(it.hasNext()) {
							String key = it.next();
							String value = likeCondition.get(key);
							if(value != null) {
								crit.add(Restrictions.like(key, value, MatchMode.ANYWHERE));
							}
						}
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				}
				crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
				crit.setFirstResult(offset);
				crit.setMaxResults(length);
				List<T> page = crit.list();
				return page;
			}

		});

		return list;
	}

	public List<T> getList(final Map<String,String> equalCondition, final Map<String,String> likeCondition) {
		List<T> list = super.getHibernateTemplate().executeFind(new HibernateCallback<List<T>>() {

			public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria crit = session.createCriteria(entityClass);
				try {
					if (equalCondition != null) {
						Set<String> keySet = equalCondition.keySet();
						Iterator<String> it = keySet.iterator();
						while(it.hasNext()) {
							String key = it.next();
							String value = equalCondition.get(key);
							if(entityClass.getDeclaredField(key).getType().getName().equals("int")){
								crit.add(Restrictions.eq(key, Integer.parseInt(value)));
							} else if (entityClass.getDeclaredField(key).getType().getName().equals("double")) {
								crit.add(Restrictions.eq(key, Double.parseDouble(value)));
							} else if(entityClass.getDeclaredField(key).getType().getName().equals("float")) {
								crit.add(Restrictions.eq(key, Float.parseFloat(value)));
							} else {
								crit.add(Restrictions.eq(key, value));
							}
						}
					}
					if(likeCondition != null) {
						Set<String> keySet = likeCondition.keySet();
						Iterator<String> it = keySet.iterator();
						while(it.hasNext()) {
							String key = it.next();
							String value = likeCondition.get(key);
							if(value != null) {
								crit.add(Restrictions.like(key, value, MatchMode.ANYWHERE));
							}
						}
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				}
				crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
				List<T> page = crit.list();
				return page;
			}

		});

		return list;
	}

	public long count(final Map<String,String> equalCondition, final Map<String,String> likeCondition) {
		
		Long count = getHibernateTemplate().execute(new HibernateCallback<Long>() {

			public Long doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria crit = session.createCriteria(entityClass);
				crit.setProjection(Projections.rowCount());
				try {
					if (equalCondition != null) {
						Set<String> keySet = equalCondition.keySet();
						Iterator<String> it = keySet.iterator();
						while(it.hasNext()) {
							String key = it.next();
							String value = equalCondition.get(key);
							if(entityClass.getDeclaredField(key).getType().getName().equals("int")){
								crit.add(Restrictions.eq(key, Integer.parseInt(value)));
							} else if (entityClass.getDeclaredField(key).getType().getName().equals("double")) {
								crit.add(Restrictions.eq(key, Double.parseDouble(value)));
							} else if(entityClass.getDeclaredField(key).getType().getName().equals("float")) {
								crit.add(Restrictions.eq(key, Float.parseFloat(value)));
							} else {
								crit.add(Restrictions.eq(key, value));
							}
						}
					}
					if(likeCondition != null) {
						Set<String> keySet = likeCondition.keySet();
						Iterator<String> it = keySet.iterator();
						while(it.hasNext()) {
							String key = it.next();
							String value = likeCondition.get(key);
							if(value != null) {
								crit.add(Restrictions.like(key, value, MatchMode.ANYWHERE));
							}
						}
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				}
				return (Long) crit.uniqueResult();
			}

		});
		return count == null ? 0 : count.longValue();
	}

	public List<Object[]> queryBySql(String sql) {
		
		Session session = this.getSession();
		SQLQuery query = session.createSQLQuery(sql);
		List<Object[]> obj = query.list();
		return obj;
	}

	public int countQueryBySql(String sql) {
		
		Session session = this.getSession();
		SQLQuery query = session.createSQLQuery(sql);
		String temp = query.list().get(0).toString();
		
		return Integer.parseInt(temp);
	}

	public List<T> getListByHql(String queryStr, int offset, int length) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query   query   =   session.createQuery(queryStr); 
		query.setFirstResult(offset); 
		query.setMaxResults(length); 
		List<T> list= (List<T>)query.list();
		session.close();
		return list;
	}

	public void deleteList(List<T> list) {

		this.getHibernateTemplate().deleteAll(list);
	}
	

}
