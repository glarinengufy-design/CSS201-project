public class Admin extends User{
     public Admin(int userId, String username, String email, String password, String phoneNumber, String fullName, String address, String role){
        super(userId, username, email, password, phoneNumber, fullName, address, role);
    }

    @Override
    public void showMenu() {
        System.out.println("\n=== Admin Menu ===");
        System.out.println("1. View profile");
        System.out.println("2. Update profile");
        System.out.println("3. Add product");
        System.out.println("4. Update product");
        System.out.println("5. View product availability");
        System.out.println("6. Remove product");
        System.out.println("7. Manage orders");
        System.out.println("8. Browse products");
        System.out.println("9. View product by category");
        System.out.println("9. View product details");
        System.out.println("10. Exit");
    }

    public void viewProfile(Repository repository){
        repository.viewProfile(username);
    }

    public void updateProfile(Repository repository){
        repository.updateProfile(User user);
    }

    public void addProduct(Repository repository) {
        repository.addProduct();
    }

    public void updateProduct(Repository repository){
        repository.updateProduct();
    }

    public void viewProductsAvailability(){

    }

    public boolean removeProduct(String productId){

    }

    public void manageOrders(Order order){

    }

    public void browseProduct(Product product){

    }

    public void viewProductByCategory(String category){

    }

    public void viewProductDetails(String producTId){

    }
}
