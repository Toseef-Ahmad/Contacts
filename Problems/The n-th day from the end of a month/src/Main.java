import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        LocalDate localDate = LocalDate.of(year, month, day);
        System.out.println(localDate.withDayOfMonth(localDate.lengthOfMonth() - day + 1));

    }
}