import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        LocalDate localDate = LocalDate.parse(date);
        System.out.println(localDate.minusDays(10));
    }
}