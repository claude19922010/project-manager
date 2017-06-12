package com.pm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pm.entity.TProject;
import com.pm.entity.TProjectTask;

public class BaseDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory
			.getLogger(BaseDao.class);
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public <T> void addEntity(T entity) {
		log.debug("saving TProject instance");
		Session session = getSessionFactory().openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(entity);
			tx.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		finally {
			if(session != null){
				session.close();
			}
		}
	}
	
	public <T> void updateEntity(T entity) {
		log.debug("attaching dirty TProject instance");
		Session session = getSessionFactory().openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(entity);
			tx.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		finally {
			if(session != null){
				session.close();
			}
		}
	}

	public <T> void deleteEntity(T entity) {
	
		log.debug("attaching dirty TProject instance");
		Session session = getSessionFactory().openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.delete(entity);
			tx.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		finally {
			if(session != null){
				session.close();
			}
		}
	}
}
