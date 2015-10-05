package com.crmservice.persistance;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the crm_acct_opty database table.
 * 
 */
@Entity
@Table(name="crm_acct_opty")
@NamedQuery(name="CrmAcctOpty.findAll", query="SELECT c FROM CrmAcctOpty c")
public class CrmAcctOpty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROW_ID")
	private int rowId;

	@Column(name="ACCT_ID")
	private int acctId;

	@Column(name="OPTY_ID")
	private int optyId;

	//bi-directional many-to-one association to CrmCompany
	@ManyToOne
	@JoinColumn(name="TENANT_ID")
	private CrmCompany crmCompany;

	public CrmAcctOpty() {
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