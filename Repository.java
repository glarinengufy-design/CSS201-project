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

    public void addProduct() {
        System.out.println("Please select the product category");
        String category = scanner.nextLine();

        System.out.println("Please enter the product name");
        String name = scanner.nextLine();

        System.out.println("Please enter the product price");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Please enter the quantity");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        // Auto set availability based on quantity
        boolean available = quantity > 0;

        // Create new Product object
        Product product = new Product(
            "P" + (products.size() + 1), // auto ID
            name,
            category,
            price,
            quantity,
            available
        );

        // Store in product list
        products.add(product);

        System.out.println("Product added successfully!");
}


    public boolean removeProduct(String productId){

    }

    public void updateProduct() {
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

    public void viewProfile(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                System.out.println("\n=== User Profile ===");
                System.out.println("User ID: " + user.getUserId());
                System.out.println("Username: " + user.getUsername());
                System.out.println("Password: " + user.getPassword()); // consider masking for security
                System.out.println("Email: " + user.getEmail());
                System.out.println("Full Name: " + user.getFullName());
                System.out.println("Phone Number: " + user.getPhoneNumber());
                System.out.println("Address: " + user.getAddress());
                return;
            }
        }
        System.out.println("User not found.");
    }

    public void updateProfile(User user) {
        System.out.println("\n=== Current Profile ===");
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Full Name: " + user.getFullName());
        System.out.println("Phone Number: " + user.getPhoneNumber());
        System.out.println("Address: " + user.getAddress());

        System.out.print("\nWhich one do you want to update? (username, password, email, fullName, phoneNumber, address): ");
        String select = scanner.nextLine();

        switch (select.toLowerCase()) {
            case "username":
                System.out.print("Enter new username: ");
                user.setUsername(scanner.nextLine());
                break;
            case "password":
                System.out.print("Enter new password: ");
                user.setPassword(scanner.nextLine());
                break;
            case "email":
                System.out.print("Enter new email: ");
                user.setEmail(scanner.nextLine());
                break;
            case "fullname":
                System.out.print("Enter new full name: ");
                user.setFullName(scanner.nextLine());
                break;
            case "phonenumber":
                System.out.print("Enter new phone number: ");
                user.setPhoneNumber(scanner.nextLine());
                break;
            case "address":
                System.out.print("Enter new address: ");
                user.setAddress(scanner.nextLine());
                break;
            default:
                System.out.println("Invalid selection.");
                return;
        }

        System.out.println("Profile updated successfully!");
    }
}
