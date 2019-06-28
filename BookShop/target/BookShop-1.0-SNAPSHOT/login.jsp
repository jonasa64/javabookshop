<%-- 
    Document   : login
    Created on : 05-06-2019, 16:00:22
    Author     : Jonas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <title>login</title>
    </head>
    <body>
        
           <nav class="navbar navbar-expand-sm bg-light">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="login.jsp">Login</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="register.jsp">Register</a>
    </li>
  
  </ul>
        </nav>
        
        <%if(request.getAttribute("error") != null) {%>
           <h1> <%out.print(request.getSession().getAttribute("error"));%></h1>
        <%} else {%>
            <%out.print("");%>
<%}%>
        <form  class="form-group" method="post" action="UserServlet">
            <input class="form-control" type="text" name="username" placeholder="Enter username"/>
            <input class="form-control" type="password" name="password" placeholder="Enter password"/>
            <button class="btn btn-success" name="Valg" value="login" >login</button>
        </form>
    </body>
</html>
