import java.util.Scanner;

public class Admin extends User{
     public Admin(int userId, String username, String email, String password, String phoneNumber, String fullName, String role){
        super(userId, username, email, password, phoneNumber, fullName, role);
    }

    @Override
    public void showMenu(Repository repository) {
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
                viewProfile(repository);
                break;
            case 2:
                updateProfile(repository);
                break;
            case 3:
                addProduct(repository);
                break;
            case 4:
                updateProduct(repository);
                break;
            case 5:
                listAllProducts(repository);
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
                browseProduct(repository);
                break;  
            case 10:
                viewProductByCategory(repository);
                break;
            case 11:
                viewProductById(repository);
                break;
            case 12:
                System.out.println("Thank you for using Borneo Fresh Market. Goodbye!");
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
        }
    }

    public void viewProfile(Repository repository){
        repository.viewProfile(username);
    }

    public void updateProfile(Repository repository){
        repository.updateProfile(username);
    }

    public void addProduct(Repository repository) {
        repository.addProduct();
    }

    public void updateProduct(Repository repository){
        repository.updateProduct();
    }

    public void listAllProducts(Repository repository){
        repository.listAllProducts();
    }

    // public void viewProductsAvailability(){

    // }

    // public boolean removeProduct(String productId){

    // }

    // public void manageOrders(Order order){

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
