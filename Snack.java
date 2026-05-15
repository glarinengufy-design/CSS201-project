public class Snack extends Product {
    private String brand;

    public Snack(String productId, String productName, String category, double price, int quantity, boolean available, String brand){
        super(productId,productName, category, price, quantity, available);
        this.brand = brand;
    }

    public String getBrand(){
        return brand;
    }

    public void displayInfo(){
        
    }
}
