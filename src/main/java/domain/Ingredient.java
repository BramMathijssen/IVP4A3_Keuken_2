package main.java.domain;
/**
 *
 * @author Bram
 */
public class Ingredient {
    // Attributen
    private int amount, inStock;
    private String name;
    
    // Constructor    
    public Ingredient(int amount, int inStock, String name) {
        this.amount = amount;
        this.inStock = inStock;
        this.name = name;
    }
    
    // Getters    
    public int getInStock() {
        return inStock;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAmount(){
        return amount;
    }
    
    // Setters    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setCurrentStock(int intStock) {
        this.inStock = inStock;
    }
    
    //Methoden 
    public void addAmount(int amount) {
        this.amount += amount;
    }
    
    public void removeAmount(int amount) {
        this.amount -= amount;
    }
}
