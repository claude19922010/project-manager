package com.pm.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.pm.entity.TProjectTask;

/**
 * A data access object (DAO) providing persistence and search support for
 * TProjectTask entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.pm.entity.TProjectTask
 * @author MyEclipse Persistence Tools
 */
@Repository
public class TProjectTaskDAO extends BaseDao {
	private static final Logger log = LoggerFactory
			.getLogger(TProjectTaskDAO.class);
	// property constants
	public static final String CREATE_USER = "createUser";
	public static final String INVALID = "invalid";
	public static final String UPDATE_USER = "updateUser";
	public static final String ATTACHMENTS = "attachments";
	public static final String CONTENT = "content";
	public static final String NAME = "name";
	public static final String PERSON = "person";
	public static final String PERSON_NAME = "personName";
	public static final String PROGRESS = "progress";
	public static final String PROJECT_ID = "projectId";
	public static final String PROJECT_STATE = "projectState";
	public static final String CREATE_USER_CNAME = "createUserCname";
	public static final String UPDATE_USER_CNAME = "updateUserCname";

	public void save(TProjectTask transientInstance) {
		log.debug("saving TProjectTask instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TProjectTask persistentInstance) {
		log.debug("deleting TProjectTask instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TProjectTask findById(java.lang.String id) {
		log.debug("getting TProjectTask instance with id: " + id);
		try {
			TProjectTask instance = (TProjectTask) getSessionFactory().getCurrentSession().get(
					"com.pm.entity.TProjectTask", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TProjectTask> findByExample(TProjectTask instance) {
		log.debug("finding TProjectTask instance by example");
		try {
			List<TProjectTask> results = (List<TProjectTask>) getSessionFactory().getCurrentSession()
					.createCriteria("com.pm.entity.TProjectTask")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TProjectTask instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TProjectTask as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TProjectTask> findByCreateUser(Object createUser) {
		return findByProperty(CREATE_USER, createUser);
	}

	public List<TProjectTask> findByInvalid(Object invalid) {
		return findByProperty(INVALID, invalid);
	}

	public List<TProjectTask> findByUpdateUser(Object updateUser) {
		return findByProperty(UPDATE_USER, updateUser);
	}

	public List<TProjectTask> findByAttachments(Object attachments) {
		return findByProperty(ATTACHMENTS, attachments);
	}

	public List<TProjectTask> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List<TProjectTask> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<TProjectTask> findByPerson(Object person) {
		return findByProperty(PERSON, person);
	}

	public List<TProjectTask> findByPersonName(Object personName) {
		return findByProperty(PERSON_NAME, personName);
	}

	public List<TProjectTask> findByProgress(Object progress) {
		return findByProperty(PROGRESS, progress);
	}

	public List<TProjectTask> findByProjectId(Object projectId) {
		return findByProperty(PROJECT_ID, projectId);
	}

	public List<TProjectTask> findByProjectState(Object projectState) {
		return findByProperty(PROJECT_STATE, projectState);
	}

	@SuppressWarnings("unchecked")
	public List<TProjectTask> findByCreateUserCname(Object createUserCname) {
		return findByProperty(CREATE_USER_CNAME, createUserCname);
	}

	@SuppressWarnings("unchecked")
	public List<TProjectTask> findByUpdateUserCname(Object updateUserCname) {
		return findByProperty(UPDATE_USER_CNAME, updateUserCname);
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all TProjectTask instances");
		try {
			String queryString = "from TProjectTask";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TProjectTask merge(TProjectTask detachedInstance) {
		log.debug("merging TProjectTask instance");
		try {
			TProjectTask result = (TProjectTask) getSessionFactory().getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TProjectTask instance) {
		log.debug("attaching dirty TProjectTask instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(TProjectTask instance) {
		log.debug("attaching clean TProjectTask instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update(TProjectTask instance) {
		log.debug("merging TProjectTask instance");
		try {
			getSessionFactory().getCurrentSession().update(instance);
			log.debug("merge successful");
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	public List findMyTaskInProject(String projectId, String personId) {
		log.debug("finding all TProjectTask instances");
		try {
			String queryString = "from TProjectTask where projectId = ? and person = ?";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, projectId);
			queryObject.setParameter(1, personId);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAllPaged(int start, int size) {
		log.debug("finding all TProjectTask instances");
		try {
			String queryString = "from TProjectTask";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);//.setParameter(0, start).setParameter(1, size);
			queryObject.setFirstResult(start);
			queryObject.setMaxResults(size);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
}