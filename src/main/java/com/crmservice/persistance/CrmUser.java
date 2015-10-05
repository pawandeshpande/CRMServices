package com.crmservice.persistance;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the crm_users database table.
 * 
 */
@Entity
@Table(name="crm_users")
@NamedQuery(name="CrmUser.findAll", query="SELECT c FROM CrmUser c")
public class CrmUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROW_ID")
	private int rowId;

	@Column(name="ACTIVE_FLG")
	private String activeFlg;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(name="CREATED_BY")
	private int createdBy;

	@Column(name="DELETED_STATE")
	private String deletedState;

	private String name;

	@Column(name="PARENT_ID")
	private int parentId;

	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	@Column(name="UPDATED_BY")
	private int updatedBy;

	private String username;

	//bi-directional many-to-one association to CrmAccount
	@OneToMany(mappedBy="crmUser1")
	private List<CrmAccount> crmAccounts1;

	//bi-directional many-to-one association to CrmAccount
	@OneToMany(mappedBy="crmUser2")
	private List<CrmAccount> crmAccounts2;

	//bi-directional many-to-one association to CrmContact
	@OneToMany(mappedBy="crmUser1")
	private List<CrmContact> crmContacts1;

	//bi-directional many-to-one association to CrmContact
	@OneToMany(mappedBy="crmUser2")
	private List<CrmContact> crmContacts2;

	//bi-directional many-to-one association to CrmOpportunity
	@OneToMany(mappedBy="crmUser1")
	private List<CrmOpportunity> crmOpportunities1;

	//bi-directional many-to-one association to CrmOpportunity
	@OneToMany(mappedBy="crmUser2")
	private List<CrmOpportunity> crmOpportunities2;

	//bi-directional many-to-one association to CrmCompany
	@ManyToOne
	@JoinColumn(name="TENANT_ID")
	private CrmCompany crmCompany;

	public CrmUser() {
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

	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<CrmAccount> getCrmAccounts1() {
		return this.crmAccounts1;
	}

	public void setCrmAccounts1(List<CrmAccount> crmAccounts1) {
		this.crmAccounts1 = crmAccounts1;
	}

	public CrmAccount addCrmAccounts1(CrmAccount crmAccounts1) {
		getCrmAccounts1().add(crmAccounts1);
		crmAccounts1.setCrmUser1(this);

		return crmAccounts1;
	}

	public CrmAccount removeCrmAccounts1(CrmAccount crmAccounts1) {
		getCrmAccounts1().remove(crmAccounts1);
		crmAccounts1.setCrmUser1(null);

		return crmAccounts1;
	}

	public List<CrmAccount> getCrmAccounts2() {
		return this.crmAccounts2;
	}

	public void setCrmAccounts2(List<CrmAccount> crmAccounts2) {
		this.crmAccounts2 = crmAccounts2;
	}

	public CrmAccount addCrmAccounts2(CrmAccount crmAccounts2) {
		getCrmAccounts2().add(crmAccounts2);
		crmAccounts2.setCrmUser2(this);

		return crmAccounts2;
	}

	public CrmAccount removeCrmAccounts2(CrmAccount crmAccounts2) {
		getCrmAccounts2().remove(crmAccounts2);
		crmAccounts2.setCrmUser2(null);

		return crmAccounts2;
	}

	public List<CrmContact> getCrmContacts1() {
		return this.crmContacts1;
	}

	public void setCrmContacts1(List<CrmContact> crmContacts1) {
		this.crmContacts1 = crmContacts1;
	}

	public CrmContact addCrmContacts1(CrmContact crmContacts1) {
		getCrmContacts1().add(crmContacts1);
		crmContacts1.setCrmUser1(this);

		return crmContacts1;
	}

	public CrmContact removeCrmContacts1(CrmContact crmContacts1) {
		getCrmContacts1().remove(crmContacts1);
		crmContacts1.setCrmUser1(null);

		return crmContacts1;
	}

	public List<CrmContact> getCrmContacts2() {
		return this.crmContacts2;
	}

	public void setCrmContacts2(List<CrmContact> crmContacts2) {
		this.crmContacts2 = crmContacts2;
	}

	public CrmContact addCrmContacts2(CrmContact crmContacts2) {
		getCrmContacts2().add(crmContacts2);
		crmContacts2.setCrmUser2(this);

		return crmContacts2;
	}

	public CrmContact removeCrmContacts2(CrmContact crmContacts2) {
		getCrmContacts2().remove(crmContacts2);
		crmContacts2.setCrmUser2(null);

		return crmContacts2;
	}

	public List<CrmOpportunity> getCrmOpportunities1() {
		return this.crmOpportunities1;
	}

	public void setCrmOpportunities1(List<CrmOpportunity> crmOpportunities1) {
		this.crmOpportunities1 = crmOpportunities1;
	}

	public CrmOpportunity addCrmOpportunities1(CrmOpportunity crmOpportunities1) {
		getCrmOpportunities1().add(crmOpportunities1);
		crmOpportunities1.setCrmUser1(this);

		return crmOpportunities1;
	}

	public CrmOpportunity removeCrmOpportunities1(CrmOpportunity crmOpportunities1) {
		getCrmOpportunities1().remove(crmOpportunities1);
		crmOpportunities1.setCrmUser1(null);

		return crmOpportunities1;
	}

	public List<CrmOpportunity> getCrmOpportunities2() {
		return this.crmOpportunities2;
	}

	public void setCrmOpportunities2(List<CrmOpportunity> crmOpportunities2) {
		this.crmOpportunities2 = crmOpportunities2;
	}

	public CrmOpportunity addCrmOpportunities2(CrmOpportunity crmOpportunities2) {
		getCrmOpportunities2().add(crmOpportunities2);
		crmOpportunities2.setCrmUser2(this);

		return crmOpportunities2;
	}

	public CrmOpportunity removeCrmOpportunities2(CrmOpportunity crmOpportunities2) {
		getCrmOpportunities2().remove(crmOpportunities2);
		crmOpportunities2.setCrmUser2(null);

		return crmOpportunities2;
	}

	public CrmCompany getCrmCompany() {
		return this.crmCompany;
	}

	public void setCrmCompany(CrmCompany crmCompany) {
		this.crmCompany = crmCompany;
	}

}