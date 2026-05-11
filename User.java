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

    public void setEmai(String email){
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

    public void setFullName(Stirng fullName){
        this.fullName=fullName;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public String getRole(){
        return role;
    }

    public User registerAccount(Repository repo) {
        System.out.println("Registration");

        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Role: ");
        String role = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Auto-generate userId
        int userId = repo.getUsers().size() + 1;

        // Create new User object
        User newUser = new User(userId, username, password, email, phoneNumber, fullName, address, role);

        // Store in repository
        repo.addUser(newUser);

        System.out.println("Account registered successfully for " + username);
        return newUser;
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
