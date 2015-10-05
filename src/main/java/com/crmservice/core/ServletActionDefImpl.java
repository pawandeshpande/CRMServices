package com.crmservice.core;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public abstract class ServletActionDefImpl implements ServletAction {
     
    protected JSONObject mModel = null;
    
    public ServletActionDefImpl() {
        super();
    }
    
    
    public boolean Create(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException
    {return false; }
    public boolean Read(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException
    { return false; }
    public boolean Update(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException
    {return false;}
    public boolean Delete(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException
    {return false;}
   
    
    public JSONObject getModel() {
        return mModel; 
    }
    
    public void setDatabase(Connection _db) {
    }

    
}
