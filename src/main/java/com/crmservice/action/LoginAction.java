package com.crmservice.action;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.crmservice.core.CRMCoreConstants;
import com.crmservice.core.CoreServiceProvider;
import com.crmservice.core.EMFactory;
import com.crmservice.core.ServletActionDefImpl;
import com.crmservice.persistance.CrmUser;


public class LoginAction extends ServletActionDefImpl {
  
  private static final String CONTENT_TYPE = "application/json";

  //private Context context; 
  public LoginAction() {
  
  
  //context = EJBContainer.createEJBContainer().getContext();
  
  
  }


  public boolean Create(HttpServletRequest _req, HttpServletResponse _res)   throws ServletException, IOException {
   
    _res.setContentType(CONTENT_TYPE);
    HttpSession hSession = null; 
    //RequestDispatcher rd = null;
    String strSignout = _req.getParameter("signout");
    if (strSignout != null && strSignout.equals("true")) {
      hSession = _req.getSession(false);
      if (hSession != null) {
        hSession.invalidate();
      }
      return true;
    }
    try {
      
      hSession = _req.getSession(true);
			CoreServiceProvider crmprovider = EMFactory.getSessionEJB();
			CrmUser usr = crmprovider.VerifyUser(
					(String) hSession.getAttribute("username"),
					(String) hSession.getAttribute("password"));
      if (usr != null) {
        System.out.println("Name = " + usr.getName());
        System.out.println("Company = " + usr.getCrmCompany().getName());
        hSession.setAttribute(CRMCoreConstants.SESSION_USER_ID, usr.getRowId());
        hSession.setAttribute(CRMCoreConstants.SESSION_USER, usr);
        hSession.setAttribute(CRMCoreConstants.SESSION_COMPANY, usr.getCrmCompany());
        hSession.setAttribute(CRMCoreConstants.SESSION_COMPANY_ID, usr.getCrmCompany().getRowId());
        hSession.setAttribute(CRMCoreConstants.SESSION_USER_NAME,usr.getName());
        hSession.setAttribute(CRMCoreConstants.SESSION_INVALID_CREDENTIALS,false);
        JSONObject obj = new JSONObject();
        obj.put(CRMCoreConstants.SESSION_USER_NAME, usr.getName());
        obj.put(CRMCoreConstants.SESSION_INVALID_CREDENTIALS, false);
        obj.put(CRMCoreConstants.SESSION_COMPANY, usr.getCrmCompany());
        mModel = obj; 
				return true;
			}
           
    } catch (Exception e) {
			mModel = null;
      e.printStackTrace(_res.getWriter());
			return false;
    }
    
		return false;
  }


  
}
