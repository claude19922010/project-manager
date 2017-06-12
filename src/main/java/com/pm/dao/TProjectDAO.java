package com.pm.dao;

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

import com.pm.entity.TProject;

/**
 * A data access object (DAO) providing persistence and search support for
 * TProject entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.pm.entity.TProject
 * @author MyEclipse Persistence Tools
 */

@Repository
public class TProjectDAO extends BaseDao {
	private static final Logger log = LoggerFactory
			.getLogger(TProjectDAO.class);
	// property constants
	public static final String CREATE_USER = "createUser";
	public static final String INVALID = "invalid";
	public static final String UPDATE_USER = "updateUser";
	public static final String BUDGET_PROJECT = "budgetProject";
	public static final String BUSINESS_REQUIREMENTS_ID = "businessRequirementsId";
	public static final String CALL_USER = "callUser";
	public static final String CALL_USER_PHONE = "callUserPhone";
	public static final String DECLARE_MEANS = "declareMeans";
	public static final String DEPT_NAME = "deptName";
	public static final String EXTERNAL_PARTIES = "externalParties";
	public static final String KJ_DEPT_FIRST_OPINION = "kjDeptFirstOpinion";
	public static final String KJ_DIRECTOR_APPROVAL = "kjDirectorApproval";
	public static final String LEVEL = "level";
	public static final String NAME = "name";
	public static final String OTHER_ID = "otherId";
	public static final String PROJECT_BACKGROUND = "projectBackground";
	public static final String PROJECT_CONTENT = "projectContent";
	public static final String PROJECT_DEPT = "projectDept";
	public static final String PROJECT_TARGET = "projectTarget";
	public static final String PROJECT_TYPE = "projectType";
	public static final String STATE = "state";
	public static final String TAG_HEAD_BANK = "tagHeadBank";
	public static final String TAG_PROJECT = "tagProject";
	public static final String XQTC_DEPT = "xqtcDept";
	public static final String XQTC_DEPT_ID = "xqtcDeptId";
	public static final String XTZTJSFA_ID = "xtztjsfaId";
	public static final String XXHXMJYS_ID = "xxhxmjysId";
	public static final String YW_DIRECTOR_APPROVAL = "ywDirectorApproval";
	public static final String YWXQFXBG_ID = "ywxqfxbgId";
	public static final String YWZG_DEPT = "ywzgDept";
	public static final String YWZG_DEPT_ID = "ywzgDeptId";
	public static final String ZGYWHLD = "zgywhld";
	public static final String ZGYWHLD_USERNAME = "zgywhldUsername";
	public static final String CREATE_USER_CNAME = "createUserCname";
	public static final String UPDATE_USER_CNAME = "updateUserCname";
	public static final String HLDQZ = "hldqz";
	public static final String QUBIE = "qubie";

	public void save(TProject transientInstance) {
		log.debug("saving TProject instance");
		Session session = getSessionFactory().openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(transientInstance);
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

	public void delete(TProject persistentInstance) {
		log.debug("deleting TProject instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TProject findById(java.lang.String id) {
		log.debug("getting TProject instance with id: " + id);
		try {
			TProject instance = (TProject) getSessionFactory().getCurrentSession().get(
					"com.pm.entity.TProject", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TProject> findByExample(TProject instance) {
		log.debug("finding TProject instance by example");
		try {
			List<TProject> results = (List<TProject>) getSessionFactory().getCurrentSession()
					.createCriteria("com.pm.entity.TProject")
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

	public List<TProject> findByCreateUser(Object createUser) {
		return findByProperty(CREATE_USER, createUser);
	}

	public List<TProject> findByInvalid(Object invalid) {
		return findByProperty(INVALID, invalid);
	}

	public List<TProject> findByUpdateUser(Object updateUser) {
		return findByProperty(UPDATE_USER, updateUser);
	}

	public List<TProject> findByBudgetProject(Object budgetProject) {
		return findByProperty(BUDGET_PROJECT, budgetProject);
	}

	public List<TProject> findByBusinessRequirementsId(
			Object businessRequirementsId) {
		return findByProperty(BUSINESS_REQUIREMENTS_ID, businessRequirementsId);
	}

	public List<TProject> findByCallUser(Object callUser) {
		return findByProperty(CALL_USER, callUser);
	}

	public List<TProject> findByCallUserPhone(Object callUserPhone) {
		return findByProperty(CALL_USER_PHONE, callUserPhone);
	}

	public List<TProject> findByDeclareMeans(Object declareMeans) {
		return findByProperty(DECLARE_MEANS, declareMeans);
	}

	public List<TProject> findByDeptName(Object deptName) {
		return findByProperty(DEPT_NAME, deptName);
	}

	public List<TProject> findByExternalParties(Object externalParties) {
		return findByProperty(EXTERNAL_PARTIES, externalParties);
	}

	public List<TProject> findByKjDeptFirstOpinion(Object kjDeptFirstOpinion) {
		return findByProperty(KJ_DEPT_FIRST_OPINION, kjDeptFirstOpinion);
	}

	public List<TProject> findByKjDirectorApproval(Object kjDirectorApproval) {
		return findByProperty(KJ_DIRECTOR_APPROVAL, kjDirectorApproval);
	}

	public List<TProject> findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List<TProject> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<TProject> findByOtherId(Object otherId) {
		return findByProperty(OTHER_ID, otherId);
	}

	public List<TProject> findByProjectBackground(Object projectBackground) {
		return findByProperty(PROJECT_BACKGROUND, projectBackground);
	}

	public List<TProject> findByProjectContent(Object projectContent) {
		return findByProperty(PROJECT_CONTENT, projectContent);
	}

	public List<TProject> findByProjectDept(Object projectDept) {
		return findByProperty(PROJECT_DEPT, projectDept);
	}

	public List<TProject> findByProjectTarget(Object projectTarget) {
		return findByProperty(PROJECT_TARGET, projectTarget);
	}

	public List<TProject> findByProjectType(Object projectType) {
		return findByProperty(PROJECT_TYPE, projectType);
	}

	public List<TProject> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<TProject> findByTagHeadBank(Object tagHeadBank) {
		return findByProperty(TAG_HEAD_BANK, tagHeadBank);
	}

	public List<TProject> findByTagProject(Object tagProject) {
		return findByProperty(TAG_PROJECT, tagProject);
	}

	public List<TProject> findByXqtcDept(Object xqtcDept) {
		return findByProperty(XQTC_DEPT, xqtcDept);
	}

	public List<TProject> findByXqtcDeptId(Object xqtcDeptId) {
		return findByProperty(XQTC_DEPT_ID, xqtcDeptId);
	}

	public List<TProject> findByXtztjsfaId(Object xtztjsfaId) {
		return findByProperty(XTZTJSFA_ID, xtztjsfaId);
	}

	public List<TProject> findByXxhxmjysId(Object xxhxmjysId) {
		return findByProperty(XXHXMJYS_ID, xxhxmjysId);
	}

	public List<TProject> findByYwDirectorApproval(Object ywDirectorApproval) {
		return findByProperty(YW_DIRECTOR_APPROVAL, ywDirectorApproval);
	}

	public List<TProject> findByYwxqfxbgId(Object ywxqfxbgId) {
		return findByProperty(YWXQFXBG_ID, ywxqfxbgId);
	}

	public List<TProject> findByYwzgDept(Object ywzgDept) {
		return findByProperty(YWZG_DEPT, ywzgDept);
	}

	public List<TProject> findByYwzgDeptId(Object ywzgDeptId) {
		return findByProperty(YWZG_DEPT_ID, ywzgDeptId);
	}

	public List<TProject> findByZgywhld(Object zgywhld) {
		return findByProperty(ZGYWHLD, zgywhld);
	}

	public List<TProject> findByZgywhldUsername(Object zgywhldUsername) {
		return findByProperty(ZGYWHLD_USERNAME, zgywhldUsername);
	}

	public List<TProject> findByCreateUserCname(Object createUserCname) {
		return findByProperty(CREATE_USER_CNAME, createUserCname);
	}

	public List<TProject> findByUpdateUserCname(Object updateUserCname) {
		return findByProperty(UPDATE_USER_CNAME, updateUserCname);
	}

	public List<TProject> findByHldqz(Object hldqz) {
		return findByProperty(HLDQZ, hldqz);
	}

	public List<TProject> findByQubie(Object qubie) {
		return findByProperty(QUBIE, qubie);
	}

	public List findAll() {
		log.debug("finding all TProject instances");
		try {
			String queryString = "from TProject";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAllPaged(int start, int size) {
		log.debug("finding all TProject instances");
		try {
			String queryString = "from TProject";
			Query queryObject = getSessionFactory().getCurrentSession().createQuery(queryString);//.setParameter(0, start).setParameter(1, size);
			queryObject.setFirstResult(start);
			queryObject.setMaxResults(size);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TProject merge(TProject detachedInstance) {
		log.debug("merging TProject instance");
		try {
			TProject result = (TProject) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TProject instance) {
		log.debug("attaching dirty TProject instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TProject instance) {
		log.debug("attaching clean TProject instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update(TProject instance) {
		log.debug("attaching dirty TProject instance");
		Session session = getSessionFactory().openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(instance);
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
//		try {
//			getSessionFactory().getCurrentSession().update(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//	log.debug("saving TProject instance");
//	Session session = getSessionFactory().openSession();
//	try {
//		Transaction tx = session.beginTransaction();
//		session.save(transientInstance);
//		tx.commit();
//		log.debug("save successful");
//	} catch (RuntimeException re) {
//		log.error("save failed", re);
//		throw re;
//	}
//	finally {
//		if(session != null){
//			session.close();
//		}
//	}
