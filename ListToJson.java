import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListToJson {
    public static void main(String[] args) throws Exception {
        List<Person> people = Arrays.asList(new Person("Alice", 25), new Person("Bob", 30));

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArray = objectMapper.writeValueAsString(people);
        System.out.println(jsonArray);
    }
}
