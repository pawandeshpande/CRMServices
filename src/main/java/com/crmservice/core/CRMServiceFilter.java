package com.crmservice.core;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
public class CRMServiceFilter implements Filter {
  private FilterConfig _filterConfig = null;

  public void init(FilterConfig filterConfig) throws ServletException {
    _filterConfig = filterConfig;
  }

  public void destroy() {
    _filterConfig = null;
  }

  public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain chain) {
    
    System.out.println("Authentication: Request received ...");
    boolean authorized = false;

    try {
      
      String strRelativeUrl = ((HttpServletRequest)request).getServletPath();
      int i = strRelativeUrl.lastIndexOf("/");
      String sDir = strRelativeUrl.substring(0, i);
      
      if (request instanceof HttpServletRequest) {
        HttpSession session = ((HttpServletRequest)request).getSession();
        if (session != null) {
          Boolean  invalidSession = (Boolean)session.getAttribute(CRMCoreConstants.SESSION_INVALID_CREDENTIALS);
          String qryStr = ((HttpServletRequest)request).getQueryString();


					// if (((invalidSession != null) && (sDir.equals("/" +
					// CRMCoreConstants.SERVLET_URL_MAPPING) ) &&
					// (false == invalidSession.booleanValue())) ||
					// ("cLogin".equalsIgnoreCase(qryStr))) {
					// authorized = true;
					// }
					authorized = true; // need to remove this line after
										// testing.
        }
      }

      if (authorized) {
        chain.doFilter(request, response);
      } else if (_filterConfig != null) {
        ServletContext context = _filterConfig.getServletContext();
        String login_page = context.getInitParameter("login_page");
        System.out.print("Authentication: Login page = " + login_page);
        if (login_page != null && !"".equals(login_page)) {
          context.getRequestDispatcher(login_page).forward(request, response);
        }
      } else {
        throw new ServletException("Unauthorized access, unable to forward to login page");
      }
    } catch (IOException io) {
      System.out.println("IOException raised in AuthenticationFilter");
      io.printStackTrace();
    } catch (ServletException se) {
      System.out.println("ServletException raised in AuthenticationFilter");
      se.printStackTrace();
    }
    System.out.print("Authentication: Response dispatched ...");
  }


  


}
