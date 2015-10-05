package com.crmservice.core;


import javax.servlet.*;
import javax.servlet.http.*;

import org.json.JSONObject;

import java.io.*;
import java.sql.*;


public interface ServletAction {
    
    /* Set Database Connection */

    abstract void setDatabase(Connection _db);
    /* Execute business logic */

    abstract boolean Create(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException;
    abstract boolean Read(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException;
    abstract boolean Update(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException;
    abstract boolean Delete(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException;
        
    /* Return a JavaBean containing the model (data) */

    abstract JSONObject getModel();
}
