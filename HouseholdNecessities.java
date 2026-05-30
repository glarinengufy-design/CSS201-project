public class HouseholdNecessities extends Product{
    private String brand;

    public HouseholdNecessities(String productId, String productName, String category, double price, int quantity, boolean available, String brand){
        super(productId,productName, category, price, quantity, available);
        this.brand = brand;
    }

    public String getBrand(){
        return brand;
    }

    public void displayInfo(){
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Category: " + category);
        System.out.println("Price: RM" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Available: " + available);
        System.out.println("Brand: " + brand);
    }
}
