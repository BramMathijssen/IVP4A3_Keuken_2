package main.java.datastorage;


import main.java.domain.Order;
import main.java.domain.Status;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.domain.Dish;

//Class that executes statements regarding the orders
public class OrderDAO {
    //Attributes
    private final DatabaseConnection dbc;
    private static final String SQL = "SQL: ";
    private static final String MID = "mealorderid";

    //Constructor
    public OrderDAO() {
        this.dbc = new DatabaseConnection();
    }

    //Methods
    public List<Order> findAcceptedOrders() {
        List<Order> activeOrders = new ArrayList<>();
        ResultSet activeRS = null;
        try {
            Statement st = con.createStatement();
            String query = "SELECT * FROM `findacceptedorders`;";
            activeRS = st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, SQL, ex);
        }

        try {
            while (activeRS.next()) {
                Order order = new Order();
                order.setTableNr(activeRS.getInt("tableid"));
                order.setOrderId(activeRS.getInt(MID));
                order.setMaxCookingTime(activeRS.getInt("cookingtime"));
                order.setEndTime(activeRS.getLong("endtime"));
                order.setStatus(Status.ACCEPTED);
                
                activeOrders.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, SQL, ex);
        }
        return activeOrders;
    }

    public List<Order> findPlacedOrders() {
        List<Order> placedOrders = new ArrayList<>();
        ResultSet placedRS = null;
        try {
            DatabaseConnection connection = new DatabaseConnection();
            
            connection.openConnection();
            
            String query = "SELECT * FROM `kitchenorder` JOIN `kitchenorder_dish` ON kitchenorder.id = kitchenorder_dish.kitchenOrderId JOIN dish ON kitchenorder_dish.dishId = dish.id WHERE kitchenorder.statusId = 1";
            ResultSet resultset = connection.executeSQLSelectStatement(query);
            
            int prevId = 0;
            Order prevOrder = null;
            
            while (resultset.next()) {
                int idFromDb = resultset.getInt("id");
                Date orderDateFromDb = resultset.getDate("orderDate");
                int statusIdFromDb = resultset.getInt("statusId");
                int dishIdFromDb = resultset.getInt("dishId");
                String dishNameFromDb = resultset.getString("dishName");
                
                if (prevId != idFromDb) {
                    Order order = new Order(idFromDb, orderDateFromDb, statusIdFromDb);
                    placedOrders.add(order);
                    order.addDish(new Dish(dishIdFromDb, dishNameFromDb));
                    prevOrder = order;
                }
                else {
                    prevOrder.addDish(new Dish(dishIdFromDb, dishNameFromDb));
                }
                
                prevId = idFromDb;
            }
            
            connection.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, SQL, ex);
        }
        return placedOrders;
    }

    public void setAccepted(int orderId, long endTime) {
        try {
            Statement st = con.createStatement();
            String query = "UPDATE `mealorder` SET status='accepted', `endtime` = " + endTime + " WHERE `mealorderid` = " + orderId + ";";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, SQL, ex);
        }
    }
    
    public void linkEmployee(int employeeid, int mealid, int mealorderid){
        try{
            Statement st = con.createStatement();
            String query = "UPDATE `mealorder_meal` SET `employeeid` = " + employeeid + " WHERE `mealid` = " + mealid + " AND mealorderid = " + mealorderid + ";";
            st.executeUpdate(query);
        } catch(SQLException ex){
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, SQL, ex);
        }
    }

    public void setReady(int orderId) {
        try {
            Statement st = con.createStatement();
                String query = "UPDATE `mealorder` SET status='ready' WHERE `mealorderid` = " + orderId + ";";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, SQL, ex);
        }
    }
    
    
        
    
}