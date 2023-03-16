/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author student
 */
public class ratingsCRUD {
    protected void connect() throws SQLException {
        Connection conn = null; 
        try{
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    
    protected void getHotelRatings() throws SQLException {
        connect();
    }    
    
    protected void createHotelRatings() throws SQLException {
        connect();
    }
    
    protected void updateHotelRatings() throws SQLException {
        connect();
    }
    
    protected void deleteHotelRatings() throws SQLException {
        connect();
    }
}
