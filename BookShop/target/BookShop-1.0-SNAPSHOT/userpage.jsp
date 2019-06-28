<%-- 
    Document   : userpage
    Created on : 05-06-2019, 16:44:20
    Author     : Jonas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="facadeImpl.UserFacadeImpl , entity.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>user Page</title>
             <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>
    <body>
        
        <%if(request.getSession().getAttribute("username") == null){%>
        <% response.sendRedirect("login.jsp");%>
        <%}%>
            
                <nav class="navbar navbar-expand-sm bg-light">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="books.jsp">View Books</a>
    </li>
    
    <li>
        <a class="nav-link" href="#">logged is as <%out.print(request.getSession().getAttribute("username"));%></a>
    </li>
    <li>
        <a class="nav-link" href="#">blance is <%out.print(request.getSession().getAttribute("amout"));%></a>
    </li>
    <li>
        <a class="nav-link"><form method="post" action="UserServlet">
              <button class="btn btn-danger" name="Valg" value="logout">Log out</button>
              
          </form></a>   
    </li>
  </ul>
        </nav>

          
        
   

       
          
          <form method="post" action="UserServlet">
              <input  class="form-group"  class="form-control" type="number" name="blance" placeholder="add to blance"/>
              <input type="hidden" name="id" value="<%out.print(request.getSession().getAttribute("userId"));%>"/>
              
              <button class="btn btn-success" name="Valg" value="add">add to blance</button>
              
              
          </form>
          
    </body>
</html>
