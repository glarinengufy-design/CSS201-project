import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private Customer customer;
    private List<OrderItem> items;
    private LocalDateTime orderDate;
    private double totalCost;

    public Order(String orderId, Customer customer, List<OrderItem> items, LocalDateTime orderDate, double totalCost){
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.orderDate = orderDate;
        this.totalCost = totalCost;
    }

    public String getOrderId(){
        return orderId;
    }

    public Customer getCustomer(){
        return customer;
    }

    public List<OrderItem> getItems(){
        return items;
    }

    public LocalDateTime getOrderDate(){
        return orderDate;
    }

    public double getTotalCost(){
        return totalCost;
    }

}
