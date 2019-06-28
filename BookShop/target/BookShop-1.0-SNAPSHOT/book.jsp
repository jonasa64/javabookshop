<%-- 
    Document   : book
    Created on : 05-06-2019, 19:35:55
    Author     : Jonas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <title>Book</title>
    </head>
    <body>
          <%if(request.getSession().getAttribute("username") == null){%>
        <% response.sendRedirect("login.jsp");%>
        <%}%>
          
                  
                        <nav class="navbar navbar-expand-sm bg-light">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="userpage.jsp">your page</a>
    </li>
    <li>
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
          
        <div class="container">
            <div class="card">
              <p>Title <%out.print(request.getSession().getAttribute("title"));%></p>
            <p>Author <%out.print(request.getSession().getAttribute("author"));%></p>
            <p>Publish <%out.print(request.getSession().getAttribute("publish"));%></p>
            <p>Genre <%out.print(request.getSession().getAttribute("genre"));%></p>
            <p>price <%out.print(request.getSession().getAttribute("price"));%></p>
                
            </div>
         
            <%if(request.getSession().getAttribute("error") != null){%>
            <h3>error <%request.getSession().getAttribute("error");%></h3>
            <%}%>
            <form  class="form-group" method="post" action="OrderServlet">
                <input class="form-control" type="number" name="quatiny" placeholder="quatiny"/>
               <input type="hidden" name="user_id" value="<%out.print(request.getSession().getAttribute("userId"));%>"/>
                <input type="hidden" name="book_price" value="<%out.print(request.getSession().getAttribute("price"));%>"/>
                <input type="hidden" name="book_id" value="<%out.print(request.getParameter("bookId"));%>"/>
                <button class="btn btn-success" name="Valg" value="order">Order book</button>
                    
                
            </form>
        </div>
    </body>
</html>
