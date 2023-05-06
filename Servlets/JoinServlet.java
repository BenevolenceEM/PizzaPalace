/*
Benevolence Ed-Malik
Pradsley D'Haiti
 */

import BusinessObject.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/JoinServlet"})
public class JoinServlet extends HttpServlet {

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
        System.out.println("*****JoinServlet RUNNING*****");
        System.out.println("**************************************");
        try {
        
        PrintWriter out = response.getWriter();
        
        HttpSession session;
        session = request.getSession();
        
        String FirstName = request.getParameter("fname");
        String LastName = request.getParameter("lname");
        String Email = request.getParameter("email");
        String Phone = request.getParameter("phone");
        String Password = request.getParameter("password");
        
        Customer c1 = new Customer();
        c1.selectEmail(Email);
        if(!"".equals(c1.getEmail())) {
            session.setAttribute("message", "Account with this email already exists.");
//            RequestDispatcher rd = request.getRequestDispatcher("Join.jsp");
//            rd.forward(request, response);
        }
        
        boolean isInserted = c1.insertDB(FirstName, LastName, Email, Phone, Password);
        String message = isInserted? "Account created succesfully": "Account creation failed";
        
        session.setAttribute("message", message);
        
//        c1.setFirstname(FirstName);
//        c1.setLastname(LastName);
//        c1.setEmail(Email);
//        c1.setPhone(Phone);
//        c1.setPassword(Password);
//        
//        c1.insertDB(FirstName, LastName, Email, Phone, Password);
        session.setAttribute("c1", c1);
        RequestDispatcher rd = request.getRequestDispatcher("Signin1.jsp");
        rd.forward(request, response);
        
        } catch (Exception e) {
            System.out.println("Error" + e);
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
