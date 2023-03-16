/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
import persistence.usersCRUD;
import persistence.bookingsCRUD;
import persistence.ratingsCRUD;
import persistence.hotelsCRUD;
import helper.UserInfo;
import helper.Bookings;
import helper.hotels;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author student
 */
@WebServlet(name = "bookNew", urlPatterns = {"/bookNew"})
public class bookNew extends HttpServlet {

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
        
    }
    
    private HotelsAvailable getListOfHotels(String uname, String password) throws Exception{
         hotelsCRUD h = new hotelsCRUD();
         return h.getAvailableHotels();
//       HotelsAvailable h= new HotelsAvailable();   
//       h.addHotel(new hotels("Hyatt Regency","Toronto",4,4,400.00));
//       h.addHotel(new hotels("Fairmount","Toronto",4,5,220.00));
//       h.addHotel(new hotels("Sandman Oakville", "Oakville", 30, 3, 100.99));
//       h.addHotel(new hotels("Marriot", "Toronto", 45, 4, 150.50));
//       h.addHotel(new hotels("Royal York", "Montreal", 300, 2, 200.50));
//       h.addHotel(new hotels("RoseBud Motel", "Schitt's Creek", 2, 3, 50.99));
//       h.addHotel(new hotels("Stevie Bud Hotel", "Schitt's Creek", 3, 2, 10.50));
//       h.addHotel(new hotels("Alexis", "New York", 0, 2, 75));
//       return h;
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
            HotelsAvailable aval = getListOfHotels(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            //response.sendRedirect("customerBookings.jsp");
            request.getSession().setAttribute("username", username);
            request.setAttribute("availableHotels", aval.getListOfHotels());
            
            RequestDispatcher rd= request.getRequestDispatcher("bookHotel.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(bookNew.class.getName()).log(Level.SEVERE, null, ex);
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
