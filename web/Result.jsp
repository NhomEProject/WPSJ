<%-- 
    Document   : Result
    Created on : Apr 1, 2015, 7:40:09 PM
    Author     : NamIT
--%>

<%@page import="Entity.StudentEntityBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="pmb" class="Model.StudentModelBean"></jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>
        <body>
        <% boolean check = Boolean.parseBoolean(request.getAttribute("check").toString());
            String result = null;
            if (check) {
                result = session.getAttribute("userName").toString();
            }
        %>
        <form action="LogoutController" method="get">
        Choice : <%if(check){%>
             <input type="submit" value="Logout" >
        <%}%>
        </form>
       
        <center>
            <h1>Wecome: <%=result%></h1>
            <br>
            <table border="1">
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Address</th>
                    <%ArrayList<StudentEntityBean> objs = null;
                    if(check){
                        objs = pmb.GetALL();
                    for (int i = 0; i < objs.size(); i++) {%>
                <tr>
                    <td><%=objs.get(i).getId()%></td>
                    <td><%=objs.get(i).getName()%></td>
                    <td><%=objs.get(i).getAge()%></td>
                    <td><%=objs.get(i).getAdđress()%></td>
                </tr> 

                <%}}%>
            </table>
            <br/>
           
        </center>
    </body>
</html>
