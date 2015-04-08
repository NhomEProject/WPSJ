<%-- 
    Document   : Result
    Created on : Apr 1, 2015, 7:40:09 PM
    Author     : NamIT
--%>

<%@page import="Entity.CartEntity"%>
<%@page import="Entity.ProductEntityBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="pmb" class="Model.ProductModelBean"></jsp:useBean>
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
                <th>Amount</th>
                <th>Price</th>
                <th>Action</th>
                    <%ArrayList<ProductEntityBean> objs = null;
                    if(check){
                        objs = pmb.GetByID(result);
                    for (int i = 0; i < objs.size(); i++) {%>
                <tr>
                    <td><%=objs.get(i).getId()%></td>
                    <td><%=objs.get(i).getName()%></td>
                    <td><%=objs.get(i).getAmount()%></td>
                    <td><%=objs.get(i).getPrice()%></td>
                    <td><a href="AddCart?id=<%=objs.get(i).getId()%>">By Product</a></td>
                </tr> 
                <%}}%>
            </table>
            <br/>
            <% 
                    int count = 0;
                    if(session.getAttribute("cart")!=null){
                        ArrayList<CartEntity> listCart= (ArrayList<CartEntity>) session.getAttribute("cart");
                        count = listCart.size();
                    }else{ count = 0;}
             %>
             Count Cart: <%=count%>
           
        </center>
    </body>
</html>
