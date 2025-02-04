class Book {
    static String libraryName = "GLA Library";
    final String isbn;
    String title, author;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    static void displayLibraryName() {
        System.out.println(libraryName);
    }

    void display() {
        if (this instanceof Book) {
            System.out.println(title + " " + author + " " + isbn);
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "John Doe", "12345");
        b1.display();
        displayLibraryName();
    }
}
