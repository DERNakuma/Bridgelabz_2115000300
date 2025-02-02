public class Book {
    private String title;
    private String author;
    private double price;

    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("Solo Leveling", "Chu-gong", 200.00);

        System.out.println("Book 1: " + book1.getTitle() + " by " + book1.getAuthor() + ", Price: $" + book1.getPrice());
        System.out.println("Book 2: " + book2.getTitle() + " by " + book2.getAuthor() + ", Price: $" + book2.getPrice());
    }
}
