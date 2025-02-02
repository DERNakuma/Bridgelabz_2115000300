public class Vehicle {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee = 100.0;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName + ", Vehicle Type: " + vehicleType);
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static double getRegistrationFee() {
        return registrationFee;
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Bhupender", "Car");
        Vehicle vehicle2 = new Vehicle("Suraj", "Motorcycle");

        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();

        System.out.println("Registration Fee: " + Vehicle.getRegistrationFee());
        Vehicle.updateRegistrationFee(150.0);
        System.out.println("Updated Registration Fee: " + Vehicle.getRegistrationFee());
    }
}