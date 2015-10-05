package com.crmservice.core;

public class CRMCoreQueryConstants {
  public static final String INSERT_USER =
    "insert into user(row_id,name,username,password,bu_id,created) values(?,?,?,?,?,?)";
  
	public static final String qryVerifyUser = "SELECT 	c FROM CrmUser c WHERE c.username = :username";
	public static final String qryFindAllUsers = "SELECT o FROM CrmUser o where o.createdBy=:createdby and o.company=:company and o.deletedState='N' order by o.name";
	public static final String qryFindAllAccounts = "SELECT A FROM CrmAccount A WHERE A.company=:company and A.deletedState='N' order by A.AccountName";
  public static final String qryFindAllExpenses="SELECT o FROM Expenses o where o.user=:createdby and o.company=:company and o.deletedState='N' order by o.billDate  desc"; 
  public static final String qryFindAllPaymentModes="SELECT o FROM PaymentMode o where o.user=:createdby and o.company=:company and o.deletedState='N'"; 
  public static final String qryFindAllBorrowers="SELECT o FROM Borrower o where o.user=:createdby and o.company=:company and o.deletedState='N'"; 
  public static final String qryFindAllExpenseTypes="SELECT o FROM ExpenseType o where o.user=:createdby and o.company=:company  and o.deletedState='N' order by o.name"; 
  public static final String qryFindAllEvents="SELECT o FROM Event o where o.user=:createdby and o.company=:company  and o.deletedState='N' order by o.name"; 
  public static final String qryFindAllCompanies="SELECT o FROM Company o where o.user=:createdby and o.company=:company  and o.deletedState='N'"; 

  
 // Get single object queries 
  
}
 
