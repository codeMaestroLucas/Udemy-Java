import java.util.Scanner;
import java.util.Locale;

public class Ex02 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("X: ");
        int x = sc.nextInt();

        if (x % 2 == 0) {
            System.out.println("X is even");
        } else {
            System.out.println("X is odd");
        }
        
        sc.close();
    }
}
