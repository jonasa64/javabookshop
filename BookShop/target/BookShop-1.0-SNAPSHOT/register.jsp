<%-- 
    Document   : register
    Created on : 05-06-2019, 16:01:30
    Author     : Jonas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <title>register</title>
    </head>
    <body>
        <form class="form-group" method="post" action="UserServlet">
            <input class="form-control" type="text" name="username" placeholder="Enter Username"/>
            <input class="form-control" type="password" name="password" placeholder="Enter password"/>
            <input class="form-control" type="number" name="blacne" placeholder="Enter blance" min="100" max="500"/>
            <button  class="btn btn-success" name="Valg" value="register">Register</button>
        </form>
    </body>
</html>
