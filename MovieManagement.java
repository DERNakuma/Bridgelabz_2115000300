import java.util.*;

class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next, prev;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = this.prev = null;
    }
}

class MovieList {
    private MovieNode head, tail;

    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addAtPosition(String title, String director, int year, double rating, int position) {
        if (position < 1) {
            return;
        }
        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode newMovie = new MovieNode(title, director, year, rating);
        MovieNode temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        newMovie.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newMovie;
        }
        temp.next = newMovie;
        newMovie.prev = temp;

        if (newMovie.next == null) {
            tail = newMovie;
        }
    }

    public void removeMovie(String title) {
        if (head == null) {
            return;
        }

        MovieNode temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    public void searchByDirector(String director) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println(temp.title + " (" + temp.year + "), Rating: " + temp.rating);
            }
            temp = temp.next;
        }
    }

    public void searchByRating(double rating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println(temp.title + " directed by " + temp.director + " (" + temp.year + ")");
            }
            temp = temp.next;
        }
    }

    public void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        MovieNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        MovieNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieList movieList = new MovieList();
        int choice;

        do {
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search by Director");
            System.out.println("6. Search by Rating");
            System.out.println("7. Update Movie Rating");
            System.out.println("8. Display Movies Forward");
            System.out.println("9. Display Movies in Reverse");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    movieList.addAtBeginning(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextDouble());
                    break;
                }
                case 2: {
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    movieList.addAtEnd(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextDouble());
                    break;
                }
                case 3: {
                    System.out.print("Enter Title, Director, Year, Rating, Position: ");
                    movieList.addAtPosition(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextDouble(), sc.nextInt());
                    break;
                }
                case 4: {
                    System.out.print("Enter Movie Title to Remove: ");
                    movieList.removeMovie(sc.nextLine());
                    break;
                }
                case 5: {
                    System.out.print("Enter Director Name: ");
                    movieList.searchByDirector(sc.nextLine());
                    break;
                }
                case 6: {
                    System.out.print("Enter Rating: ");
                    movieList.searchByRating(sc.nextDouble());
                    break;
                }
                case 7: {
                    System.out.print("Enter Title and New Rating: ");
                    movieList.updateRating(sc.nextLine(), sc.nextDouble());
                    break;
                }
                case 8: {
                    movieList.displayForward();
                    break;
                }
                case 9: {
                    movieList.displayReverse();
                    break;
                }
                case 10: {
                    System.out.println("Exiting...");
                    break;
                }
                default: {
                    System.out.println("Invalid choice.");
                }
            }
        } while (choice != 10);

        sc.close();
    }
}