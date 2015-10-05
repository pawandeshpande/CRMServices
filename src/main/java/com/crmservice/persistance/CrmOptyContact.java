package com.crmservice.persistance;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the crm_opty_contact database table.
 * 
 */
@Entity
@Table(name="crm_opty_contact")
@NamedQuery(name="CrmOptyContact.findAll", query="SELECT c FROM CrmOptyContact c")
public class CrmOptyContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROW_ID")
	private int rowId;

	@Column(name="CONTACT_ID")
	private int contactId;

	@Column(name="OPTY_ID")
	private int optyId;

	//bi-directional many-to-one association to CrmCompany
	@ManyToOne
	@JoinColumn(name="TENANT_ID")
	private CrmCompany crmCompany;

	public CrmOptyContact() {
	}

	public int getRowId() {
		return this.rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public int getContactId() {
		return this.contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public int getOptyId() {
		return this.optyId;
	}

	public void setOptyId(int optyId) {
		this.optyId = optyId;
	}

	public CrmCompany getCrmCompany() {
		return this.crmCompany;
	}

	public void setCrmCompany(CrmCompany crmCompany) {
		this.crmCompany = crmCompany;
	}

}