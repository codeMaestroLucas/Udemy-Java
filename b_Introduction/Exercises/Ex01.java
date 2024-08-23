import java.util.Scanner;
import java.util.Locale;

public class Ex01 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        int a, b;

        System.out.print("A: ");
        a = sc.nextInt();
        System.out.print("B: ");
        b = sc.nextInt();

        System.out.printf("%d \033[32m+\033[m %d = %d\n", a, b, a + b);
        System.out.printf("%d \033[31m-\033[m %d = %d\n", a, b, a - b);
        System.out.printf("%d \033[33mx\033[m %d = %d\n", a, b, a * b);
        System.out.printf("%d \033[34m/\033[m %d = %d\n", a, b, a / b);
        
        sc.close();
    }
}
