/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import helper.Bookings;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.HotelsAvailable;
import helper.hotels;

/**
 *
 * @author student
 */
public class hotelsCRUD {
    Connection conn = null;
    private Connection connect() throws SQLException, Exception {
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
    
    public HotelsAvailable getAvailableHotels() throws SQLException, Exception {
        Connection conn = connect();
        HotelsAvailable h= new HotelsAvailable(); 
        System.out.println("[OUTPUT FROM SELECT getAvailableHotels()]");
        try {            
            String query = "SELECT * FROM HOTELS";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                h.addHotel(new hotels(rs.getString("hotelName"),rs.getString("location"), rs.getInt("capacity"), rs.getInt("rating"), rs.getDouble("price")));                 
            }   
            return h;
        }
        catch (SQLException ex)
        {
          System.err.println(ex.getMessage());
        }          
        return h;
    }    
    
    protected void createHotel() throws SQLException {
        //connect();
    }
    
    protected void updateHotel() throws SQLException {
        //connect();
    }
    
    protected void deleteHotel() throws SQLException {
        //connect();
    }
}
