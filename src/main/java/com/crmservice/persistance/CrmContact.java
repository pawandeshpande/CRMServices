package com.crmservice.persistance;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the crm_contact database table.
 * 
 */
@Entity
@Table(name="crm_contact")
@NamedQuery(name="CrmContact.findAll", query="SELECT c FROM CrmContact c")
public class CrmContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROW_ID")
	private int rowId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date birthdate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(name="DELETED_STATE")
	private String deletedState;

	private String firstname;

	private String fullname;

	private String lastname;

	private String name;

	@Column(name="PHONE_HOME")
	private String phoneHome;

	@Column(name="PHONE_MOBILE")
	private String phoneMobile;

	@Column(name="PHONE_OFFICE")
	private String phoneOffice;

	private String picture;

	@Column(name="PRIMARY_ADDRESS_CITY")
	private String primaryAddressCity;

	@Column(name="PRIMARY_ADDRESS_COUNTRY")
	private String primaryAddressCountry;

	@Column(name="PRIMARY_ADDRESS_POSTALCODE")
	private String primaryAddressPostalcode;

	@Column(name="PRIMARY_ADDRESS_STATE")
	private String primaryAddressState;

	@Column(name="PRIMARY_ADDRESS_STREET")
	private String primaryAddressStreet;

	private String salutation;

	private String title;

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

	public CrmContact() {
	}

	public int getRowId() {
		return this.rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getDeletedState() {
		return this.deletedState;
	}

	public void setDeletedState(String deletedState) {
		this.deletedState = deletedState;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneHome() {
		return this.phoneHome;
	}

	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
	}

	public String getPhoneMobile() {
		return this.phoneMobile;
	}

	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}

	public String getPhoneOffice() {
		return this.phoneOffice;
	}

	public void setPhoneOffice(String phoneOffice) {
		this.phoneOffice = phoneOffice;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPrimaryAddressCity() {
		return this.primaryAddressCity;
	}

	public void setPrimaryAddressCity(String primaryAddressCity) {
		this.primaryAddressCity = primaryAddressCity;
	}

	public String getPrimaryAddressCountry() {
		return this.primaryAddressCountry;
	}

	public void setPrimaryAddressCountry(String primaryAddressCountry) {
		this.primaryAddressCountry = primaryAddressCountry;
	}

	public String getPrimaryAddressPostalcode() {
		return this.primaryAddressPostalcode;
	}

	public void setPrimaryAddressPostalcode(String primaryAddressPostalcode) {
		this.primaryAddressPostalcode = primaryAddressPostalcode;
	}

	public String getPrimaryAddressState() {
		return this.primaryAddressState;
	}

	public void setPrimaryAddressState(String primaryAddressState) {
		this.primaryAddressState = primaryAddressState;
	}

	public String getPrimaryAddressStreet() {
		return this.primaryAddressStreet;
	}

	public void setPrimaryAddressStreet(String primaryAddressStreet) {
		this.primaryAddressStreet = primaryAddressStreet;
	}

	public String getSalutation() {
		return this.salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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