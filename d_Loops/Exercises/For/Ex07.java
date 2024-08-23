import java.util.Scanner;
import java.util.Locale;

public class Ex07 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Number: ");
        int number = sc.nextInt();

        for (int i = 1 ; i < number + 1 ; i++) {

            System.out.printf("%-5d   %-5.0f   %.0f", i, Math.pow(i, 2), Math.pow(i, 3));
            System.out.println();
        }
        
        sc.close();
    }
}
