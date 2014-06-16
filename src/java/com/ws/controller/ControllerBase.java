/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ws.controller;

import LeoLib.tools.Toolets;
import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/**
 *
 * @author leo
 */
public abstract class ControllerBase extends ServletBase {
    static final String ERROR_TAG = "ERROR";
    static final String WRONG_OPERATION = "WRONG OPERATION";
    static final String OTHER_ERROR = "OTHER ERROR";
    
    public abstract String jobClassPath();
    
    @Override
    protected void processRequest()
            throws ServletException, IOException {
        String oper = Toolets.parmGetter(request, "oper");
        try {
            Class objC = Class.forName(jobClassPath());
            Method objM = objC.getMethod(
                    oper, 
                    new Class[]{
                        Class.forName("javax.servlet.http.HttpServletRequest"), 
                        Class.forName("javax.servlet.http.HttpServletResponse")}
            );
            objM.invoke(objC.newInstance(), new Object[]{request, response});
            controllerDispatchPageXML();
        } catch (java.lang.NoSuchMethodException e) {
            e.printStackTrace();
            this.dispatchPageXML("<"+ERROR_TAG+">" + WRONG_OPERATION + "</"+ERROR_TAG+">");
        } catch (Exception e) {
            e.printStackTrace();
            this.dispatchPageXML("<"+ERROR_TAG+">" + OTHER_ERROR + "</"+ERROR_TAG+">");
        }
    }
    
    protected void controllerDispatchPageXML() throws ServletException, IOException{
        response.setContentType(xmlHeader);
        (getServletConfig().getServletContext().getRequestDispatcher("/resultList.jsp")).include(request, response);
    }
}
