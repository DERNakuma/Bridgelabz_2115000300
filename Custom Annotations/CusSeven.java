import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class ExpensiveComputation {
    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    int computeSquare(int num) {
        if (cache.containsKey(num)) {
            System.out.println("Returning cached result for: " + num);
            return cache.get(num);
        }
        System.out.println("Computing square for: " + num);
        int result = num * num;
        cache.put(num, result);
        return result;
    }
}

public class CusSeven {
    public static void main(String[] args) throws Exception {
        ExpensiveComputation computation = new ExpensiveComputation();
        Method method = ExpensiveComputation.class.getMethod("computeSquare", int.class);

        if (method.isAnnotationPresent(CacheResult.class)) {
            System.out.println(computation.computeSquare(5));
            System.out.println(computation.computeSquare(5));
            System.out.println(computation.computeSquare(10));
            System.out.println(computation.computeSquare(10));
        }
    }
}
