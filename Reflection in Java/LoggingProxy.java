import java.lang.reflect.*;
interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    public void sayHello() { System.out.println("Hello!"); }
}

class LoggingProxy {
    public static <T> T createProxy(T obj) {
        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("Calling method: " + method.getName());
            return method.invoke(obj, args);
        });
    }

    public static void main(String[] args) {
        Greeting g = createProxy(new GreetingImpl());
        g.sayHello();
    }
}
