<%-- 
    Document   : index
    Created on : Apr 3, 2015, 2:21:56 AM
    Author     : NamIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="s" class="Model.SessionModel"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <% if(s.CheckSession(request)){
        RequestDispatcher rs = request.getRequestDispatcher("LoginController");
        rs.forward(request, response);
    }%>
        <center>
           <form action="LoginController" method="POST">
                <input type="text" name="user">
                <br>
               <input type="text" name="pass">
               <br>
               <input type="submit" value="Login" />
           </form>
       </center>
    </body>
</html>
