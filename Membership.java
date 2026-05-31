public class Membership {
    private String  membershipId;
    private boolean isActive;
    private double discountRate;
    private String status;

    public Membership(String membershipId, boolean isActive, double discountRate, String status) {
        this.membershipId = membershipId;
        this.isActive = isActive;
        this.discountRate = discountRate;
        this.status = status;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public boolean isActive() {
        return isActive;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public String getStatus() {
        return status;
    }

    public void registerMembership() {
        // Logic to register a new membership
    }

    public void cancelMembership() {
        // Logic to cancel the membership
    }

    public void displayMembershipInfo() {
        System.out.println("Membership ID: " + membershipId);
        System.out.println("Active: " + isActive);
        System.out.println("Discount Rate: " + discountRate + "%");
        System.out.println("Status: " + status);
    }
}
