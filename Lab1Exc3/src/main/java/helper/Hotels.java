/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;
//      /\
import persistence.usersCRUD;
import persistence.bookingsCRUD;
import persistence.ratingsCRUD;
import persistence.hotelsCRUD;
import helper.UserInfo;
import helper.Bookings;
import business.HotelsAvailable;
import business.bookNew;
//     /m \
/** . / m  \
 *  . \ m  /
 *     \m /
 *      \/
 *
 * @author student
 */
public class Hotels {
    

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public int getRoomsAvailable() {
        return roomsAvailable;
    }

    public int getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }
    
    private final String hotelName;
    private final String hotelAddress;
    private final int roomsAvailable;
    private final int rating;
    private final double price;
    
    public Hotels(String hotelName, String hotelAddress, int roomsAvailable, int rating, double price) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.roomsAvailable = roomsAvailable;
        this.rating = rating;
        this.price = price;        
    }
}
