class Ticket {
    int ticketID;
    String customerName, movieName, seatNumber, bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}
class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;
    private int totalTickets = 0;

    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
        totalTickets++;
    }

    public void removeTicket(int ticketID) {
        if (head == null) return;
        Ticket current = head, prev = tail;
        do {
            if (current.ticketID == ticketID) {
                if (current == head) head = head.next;
                if (current == tail) tail = prev;
                prev.next = current.next;
                totalTickets--;
                if (totalTickets == 0) head = tail = null;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName + 
                               ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + 
                               ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    public void searchTicket(String query) {
        if (head == null) return;
        Ticket current = head;
        do {
            if (current.customerName.equalsIgnoreCase(query) || current.movieName.equalsIgnoreCase(query)) {
                System.out.println("Found Ticket - ID: " + current.ticketID + ", Customer: " + current.customerName +
                                   ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                                   ", Time: " + current.bookingTime);
                return;
            }
            current = current.next;
        } while (current != head);
        System.out.println("No ticket found.");
    }

    public int getTotalTickets() {
        return totalTickets;
    }
}

public class TicketReservationApp {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        system.addTicket(101, "Alice", "Inception", "A1", "10:00 AM");
        system.addTicket(102, "Bob", "Avatar", "B2", "12:00 PM");
        system.addTicket(103, "Charlie", "Interstellar", "C3", "02:00 PM");

        System.out.println("All Tickets:");
        system.displayTickets();

        System.out.println("\nSearch for 'Alice':");
        system.searchTicket("Alice");

        System.out.println("\nTotal Booked Tickets: " + system.getTotalTickets());

        System.out.println("\nRemoving Ticket ID 102...");
        system.removeTicket(102);
        system.displayTickets();
    }
}