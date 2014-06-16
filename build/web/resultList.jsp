<%-- 
    Document   : getResult
    Created on : 2011/5/1, 下午 01:43:55
    Author     : leo
--%>
<%@page contentType="text/xml"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="LeoLib.tools.GeneralXmlPullParser" %>

<% String ContextPath = request.getContextPath(); %>
<%		
	ArrayList resultList = (ArrayList) request.getAttribute("resultList");	
	
	if (resultList == null) {
		resultList = new ArrayList();
	}
%>

<%=GeneralXmlPullParser.reverse(resultList)%>
