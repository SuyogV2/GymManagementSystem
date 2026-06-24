// Subclass: RegularMember
class RegularMember extends GymMember
 {
    private final int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;

    // Constructor
    
    public RegularMember
    (int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String referralSource) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.attendanceLimit = 30;
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = "";
        this.referralSource = referralSource;
    }

    // Accessor methods
    public int getAttendanceLimit() 
    { 
        return attendanceLimit; 
    }
    public boolean getIsEligibleForUpgrade()
    { 
        return isEligibleForUpgrade;
    }
    public String getRemovalReason() 
    { 
        return removalReason; 
    }
    public String getReferralSource()
    { 
        return referralSource;
    }
    public String getPlan()
    { 
        return plan; 
    }
    public double getPrice()
    {
        return price; 
    }

    // Implement abstract method markAttendance
    @Override
    public void markAttendance() 
    {
        this.attendance++;
        this.loyaltyPoints += 5;
        if (this.attendance >= attendanceLimit)
        {
            this.isEligibleForUpgrade = true;
        }
    }

    // Method to get plan price
    public double getPlanPrice(String plan) 
    {
        switch (plan.toLowerCase())
        {
            case "basic": return 6500;
            case "standard": return 12500;
            case "deluxe": return 18500;
            default: return -1;
        }
    }

    // Method to upgrade plan
    public String upgradePlan(String newPlan)
    {
        if (!isEligibleForUpgrade)
        {
            return "Upgrade not available. Attendance limit not reached.";
        }
        if (this.plan.equalsIgnoreCase(newPlan))
        
        {
            return "You are already subscribed to this plan.";
        }
        double newPrice = getPlanPrice(newPlan);
        if (newPrice == -1) 
        {
            return "Invalid plan selected.";
        }
        this.plan = newPlan;
        this.price = newPrice;
        return "Plan upgraded successfully to " + newPlan + " for " + newPrice;
    }

    // Method to revert RegularMember
    public void revertRegularMember(String removalReason)
    {
        resetMember();
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = removalReason;
    }

    // Display method
    @Override
    public void displayInfo()
    {
        super.displayInfo();
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        if (!removalReason.isEmpty())
        {
            System.out.println("Removal Reason: " + removalReason);
        }
    }
}
