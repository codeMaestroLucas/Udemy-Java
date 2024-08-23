
import java.util.Scanner;
import java.util.Locale;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        // Operations with data]
        LocalDate d01 = LocalDate.parse("2024-08-23");

        LocalDate sumOperation = d01.plusDays(30);
        LocalDate subOperation = d01.minusDays(30);
        // LocalDate x = d01.plus

        System.out.println("Actual: " + d01);
        System.out.println("Next Month: " + sumOperation);
        System.out.println("Last Month: " + subOperation);

        
        Instant d02 = Instant.now();
        Instant sumInstant = d02.plus(7, ChronoUnit.DAYS);
        Instant subInstant = d02.minus(7, ChronoUnit.DAYS);

        System.out.println("Instant: " + d02);
        System.out.println("Next Week Instant: " + sumInstant);
        System.out.println("Last Week Instant: " + subInstant);

        Duration timeBetween = Duration.between(subInstant, d02);
                                             // StartTime    EndTime
        System.out.println(timeBetween.toDays());
        System.out.println(timeBetween.toHours());
        
        sc.close();
    }
}
