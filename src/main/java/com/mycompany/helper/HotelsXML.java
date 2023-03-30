/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.helper;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import com.mycompany.helper.Hotel;

@XmlRootElement(name = "hotels")
@XmlAccessorType (XmlAccessType.FIELD)
    public class HotelsXML{
    @XmlElement(name="hotel")
        private ArrayList<Hotel> hotels;

        public List<Hotel> getHotels(){
            return hotels;
        }

        public void setHotels(ArrayList<Hotel> hx){
            hotels = hx;
        }

    }