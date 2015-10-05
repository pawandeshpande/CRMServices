package com.crmservice.action;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.crmservice.core.CRMCoreConstants;
import com.crmservice.core.ServletActionDefImpl;


public class IllegalAction extends ServletActionDefImpl {
  
  private static final String CONTENT_TYPE = "application/json";

  //private Context context; 
  public IllegalAction() {
  
  }


  public boolean Create(HttpServletRequest _req, HttpServletResponse _res)   throws ServletException, IOException {
   
    _res.setContentType(CONTENT_TYPE);
    HttpSession hSession = null; 
    String strSignout = _req.getParameter("signout");
		if (strSignout != null && strSignout.equals("true")) {
			hSession = _req.getSession(false);
			if (hSession != null) {
				hSession.invalidate();}
			mModel = null;
			return true;}
    
		try{
			hSession = _req.getSession(true);
        JSONObject obj = new JSONObject();
        obj.put("ERROR", "Error Condition: Please contact your system Administrator");  
        obj.put(CRMCoreConstants.SESSION_INVALID_CREDENTIALS, false);
        mModel = obj; 
    } catch (Exception e) {
      e.printStackTrace(_res.getWriter());
    }
		return true;
  }


  
}
