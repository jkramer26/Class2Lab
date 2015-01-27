<%-- 
    Document   : PageGenerator2
    Created on : Jan 22, 2015, 2:05:54 PM
    Author     : jkramer26
--%>
<%-- this is a page that has a type content and certain encoding. Can add java code to this page --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String color = request.getParameter("color");  
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="color: <%= color %>">This is a JSP table</h1>
        <table border="1">
            <% 
                for (int j = 0; j < 3; j++) {
                    out.println("<tr>");
                        for (int g = 0; g < 3; g++ ) {
                            out.println("<td>");
                            out.println("</td>");
                            
                        }
                    out.println("</tr>");
                }
            %>
        </table>
    </body>
</html>
