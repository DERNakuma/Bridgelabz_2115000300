import java.lang.reflect.*;
class Person {
    private int age = 25;
}
class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Field f = Person.class.getDeclaredField("age");
        f.setAccessible(true);
        System.out.println("Original Age: " + f.get(p));
        f.set(p, 30);
        System.out.println("Modified Age: " + f.get(p));
    }
}
