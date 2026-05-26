import java.util.Scanner;

public class Admin extends User{
    private Repository repository;

     public Admin(int userId, String username, String email, String password, String phoneNumber, String fullName, String role){
        super(userId, username, email, password, phoneNumber, fullName, role);
    }

    @Override
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Admin Menu ===");
        System.out.println("1. View profile");
        System.out.println("2. Update profile");
        System.out.println("3. Add product");
        System.out.println("4. Update product");
        System.out.println("5. List all products");
        System.out.println("6. View products availability");
        System.out.println("7. Remove product");
        System.out.println("8. Manage orders");
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
                addProduct();
                break;
            case 4:
                updateProduct();
                break;
            case 5:
                listAllProducts();
                break;
            case 6:
                // viewProductsAvailability();
                break;
            case 7:
                // removeProduct();
                break;
            case 8:
                // manageOrders();
                break;
            case 9:
                // browseProduct();
                break;  
            case 10:
                // viewProductByCategory();
                break;
            case 11:
                // viewProductDetails();
                break;
            case 12:
                System.out.println("Thank you for using Borneo Fresh Market. Goodbye!");
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
        }

        scanner.close();
    }

    public void viewProfile(){
        repository.viewProfile(username);
    }

    public void updateProfile(){
        repository.updateProfile(username);
    }

    public void addProduct() {
        repository.addProduct();
    }

    public void updateProduct(){
        repository.updateProduct();
    }

    public void listAllProducts(){
        repository.listAllProducts();
    }

    // public void viewProductsAvailability(){

    // }

    // public boolean removeProduct(String productId){

    // }

    // public void manageOrders(Order order){

    // }

    // public void browseProduct(Product product){

    // }

    // public void viewProductByCategory(String category){

    // }

    // public void viewProductDetails(String producTId){

    // }
}
