/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ws.controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leo
 */
public abstract class ServletBase extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected String htmlHeader = "text/html;charset=UTF-8";
    protected String xmlHeader = "text/xml;charset=UTF-8";
    protected enum ResultType {HTML, XML}
    
    protected abstract void processRequest() throws ServletException, IOException;
    
    protected void dispatchPageXML(List result) 
            throws ServletException, IOException{
        this.dispatchPageXML("/resultList.jsp", result);
    }
    
    protected void dispatchPageXML(String result) 
            throws ServletException, IOException{
        this.dispatchPageXML("/resultString.jsp", result);
    }
    
    protected void dispatchPageXML(String outputPage, Object result) 
            throws ServletException, IOException{
        this.dispatchPage(ResultType.XML, outputPage, result);
    }
    
    protected String dispatchPage(ResultType resultType, String outputPage, Object result) 
            throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        String log = "";
        if( ResultType.XML == resultType ){
            response.setContentType(xmlHeader);
            System.out.println(result.getClass().getName());
            if("java.lang.String".equals(result.getClass().getName())){
                request.setAttribute("resultString", result);
                log = "attrubite:resultString";
            }else{
                request.setAttribute("resultList", result);
                log = "attrubite:resultList";
            }
        }else{
            response.setContentType(htmlHeader);
            request.setAttribute("result", result);
            log = "attrubite:result";
        }
        
        RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher(outputPage);
        dispatcher.include(request, response);
        return log;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.request = request;
        this.response = response;
        processRequest();
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.request = request;
        this.response = response;
        processRequest();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
