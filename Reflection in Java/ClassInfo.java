import java.lang.reflect.*;
class ClassInfo {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName(args[0]);
        System.out.println("Methods:");
        for (Method m : cls.getDeclaredMethods()) System.out.println(m);
        System.out.println("\nFields:");
        for (Field f : cls.getDeclaredFields()) System.out.println(f);
        System.out.println("\nConstructors:");
        for (Constructor<?> c : cls.getDeclaredConstructors()) System.out.println(c);
    }
}
