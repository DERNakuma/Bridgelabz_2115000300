import java.util.Scanner;
public class Calendar {
    private static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static int getFirstDay(int year, int month) {
        int y = year - (14 - month) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        return (1 + x + 31 * m / 12) % 7;
    }
    public static void displayCalendar(int year, int month) {
        System.out.println(months[month - 1] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int firstDay = getFirstDay(year, month);
        int numDays = days[month - 1];
        if (month == 2 && isLeapYear(year)) numDays = 29;

        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= numDays; day++) {
            System.out.printf("%3d ", day);
            if ((day + firstDay) % 7 == 0 || day == numDays) {
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        displayCalendar(year, month);
    }
}