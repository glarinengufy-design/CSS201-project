import java.time.LocalDateTime;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        boolean isRunning = true; 
        Scanner scanner = new Scanner(System.in);
        Repository repo = new Repository();

        Admin admin = new Admin(6464588,"admin123","borneo_freshfood@gmail.com","Ad_14899","014-333555","Borneo Fresh Food Official","Admin");
        Customer customer = new Customer(444515,"dnfdj","fafa445@gamil.com","fafa123","014-331155","Fafa","Customer", 444515, "dnfdj");
        Customer customer2 = new Customer(105802515,"glarine123","glarine123@gmail.com","g1115","014-331155","Glarine Ngu","Customer", 105802515, "glarine123");
        repo.addUser(admin);
        repo.addUser(customer);
        repo.addUser(customer2);

        Product carrot = new Vegetable("V001", "Carrot", "Vegetable", 1.5, 50, true, "2026-08-30");
        repo.addProduct(carrot);

        Product apple = new Fruit("F001", "Apple", "Fruit", 2.0, 100, true, "2026-09-15");
        repo.addProduct(apple);

        Product milk = new DailyProduct("D001", "Milk", "Dairy", 3.0, 200, true, "Dutch Lady");
        repo.addProduct(milk);

        Product rice = new DailyProduct("G001", "Rice", "Grain", 58.0, 500, true, "Jati");
        repo.addProduct(rice);

        Review review1 = new Review("R001", "O001", LocalDateTime.now(), "Great quality and fresh produce!");
        repo.addReview(review1);
        
        System.out.println("Welcome to Borneo Fresh Market!");

        do {
            System.out.println("Did you have any account? (yes/no)");
            String choose = scanner.nextLine();
            if (choose.equalsIgnoreCase("yes")) {
                break;
            } else if (choose.equalsIgnoreCase("no")) {
                User newUser = User.registerAccount(repo);
                if (newUser != null) {
                    repo.addUser(newUser);
                }
                break;
            } else {
                System.out.println("Invalid selection. Please restart the program and enter yes or no.");
            }
        } while (isRunning);

        System.out.print("Please enter your username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Please enter your password: ");
        String inputPassword = scanner.nextLine();
        User loggedInUser = User.login(repo, inputUsername, inputPassword);

        if (loggedInUser != null) {
            // role-specific actions
            if (loggedInUser instanceof Admin) {
                ((Admin) loggedInUser).showMenu(repo);
            } else if (loggedInUser instanceof Customer) {
                ((Customer) loggedInUser).showMenu(repo);
            }
        }

        scanner.close();
    } 
}