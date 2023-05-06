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


@WebServlet(urlPatterns = {"/SigninServlet"})
public class SigninServlet extends HttpServlet {

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
        System.out.println("*****SigninServlet RUNNING*****");
        System.out.println("**************************************");
        
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        Customer c1 = new Customer();
        c1.selectEmail(email);
        System.out.println(c1.getEmail());
        System.out.println(c1.getPassword());
        
        HttpSession ses1;
        ses1 = request.getSession();
        ses1.setAttribute("c1", c1);
        System.out.println("Customer has been added to Session");
        c1.display();
        
        String EMAIL, PASS;
        EMAIL = c1.getEmail();
        PASS = c1.getPassword();
        System.out.println(EMAIL);
        System.out.println(PASS);
        
        boolean empty = (email.equals("") && password.equals(""));
        boolean valid = EMAIL.equals(email) && PASS.equals(password);
        System.out.println(empty);
        System.out.println(valid);
        
        if(empty) {
            response.sendRedirect("Signin.jsp?alert=empty");
        }
        else if(valid) {
            RequestDispatcher rd = request.getRequestDispatcher("ViewAccount.jsp");
            rd.forward(request, response);
        }
        else {
            response.sendRedirect("Signin.jsp?alert1=invalid");
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
