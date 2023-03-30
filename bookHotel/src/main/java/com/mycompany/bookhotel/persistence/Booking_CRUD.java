/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookhotel.persistence;

import com.mycompany.bookhotel.helper.Booking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author student
 */
public class Booking_CRUD {
    Connection conn = null;
    
    private static Connection connect() throws SQLException, Exception {
        Connection conn = null; 
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/searchHotel?autoReconnect=true&useSSL=false", "root", "student");
           System.out.println("Connection Established");
        } catch(Exception e) {
           System.out.println("Where is your JBDC driver");
           e.printStackTrace();
           throw e;
        }
        return conn;
    }
    
    public static ArrayList<Booking> getUserBookings(int userID) throws SQLException, Exception {
        Connection conn = connect();
        ArrayList<Booking> bookings = new ArrayList<>();
        
        try {
            // query hotel -- FIX
            String q = "SELECT * FROM BOOKING WHERE userID = " + userID;
        
            PreparedStatement ps = conn.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                int hotelID = rs.getInt("hotelID");
                Date startDate = rs.getDate("startDate"); // may need to use java.util.date insteadd of java.sql.date
                Date endDate = rs.getDate("endDate");
                
                bookings.add(new Booking(userID, hotelID, startDate, endDate));
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        conn.close();
        return bookings;
    }
    
    public static void createUserBooking(int userID, int hotelID, Date startDate, Date endDate) throws SQLException, Exception {
        Connection conn = connect();
        
        try {
            String q = "INSERT INTO BOOKINGS VALUES(" +  getLastBookingID() + "," + userID + "," + hotelID + ",'" + startDate  + "','" + endDate + "')";
            PreparedStatement st = conn.prepareStatement(q);
            int rs = st.executeUpdate();
        } catch (SQLException ex) {
          System.err.println(ex.getMessage());
        }
    }

    private static int getLastBookingID() throws SQLException, Exception {
        Connection conn = connect();
        System.out.println("getlastbookingID");
        int rs_1 = 100;
        String currentMaxBookingNumber = "SELECT MAX(bookingID) AS maxID FROM BOOKINGS";
        try {
            PreparedStatement sub_st = conn.prepareStatement(currentMaxBookingNumber);
            ResultSet rs_0 = sub_st.executeQuery();  
            if (rs_0.next()) {
                rs_1 = rs_0.getInt("maxID")+1;
            }
        } catch (SQLException ex) {
          System.err.println(ex.getMessage());
        }
        return rs_1;
    }
}
