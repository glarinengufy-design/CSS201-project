public class Fruit extends Product{
    private String expiryDate;

    public Fruit(String productId, String productName, String category, double price, int quantity, boolean available, String expiryDate){
        super(productId,productName, category, price, quantity, available);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate(){
        return expiryDate;
    }

    public void displayInfo(){
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Category: " + category);
        System.out.println("Price: RM" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Available: " + available);
        System.out.println("Expiry Date: " + expiryDate);
    }
}
