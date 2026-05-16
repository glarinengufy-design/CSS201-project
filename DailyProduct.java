public class DailyProduct extends Product{
    private String brand;

    public DailyProduct(String productId, String productName, String category, double price, int quantity, boolean available, String brand){
        super(productId,productName, category, price, quantity, available);
        this.brand = brand;
    }

    public String getBrand(){
        return brand;
    }

    public void displayInfo(){
        
    }
}
