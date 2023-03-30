/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.helper;



/**
 *
 * @author student
 */
public class Room {
    private int hotelID;
    private int roomID;
    private int capacity;

    public Room(int hotelID, int roomID, int capacity) {
        this.hotelID = hotelID;
        this.roomID = roomID;
        this.capacity = capacity;
    }
    
    
    
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getroomID() {
        return roomID;
    }

    public void setroomID(int roomID) {
        this.roomID = roomID;
    }
}
