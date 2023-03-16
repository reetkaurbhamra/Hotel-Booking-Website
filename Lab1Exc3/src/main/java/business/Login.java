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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author student
 */
@WebServlet(name = "/Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    
        UserInfo uinfo = new UserInfo();
        
        usersCRUD user = new usersCRUD();
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
        //INSTANCE OF CLASS: USER
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.equals("/login")){
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/another.jsp").forward(request, response);
        }
        
    }

    public ArrayList<Bookings> userBookings(int userid) throws ClassNotFoundException{
        
       ArrayList<Bookings> uf= new ArrayList<>();   
        
       try {
           return bookingsCRUD.getCustBookings(userid);
           //uf.addCustBooking(new Bookings("Fiesta Inn", "Mexico City, Mexico", new SimpleDateFormat("YYYY-MM-dd").parse("2023-02-22"), new SimpleDateFormat("YYYY-MM-dd").parse("2023-02-30"), true));
           //uf.addCustBooking(new Bookings("Royal York", "Opp. Union Station, ViaRail and UP Express", new SimpleDateFormat("YYYY-MM-dd").parse("2023-11-20"), new SimpleDateFormat("YYYY-MM-dd").parse("2023-12-01"), false));
       } catch (Exception ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("Error");
       }
        return uf;
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String username=(String) request.getParameter("username");
        String password=(String) request.getParameter("password");
        
        
        try {
            uinfo = user.getUserInfo(username);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (uinfo==null){
            RequestDispatcher rd= request.getRequestDispatcher("another.jsp");
            rd.forward(request, response);
            response.sendRedirect("login.jsp");
        }
        else if(password.equals(uinfo.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            //response.sendRedirect("customerBookings.jsp");
            request.getSession().setAttribute("username", username);
            try {
                request.setAttribute("custBookingsInfo", userBookings(uinfo.getUserID()));
            } catch (ClassNotFoundException ex) {            }
            
            RequestDispatcher rd= request.getRequestDispatcher("customerBookings.jsp");
            rd.forward(request, response);
            
        } else {
            response.sendRedirect("login.jsp");
        }
        return;
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
