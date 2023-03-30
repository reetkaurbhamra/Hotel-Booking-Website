/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookhotel.business;

import com.mycompany.bookhotel.helper.BookingsXML;
import com.mycompany.bookhotel.persistence.Booking_CRUD;
import java.sql.Date;

/**
 *
 * @author student
 */
public class BookingBusiness {
    
    public BookingsXML getBookingsByUser(int userID) throws Exception {
        BookingsXML bx = new BookingsXML();
        bx.setBookings(Booking_CRUD.getUserBookings(userID));
        return bx;
    }
    
    public void setBookings(int userID, int hotelID, Date startDate, Date endDate) throws Exception {
        Booking_CRUD.createUserBooking(userID, hotelID, startDate, endDate);
    }
}
