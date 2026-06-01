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
        System.out.println("12. View reviews");
        System.out.println("13. View sales report");
        System.out.println("14. Exit");

        System.out.println("Please choose an option:");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                viewProfile(repository);
                showMenu(repository);
                break;
            case 2:
                updateProfile(repository);
                showMenu(repository);
                break;
            case 3:
                addProduct(repository);
                showMenu(repository);
                break;
            case 4:
                updateProduct(repository);
                showMenu(repository);
                break;
            case 5:
                listAllProducts(repository);
                showMenu(repository);
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
                showMenu(repository);
                break;  
            case 10:
                viewProductByCategory(repository);
                showMenu(repository);
                break;
            case 11:
                viewProductById(repository);
                showMenu(repository);
                break;
            case 12:
                viewAllReviews(repository);
                showMenu(repository);
                break;
            case 13:
                SalesReport salesReport = new SalesReport(repository);
                salesReport.displaySalesReport();
                showMenu(repository);
                break;
            case 14:
                System.out.println("Thank you for using Borneo Fresh Market. Goodbye!");
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
                break;
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

    public void viewAllReviews(Repository repository){
        repository.viewAllReviews();
    }
}
