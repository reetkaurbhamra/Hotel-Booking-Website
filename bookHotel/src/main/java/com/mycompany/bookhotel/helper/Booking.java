/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookhotel.helper;

import java.sql.Date;

/**
 *
 * @author student
 */
public class Booking {
    int userID;
    int hotelID;
    Date startDate;
    Date endDate;

    public Booking(int userID, int hotelID, Date startDate, Date endDate) {
        this.userID = userID;
        this.hotelID = hotelID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
