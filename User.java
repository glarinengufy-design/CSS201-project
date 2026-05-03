import java.util.Scanner;

public abstract class User {
    protected int userId;
    protected String password;
    protected String username;
    protected String email;
    protected String phoneNumber;
    protected String fullName;
    protected String address;
    protected String role;

    Scanner scanner = new Scanner(System.in);

    public User(int userId, String password, String username, String email, String phoneNumber, String fullName, String address, String role){
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.address = address;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public String getPassword(){
        return password;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getFullName(){
        return fullName;
    }

    public String getAddress(){
        return address;
    }

    public String getRole(){
        return role;
    }

    public String registerAccount(String username, String password, String email, String phoneNumber, String fullName, String address, String role){
        System.out.println("Registration");
        System.out.print("Full Name: ");
        this.fullName = scanner.nextLine();

        System.out.print("Email: ");
        this.email = scanner.nextLine();

        System.out.print("Phone Number: ");
        this.phoneNumber = scanner.nextLine();

        System.out.print("Address: ");
        this.address = scanner.nextLine();

        System.out.print("Username: ");
        this.username = scanner.nextLine();

        System.out.print("Role: ");
        this.role = scanner.nextLine();

        System.out.print("Password: ");
        this.password = scanner.nextLine();

        return "Account registered successfully for " + this.username;
    }

    public abstract void showMenu();

    public static User login(Repository repo, String inputUsername, String inputPassword) {
        for (User user : repo.getUsers()) {
            if (user.username.equals(inputUsername) && user.password.equals(inputPassword)) {
                System.out.println("Login successful! Role: " + user.role);
                user.showMenu();   // Polymorphism: calls the right menu automatically
                return user;
            }
        }
        System.out.println("Login failed. Invalid username or password.");
        return null;
    }
}
