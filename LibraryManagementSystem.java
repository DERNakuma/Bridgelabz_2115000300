import java.util.*;

class BookNode {
    String title, author, genre;
    int bookID;
    boolean isAvailable;
    BookNode next, prev;

    public BookNode(String title, String author, String genre, int bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = this.prev = null;
    }
}

class Library {
    private BookNode head, tail;
    private int count;

    public void addAtBeginning(String title, String author, String genre, int bookID, boolean isAvailable) {
        BookNode newBook = new BookNode(title, author, genre, bookID, isAvailable);
        if (head == null) head = tail = newBook;
        else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        count++;
    }

    public void addAtEnd(String title, String author, String genre, int bookID, boolean isAvailable) {
        BookNode newBook = new BookNode(title, author, genre, bookID, isAvailable);
        if (tail == null) head = tail = newBook;
        else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        count++;
    }

    public void addAtPosition(String title, String author, String genre, int bookID, boolean isAvailable, int position) {
        if (position < 1 || position > count + 1) return;
        if (position == 1) {
            addAtBeginning(title, author, genre, bookID, isAvailable);
            return;
        }
        if (position == count + 1) {
            addAtEnd(title, author, genre, bookID, isAvailable);
            return;
        }

        BookNode newBook = new BookNode(title, author, genre, bookID, isAvailable);
        BookNode temp = head;
        for (int i = 1; i < position - 1; i++) temp = temp.next;

        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
        count++;
    }

    public void removeBook(int bookID) {
        if (head == null) return;
        BookNode temp = head;
        while (temp != null && temp.bookID != bookID) temp = temp.next;

        if (temp == null) return;

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        count--;
    }

    public void searchByTitle(String title) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title))
                System.out.println("Book Found: " + temp.title + " by " + temp.author + " (ID: " + temp.bookID + ")");
            temp = temp.next;
        }
    }

    public void searchByAuthor(String author) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author))
                System.out.println("Book: " + temp.title + " (ID: " + temp.bookID + ")");
            temp = temp.next;
        }
    }

    public void updateAvailability(int bookID, boolean isAvailable) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookID == bookID) {
                temp.isAvailable = isAvailable;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        BookNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.author + " | " + temp.genre + " | ID: " + temp.bookID + " | Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        BookNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.author + " | " + temp.genre + " | ID: " + temp.bookID + " | Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    public int countBooks() {
        return count;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search by Title");
            System.out.println("6. Search by Author");
            System.out.println("7. Update Availability Status");
            System.out.println("8. Display Books Forward");
            System.out.println("9. Display Books Reverse");
            System.out.println("10. Count Books");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Title, Author, Genre, Book ID, Availability (true/false): ");
                    library.addAtBeginning(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextBoolean());
                }
                case 2 -> {
                    System.out.print("Enter Title, Author, Genre, Book ID, Availability (true/false): ");
                    library.addAtEnd(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextBoolean());
                }
                case 3 -> {
                    System.out.print("Enter Title, Author, Genre, Book ID, Availability (true/false), Position: ");
                    library.addAtPosition(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextBoolean(), sc.nextInt());
                }
                case 4 -> {
                    System.out.print("Enter Book ID to Remove: ");
                    library.removeBook(sc.nextInt());
                }
                case 5 -> {
                    System.out.print("Enter Book Title: ");
                    library.searchByTitle(sc.nextLine());
                }
                case 6 -> {
                    System.out.print("Enter Author Name: ");
                    library.searchByAuthor(sc.nextLine());
                }
                case 7 -> {
                    System.out.print("Enter Book ID and Availability (true/false): ");
                    library.updateAvailability(sc.nextInt(), sc.nextBoolean());
                }
                case 8 -> library.displayForward();
                case 9 -> library.displayReverse();
                case 10 -> System.out.println("Total Books: " + library.countBooks());
                case 11 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 11);

        sc.close();
    }
}