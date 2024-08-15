import java.util.Scanner;
import java.util.Locale;

public class Ex06 {

    public static void determinateInterval(int number) {
        if (0 <= number && number <= 25) {
            System.out.println("Interval: [0-25]");
        } else if (25 < number && number <= 50) {
            System.out.println("Interval: (25-50]");
        } else if (50 < number && number <= 75) {
            System.out.println("Interval: (50-75]");
        } else if (75 < number && number <= 100) {
            System.out.println("Interval: (75-100]");
        } else {
            System.out.println("Number is outside the specified interval of 0 - 100");
        }
    }


    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Number: ");
        int value = sc.nextInt();
        
        determinateInterval(value);

        sc.close();
    }
}
