import java.util.*;

public class SalesReport {
    private Repository repository;

    SalesReport(Repository repository) {
        this.repository = repository;
    }

    private Map<String, Integer> buildSalesMap() {
        Map<String, Integer> salesMap = new HashMap<>();

        for (Order order : repository.getOrders()) {
            for (OrderItem item : order.getItems()) {
                String productId = item.getProduct().getProductId();
                int quantity = item.getQuantity();

                salesMap.put(productId, salesMap.getOrDefault(productId, 0) + quantity);
            }
        }
        return salesMap;
    }

    // public Product getTopSalesProduct() {
    //     Map<String, Integer> salesMap = buildSalesMap();
    //     String topId = null;
    //     int max = 0;

    //     for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
    //         if (entry.getValue() > max) {
    //             max = entry.getValue();
    //             topId = entry.getKey();
    //         }
    //     }
    //     return topId != null ? repository.viewProductById(topId) : null;
    // }
}
