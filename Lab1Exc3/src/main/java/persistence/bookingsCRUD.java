/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import helper.UserInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import helper.Bookings;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public class bookingsCRUD {
    
    private static ArrayList <Bookings> custBookings = new ArrayList<>();
    
    private static Connection getConnect() throws ClassNotFoundException, SQLException {
        Connection conn = null; 
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC", "root", "student");
           System.out.println("Connection Established");
       }catch(Exception e){
           System.out.println("Where is your JBDC driver");
           e.printStackTrace();
           throw e;
       }
       return conn;
    }
    
    public static ArrayList<Bookings> getCustBookings(int userid) throws ClassNotFoundException, SQLException {
        Connection conn = getConnect();
        //Bookings custBooking = null;
        System.out.println("[OUTPUT FROM SELECT getCustBookings()]");
        try {            
            String query = "SELECT HOTELS.hotelName AS hotelName, HOTELS.location AS location, BOOKINGS.startDate AS startDate, BOOKINGS.endDate AS endDate " +
                            "FROM HOTELS " +
                            "JOIN BOOKINGS ON HOTELS.hotelID = BOOKINGS.hotelID " +
                            "AND BOOKINGS.userID = " + userid +
                            " ORDER BY BOOKINGS.bookingID";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                custBookings.add(new Bookings(rs.getString("hotelName"), rs.getString("location"), rs.getDate("startDate"), rs.getDate("endDate"),true));                  
            }   
            return custBookings;
        }
        catch (SQLException ex)
        {
          System.err.println(ex.getMessage());
        }          
        return custBookings;
    }    
    
    public void createUserBooking(int userID, int hotelID, Date startDate, Date endDate) throws ClassNotFoundException, SQLException {
        Connection conn = getConnect();
        System.out.println("[OUTPUT FROM SELECT createUserBooking()]");
        try {
            String query = "INSERT INTO BOOKINGS VALUES(" +  getLastBookingID() + "," + userID + "," + hotelID + "," + "'" + startDate  + "'" + "," + "'" + endDate + "'" + ")";
            PreparedStatement st = conn.prepareStatement(query);
            int rs = st.executeUpdate();  
            return;
        }
        catch (SQLException ex)
        {
          System.err.println(ex.getMessage());
        }          
        return;
    }
    
    private int getLastBookingID() throws ClassNotFoundException, SQLException{
        Connection conn = getConnect();
        System.out.println("getlastbookingID");
        int rs_1 = 100;
        String currentMaxBookingNumber = "SELECT MAX(bookingID) AS maxID FROM BOOKINGS";
        try{
            PreparedStatement sub_st = conn.prepareStatement(currentMaxBookingNumber);
            ResultSet rs_0 = sub_st.executeQuery();  
            if (rs_0.next()){
                rs_1 = rs_0.getInt("maxID")+1;
            }
        }
        catch (SQLException ex)
        {
          System.err.println(ex.getMessage());
        }
        return rs_1;
    }
    
    protected void updateUserBooking() throws ClassNotFoundException, SQLException {
        getConnect();
    }
    
    public void deleteUserBooking(int bookingid) throws ClassNotFoundException, SQLException {
        Connection conn = getConnect();
        System.out.println("[OUTPUT FROM SELECT deleteUserBooking()]");
        try {            
            String query = "DELETE FROM BOOKINGS WHERE bookingID = "+ bookingid;
            PreparedStatement st = conn.prepareStatement(query);
            int rs = st.executeUpdate();  
            return;
        }
        catch (SQLException ex)
        {
          System.err.println(ex.getMessage());
        }          
        return;
    }
}
