/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import helper.hotels;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public class HotelsAvailable {
    ArrayList<hotels> hotelsAvailable = new ArrayList<>();
    
    public void addHotel(hotels hotel){
        hotelsAvailable.add(hotel);
    }
    public ArrayList<hotels> getListOfHotels(){
        return hotelsAvailable;
    }
}
