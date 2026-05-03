public class Customer extends User{
    private int customerId;
    private String customerName;

    public Customer(int userId, String username, String email, String password, String phoneNumber, String fullName, String address, String role, int customerId, String customerName){
        super(userId, username, email, password, phoneNumber, fullName, address, role);
        this.customerId = customerId;
        this.customerName = customerName;
    }

    @Override
    public void showMenu() {
        System.out.println("\n=== Customer Menu ===");
        System.out.println("1. Browse Products");
        System.out.println("2. View Product by Category");
        System.out.println("3. View Cart");
        System.out.println("4. Place Order");
        System.out.println("5. View Order History");
    }

    public int getCustomerId(){
        return customerId;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void viewProfile(){

    }

    public String updateProfile(String adminName, String email, String phoneNumber){

    }

    public Order placeOrder(){

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
