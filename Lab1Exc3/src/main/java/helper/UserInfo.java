/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author student
 */
public class UserInfo {
    /*to be completed
    For now, we just add book info to make the example work. This class must be completed in future
    */
    private int userID ;
    private String  username;
    private String password;
    private int creditCardNumber;
    private Date expiryDate;
    private int CVV;
    private boolean adminBool;
    
    private ArrayList <Bookings> custBookings = new ArrayList<>();

    
    public UserInfo(int userID, String uname, String passw, int creditCardNumber, Date expiryDate, int cvv, boolean admin){
        this.userID = userID;
        this.username= uname;
        this.password = passw;
        this.creditCardNumber = creditCardNumber;
        this.expiryDate = expiryDate;
        this.CVV = cvv;
        this.adminBool = admin;
    }
    public UserInfo () {}

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }    
    
    public void addCustBooking(Bookings booking){
        custBookings.add(booking);
    }
    public ArrayList<Bookings> getCustBookings(){
        return custBookings;
    }
    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public int getCVV() {
        return CVV;
    }

    public boolean isAdminBool() {
        return adminBool;
    }
    
}
