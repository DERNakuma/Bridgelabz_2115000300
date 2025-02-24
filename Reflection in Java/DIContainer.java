import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class Service {
    void greet() { System.out.println("Service is running!"); }
}

class Controller {
    @Inject
    Service service;
}
class DIContainer {
    public static void injectDependencies(Object obj) throws Exception {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(obj, field.getType().getDeclaredConstructor().newInstance());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Controller c = new Controller();
        injectDependencies(c);
        c.service.greet();
    }
}
