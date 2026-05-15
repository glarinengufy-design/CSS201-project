import java.util.List;

public class Customer extends User{
    private int customerId;
    private String customerName;

    public Customer(int userId, String username, String email, String password, String phoneNumber, String fullName, String role, int customerId, String customerName){
        super(userId, username, email, password, phoneNumber, fullName, role);
        this.customerId = customerId;
        this.customerName = customerName;
    }

    @Override
    public void showMenu() {
        System.out.println("\n=== Customer Menu ===");
        System.out.println("1. View profile");
        System.out.println("2. Update profile");
        System.out.println("3. Place order");
        System.out.println("4. View order history");
        System.out.println("5. Display order history");
        System.out.println("6. View cart");
        System.out.println("7. Add to cart");
        System.out.println("8. Browse products");
        System.out.println("9. View product by category");
        System.out.println("9. View product details");
        System.out.println("10. Exit");
    }

    public int getCustomerId(){
        return customerId;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void viewProfile(Repository repository){
        repository.viewProfile(username);
    }

    public void updateProfile(Repository repository){
        repository.updateProfile(User user);
    }

    public void placeOrder(Repository repository){
        repository.placeOrder(Customer customer);
    }

    public List<Order> viewOrderHistory(){

    }

    public void displayOrderHistory(){

    }

    public void viewCart(){

    }

    public void addToCart(Product product, int quantity){

    }

    public void browseProduct(Product product){

    }

    public void viewProductByCategory(String category){

    }

    public void viewProductDetails(String producTId){

    }
}
