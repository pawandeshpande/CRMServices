package com.crmservice.test; 

 
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.crmservice.core.CoreServiceProvider;
import com.crmservice.persistance.CrmUser;

public class SessionEJBBeanTest {
   

     private static EJBContainer ejbContainer;
     private CoreServiceProvider crmprovider;
	    
     @BeforeClass
     public static void startTheContainer()
     {
    	 ejbContainer = EJBContainer.createEJBContainer();
    	 
     }
     @Before
     public void lookupABean() throws NamingException {
    	 Object object = ejbContainer.getContext().lookup("java:global/CRMServices/CoreServiceProvider");
    	 
         assertTrue(object instanceof CoreServiceProvider);
         crmprovider = (CoreServiceProvider) object;
     }
      
     
    

    @AfterClass
    public static void stopTheContainer() {
        if (ejbContainer != null) {
            ejbContainer.close();
        }
    }
    
	/**
	 * @see com.expensetracker.bean.SessionEJBBean#VerifyUser(String,String)
	 */
	@Test
	public void testAccount() throws RemoteException {
    
	}


    /**
     * @see com.expensetracker.bean.SessionEJBBean#VerifyUser(String,String)
     */
    @Test
    public void testVerifyUser() throws RemoteException {
        
        String Username = "TestAdmin1";
        String Password = "P@ssword1"; 
       
        try {
			CrmUser usr = crmprovider.VerifyUser(Username, Password);
			assertNotNull("CrmUser is not NULL", usr);

			assertTrue("*********Username is TestAdmin1 - passed ***********",
					(usr.getUsername().equals("TestAdmin1")));
			assertTrue(
					"***************Company = TestCompany - passed ************",
					(usr.getCrmCompany()
					.getName().equals("TestCompany")));
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

     
}
