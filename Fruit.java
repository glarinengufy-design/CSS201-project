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
        
    }
}
