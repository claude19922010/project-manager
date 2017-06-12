package com.pm.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.pm.entity.TProjectMember;

/**
 * A data access object (DAO) providing persistence and search support for
 * TProjectMember entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.pm.entity.TProjectMember
 * @author MyEclipse Persistence Tools
 */
@Repository
public class TProjectMemberDAO extends BaseDao {
	private static final Logger log = LoggerFactory
			.getLogger(TProjectMemberDAO.class);
	// property constants
	public static final String CREATE_USER = "createUser";
	public static final String INVALID = "invalid";
	public static final String UPDATE_USER = "updateUser";
	public static final String PHONE = "phone";
	public static final String PROJECT_ID = "projectId";
	public static final String PROJECT_ROLE = "projectRole";
	public static final String USER_NAME = "userName";
	public static final String CREATE_USER_CNAME = "createUserCname";
	public static final String UPDATE_USER_CNAME = "updateUserCname";

	public void save(TProjectMember transientInstance) {
		log.debug("saving TProjectMember instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TProjectMember persistentInstance) {
		log.debug("deleting TProjectMember instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TProjectMember findById(java.lang.String id) {
		log.debug("getting TProjectMember instance with id: " + id);
		try {
			TProjectMember instance = (TProjectMember) getSessionFactory().getCurrentSession().get(
					"com.pm.entity.TProjectMember", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TProjectMember> findByExample(TProjectMember instance) {
		log.debug("finding TProjectMember instance by example");
		try {
			List<TProjectMember> results = (List<TProjectMember>) getSessionFactory().getCurrentSession()
					.createCriteria("com.pm.entity.TProjectMember")
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
		log.debug("finding TProjectMember instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TProjectMember as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TProjectMember> findByCreateUser(Object createUser) {
		return findByProperty(CREATE_USER, createUser);
	}

	public List<TProjectMember> findByInvalid(Object invalid) {
		return findByProperty(INVALID, invalid);
	}

	public List<TProjectMember> findByUpdateUser(Object updateUser) {
		return findByProperty(UPDATE_USER, updateUser);
	}

	public List<TProjectMember> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<TProjectMember> findByProjectId(Object projectId) {
		return findByProperty(PROJECT_ID, projectId);
	}

	public List<TProjectMember> findByProjectRole(Object projectRole) {
		return findByProperty(PROJECT_ROLE, projectRole);
	}

	public List<TProjectMember> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List<TProjectMember> findByCreateUserCname(Object createUserCname) {
		return findByProperty(CREATE_USER_CNAME, createUserCname);
	}

	public List<TProjectMember> findByUpdateUserCname(Object updateUserCname) {
		return findByProperty(UPDATE_USER_CNAME, updateUserCname);
	}

	public List findAll() {
		log.debug("finding all TProjectMember instances");
		try {
			String queryString = "from TProjectMember";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TProjectMember merge(TProjectMember detachedInstance) {
		log.debug("merging TProjectMember instance");
		try {
			TProjectMember result = (TProjectMember) getSessionFactory().getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TProjectMember instance) {
		log.debug("attaching dirty TProjectMember instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update(TProjectMember instance) {
		log.debug("attaching dirty TProjectMember instance");
		try {
			getSessionFactory().getCurrentSession().update(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TProjectMember instance) {
		log.debug("attaching clean TProjectMember instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public List findAllUserNameUnique() {
		log.debug("finding all TProjectMember instances where username is unique");
		try {
			String queryString = "select distinct(userName),phone from TProjectMember";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	//根据userId查找条目，where role == leader return projectId
	public List findProjectByIdAndLeader(String userId) {
		log.debug("finding all TProjectMember instances where username is unique");
		try {
			String queryString = "select projectId from TProjectMember where userName = ? and projectRole = 0 or projectRole = 1 ";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, userId);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
}