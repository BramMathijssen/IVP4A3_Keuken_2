/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bram
 */
public class Order {
    private int id;
    private Date date;
    private int status;
    private List<Dish> dishList;
    
    public Order(int id, Date date, int status){
        this.id = id;
        this.date = date;
        this.status = status;
        
        dishList = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }
    
    public Date getDate() {
        return date;
    }
    
    public int getStatus() {
        return status;
    }
    
    public List<Dish> getDishList() {
        return dishList;
    }
    
    public void addDish(Dish dish) {
        dishList.add(dish);
    }
}
