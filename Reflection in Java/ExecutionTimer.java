import java.lang.reflect.*;
class ExecutionTimer {
    public static void measureExecutionTime(Object obj, String methodName, Class<?>[] paramTypes, Object... args) throws Exception {
        Method method = obj.getClass().getMethod(methodName, paramTypes);
        long start = System.nanoTime();
        method.invoke(obj, args);
        long end = System.nanoTime();
        System.out.println("Execution Time: " + (end - start) + " ns");
    }

    public static void main(String[] args) throws Exception {
        MathOperations m = new MathOperations();
        measureExecutionTime(m, "add", new Class[]{int.class, int.class}, 5, 10);
    }
}

class MathOperations {
    public int add(int a, int b) { return a + b; }
}
