import java.time.LocalDateTime;

public class Review {
    private String reviewId;
    private String orderId;
    private LocalDateTime reviewDate;
    private String reviewComment;

    public Review(String reviewId, String orderId, LocalDateTime reviewDate, String reviewComment){
        this.reviewId = reviewId;
        this.orderId = orderId;
        this.reviewDate = reviewDate;
        this.reviewComment = reviewComment;
    }

    public String getReviewId(){
        return reviewId;
    }

    public String getOrderId(){
        return orderId;
    }
    
    public LocalDateTime getReviewDate(){
        return reviewDate;
    }

    public String getReviewComment(){
        return reviewComment;
    }
}
