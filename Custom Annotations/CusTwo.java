import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}
class Project {
    @Todo(task = "Implement login feature", assignedTo = "Krishna", priority = "HIGH")
    void login() {
        System.out.println("Login feature pending...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Amit")
    void optimizeDB() {
        System.out.println("Database optimization pending...");
    }
}
public class CusTwo {
    public static void main(String[] args) throws Exception {
        Method[] methods = Project.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo annotation = method.getAnnotation(Todo.class);
                System.out.println("Task: " + annotation.task());
                System.out.println("Assigned To: " + annotation.assignedTo());
                System.out.println("Priority: " + annotation.priority());
                System.out.println();
            }
        }
    }
}
