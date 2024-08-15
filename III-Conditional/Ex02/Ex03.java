import java.util.Scanner;
import java.util.Locale;

public class Ex03 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        int x, y;

        System.out.print("Numbers: ");
        x = sc.nextInt();
        y = sc.nextInt();

        if (x % y == 0) {
            System.out.printf("%d is divisible by %d\n", x, y);
        } else {
            System.out.printf("%d is not divisible by %d\n", x, y);
        }
        
        sc.close();
    }
}
