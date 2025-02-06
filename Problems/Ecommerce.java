import java.util.ArrayList;

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }

    void placeOrder(Order order) {
        System.out.println(this.name + " placed an order.");
    }
}

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    ArrayList<Product> products;

    Order() {
        products = new ArrayList<>();
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void displayOrder() {
        System.out.println("Order contains:");
        for (Product product : products) {
            System.out.println(product.name + " - " + product.price);
        }
    }
}

public class Ecommerce {
    public static void main(String[] args) {
        Customer customer = new Customer("Bhupender");
        Order order = new Order();
        order.addProduct(new Product("Laptop", 90000));
        order.addProduct(new Product("Mouse", 10000));

        customer.placeOrder(order);
        order.displayOrder();
    }
}