import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        LocalDate localDate = LocalDate.parse(date);
        LocalDate before = localDate.withYear(localDate.getYear()).minusYears(30);
        LocalDate after = localDate.withYear(localDate.getYear()).plusYears(30);
        System.out.println(before);
        System.out.println(after);
    }
}