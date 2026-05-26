import java.time.LocalDateTime;

public class Review {
    private String reviewId;
    private String customerName;
    private LocalDateTime reviewDate;

    public Review(String reviewId, String customerName, LocalDateTime reviewDate){
        this.reviewId = reviewId;
        this.customerName = customerName;
        this.reviewDate = reviewDate;
    }

    public String getReviewId(){
        return reviewId;
    }

    public String getCustomerName(){
        return customerName;
    }

    public LocalDateTime getReviewDate(){
        return reviewDate;
    }
}
