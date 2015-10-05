package com.crmservice.persistance;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the crm_acct_contact database table.
 * 
 */
@Entity
@Table(name="crm_acct_contact")
@NamedQuery(name="CrmAcctContact.findAll", query="SELECT c FROM CrmAcctContact c")
public class CrmAcctContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROW_ID")
	private int rowId;

	@Column(name="ACCT_ID")
	private int acctId;

	@Column(name="CONTACT_ID")
	private int contactId;

	//bi-directional many-to-one association to CrmCompany
	@ManyToOne
	@JoinColumn(name="TENANT_ID")
	private CrmCompany crmCompany;

	public CrmAcctContact() {
	}

	public int getRowId() {
		return this.rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public int getAcctId() {
		return this.acctId;
	}

	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}

	public int getContactId() {
		return this.contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public CrmCompany getCrmCompany() {
		return this.crmCompany;
	}

	public void setCrmCompany(CrmCompany crmCompany) {
		this.crmCompany = crmCompany;
	}

}