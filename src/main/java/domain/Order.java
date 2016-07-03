/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.domain;

import java.sql.Date;

/**
 *
 * @author Bram
 */
public class Order {
    private int id;
    private Date date;
    private int status;
    
    public Order(int id, Date date, int status){
        this.id = id;
        this.date = date;
        this.status = status;
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
}
