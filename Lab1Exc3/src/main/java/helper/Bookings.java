/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;
import java.util.Date;

/**
 *
 * @author student
 */
public class Bookings {
    
    public boolean isAvailable() {
        return true;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    private  boolean available;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
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
    String hotelName;
    String hotelAddress;
    Date startDate;
    Date endDate;
    

    /*
    To be completed
     */
    public Bookings(String hotelName, String hotelAddress, Date startDate, Date endDate, boolean isAvailable) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.startDate = startDate;
        this.endDate = endDate;
        this.available = isAvailable;
    }
}
