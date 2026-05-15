import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception { 
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        List<User> users = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        Repository repo = new Repository(products, orders, users);

        Admin admin = new Admin(1, "AdminUser");
        Customer customer = new Customer(2, "CustUser");

        repo.addUser(admin);
        repo.addUser(customer);

        Product carrot = new Vegetable("V001", "Carrot", "Vegetable", 1.5, 50, true, "2026-05-30");
        // repo.addProduct(carrot);

        System.out.println("Welcome to ");
        System.out.println("Did you have any account?(yes/no)");
        String choose = scanner.nextLine();
        if (choose=="yes") {
            System.out.print("Please enter your username: ");
            String inputUsername = scanner.nextLine();
            System.out.print("Please enter your password: ");
            String inputPAssword = scanner.nextLine();
            User.login(repo, inputUsername, inputPAssword);
        } else if (choose=="no") {
            User.RegisterAccount(repo);
        } else {
            
        }
    }
}