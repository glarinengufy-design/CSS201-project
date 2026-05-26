import java.util.Scanner;

public class Customer extends User{
    private int customerId;
    private String customerName;
    private Repository repository;

    public Customer(int userId, String username, String email, String password, String phoneNumber, String fullName, String role, int customerId, String customerName){
        super(userId, username, email, password, phoneNumber, fullName, role);
        this.customerId = customerId;
        this.customerName = customerName;
    }

    @Override
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Customer Menu ===");
        System.out.println("1. View profile");
        System.out.println("2. Update profile");
        System.out.println("3. List all products");
        System.out.println("4. Place order");
        System.out.println("5. View order history");
        System.out.println("6. Display order history");
        System.out.println("7. View cart");
        System.out.println("8. Add to cart");
        System.out.println("9. Browse products");
        System.out.println("10. View product by category");
        System.out.println("11. View product details");
        System.out.println("12. Exit");

        System.out.println("Please choose an option:");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                viewProfile();
                break;
            case 2:
                updateProfile();
                break;
            case 3:
                listAllProducts();
                break;
            case 4:
                placeOrder();
                break;
            case 5:
            //     viewOrderHistory();
                break;
            case 6:
            //     displayOrderHistory();
                break;  
            case 7:
            //     viewCart();
                break;
            case 8:
            //     addToCart();
                break;
            case 9:
            //     browseProduct();
                break;      
            case 10:
            //     viewProductByCategory();
                break;
            case 11:
            //     viewProductDetails();
                break;
            case 12:
                System.out.println("Thank you for using Borneo Fresh Market. Goodbye!");
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
        }
    }

    public int getCustomerId(){
        return customerId;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void viewProfile(){
        repository.viewProfile(username);
    }

    public void updateProfile(){
        repository.updateProfile(this.username);
    }

    public void listAllProducts(){
        repository.listAllProducts();
    }

    public void placeOrder(){
        repository.placeOrder(this);
    }

    // public List<Order> viewOrderHistory(){

    // }

    // public void displayOrderHistory(){

    // }

    // public void viewCart(){

    // }

    // public void addToCart(Product product, int quantity){

    // }

    // public void browseProduct(Product product){

    // }

    // public void viewProductByCategory(String category){

    // }

    // public void viewProductDetails(String producTId){

    // }
}
