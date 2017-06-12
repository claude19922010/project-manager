package com.pm.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.pm.entity.TProject;
import com.pm.entity.TProjectTime;

@Repository
public class TProjectTimeDAO extends BaseDao {
	private static final Logger log = LoggerFactory
			.getLogger(TProjectTaskDAO.class);

	public static final String YEAR = "year";
	public static final String ID = "id";
	public static final String START_TIME_DATE = "startTimeDate";
	public static final String END_TIME_DATE = "endTimeDate";
	
	public void addTimeProject(TProjectTime tProjectTime) {
		log.debug("saving TProject instance");

		Session session = getSessionFactory().openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(tProjectTime);
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
	
	@SuppressWarnings("unchecked")
	public List<TProject> findByYear(Object year) {
		return findByProperty(YEAR, year);
	}
	
	@SuppressWarnings("unchecked")
	public List<TProject> findById(Object id) {
		return findByProperty(ID, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<TProject> findByStartTimeDate(Object startTimeDate) {
		return findByProperty(START_TIME_DATE, startTimeDate);
	}
	
	@SuppressWarnings("unchecked")
	public List<TProject> findByEndTimeDate(Object endTimeDate) {
		return findByProperty(END_TIME_DATE, endTimeDate);
	}
	
	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TProject instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TProject as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all TProjectTime instances");
		try {
			String queryString = "from TProjectTime";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


}
