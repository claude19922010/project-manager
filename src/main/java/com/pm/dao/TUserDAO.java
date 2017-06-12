package com.pm.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.pm.entity.TUser;

/**
 * A data access object (DAO) providing persistence and search support for TUser
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.pm.entity.TUser
 * @author MyEclipse Persistence Tools
 */
@Repository
public class TUserDAO extends BaseDao {
	private static final Logger log = LoggerFactory.getLogger(TUserDAO.class);
	// property constants
	public static final String ADDRESS = "address";
	public static final String ADMINISTRATOR = "administrator";
	public static final String CNAME = "cname";
	public static final String COMPANY_ID = "companyId";
	public static final String EMAIL = "email";
	public static final String ENABLED = "enabled";
	public static final String ENAME = "ename";
	public static final String IDENTITY = "identity";
	public static final String MALE = "male";
	public static final String MOBILE = "mobile";
	public static final String PASSWORD = "password";
	public static final String SALT = "salt";
	public static final String DUTY = "duty";
	public static final String FK_ID = "fkId";
	public static final String FK_SYS_NAME = "fkSysName";

	public void save(TUser transientInstance) {
		log.debug("saving TUser instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TUser persistentInstance) {
		log.debug("deleting TUser instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TUser findById(java.lang.String id) {
		log.debug("getting TUser instance with id: " + id);
		try {
			TUser instance = (TUser) getSessionFactory().getCurrentSession()
					.get("com.pm.entity.TUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TUser> findByExample(TUser instance) {
		log.debug("finding TUser instance by example");
		try {
			List<TUser> results = (List<TUser>) getSessionFactory().getCurrentSession()
					.createCriteria("com.pm.entity.TUser")
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
		log.debug("finding TUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TUser as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TUser> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<TUser> findByAdministrator(Object administrator) {
		return findByProperty(ADMINISTRATOR, administrator);
	}

	public List<TUser> findByCname(Object cname) {
		return findByProperty(CNAME, cname);
	}

	public List<TUser> findByCompanyId(Object companyId) {
		return findByProperty(COMPANY_ID, companyId);
	}

	public List<TUser> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<TUser> findByEnabled(Object enabled) {
		return findByProperty(ENABLED, enabled);
	}

	public List<TUser> findByEname(Object ename) {
		return findByProperty(ENAME, ename);
	}

	public List<TUser> findByIdentity(Object identity) {
		return findByProperty(IDENTITY, identity);
	}

	public List<TUser> findByMale(Object male) {
		return findByProperty(MALE, male);
	}

	public List<TUser> findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List<TUser> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<TUser> findBySalt(Object salt) {
		return findByProperty(SALT, salt);
	}

	public List<TUser> findByDuty(Object duty) {
		return findByProperty(DUTY, duty);
	}

	public List<TUser> findByFkId(Object fkId) {
		return findByProperty(FK_ID, fkId);
	}

	public List<TUser> findByFkSysName(Object fkSysName) {
		return findByProperty(FK_SYS_NAME, fkSysName);
	}

	public List findAll() {
		log.debug("finding all TUser instances");
		try {
			String queryString = "from TUser";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TUser merge(TUser detachedInstance) {
		log.debug("merging TUser instance");
		try {
			TUser result = (TUser) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TUser instance) {
		log.debug("attaching dirty TUser instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TUser instance) {
		log.debug("attaching clean TUser instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}