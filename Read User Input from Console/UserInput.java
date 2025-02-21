import java.io.*;
public class UserInput {
    public static void main(String[] args) {
        String filename = "user_info.txt";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter(filename)) {
            System.out.print("Enter your name: ");
            String name = br.readLine();
            System.out.print("Enter your age: ");
            String age = br.readLine();
            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            fw.write("Name: " + name + "\nAge: " + age + "\nFavorite Language: " + language + "\n");
            System.out.println("Information saved successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving data.");
        }
    }
}
