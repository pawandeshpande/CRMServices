package com.crmservice.persistance;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the crm_opportunity database table.
 * 
 */
@Entity
@Table(name="crm_opportunity")
@NamedQuery(name="CrmOpportunity.findAll", query="SELECT c FROM CrmOpportunity c")
public class CrmOpportunity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROW_ID")
	private int rowId;

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

	@Column(name="OPPORTUNITY_ID")
	private String opportunityId;

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

	public CrmOpportunity() {
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

	public String getOpportunityId() {
		return this.opportunityId;
	}

	public void setOpportunityId(String opportunityId) {
		this.opportunityId = opportunityId;
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