import java.util.Scanner;
import java.util.Locale;

public class Ex01 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        double valueToPay = 50.0;

        System.out.print("Time in minutes used this month: ");
        double minPerMonth = sc.nextDouble();

        if (minPerMonth > 100) {
            valueToPay += (minPerMonth - 100) * 2;
        }

        System.out.printf("TO PAY: \033[1;32m$%.2f\033[m\n", valueToPay);

        
        sc.close();
    }
}
