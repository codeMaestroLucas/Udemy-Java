import java.util.Locale;
import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        
        int sum = 0;
        int option = 1;

        System.out.println("Type one number\nType \033[1;31m0\033[m to break the loop.");
        while (option != 0) {
            System.out.print("-> ");
            option = sc.nextInt();
            sum += option;

        }

        System.out.println("SUM: " + sum);

        sc.close();
        
        
    }
}
