/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.usersCRUD;
import persistence.bookingsCRUD;
import persistence.ratingsCRUD;
import persistence.hotelsCRUD;
import helper.UserInfo;
import helper.Bookings;
import helper.Hotels;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author student
 */
@WebServlet(name = "confirmBooking", urlPatterns = {"/confirmBooking"})
public class confirmBooking extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet confirmBooking</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Room has been successfully booked! " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
                       
        } catch (Exception ex){}
    }

    private ArrayList<Hotels> getListOfHotels(String uname, String password) throws Exception{
        hotelsCRUD h = new hotelsCRUD();
        return h.getAvailableHotels();
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
        try {
            processRequest(request, response);
            
            String username=(String) request.getParameter("username");
            String password=(String) request.getParameter("password");
            //HotelsAvailable aval = getListOfHotels(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            //response.sendRedirect("customerBookings.jsp");
            request.getSession().setAttribute("username", username);
            request.setAttribute("availableHotels", getListOfHotels(username, password));
            
            bookingsCRUD a = new bookingsCRUD();
            String date1 = "2023-10-11";
            String date2 = "2023-10-17";
            Date date3 = Date.valueOf(date1);
            Date date4 = Date.valueOf(date2);
            a.createUserBooking(1, 2,  date3, date4);
//           RequestDispatcher rd= request.getRequestDispatcher("customerBookings.jsp");
//            rd.forward(request, response); 
            response.sendRedirect("customerBookings.jsp");
               return;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(confirmBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(confirmBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(confirmBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(confirmBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(confirmBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
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
