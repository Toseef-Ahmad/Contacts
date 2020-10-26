import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static LocalDateTime merge(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        // write your code here
        int hours = Math.max(dateTime1.getHour(), dateTime2.getHour());
        int minuts = Math.max(dateTime1.getMinute(), dateTime2.getMinute());
        int seconds = Math.max(dateTime1.getSecond(), dateTime2.getSecond());
        int day = Math.max(dateTime1.getDayOfMonth(), dateTime2.getDayOfMonth());
        int month = Math.max(dateTime1.getMonthValue(), dateTime2.getMonthValue());
        int year = Math.max(dateTime1.getYear(), dateTime2.getYear());
        return LocalDateTime.of(year, month, day, hours, minuts, seconds);

    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final LocalDateTime firstDateTime = LocalDateTime.parse(scanner.nextLine());
        final LocalDateTime secondDateTime = LocalDateTime.parse(scanner.nextLine());
        System.out.println(merge(firstDateTime, secondDateTime));
    }
}