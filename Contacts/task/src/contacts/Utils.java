package contacts;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class Utils implements Serializable {

    private static final String regex = "(\\+?\\(\\w+\\)([\\s-]\\w{2,})*)|(\\+?\\w+([\\s-]\\(\\w{2,}\\))?([\\s-]\\w{2,})*)";

    public static LocalDate checkBirthDate(String birthDate) {
        Pattern pattern = Pattern.compile("(\\d{4})-([1][0-12]|[0]\\d|\\d)-(([1-2]\\d)|([3][0-1])|([0]\\d)|(\\d))");
        Matcher matcher = pattern.matcher(birthDate);

        if (matcher.matches()) {
            System.out.println(birthDate);
            return LocalDate.parse(birthDate);
        } else {
            System.out.println("Bad birth date!");
            return null;
        }
    }

    public static boolean isValid(String phoneNumber) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches()) {
            return true;
        } else {
            System.out.println("Wrong number format!");
            return false;
        }
    }
}
