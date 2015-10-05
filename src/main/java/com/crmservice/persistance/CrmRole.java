package com.crmservice.persistance;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the crm_roles database table.
 * 
 */
@Entity
@Table(name="crm_roles")
@NamedQuery(name="CrmRole.findAll", query="SELECT c FROM CrmRole c")
public class CrmRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROW_ID")
	private int rowId;

	@Column(name="ACTIVE_FLG")
	private String activeFlg;

	@Column(name="DELETED_STATE")
	private String deletedState;

	private String description;

	private String name;

	@Column(name="PARENT_ID")
	private int parentId;

	//bi-directional many-to-one association to CrmCompany
	@ManyToOne
	@JoinColumn(name="TENANT_ID")
	private CrmCompany crmCompany;

	public CrmRole() {
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

	public CrmCompany getCrmCompany() {
		return this.crmCompany;
	}

	public void setCrmCompany(CrmCompany crmCompany) {
		this.crmCompany = crmCompany;
	}

}