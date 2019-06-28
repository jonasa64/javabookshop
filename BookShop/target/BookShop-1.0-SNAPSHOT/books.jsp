<%-- 
    Document   : books
    Created on : 05-06-2019, 19:35:38
    Author     : Jonas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, Data.BookMapper, entity.Book" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <title>Books</title>
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
        
         
       <%List<Book> books = new BookMapper().getAllBooks();%>
       <%for(int i = 0; i < books.size(); i++){%>
       <div>
           <p><%out.print(books.get(i).getId());%></p>
           <p><%out.print(books.get(i).getAuthor());%></p>
           <p><%out.print(books.get(i).getTitle());%></p>
           <form  method="post" action="BookServlet">
               <input type="hidden" name="bookId" value="<%out.print(books.get(i).getId());%>"/>
               <button  class="btn btn-success" name="Valg" value="view">View book</button>
           </form>
       </div>
       
       <%}%>
    </body>
</html>
