import java.util.Scanner;
import java.util.Locale;

public class Ex01 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("X: ");
        int x = sc.nextInt();

        if (x < 0) {
            System.out.println("X is \033[31mnegative\033[m.");
        } else {
            System.out.println("X is \033[32mpositive\033[m.");
        }
        
        sc.close();
    }
}
