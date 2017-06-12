package com.pm.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.pm.entity.TPfile;
import com.pm.entity.TProject;

/**
 * A data access object (DAO) providing persistence and search support for
 * TPfile entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.pm.entity.TPfile
 * @author MyEclipse Persistence Tools
 */
@Repository
public class TPfileDAO extends BaseDao {
	private static final Logger log = LoggerFactory.getLogger(TPfileDAO.class);
	// property constants
	public static final String CREATE_USER = "createUser";
	public static final String INVALID = "invalid";
	public static final String UPDATE_USER = "updateUser";
	public static final String FILE_NAME = "fileName";
	public static final String OWNER_ID = "ownerId";
	public static final String PATH = "path";
	public static final String TYPE = "type";
	public static final String CREATE_USER_CNAME = "createUserCname";
	public static final String UPDATE_USER_CNAME = "updateUserCname";

	public String save(TPfile transientInstance) {
		String ret = null;
		log.debug("saving TProject instance");
		Session session = getSessionFactory().openSession();
		try {
			Transaction tx = session.beginTransaction();
			ret = (String) session.save(transientInstance);
			System.out.println(ret);
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
		
		return ret;
	}

	public void delete(TPfile persistentInstance) {
		log.debug("deleting TPfile instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TPfile findById(java.lang.String id) {
		log.debug("getting TPfile instance with id: " + id);
		try {
			TPfile instance = (TPfile) getSessionFactory().getCurrentSession().get("com.pm.entity.TPfile",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TPfile> findByExample(TPfile instance) {
		log.debug("finding TPfile instance by example");
		try {
			List<TPfile> results = (List<TPfile>) getSessionFactory().getCurrentSession()
					.createCriteria("com.pm.entity.TPfile")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TPfile instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TPfile as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TPfile> findByCreateUser(Object createUser) {
		return findByProperty(CREATE_USER, createUser);
	}

	public List<TPfile> findByInvalid(Object invalid) {
		return findByProperty(INVALID, invalid);
	}

	public List<TPfile> findByUpdateUser(Object updateUser) {
		return findByProperty(UPDATE_USER, updateUser);
	}

	public List<TPfile> findByFileName(Object fileName) {
		return findByProperty(FILE_NAME, fileName);
	}

	public List<TPfile> findByOwnerId(Object ownerId) {
		return findByProperty(OWNER_ID, ownerId);
	}

	public List<TPfile> findByPath(Object path) {
		return findByProperty(PATH, path);
	}

	public List<TPfile> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<TPfile> findByCreateUserCname(Object createUserCname) {
		return findByProperty(CREATE_USER_CNAME, createUserCname);
	}

	public List<TPfile> findByUpdateUserCname(Object updateUserCname) {
		return findByProperty(UPDATE_USER_CNAME, updateUserCname);
	}

	public List findAll() {
		log.debug("finding all TPfile instances");
		try {
			String queryString = "from TPfile";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TPfile merge(TPfile detachedInstance) {
		log.debug("merging TPfile instance");
		try {
			TPfile result = (TPfile) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TPfile instance) {
		log.debug("attaching dirty TPfile instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TPfile instance) {
		log.debug("attaching clean TPfile instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}