import java.util.Scanner;

public class Customer extends User{
    private int customerId;
    private String customerName;

    public Customer(int userId, String username, String email, String password, String phoneNumber, String fullName, String role, int customerId, String customerName){
        super(userId, username, email, password, phoneNumber, fullName, role);
        this.customerId = customerId;
        this.customerName = customerName;
    }

    @Override
    public void showMenu(Repository repository) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Customer Menu ===");
        System.out.println("1. View profile");
        System.out.println("2. Update profile");
        System.out.println("3. List all products");
        System.out.println("4. Place order");
        System.out.println("5. View order history");
        System.out.println("6. Display order history");
        System.out.println("7. Browse products");
        System.out.println("8. View product by category");
        System.out.println("9. View product details");
        System.out.println("10. Exit");

        System.out.println("Please choose an option:");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                viewProfile(repository);
                showMenu(repository);
                break;
            case 2://s
                updateProfile(repository);
                showMenu(repository);   
                break;
            case 3:
                listAllProducts(repository);
                showMenu(repository);
                break;
            case 4:
                placeOrder(repository);
                showMenu(repository);
                break;
            case 5:
            //     viewOrderHistory();
                break;
            case 6:
            //     displayOrderHistory();
                break;  
            case 7:
                browseProduct(repository);
                showMenu(repository);
                break;      
            case 8:
                viewProductByCategory(repository);
                showMenu(repository);
                break;
            case 9:
                viewProductById(repository);
                showMenu(repository);
                break;
            case 10:
                System.out.println("Thank you for using Borneo Fresh Market. Goodbye!");
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
                break;
        }
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
        repository.updateProfile(this.username);
    }

    public void listAllProducts(Repository repository){
        repository.listAllProducts();
    }

    public void placeOrder(Repository repository){
        repository.placeOrder(this);
    }

    // public List<Order> viewOrderHistory(){

    // }

    // public void displayOrderHistory(){

    // }

    public void browseProduct(Repository repository){
        repository.browseProduct();
    }

    public void viewProductByCategory(Repository repository){
        repository.viewProductByCategory();
    }

    public void viewProductById(Repository repository){
        repository.viewProductById();
    }
}
