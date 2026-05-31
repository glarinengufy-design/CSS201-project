import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repository {
    private List<Product> products;
    private List<Order> orders;
    private List<User> users;
    Scanner scanner = new Scanner(System.in);

    public Repository(){
        products = new ArrayList<>();
        orders = new ArrayList<>();
        users = new ArrayList<>();
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

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addProduct() {
        System.out.println("\n=== Add Product ===");
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

        String expiryDate = null;
        String brand = null;

        switch(category){
            case "Vegetable":
                System.out.println("Please enter product expiry date");
                expiryDate= scanner.nextLine();
                Vegetable newVegetable = new Vegetable(
                    "V" + (products.size() + 1), // auto ID
                    name,
                    "Vegetable",
                    price,
                    quantity,
                    available,
                    expiryDate
                );
                products.add(newVegetable);
                break;
            
            case "Snack":
                System.out.println("Please enter product brand");
                brand = scanner.nextLine();
                Snack newSnack = new Snack(
                    "S" + (products.size() + 1), // auto ID
                    name,
                    "Snack",
                    price,
                    quantity,
                    available,
                    brand
                );
                products.add(newSnack);
                break;

            case "Fruit":
                System.out.println("Please enter product expiry date");
                expiryDate= scanner.nextLine();
                Fruit newFruit = new Fruit(
                    "F" + (products.size() + 1), // auto ID
                    name,
                    "Fruit",
                    price,
                    quantity,
                    available,
                    expiryDate
                );
                products.add(newFruit);
                break;

            case "Daily Product":
                System.out.println("Please enter product brand");
                brand = scanner.nextLine();
                DailyProduct newDailyProduct = new DailyProduct(
                    "D" + (products.size() + 1), // auto ID
                    name,
                    "Daily Product",
                    price,
                    quantity,
                    available,
                    brand
                );
                products.add(newDailyProduct);
                break;

            case "Household Necessities":
                System.out.println("Please enter product brand");
                brand = scanner.nextLine();
                HouseholdNecessities newHousehold = new HouseholdNecessities(
                    "H" + (products.size() + 1), // auto ID
                    name,
                    "Household Necessities",
                    price,
                    quantity,
                    available,
                    brand
                );
                products.add(newHousehold);
                break;
        }
        System.out.println("Product added successfully!");
}


    // public boolean removeProduct(String productId){

    // }

    public void updateProduct() {
        System.out.println("\n=== Update Product ===");
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

    // public void viewProductsAvailability(){

    // }

    public List<Product> listAllProducts() {
        System.out.println("\n=== Product List ===");

        for (Product p : products) {
            System.out.println("\nID: " + p.getProductId() );
            System.out.println("Name: " + p.getProductName());                   
            System.out.println("Category: " + p.getCategory());                  
            System.out.println("Price: RM" + p.getPrice());                  
            System.out.println("Quantity: " + p.getQuantity());                   
            System.out.println("Available: " + (p.isAvailability() ? "Yes" : "No"));                   
        }
        return products;
    }

    public Product browseProduct() {
        System.out.println("\n=== Browse Product ===");
        System.out.print("Please enter the product name: ");
        String inputName = scanner.nextLine();

        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(inputName)) {
                System.out.println("ID: " + p.getProductId() );
                System.out.println("Name: " + p.getProductName());                   
                System.out.println("Category: " + p.getCategory());                  
                System.out.println("Price: RM" + p.getPrice());                  
                System.out.println("Quantity: " + p.getQuantity());                   
                System.out.println("Available: " + (p.isAvailability() ? "Yes" : "No"));  
                return p;
            }
        }
        System.out.println("Product not found.");
        return null;
    }

    public List<Product>  viewProductByCategory(){
        System.out.println("\n=== View Products by Category ===");
        System.out.println("Please enter the product category: ");
        String inputCategory = scanner.nextLine();
        List<Product> productsInCategory = new ArrayList<>();

        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(inputCategory)) {
                System.out.println("ID: " + p.getProductId() );
                System.out.println("Name: " + p.getProductName());                   
                System.out.println("Category: " + p.getCategory());                  
                System.out.println("Price: RM" + p.getPrice());                  
                System.out.println("Quantity: " + p.getQuantity());                   
                System.out.println("Available: " + (p.isAvailability() ? "Yes" : "No"));  
                productsInCategory.add(p);
            }
        }
        if (productsInCategory.isEmpty()) {
            System.out.println("No products found in this category.");
        }
        return productsInCategory;
    }

    public Product viewProductById(){
        System.out.println("\n=== View Product Details ===");
        System.out.println("Please enter the product ID: ");
        String inputProductId = scanner.nextLine();

        for (Product p : products) {
            if (p.getProductId().equalsIgnoreCase(inputProductId)) {
                System.out.println("ID: " + p.getProductId() );
                System.out.println("Name: " + p.getProductName());                   
                System.out.println("Category: " + p.getCategory());                  
                System.out.println("Price: RM" + p.getPrice());                  
                System.out.println("Quantity: " + p.getQuantity());                   
                System.out.println("Available: " + (p.isAvailability() ? "Yes" : "No"));  
                return p;
            }
        }
        System.out.println("Product not found.");
        return null;
    }

    // public void addOrder(Order order){

    // }

    // public boolean removeOrder(String orderId){

    // }

    public Order viewOrderById(String orderId){
        System.out.println("\n=== View Order ===");
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

    // public List<Order> listAllOrders(){

    // }

    // public List<Order> viewOrdersByCustomer(int customerId){

    // }

    public Order placeOrder(Customer customer) {
        List<OrderItem> items = new ArrayList<>();
        String addMore = "Yes";

        System.out.println("\n=== Place Order ===");

        while (addMore.equalsIgnoreCase("Yes")) {
            System.out.print("Please enter the product name: ");
            String productName = scanner.nextLine();

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

            System.out.print("Please enter the product quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // consume newline

            // Create order item
            OrderItem item = new OrderItem(selectedProduct, quantity);
            items.add(item);

            System.out.print("Do you want to add more items? (Yes/No): ");
            addMore = scanner.nextLine();
        }

        // Calculate total for all items
        double totalPrice = 0;
        System.out.println("\n=== Order Summary ===");

        for (OrderItem item : items) {
            double subtotal = item.getProduct().getPrice() * item.getQuantity();
            totalPrice += subtotal;
            System.out.println(item.getProduct().getProductName() + " x " + item.getQuantity() +
                            " = RM " + subtotal);
        }
        System.out.println("Total Price: RM " + totalPrice);

        // Confirm order
        System.out.print("Confirm order? (Yes/No): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("Yes")) {
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


    // public List<Order> viewOrderHistory(){

    // }

    // public void displayOrderHistory(){

    // }

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
                return;
            }
        }
        System.out.println("User not found.");
    }

    public void updateProfile(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                System.out.println("\n=== User Profile ===");
                System.out.println("User ID: " + user.getUserId());
                System.out.println("Username: " + user.getUsername());
                System.out.println("Password: " + user.getPassword()); // consider masking for security
                System.out.println("Email: " + user.getEmail());
                System.out.println("Full Name: " + user.getFullName());
                System.out.println("Phone Number: " + user.getPhoneNumber());

                System.out.print("\nWhich one do you want to update? (username, password, email, fullName, phoneNumber): ");
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
                    default:
                        System.out.println("Invalid selection.");
                        return;
                }

                System.out.println("Profile updated successfully!");
            }
        }
    }
}
