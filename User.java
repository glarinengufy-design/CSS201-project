import java.util.Scanner;

public abstract class User {
    protected int userId;
    protected String password;
    protected String username;
    protected String email;
    protected String phoneNumber;
    protected String fullName;
    protected String role;
    private static int nextUserId = 1;

    public User(int userId, String username, String email, String password, String phoneNumber, String fullName, String role){
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public String getFullName(){
        return fullName;
    }

    public void setFullName(String fullName){
        this.fullName=fullName;
    }

    public String getRole(){
        return role;
    }

    public static User registerAccount(Repository repository) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Registration");

        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Role: ");
        String role = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        // Auto-generate userId using internal counter
        int userId = nextUserId++;

        User newUser = null;

        if (role.equalsIgnoreCase("Admin")) {
            newUser = new Admin(userId, username, email, password, phoneNumber, fullName, role);
        } else if (role.equalsIgnoreCase("Customer")) {
            newUser = new Customer(userId, username, email, password, phoneNumber, fullName, role, userId, username);
        }

        if (newUser != null) {
            System.out.println("Account registered successfully for " + username);
            return newUser;
        }

        System.out.println("Invalid role specified. Please use Admin or Customer.");
        return null;
    }

    public abstract void showMenu(Repository repository );

    public static User login(Repository repository,String inputUsername, String inputPassword) {
        for (User user : repository.getUsers()) {
            if (user.username.equals(inputUsername) && user.password.equals(inputPassword)) {
                System.out.println("Login successful! username: " + inputUsername);
                user.showMenu(repository);
                return user;
            }
        }
        System.out.println("Login failed. Invalid username or password.");
        return null;
    }
}
