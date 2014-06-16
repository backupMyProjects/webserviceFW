/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ws.controller;

import javax.servlet.annotation.WebServlet;

/**
 *
 * @author leo
 * Annotation : 
 * Ref. Doc : http://tomcat.apache.org/tomcat-7.0-doc/servletapi/javax/servlet/annotation/WebServlet.html
 */
@WebServlet(name = "ControllerSample", urlPatterns = {"/getData"})
public class ControllerSample extends ControllerBase {
    @Override
    public String jobClassPath() {
        return "com.ws.module.getDataJobs";
    }
}
