import java.util.*;

public class SalesReport {
    private Repository repository;

    SalesReport(Repository repository) {
        this.repository = repository;
    }

    private Map<String, Integer> buildSalesMap() {
        Map<String, Integer> salesMap = new HashMap<>();    //key = product ID (String) and quantity (Integer)

        for (Order order : repository.getOrders()) { //combine all orders item in a list
            for (OrderItem item : order.getItems()) {
                String productId = item.getProduct().getProductId();
                int quantity = item.getQuantity();

                // add quantity to the existing count for this product ID, or initialize it if not present
                salesMap.put(productId, salesMap.getOrDefault(productId, 0) + quantity);
            }
        }
        return salesMap;
    }

    // Top-selling product
    public Product getTopSalesProduct() {
        Map<String, Integer> salesMap = buildSalesMap();
        String topId = null;
        int max = 0;

        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                topId = entry.getKey();
            }
        }

        return topId != null ? repository.findProductById(topId) : null;
    }

    // Least-selling product
    public Product getLeastSalesProduct() {
        Map<String, Integer> salesMap = buildSalesMap();
        String leastId = null;
        int min = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                leastId = entry.getKey();
            }
        }
        return leastId != null ? repository.findProductById(leastId) : null;
    }

    // Total number of orders
    public int getTotalOrders() {
        return repository.getOrders().size();
    }

    // Total earnings (sum of all order totals)
    public double getTotalEarnings() {
        double total = 0;
        for (Order order : repository.getOrders()) {
            total += order.getTotalCost();
        }
        return total;
    }

    // Average earnings per order
    public double getAverageEarnings() {
        int totalOrders = getTotalOrders();
        return totalOrders > 0 ? getTotalEarnings() / totalOrders : 0;
    }

    // Display full sales report
    public void displaySalesReport() {
        System.out.println("\n=== Sales Report ===");
        System.out.println("Total Orders: " + getTotalOrders());
        System.out.println("Total Earnings: RM " + getTotalEarnings());
        System.out.println("Average Earnings per Order: RM " + getAverageEarnings());

        Product topProduct = getTopSalesProduct();
        Product leastProduct = getLeastSalesProduct();

        if (topProduct != null) {
            System.out.println("Top-Selling Product: " + topProduct.getProductName());
        }
        if (leastProduct != null) {
            System.out.println("Least-Selling Product: " + leastProduct.getProductName());
        }
    }
}
