/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.helper;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author student
 */
@XmlRootElement(name = "hotel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hotel {
    
    private int hotelID;
    private double price;
    private double rating;
    private String location;
    private String name;
    ArrayList<Room> rooms; //capacity of hotel is length of this arraylist

    public Hotel(int hotelID, double price, int capacity, int rating, String location, ArrayList<Room> rooms) {
        this.hotelID = hotelID;
        this.rating = rating;
        this.location = location;
        this.rooms = rooms;
    }
    public Hotel(int hotelID, double price, int capacity, int rating, String location) {
        this.hotelID = hotelID;
        this.rating = rating;
        this.location = location;
        this.rooms = rooms;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
        
    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
    
    public int getHotelCapacity(){
        return rooms.size();
    }
}
