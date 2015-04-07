/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CheckLogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NamIT
 */
public class LoginController extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(true);
            if(session.getAttribute("userName")==null){
                CheckLogin check = new CheckLogin();
                String user = request.getParameter("user");
                String pass = request.getParameter("pass");
                if(check.check(user, pass)){
                    RequestDispatcher rd = request.getRequestDispatcher("Result.jsp");
                    request.setAttribute("check", true);
                    session.setAttribute("userName", user);
                    rd.forward(request, response);
                }else{
                    
                }
            }else{
                    String user = session.getAttribute("userName").toString();
                    RequestDispatcher rd = request.getRequestDispatcher("Result.jsp");
                    System.out.println(""+session.getId());
                    request.setAttribute("check", true);
                    session.setAttribute("userName", user);
                    rd.forward(request, response);
            }
        }
    }

 
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