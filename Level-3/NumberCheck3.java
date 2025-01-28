public class NumberCheck3 {
    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    public static int[] storeDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    public static boolean compareArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseDigits(digits);
        return compareArrays(digits, reversed);
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit != 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int number = 121;
        int[] digits = storeDigits(number);

        System.out.println("Count of Digits: " + countDigits(number));
        
        int[] reversedDigits = reverseDigits(digits);
        System.out.print("Reversed Digits: ");
        for (int digit : reversedDigits) {
            System.out.print(digit);
        }
        System.out.println();

        System.out.print("Palindrome Number: ");
        System.out.println(isPalindrome(digits) ? "Yes" : "No");

        System.out.print("Duck Number: ");
        System.out.println(isDuckNumber(digits) ? "Yes" : "No");
    }
}
