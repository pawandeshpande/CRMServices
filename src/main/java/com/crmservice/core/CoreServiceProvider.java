package com.crmservice.core;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.crmservice.persistance.CrmAccount;
import com.crmservice.persistance.CrmCompany;
import com.crmservice.persistance.CrmUser;

@Stateless
@LocalBean
public class CoreServiceProvider {
	@PersistenceContext(unitName = CRMCoreConstants.PERSISTENCE_CONTEXT)
	private EntityManager em;

	// @Resource(name = CRMCoreConstants.SESSION_EJB_NAME)

	public CoreServiceProvider() {
		// Since we are using transaction type = JTA, we cannot create the
		// entity manager here.
		// try
		// {
		// EntityManagerFactory EMF =
		// Persistence.createEntityManagerFactory(CRMCoreConstants.PERSISTENCE_UNIT_NAME);
		// em = EMF.createEntityManager();
		// em.setFlushMode(FlushModeType.COMMIT);
		// }
		// catch(Exception e)
		// {
		// e.printStackTrace();
		//
		// }

	}

	public Object mergeEntity(Object entity) {
		return em.merge(entity);
	}

	public Object persistEntity(Object entity) {
		em.persist(entity);
		return entity;
	}

	public CrmUser SavePassword(String strPassword) {

		Query qry = em.createNativeQuery("select *****"); // to be completed
		CrmUser u = new CrmUser();
		try {
			qry.setParameter("password", PasswordHash.createHash(strPassword));
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		} catch (InvalidKeySpecException ex) {
			ex.printStackTrace();

		}

		return u;
	}

	public CrmUser VerifyUser(String strUsername, String strPassword) {

		Query qry = em.createNamedQuery("CrmUser.GetUser");
		qry.setParameter("username", strUsername);

		CrmUser u = null;
		try {
			u = (CrmUser) qry.getSingleResult();
			String correctHash = u.getPassword();
			if (!PasswordHash.validatePassword(strPassword, correctHash))
				return null;
		} catch (javax.persistence.NoResultException NRException) {
			NRException.printStackTrace();
		} catch (InvalidKeySpecException ex) {
			ex.printStackTrace();
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return u;
	}

	public List<CrmAccount> getAccountList(CrmUser user, CrmCompany comp) {
		List<CrmAccount> eventList = (List<CrmAccount>) getList(
				CRMCoreQueryConstants.qryFindAllEvents, user, comp);
		return eventList;
	}

	public List<CrmUser> getUserList(Integer user, CrmCompany comp) {

		List<CrmUser> userList = null;

		try {
			Query qry = em.createQuery(CRMCoreQueryConstants.qryFindAllUsers);
			qry.setParameter("createdby", user);
			qry.setParameter("company", comp);
			userList = (List<CrmUser>) qry.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return userList;
	}

	private List getList(String strQuery, CrmUser user, CrmCompany comp) {
		List<Object> obj = null;
		Query qry = em.createQuery(strQuery);
		qry.setParameter("createdby", user);
		qry.setParameter("company", comp);

		obj = qry.getResultList();
		return obj;
	}

	public List<CrmCompany> getCompanyList(String Admin)
			throws IllegalAccessException {

		IllegalAccessException e = new IllegalAccessException();
		if ((Admin != null) || (Admin.compareTo("Admin") != 0))
			throw e;
		String strQuery = "select c from Company c where primary_contact='"
				+ Admin + "' order by c.Name";
		Query qry = em.createQuery(strQuery, CrmCompany.class);
		List<CrmCompany> companyList = (List<CrmCompany>) qry.getResultList();
		return companyList;
	}

	public boolean AddObject(Object obj) {
		try { // EntityManagerFactory EMF =
				// Persistence.createEntityManagerFactory(CRMCoreConstants.PERSISTENCE_UNIT_NAME);
				// em = EMF.createEntityManager();
				// em.getTransaction().begin();
			em.persist(obj);
			em.flush();
			// em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean RemoveObject(Object obj) {
		try {

			em.remove(obj);
			em.flush();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return true;

	}

	public boolean RestoreUser(CrmUser u) {
		u.setDeletedState("N");
		return true;
	}

	public boolean DeleteUser(CrmUser u) {
		u.setDeletedState("Y");
		return true;
	}

	public boolean AddCompany(CrmCompany company) {
		AddObject(company);
		return true;
	}

	public boolean AddUser(CrmUser user) {
		System.out.println("\n\n\nInside AddUser");
		AddObject(user);
		return true;
	}

	public boolean AddAccount(CrmAccount accnt) {
		AddObject(accnt);
		return true;
	}

	public CrmUser getUser(String RowId, String CompanyId) {

		String strQuery = "select * from User where deleted_state='N' and  bu_id="
				+ CompanyId + " and row_id = " + RowId;
		Query qry = em.createNativeQuery(strQuery, CrmUser.class);
		CrmUser u = (CrmUser) qry.getSingleResult();
		return u;

	}

	public CrmCompany findCompany(Integer RowId) {
		CrmCompany cmp = null;
		cmp = em.find(CrmCompany.class, RowId);
		return cmp;
	}

	public CrmUser findUser(Integer RowId) {
		CrmUser usr = null;
		usr = em.find(CrmUser.class, RowId);
		return usr;
	}



}
