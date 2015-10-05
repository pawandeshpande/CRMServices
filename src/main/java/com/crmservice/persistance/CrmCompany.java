package com.crmservice.persistance;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the crm_company database table.
 * 
 */
@Entity
@Table(name="crm_company")
@NamedQuery(name="CrmCompany.findAll", query="SELECT c FROM CrmCompany c")
public class CrmCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROW_ID")
	private int rowId;

	@Column(name="ACTIVE_FLG")
	private String activeFlg;

	private String address;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Column(name="DELETED_STATE")
	private String deletedState;

	private String name;

	@Column(name="PRIMARY_CONTACT")
	private String primaryContact;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	@Column(name="UPDATED_BY")
	private int updatedBy;

	//bi-directional many-to-one association to CrmAccount
	@OneToMany(mappedBy="crmCompany")
	private List<CrmAccount> crmAccounts;

	//bi-directional many-to-one association to CrmAcctContact
	@OneToMany(mappedBy="crmCompany")
	private List<CrmAcctContact> crmAcctContacts;

	//bi-directional many-to-one association to CrmAcctOpty
	@OneToMany(mappedBy="crmCompany")
	private List<CrmAcctOpty> crmAcctOpties;

	//bi-directional many-to-one association to CrmContact
	@OneToMany(mappedBy="crmCompany")
	private List<CrmContact> crmContacts;

	//bi-directional many-to-one association to CrmOpportunity
	@OneToMany(mappedBy="crmCompany")
	private List<CrmOpportunity> crmOpportunities;

	//bi-directional many-to-one association to CrmOptyContact
	@OneToMany(mappedBy="crmCompany")
	private List<CrmOptyContact> crmOptyContacts;

	//bi-directional many-to-one association to CrmRole
	@OneToMany(mappedBy="crmCompany")
	private List<CrmRole> crmRoles;

	//bi-directional many-to-one association to CrmUser
	@OneToMany(mappedBy="crmCompany")
	private List<CrmUser> crmUsers;

	public CrmCompany() {
	}

	public int getRowId() {
		return this.rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public String getActiveFlg() {
		return this.activeFlg;
	}

	public void setActiveFlg(String activeFlg) {
		this.activeFlg = activeFlg;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public String getDeletedState() {
		return this.deletedState;
	}

	public void setDeletedState(String deletedState) {
		this.deletedState = deletedState;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrimaryContact() {
		return this.primaryContact;
	}

	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public int getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<CrmAccount> getCrmAccounts() {
		return this.crmAccounts;
	}

	public void setCrmAccounts(List<CrmAccount> crmAccounts) {
		this.crmAccounts = crmAccounts;
	}

	public CrmAccount addCrmAccount(CrmAccount crmAccount) {
		getCrmAccounts().add(crmAccount);
		crmAccount.setCrmCompany(this);

		return crmAccount;
	}

	public CrmAccount removeCrmAccount(CrmAccount crmAccount) {
		getCrmAccounts().remove(crmAccount);
		crmAccount.setCrmCompany(null);

		return crmAccount;
	}

	public List<CrmAcctContact> getCrmAcctContacts() {
		return this.crmAcctContacts;
	}

	public void setCrmAcctContacts(List<CrmAcctContact> crmAcctContacts) {
		this.crmAcctContacts = crmAcctContacts;
	}

	public CrmAcctContact addCrmAcctContact(CrmAcctContact crmAcctContact) {
		getCrmAcctContacts().add(crmAcctContact);
		crmAcctContact.setCrmCompany(this);

		return crmAcctContact;
	}

	public CrmAcctContact removeCrmAcctContact(CrmAcctContact crmAcctContact) {
		getCrmAcctContacts().remove(crmAcctContact);
		crmAcctContact.setCrmCompany(null);

		return crmAcctContact;
	}

	public List<CrmAcctOpty> getCrmAcctOpties() {
		return this.crmAcctOpties;
	}

	public void setCrmAcctOpties(List<CrmAcctOpty> crmAcctOpties) {
		this.crmAcctOpties = crmAcctOpties;
	}

	public CrmAcctOpty addCrmAcctOpty(CrmAcctOpty crmAcctOpty) {
		getCrmAcctOpties().add(crmAcctOpty);
		crmAcctOpty.setCrmCompany(this);

		return crmAcctOpty;
	}

	public CrmAcctOpty removeCrmAcctOpty(CrmAcctOpty crmAcctOpty) {
		getCrmAcctOpties().remove(crmAcctOpty);
		crmAcctOpty.setCrmCompany(null);

		return crmAcctOpty;
	}

	public List<CrmContact> getCrmContacts() {
		return this.crmContacts;
	}

	public void setCrmContacts(List<CrmContact> crmContacts) {
		this.crmContacts = crmContacts;
	}

	public CrmContact addCrmContact(CrmContact crmContact) {
		getCrmContacts().add(crmContact);
		crmContact.setCrmCompany(this);

		return crmContact;
	}

	public CrmContact removeCrmContact(CrmContact crmContact) {
		getCrmContacts().remove(crmContact);
		crmContact.setCrmCompany(null);

		return crmContact;
	}

	public List<CrmOpportunity> getCrmOpportunities() {
		return this.crmOpportunities;
	}

	public void setCrmOpportunities(List<CrmOpportunity> crmOpportunities) {
		this.crmOpportunities = crmOpportunities;
	}

	public CrmOpportunity addCrmOpportunity(CrmOpportunity crmOpportunity) {
		getCrmOpportunities().add(crmOpportunity);
		crmOpportunity.setCrmCompany(this);

		return crmOpportunity;
	}

	public CrmOpportunity removeCrmOpportunity(CrmOpportunity crmOpportunity) {
		getCrmOpportunities().remove(crmOpportunity);
		crmOpportunity.setCrmCompany(null);

		return crmOpportunity;
	}

	public List<CrmOptyContact> getCrmOptyContacts() {
		return this.crmOptyContacts;
	}

	public void setCrmOptyContacts(List<CrmOptyContact> crmOptyContacts) {
		this.crmOptyContacts = crmOptyContacts;
	}

	public CrmOptyContact addCrmOptyContact(CrmOptyContact crmOptyContact) {
		getCrmOptyContacts().add(crmOptyContact);
		crmOptyContact.setCrmCompany(this);

		return crmOptyContact;
	}

	public CrmOptyContact removeCrmOptyContact(CrmOptyContact crmOptyContact) {
		getCrmOptyContacts().remove(crmOptyContact);
		crmOptyContact.setCrmCompany(null);

		return crmOptyContact;
	}

	public List<CrmRole> getCrmRoles() {
		return this.crmRoles;
	}

	public void setCrmRoles(List<CrmRole> crmRoles) {
		this.crmRoles = crmRoles;
	}

	public CrmRole addCrmRole(CrmRole crmRole) {
		getCrmRoles().add(crmRole);
		crmRole.setCrmCompany(this);

		return crmRole;
	}

	public CrmRole removeCrmRole(CrmRole crmRole) {
		getCrmRoles().remove(crmRole);
		crmRole.setCrmCompany(null);

		return crmRole;
	}

	public List<CrmUser> getCrmUsers() {
		return this.crmUsers;
	}

	public void setCrmUsers(List<CrmUser> crmUsers) {
		this.crmUsers = crmUsers;
	}

	public CrmUser addCrmUser(CrmUser crmUser) {
		getCrmUsers().add(crmUser);
		crmUser.setCrmCompany(this);

		return crmUser;
	}

	public CrmUser removeCrmUser(CrmUser crmUser) {
		getCrmUsers().remove(crmUser);
		crmUser.setCrmCompany(null);

		return crmUser;
	}

}