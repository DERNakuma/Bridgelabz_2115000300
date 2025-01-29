import java.util.Scanner;
public class CountVowels {
    public int[] countVowelsConsonants(String str) {
        int vowels = 0, consonants = 0;
        str = str.toLowerCase();
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) != -1) vowels++;
                else consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();
        CountVowels counter = new CountVowels();
        int[] result = counter.countVowelsConsonants(input);
        System.out.println("Vowels: " + result[0] + ", Consonants: " + result[1]);
    }
}
