public class Book {
    public String isbn;
    protected String title;
    private String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class EBook extends Book {
    public EBook(String isbn, String title, String author) {
        super(isbn, title, author);
    }

    public void displayDetails() {
        System.out.println("ISBN: " + isbn + ", Title: " + title);
    }

    public static void main(String[] args) {
        EBook ebook = new EBook("123456789", "Java Programming", "James Gosling");
        ebook.displayDetails();
        System.out.println("Author: " + ebook.getAuthor());
    }
}