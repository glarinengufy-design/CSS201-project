import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repository {
    private List<Product> products;
    private List<Order> orders;
    private List<User> users;
    Scanner scanner = new Scanner(System.in);

    public Repository(List<Product> products,List<Order> orders, List<User> users){
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public List<Product> getProducts(){
        return products;
    }

    public List<Order> getOrders(){
        return orders;
    }

    public List<User> getUsers(){
        return users;
    }

    public void addUser(User user) { 
        users.add(user); 
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public boolean removeProduct(String productId){

    }

    public void updateProduct(Product product) {
        System.out.print("Please enter the Product ID: ");
        String productId = scanner.nextLine();

        // Find product by ID
        Product productToUpdate = null;
        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                productToUpdate = p;
                break;
            }
        }

        if (productToUpdate == null) {
            System.out.println("Product not found.");
            return;
        }

        // Show current details
        System.out.println("Current details:");
        System.out.println("Name: " + productToUpdate.getProductName());
        System.out.println("Category: " + productToUpdate.getCategory());
        System.out.println("Price: " + productToUpdate.getPrice());
        System.out.println("Quantity: " + productToUpdate.getQuantity());
        System.out.println("Availability: " + productToUpdate.isAvailability());

        // Ask what to update
        System.out.print("Which one do you want to update (name/category/price/quantity/availability)? ");
        String select = scanner.nextLine();

        if (select.equalsIgnoreCase("name")) {
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            productToUpdate.setProductName(newName);
        } else if (select.equalsIgnoreCase("category")) {
            System.out.print("Enter new category: ");
            String newCategory = scanner.nextLine();
            productToUpdate.setCategory(newCategory);
        } else if (select.equalsIgnoreCase("price")) {
            System.out.print("Enter new price: ");
            double newPrice = scanner.nextDouble();
            scanner.nextLine();
            productToUpdate.setPrice(newPrice);
        } else if (select.equalsIgnoreCase("availability")) {
            System.out.print("Enter availability (true/false): ");
            boolean newAvailability = scanner.nextBoolean();
            scanner.nextLine();
            productToUpdate.setAvailable(newAvailability);
        } else if(select.equalsIgnoreCase("quantity")){
            System.out.print("Enter new quantity: ");
            int newQuantity = scanner.nextInt();
            scanner.nextLine();
            productToUpdate.setQuantity(newQuantity);
        } else {
            System.out.println("Invalid choice.");
        }

        System.out.println("Product updated successfully!");
    }

    public void viewProductsAvailability(){

    }

    public List<Product> listAllProducts() {
        System.out.println("\n=== Product List ===");
        for (Product p : products) {
            System.out.println("ID: " + p.getProductId() );
            System.out.println("Name: " + p.getProductName());                   
            System.out.println("Category: " + p.getCategory());                  
            System.out.println("Price: RM" + p.getPrice());                  
            System.out.println("Quantity: " + p.getQuantity());                   
            System.out.println("Available: " + (p.isAvailability() ? "Yes" : "No"));                   
        }
        return products;
    }

    public List<Product>  viewProductByCategory(String category){

    }

    public Product viewProductById(String producTId){

    }

    public void addOrder(Order order){

    }

    public boolean removeOrder(String orderId){

    }

    public Order viewOrderById(String orderId){
        System.out.print("Please enter the Order ID: ");
        String inputOrderId = scanner.nextLine();

        for (Order o : orders) {
            if (o.getOrderId().equals(inputOrderId)) {
                System.out.println("\n=== Order Details ===");
                System.out.println("Order ID: " + o.getOrderId());
                System.out.println("Customer: " + o.getCustomer().getCustomerName());
                System.out.println("Order Date: " + o.getOrderDate());
                
                System.out.println("\nPurchased Items:");
                for (OrderItem item : o.getItems()) {
                    System.out.println("- " + item.getProduct().getProductName() +
                                       " | Quantity: " + item.getQuantity() +
                                       " | Subtotal: $" + item.calculateTotal());
                }

                System.out.println("Total Cost: $" + o.getTotalCost());
                return o;
            }
        }

        System.out.println("Order not found.");
        return null;
    }

    public List<Order> listAllOrders(){

    }

    public List<Order> viewOrdersByCustomer(int customerId){

    }

    public Order placeOrder(Customer customer){
        System.out.print("Please enter the product name: ");
        String productName = scanner.nextLine();

        System.out.print("Please enter the product quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Find product
        Product selectedProduct = null;
        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(productName)) {
                selectedProduct = p;
                break;
            }
        }

        if (selectedProduct == null) {
            System.out.println("Product not found.");
            return null;
        }
        // Calculate total
        double totalPrice = selectedProduct.getPrice() * quantity;
        System.out.println("Total Price: $" + totalPrice);

        System.out.print("Confirm order? (Yes/No): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("Yes")) {
            // Create order item
            OrderItem item = new OrderItem(selectedProduct, quantity);
            List<OrderItem> items = new ArrayList<>();
            items.add(item);

            // Create order
            Order order = new Order(
                "O" + (orders.size() + 1), // simple ID
                customer,
                items,
                java.time.LocalDateTime.now(),
                totalPrice
            );
            orders.add(order);
            System.out.println("Order placed successfully!");
            return order;
        } else if (confirm.equalsIgnoreCase("No")) {
            System.out.println("Order cancelled.");
            return null;
        } else {
            System.out.println("Invalid input. Please enter Yes or No.");
            return null;
        }
    }
    

    public List<Order> viewOrderHistory(){

    }

    public void displayOrderHistory(){

    }
}
