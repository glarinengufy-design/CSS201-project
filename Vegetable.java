public class Vegetable extends Product{
    private String expiryDate;

    public Vegetable(String productId, String productName, String category, double price, int quantity, boolean available,String expiryDate){
        super(productId, productName, category, price, quantity, available);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate(){
        return expiryDate;
    }

    public void displayInfo(){
        
    }
}
