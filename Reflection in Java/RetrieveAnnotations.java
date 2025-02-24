import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "John Doe")
class Book {}

class RetrieveAnnotations {
    public static void main(String[] args) {
        Author author = Book.class.getAnnotation(Author.class);
        if (author != null) System.out.println("Author: " + author.name());
    }
}
