/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import helper.UserInfo;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author student
 */
public class usersCRUD {
    
    
    ArrayList<UserInfo> listofCust = new ArrayList<UserInfo>();
    
    private Connection getConnect() throws ClassNotFoundException, SQLException {
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
    
    public UserInfo getUserInfo(String user) throws ClassNotFoundException, SQLException {
        Connection conn = getConnect();
        UserInfo userInst = null;
        System.out.println("[OUTPUT FROM SELECT GETUSERS()]");
        try {            
            String query = "SELECT * FROM USERS WHERE username='" + user +"'";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            if (rs.next())
            {
                int userID = rs.getInt("userID");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(rs.getString("password"));
                int cardNum = rs.getInt("creditCardNumber");
                Date date = rs.getDate("expiryDate");
                int cvv = rs.getInt("CVV");
                boolean adminBool = rs.getBoolean("adminBool");   
                return new UserInfo(userID, username, password, cardNum, date, cvv, adminBool);
            }    
        }
        catch (SQLException ex)
        {
          System.err.println(ex.getMessage());
        }          
        return userInst;
    }    
    
    public void createUser(String user) throws ClassNotFoundException, SQLException {
        Connection conn = getConnect();
        System.out.println("[CREATING USER:]");
        String query = "SELECT * FROM USERS WHERE username=" + user;
        try
        {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                int userID = rs.getInt("userID");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int cardNum = rs.getInt("creditCardNumber");
                Date date = rs.getDate("expiryDate");
                int cvv = rs.getInt("CVV");
                boolean adminBool = rs.getBoolean("adminBool"); 
            }
        }
        catch (SQLException ex)
        {
          System.err.println(ex.getMessage());
        }
        conn.close();
    }
    
    public void updateUser() throws ClassNotFoundException, SQLException {
        Connection conn = getConnect();
    }
    
    public void deleteUser() throws ClassNotFoundException, SQLException {
        Connection conn = getConnect();
    }
    
}
