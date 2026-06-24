// Subclass: PremiumMember
public class PremiumMember extends GymMember
 {
    private final double premiumCharge = 50000;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;

    public PremiumMember
    (int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    public String payDueAmount(double amount)
    {
        if (isFullPayment)
        {
            return "Payment already completed.";
        }
        if (paidAmount + amount > premiumCharge) 
        {
            return "Amount exceeds due payment.";
        }
        paidAmount += amount;
        isFullPayment = paidAmount == premiumCharge;
        return "Payment successful. Remaining amount: " + (premiumCharge - paidAmount);
    }

    public void calculateDiscount() 
    {
        if (isFullPayment)
        {
            discountAmount = premiumCharge * 0.1;
        }
    }

    public void revertPremiumMember()
    {
        resetMember();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }
    @Override
public void markAttendance() {
    this.attendance++;
    this.loyaltyPoints += 10; // Premium members get more loyalty points
}


    @Override
    public void displayInfo() 
    {
        super.displayInfo();
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Is Full Payment: " + isFullPayment);
        System.out.println("Remaining Amount: " + (premiumCharge - paidAmount));
        if (isFullPayment) 
        {
            System.out.println("Discount Amount: " + discountAmount);
        }
    }
}
