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
        
    }
}
