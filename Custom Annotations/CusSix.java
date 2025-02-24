import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    String username;

    @JsonField(name = "user_age")
    int age;

    User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

public class CusSix {
    public static String toJson(Object obj) throws Exception {
        Map<String, String> jsonMap = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                jsonMap.put(annotation.name(), field.get(obj).toString());
            }
        }
        return jsonMap.toString().replace("=", ": ");
    }

    public static void main(String[] args) throws Exception {
        User user = new User("Krishna", 25);
        System.out.println(toJson(user));
    }
}
