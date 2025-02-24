import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    void adminTask() {
        System.out.println("Admin task executed.");
    }
}

public class CusFive {
    static String currentUserRole = "USER"; 

    public static void main(String[] args) throws Exception {
        SecureService service = new SecureService();
        Method method = SecureService.class.getMethod("adminTask");

        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed annotation = method.getAnnotation(RoleAllowed.class);
            if (annotation.value().equals(currentUserRole)) {
                method.invoke(service);
            } else {
                System.out.println("Access Denied!");
            }
        }
    }
}
