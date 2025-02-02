public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;

    public CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Standard";
        this.rentalDays = 1;
    }

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost(double dailyRate) {
        return rentalDays * dailyRate;
    }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCarModel() { return carModel; }
    public void setCarModel(String carModel) { this.carModel = carModel; }

    public int getRentalDays() { return rentalDays; }
    public void setRentalDays(int rentalDays) { this.rentalDays = rentalDays; }

    public static void main(String[] args) {
        CarRental rental = new CarRental("Bhupender", "Ford", 5);
        double totalCost = rental.calculateTotalCost(50.0);

        System.out.println("Customer: " + rental.getCustomerName() + ", Car: " + rental.getCarModel() + ", Days: " + rental.getRentalDays());
        System.out.println("Total Cost: $" + totalCost);
    }
}