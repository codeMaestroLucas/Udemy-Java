import java.util.Scanner;
import java.util.Locale;

public class SwitchCase {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        int value = sc.nextInt();
        String weekDay;

        switch (value) {
            case 1:
                weekDay = "Sunday";
                break;

            case 2:
                weekDay = "Monday";
                break;

            case 3:
                weekDay = "Tuesday";
                break;

            case 4:
                weekDay = "Wednesday";
                break;

            case 5:
                weekDay = "Thursday";
                break;

            case 6:
                weekDay = "Friday";
                break;

            case 7:
                weekDay = "Saturday";
                break;
        
            default:   // An else value
                weekDay = "Invalid day";
                break;
        }

        System.out.println("Day: " + weekDay);

        sc.close();
    }
}
