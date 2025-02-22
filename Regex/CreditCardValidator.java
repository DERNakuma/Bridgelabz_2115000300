public class CreditCardValidator {
    public static boolean isValidCard(String cardNumber) {
        return cardNumber.matches("^4\\d{15}$") || cardNumber.matches("^5\\d{15}$");
    }

    public static void main(String[] args) {
        System.out.println(isValidCard("4111111111111111"));
        System.out.println(isValidCard("5111111111111111"));
        System.out.println(isValidCard("6111111111111111"));
    }
}

