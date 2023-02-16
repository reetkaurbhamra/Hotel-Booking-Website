/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab1exc3;


import java.util.ArrayList;

/**
 *
 * @author student
 */
class UserInfo {
    /*to be completed
    For now, we just add book info to make the example work. This class must be completed in future
    */
    
    private ArrayList <Bookings> custBookings = new ArrayList<>();
    
    public void addCustBooking(Bookings booking){
        custBookings.add(booking);
    }
    public ArrayList<Bookings> getCustBookings(){
        return custBookings;
    }
    
}
