import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        LocalDate date = LocalDate.of(year, month, 1);
        System.out.print(getFirstDayOfMonth(date) + " ");
        System.out.print(getLastDayOfYear(date));
    }

    public static LocalDate getFirstDayOfMonth(LocalDate month) {
        return month.withDayOfMonth(1);
    }

    public static LocalDate getLastDayOfYear(LocalDate year) {
        int lastDay = year.lengthOfMonth();
        return year.withDayOfMonth(lastDay);
    }
}