import java.util.ArrayList;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

class Library {
    ArrayList<Book> books;

    Library() {
        books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    void displayBooks() {
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println("Title: " + book.title + ", Author: " + book.author);
        }
    }
}

public class LibraryAndBooks {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Rich dad Poor dad", "Robert Kiyosaki"));
        library.addBook(new Book("The Psychopath Test: A Journey through the Madness Industry", "Jon Ronson"));
        library.displayBooks();
    }
}