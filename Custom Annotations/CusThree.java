import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}
class PerformanceTest {
    @LogExecutionTime
    void fastMethod() {
        for (int i = 0; i < 1000; i++);
    }

    @LogExecutionTime
    void slowMethod() {
        for (int i = 0; i < 1000000; i++);
    }
}

public class CusThree {
    public static void main(String[] args) throws Exception {
        PerformanceTest test = new PerformanceTest();
        Method[] methods = PerformanceTest.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(test);
                long end = System.nanoTime();
                System.out.println("Method: " + method.getName() + ", Execution Time: " + (end - start) + " ns");
            }
        }
    }
}
