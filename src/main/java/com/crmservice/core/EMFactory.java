package com.crmservice.core;

import javax.naming.InitialContext;


public class EMFactory {
  private static InitialContext ic = null;
  private static CoreServiceProvider ejb = null;

  private EMFactory() {
    ic = null;

  }

  public static CoreServiceProvider getSessionEJB() {
    
    try {

System.out.println("\n\n\n started");
      if (ejb == null) {
        System.out.println("\n\n\n Inside");
           ic = new InitialContext();
      
          // EJBContainer ejbContainer = EJBContainer.createEJBContainer();

         //  Object object = ejbContainer.getContext().lookup("global/CRMServices/CoreServiceProvider");
           ejb=(CoreServiceProvider)ic.lookup("java:/openejb/local/CoreServiceProviderLocalBean");
    //  ejb = (CoreServiceProvider)object; 
        return ejb;

      }

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("\n\n\n Exception"+e);
    }

    return ejb;
  }


}
