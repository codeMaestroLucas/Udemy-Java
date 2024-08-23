import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        String separator = "-".repeat(70);

        LocalDate d01 = LocalDate.now();
        System.out.println("LocalDATE: " + d01);
        // System.out.println("LocalDATE: ", d01.toString());
        System.out.println(separator);

        LocalDateTime d02 = LocalDateTime.now();
        System.out.println("LocalDATETIME" + d02);
        System.out.println(separator);

        Instant d03 = Instant.now();
        System.out.println("Instant: " + d03);
        System.out.println(separator);

        LocalDate d04 = LocalDate.parse("2022-07-20"); // String in a IOS
        // format to LocalDate
        // ! Works in all the time-date, Instant...
        System.out.println("Parsed Date: " + d04);
        System.out.println(separator);

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Formatted DATA1: " + d04.format(fmt1));

        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy   HH:mm:ss");
        System.out.println("Formatted DATA2: " + d02.format(fmt2));

        // First, convert Instant to ZonedDateTime
        ZonedDateTime zonedDateTime = d03.atZone(ZoneId.systemDefault());
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern(
                "dd/MM/yyyy   HH:mm:ss    XXX")
                .withZone(ZoneId.systemDefault());

        System.out.println("Formatted DATA3: " + fmt3.format(zonedDateTime));

        ZonedDateTime zonedDateTimeNY = d03.atZone(ZoneId.of("America/New_York"));
        DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern(
                "dd/MM/yyyy   HH:mm:ss    XXX")
                .withZone(ZoneId.of("America/New_York"));

        System.out.println("Formatted DATA4: " + fmt4.format(zonedDateTimeNY));

        System.out.println(separator);

        sc.close();
    }
}
