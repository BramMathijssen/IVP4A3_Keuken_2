/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.domain;

/**
 *
 * @author Bram
 */
public class Dish {
    private int id;
    private String dishName;
    
    public Dish(int id, String dishName) {
        this.id = id;
        this.dishName = dishName;
    }
    
    //Getters
    public int getId() {
        return id;
    }
    
    public String getDishName() {
        return dishName;
    }
}
