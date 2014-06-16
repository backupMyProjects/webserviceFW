<%-- 
    Document   : index
    Created on : 2014/5/22, 上午 11:40:57
    Author     : leo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Post Page</title>
    </head>
    <body>
        
        <form action="<%=request.getRequestURL()%>" method="POST">
            <h3>URL</h3>
            <% String urlPath = (String) request.getAttribute("urlPath"); %>
            <%if( null == urlPath || "".equals(urlPath) ){%>
                <input name="urlPath" size="100" value="http://localhost:<%=request.getLocalPort()%><%=request.getContextPath()%>/getData?oper=getAPI" />
            <%}else{%>
                <input name="urlPath" size="100" value="<%=urlPath%>" />
            <%}%>
            <h3>POST String</h3>
            <% String postString = (String) request.getAttribute("postString"); %>
            <%if( null == urlPath || "".equals(urlPath) ){%>
                <input name="postString" size="100" value="" />
            <%}else{%>
                <input name="postString" size="100" value="<%=postString%>" />
            <%}%>
            <br />
            <br />
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
