import java.util.*;

abstract class Product {
    private int productId;
    private String name;
    private double price;
    
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    
    public void setPrice(double price) { this.price = price; }
    
    public abstract double calculateDiscount();
    
    public double getFinalPrice() {
        return price - calculateDiscount();
    }
    
    public void displayDetails() {
        System.out.println("ID: " + productId + ", Name: " + name + ", Price: " + getFinalPrice());
    }
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    public double calculateDiscount() {
        return getPrice() * 0.1;
    }
    
    public double calculateTax() {
        return getPrice() * 0.18;
    }
    
    public String getTaxDetails() {
        return "18% GST";
    }
}

class Clothing extends Product {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    public double calculateDiscount() {
        return getPrice() * 0.2;
    }
}

class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class Ecommerce {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        
        Electronics p1 = new Electronics(1, "Laptop", 50000);
        Clothing p2 = new Clothing(2, "T-Shirt", 1000);
        Groceries p3 = new Groceries(3, "Apple", 200);
        
        products.add(p1);
        products.add(p2);
        products.add(p3);
        
        for (Product p : products) {
            double tax = (p instanceof Taxable) ? ((Taxable) p).calculateTax() : 0;
            double finalPrice = p.getFinalPrice() + tax;
            System.out.println("ID: " + p.getProductId() + ", Name: " + p.getName() + ", Final Price: " + finalPrice);
        }
    }
}
