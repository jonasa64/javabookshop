/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.User;
import facadeImpl.UserFacadeImpl;
import javax.servlet.http.HttpSession;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author Jonas
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    UserFacadeImpl ufl = new UserFacadeImpl();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String valg = request.getParameter("Valg");
       
    
            User u;
            switch(valg){
                case "login":
                     String username = request.getParameter("username");
            String password = request.getParameter("password");
                    if(username.isEmpty() || password.isEmpty()){
                        request.getSession().setAttribute("error", "pleas chck your username and password");
                        response.sendRedirect("login.jsp");
                    } else {
                    u = ufl.loginUser(username, password);
                        request.getSession().setAttribute("userId", u.getId());
                        request.getSession().setAttribute("username", username);
                        request.getSession().setAttribute("amout", u.getBlance());
                     session.setAttribute("blance", u.getBlance());
                        request.getRequestDispatcher("userpage.jsp").forward(request, response);
                    }
                    
                    break;
                    
                case "logout":
                    request.getSession().invalidate();
                    response.sendRedirect("index.html");
                    break;
                   
                    case "register":
                        
                           String name = request.getParameter("username");
            String pass = request.getParameter("password");
            int b =  Integer.parseInt(request.getParameter("blacne"));
                    User user = new User(name, pass, b);
                        ufl.crateUser(user);
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    break;
                    
                    case "add":
                        int userId = Integer.parseInt(request.getParameter("id"));
                        int amountToAdd = Integer.parseInt(request.getParameter("blance"));
                      
                        ufl.addToToBlance(userId, amountToAdd);
                        User use = ufl.findeUser(userId);
                        request.getSession().setAttribute("amout", use.getBlance());
                        request.getRequestDispatcher("userpage.jsp").forward(request, response);
                        break;
           
            }
            
            
      
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>





}
