import java.lang.annotation.*;
import java.lang.reflect.Field;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    String username;

    User(String username) throws Exception {
        this.username = username;
        validate();
    }

    private void validate() throws Exception {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength annotation = field.getAnnotation(MaxLength.class);
                String value = (String) field.get(this);
                if (value.length() > annotation.value()) {
                    throw new IllegalArgumentException("Username exceeds max length of " + annotation.value());
                }
            }
        }
    }
}

public class CusFour {
    public static void main(String[] args) {
        try {
            User user1 = new User("Krishna");
            System.out.println("Valid Username: " + user1.username);
            User user2 = new User("LongUsername123");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
