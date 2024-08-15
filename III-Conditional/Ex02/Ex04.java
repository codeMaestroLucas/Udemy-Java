import java.util.Scanner;
import java.util.Locale;

public class Ex04 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Time-start & Time-end");
        int h1 = sc.nextInt();
        int h2 = sc.nextInt();

        int total_time;

        if (h1 >= h2) {
            total_time = h2 + 24 - h1;
        } else {
            total_time = h2 - h1;
        }

        System.out.printf("The match lasted %d hour(s)\n", total_time);
        
        sc.close();
    }
}
