package com.crmservice.persistance;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the crm_account database table.
 * 
 */
@Entity
@Table(name="crm_account")
@NamedQuery(name="CrmAccount.findAll", query="SELECT c FROM CrmAccount c")
public class CrmAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROW_ID")
	private int rowId;

	@Column(name="ACCOUNT_NO")
	private String accountNo;

	@Column(name="ACTIVE_FLG")
	private String activeFlg;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(name="DEFAULT_FLG")
	private String defaultFlg;

	@Column(name="DELETED_STATE")
	private String deletedState;

	private String description;

	private String name;

	@Column(name="PARENT_ID")
	private int parentId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	//bi-directional many-to-one association to CrmCompany
	@ManyToOne
	@JoinColumn(name="TENANT_ID")
	private CrmCompany crmCompany;

	//bi-directional many-to-one association to CrmUser
	@ManyToOne
	@JoinColumn(name="CREATED_BY")
	private CrmUser crmUser1;

	//bi-directional many-to-one association to CrmUser
	@ManyToOne
	@JoinColumn(name="UPDATED_BY")
	private CrmUser crmUser2;

	public CrmAccount() {
	}

	public int getRowId() {
		return this.rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public String getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
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

	public String getDefaultFlg() {
		return this.defaultFlg;
	}

	public void setDefaultFlg(String defaultFlg) {
		this.defaultFlg = defaultFlg;
	}

	public String getDeletedState() {
		return this.deletedState;
	}

	public void setDeletedState(String deletedState) {
		this.deletedState = deletedState;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public CrmCompany getCrmCompany() {
		return this.crmCompany;
	}

	public void setCrmCompany(CrmCompany crmCompany) {
		this.crmCompany = crmCompany;
	}

	public CrmUser getCrmUser1() {
		return this.crmUser1;
	}

	public void setCrmUser1(CrmUser crmUser1) {
		this.crmUser1 = crmUser1;
	}

	public CrmUser getCrmUser2() {
		return this.crmUser2;
	}

	public void setCrmUser2(CrmUser crmUser2) {
		this.crmUser2 = crmUser2;
	}

}