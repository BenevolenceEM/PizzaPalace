/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BusinessObject.Cart;
import BusinessObject.Customer;
import BusinessObject.CustomerList;
import BusinessObject.Orders;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pach3
 */
@WebServlet(name = "checkOut", urlPatterns = {"/check-out"})
public class CheckOutServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        System.out.println("**************************************");
        System.out.println("*****CheckOutServlet RUNNING*****");
        System.out.println("**************************************");
        
        PrintWriter out = response.getWriter();
            String fn, ln, em, phone,empId,oCode;
            Customer c1;
            HttpSession session = request.getSession();
            List<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cart-list");
            
            fn = request.getParameter("firstname");
            ln = request.getParameter("lastname");
            em = request.getParameter("email");
            phone = request.getParameter("phone");
            empId = "Admin";
            c1 = new Customer(fn,ln,em,phone);
            c1.insertDB(fn, ln, em, em, phone);
           
     
           if( cartList != null){
               for(Cart c: cartList){
                   Orders order = new Orders();
                   c.setStatus("Delivered");
                   order.InsertDB(c.getProductCode(), c1.getCustomerId(),empId, c.getProductCode(), c.getStatus(), c1.getEmail());
                   out.print(c.getQuantity());
               }
               session.setAttribute("customer", c1);
               response.sendRedirect("thankYou.jsp");
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