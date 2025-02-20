import java.util.*;

class ShoppingCart {
    private Map<String, Integer> priceMap = new HashMap<>();
    private Map<String, Integer> cart = new LinkedHashMap<>();
    private TreeMap<Integer, String> sortedByPrice = new TreeMap<>();

    void addProduct(String product, int price) {
        priceMap.put(product, price);
        cart.put(product, price);
        sortedByPrice.put(price, product);
    }

    Map<String, Integer> getCartInOrder() {
        return new LinkedHashMap<>(cart);
    }

    Map<Integer, String> getSortedByPrice() {
        return new TreeMap<>(sortedByPrice);
    }

    void displayCart(Map<?, ?> cart) {
        cart.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}

public class ShoppingCartApp {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Apple", 100);
        cart.addProduct("Banana", 40);
        cart.addProduct("Cherry", 150);
        cart.addProduct("Date", 120);

        System.out.println("Cart in order of adding:");
        cart.displayCart(cart.getCartInOrder());

        System.out.println("\nCart sorted by price:");
        cart.displayCart(cart.getSortedByPrice());
    }
}
