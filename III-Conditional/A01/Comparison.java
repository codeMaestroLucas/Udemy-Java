import java.util.Scanner;
import java.util.Locale;

public class Comparison {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        int x, y;

        System.out.print("X: ");
        x = sc.nextInt();

        System.out.print("Y: ");
        y = sc.nextInt();

        if (x == y) {
            System.out.println("X \033[1;33m==\033[m Y");
        } else if (x > y) {
            System.out.println("X \033[1;32m>\033[m Y");
        } else if (x < y) {
            System.out.println("X \033[1;31m<\033[m Y");
        }

        if (x <= 20 && x == 10) {
            System.out.println("X <= 20 and X == 10");
        }

        if (x > 0 || x < -1) {
            System.out.println("X > 0 or X < -1");
        }

        if (y != 13) {
            System.out.println("Y != 13");
        }
        
        
        sc.close();
    }
}
