package main.java.businesslogic;


import main.java.datastorage.IngredientDAO;
import main.java.datastorage.OrderDAO;
import main.java.domain.Ingredient;
import main.java.domain.Order;
import main.java.domain.Status;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Bram
 */
public class OrderManager {
    //Attributes
    private final OrderDAO orderDAO;
    private final IngredientDAO ingredientDAO;
    private List<Order> placedOrders, acceptedOrders;

    //Constructor
    public OrderManager() {
        this.orderDAO = new OrderDAO();
        this.ingredientDAO = new IngredientDAO();
        this.placedOrders = new ArrayList<>();
        this.acceptedOrders = new ArrayList<>();
        
        findPlacedOrders();
    }

    //Getters
    public List<Order> getPlacedOrders() {
        return placedOrders;
    }

    public List<Order> getAcceptedOrders() {
        return acceptedOrders;
    }

    //Methods    
    public void findPlacedOrders() {
        this.placedOrders = orderDAO.findPlacedOrders();
    }

    public void findAcceptedOrders() {
        this.acceptedOrders = orderDAO.findAcceptedOrders();
    }

    public void readyOrder(Order o) {
        if(o.setStatus(Status.READY)){
            orderDAO.setReady(o.getOrderId());
        }
    }

    public void acceptOrder(Order o) {
        if(o.setStatus(Status.ACCEPTED)){
            orderDAO.setActive(o.getOrderId(), o.getEndTime());
        }
    }
    
    
    public void linkEmployee(int mealid, int employeeid, int mealorderid){
        orderDAO.linkEmployee(employeeid, mealid, mealorderid);
    }
    

}