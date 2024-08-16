import java.util.Scanner;
import java.util.Locale;

public class Ex01 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        int password = 2002;
        int option = 0;

        while (option != password) {
            System.out.print("Enter password: ");
            option = sc.nextInt();

            if (option!= password) {
                System.out.println("\033[31mIncorrect password!\033[m Try again.");
                System.out.println("-".repeat(30));
            }
        }
        System.out.println("=".repeat(30));
        System.out.println("\033[32mAccess Granted!\033[m");
        
        sc.close();
    }
}
