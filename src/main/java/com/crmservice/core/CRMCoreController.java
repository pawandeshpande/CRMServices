package com.crmservice.core;


import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;


public class CRMCoreController extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = -4382127896341085651L;
 
private JSONObject model = null; 
private String responseJSON = "";  
    


public void init() {
        /* Initialize shared resources */
	}

    public void doGet(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException {

    boolean json = false; 
    String accept = _req.getHeader("accept"); 
    if(accept != null && accept.contains("json"))json = true; 
    
    HttpSession session = null; 
    try {
			session = _req.getSession(false);
    	/* Wrap request object with helper */
        RequestUtil reqUtil = new RequestUtil(_req);
        /* Create an Action object based on request parameters */
			ServletAction action = reqUtil.getAction(_req
					.getParameter("action"));
        /* Pass the database connection to the action */

        /* Execute business logic */
        if (action != null && action.Read(_req, _res)) {
            /* Get appropriate model for action */
            model = action.getModel();
        }else
        {
            model = null; 
        }


        if(session!=null && model!= null){
        	  responseJSON = model.toString(3); 
            }else{
       responseJSON = "No Data Returned"; 
        }
        
        OutputStream out = _res.getOutputStream();
        out.write(responseJSON.getBytes()); 
        out.flush();
   
        
        
   } catch (Exception e) {
        e.printStackTrace(_res.getWriter());
        }
    
    }

    public void doPost(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException {

    HttpSession session = null; 
        try {
			session = _req.getSession(false);
			String strCrmData = _req.getParameter("crmdata");
			JSONObject jObj = new JSONObject(strCrmData); // this
																			// parses
																			// the
																			// json
			Iterator it = jObj.keys(); // gets all the keys

			while (it.hasNext()) {
				String key = (String) it.next(); // get key
				Object o = jObj.get(key); // get value
				session.setAttribute(key, o); // store in session
			}
			/* Wrap request object with helper */
            RequestUtil reqUtil = new RequestUtil(_req);
            /* Create an Action object based on request parameters */
			ServletAction action = reqUtil.getAction((String) session
					.getAttribute("action"));

            /* Pass the database connection to the action */
            /* Execute business logic */
            if (action != null && action.Create(_req, _res)) {
                /* Get appropriate model for action */
                model = action.getModel();
            }else
            {
                model = null; 
            }
            /* Execute business logic */

            if(session!=null && model!= null){
            	  responseJSON = model.toString(3); 
                }else{
           responseJSON = "No Data Returned"; 
            }
            
            OutputStream out = _res.getOutputStream();
            out.write(responseJSON.getBytes()); 
            out.flush();
       
              } catch (Exception e) {
            e.printStackTrace(_res.getWriter());
            }
    }

    public void destroy() {
        /* Clean up shared resources */

    }
}
