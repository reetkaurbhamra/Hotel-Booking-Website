/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import helper.Hotels;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public class HotelsAvailable {
    ArrayList<Hotels> hotelsAvailable = new ArrayList<>();
    
    public void addHotel(Hotels hotel){
        hotelsAvailable.add(hotel);
    }
    public ArrayList<Hotels> getListOfHotels(){
        return hotelsAvailable;
    }
}
