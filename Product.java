public abstract class Product {
    protected String productId;
    protected String productName;
    protected String category;
    protected double price;
    protected int quantity;
    protected boolean available;

    public Product(String productId, String productName, String category, double price,int quantity, boolean available){
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.available = available;
    }

    public String getProductId(){
        return productId;
    }

    public String getProductName(){
        return productName;
    }

    public String getCategory(){
        return category;
    }

    public double getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public boolean isAvailability(){
        return available;
    }

    public void setProductName(String productName) { 
        this.productName = productName; 
    }

    public void setCategory(String category) { 
        this.category = category; 
    }

    public void setPrice(double price) {
        if (price >= 0) {  // validation
            this.price = price;
        } else {
            System.out.println("Price cannot be negative!");
        }
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public void setAvailable(boolean available) { 
        this.available = available;
    }
}
