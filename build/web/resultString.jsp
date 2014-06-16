<%-- 
    Document   : getResult
    Created on : 2011/5/1, 下午 01:43:55
    Author     : leo
--%>
<%@page contentType="text/xml"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>

<% String ContextPath = request.getContextPath(); %>
<%		
	String resultString = (String) request.getAttribute("resultString");	
	
	if (resultString == null) {
		resultString = "";
	}
%>

<%=resultString%>
