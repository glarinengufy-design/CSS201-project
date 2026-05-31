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

    // public double calculateTotal(){
    //     double sum = 0;
    //     for (OrderItem item : items) {
    //         sum += item.calculateTotal();
    //     }
    //     return sum;
    // }

    // public boolean updateQuantity(String productId, int quantity) {
    //     for (OrderItem item : items) {
    //         if (item.getProduct().getProductId().equals(productId)) {
    //             // Update the quantity
    //             int newQuantity = item.getQuantity() + quantity; // add to existing
    //             if (newQuantity <= 0) {
    //                 System.out.println("Quantity must be greater than 0.");
    //                 return false;
    //             }
    //             item.setQuantity(newQuantity);

    //             // Recalculate total cost
    //             totalCost = calculateTotal();

    //             System.out.println("Quantity updated successfully. New quantity: " + newQuantity);
    //             return true;
    //         }
    //     }
    //     System.out.println("Product not found in order.");
    //     return false;
    // }
}
