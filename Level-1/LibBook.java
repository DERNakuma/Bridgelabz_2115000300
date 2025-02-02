public class LibBook {
    private String title;
    private String author;
    private double price;
    private boolean available;

    public LibBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed: " + title);
        } else {
            System.out.println("Book not available.");
        }
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public static void main(String[] args) {
        LibBook book = new LibBook("Solo Leveling", "Chu-gong", 200.00);
        System.out.println("Book: " + book.getTitle() + " by " + book.getAuthor() + ", Price: $" + book.getPrice());

        book.borrowBook();
        book.borrowBook(); 
    }
}