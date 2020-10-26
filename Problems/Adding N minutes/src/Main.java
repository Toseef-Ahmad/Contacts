import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDateTime time = LocalDateTime.parse(scanner.nextLine());
        int minuts = scanner.nextInt();
        time = time.plusMinutes(minuts);
        System.out.println(time.getYear() + " " + time.getDayOfYear() + " " + time.toLocalTime());
    }
}