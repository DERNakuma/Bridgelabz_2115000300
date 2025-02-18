import java.util.ArrayList;
import java.util.List;

abstract class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Book extends Product {
    public Book(String name, double price) {
        super(name, price);
    }
}

class Clothing extends Product {
    public Clothing(String name, double price) {
        super(name, price);
    }
}

class Gadget extends Product {
    public Gadget(String name, double price) {
        super(name, price);
    }
}

class Catalog<T extends Product> {
    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public List<T> getProducts() {
        return products;
    }

    public static <T extends Product> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(newPrice);
    }
}

public class DynamicMarketplace {
    public static void main(String[] args) {
        Catalog<Book> bookCatalog = new Catalog<>();
        Book book1 = new Book("Java Programming", 500);
        Book book2 = new Book("Data Structures", 600);
        bookCatalog.addProduct(book1);
        bookCatalog.addProduct(book2);

        Catalog<Clothing> clothingCatalog = new Catalog<>();
        Clothing cloth1 = new Clothing("T-Shirt", 300);
        Clothing cloth2 = new Clothing("Jeans", 1200);
        clothingCatalog.addProduct(cloth1);
        clothingCatalog.addProduct(cloth2);

        Catalog<Gadget> gadgetCatalog = new Catalog<>();
        Gadget gadget1 = new Gadget("Smartphone", 15000);
        Gadget gadget2 = new Gadget("Laptop", 50000);
        gadgetCatalog.addProduct(gadget1);
        gadgetCatalog.addProduct(gadget2);

        System.out.println("Before Discount:");
        for (Book book : bookCatalog.getProducts()) {
            System.out.println(book.getName() + " - " + book.getPrice());
        }

        Catalog.applyDiscount(book1, 10);
        Catalog.applyDiscount(book2, 15);

        System.out.println("After Discount:");
        for (Book book : bookCatalog.getProducts()) {
            System.out.println(book.getName() + " - " + book.getPrice());
        }
    }
}
