public class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    public HotelBooking() {
        this.guestName = "Unknown";
        this.roomType = "Standard";
        this.nights = 1;
    }

    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    public String getGuestName() { return guestName; }
    public void setGuestName(String guestName) { this.guestName = guestName; }

    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }

    public int getNights() { return nights; }
    public void setNights(int nights) { this.nights = nights; }

    public static void main(String[] args) {
        HotelBooking booking1 = new HotelBooking();
        HotelBooking booking2 = new HotelBooking("John Doe", "Deluxe", 3);
        HotelBooking booking3 = new HotelBooking(booking2); 

        System.out.println("Booking 1: " + booking1.getGuestName() + ", Room: " + booking1.getRoomType() + ", Nights: " + booking1.getNights());
        System.out.println("Booking 2: " + booking2.getGuestName() + ", Room: " + booking2.getRoomType() + ", Nights: " + booking2.getNights());
        System.out.println("Booking 3 (Copy): " + booking3.getGuestName() + ", Room: " + booking3.getRoomType() + ", Nights: " + booking3.getNights());
    }
}