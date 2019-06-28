<%-- 
    Document   : yourOrders
    Created on : 05-06-2019, 22:40:48
    Author     : Jonas
--%>

<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Order, facadeImpl.OrderFacadeImpl, java.util.List, facadeImpl.BookFacadeImpl, entity.Book" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orders</title>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
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
        <%OrderFacadeImpl ofl = new OrderFacadeImpl();%>
        <%int id = Integer.parseInt(request.getParameter("user_id"));%>
       <%List<Order> orders = ofl.getOrderByUser(id);%>
       <%BookFacadeImpl bfl = new BookFacadeImpl();%>
       <%for(int i = 0; i < orders.size(); i++){%>
       <div class="container">
           <div class="card">
                   <p>Order id<%out.print(" " + orders.get(i).getId());%></p>
           <p>user id <%out.print(" " + orders.get(i).getUserId());%></p>
           <p>book id <%out.print(" " + orders.get(i).getBookId());%></p>
           <%Book b = bfl.getBookById(orders.get(i).getBookId());%>
           <p>title  <%out.print(b.getTitle());%></p>
           <p>total price <%out.print(" " + orders.get(i).getTotalPrice());%></p>
           <p>order date <%out.print(" " + orders.get(i).getOrderDate());%></p>
           <p>quatiay <%out.print(" " + orders.get(i).getQuatiay());%></p>
           </div>
           
       
       </div>
       <br/>
        
        <%}%>
    </body>
</html>
