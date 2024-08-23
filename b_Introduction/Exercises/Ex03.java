import java.util.Scanner;
import java.util.Locale;

public class Ex03 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        int a, b, c, d;

        System.out.println("Numbers: ");
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        System.out.println("(A * B - C * D)");
        System.out.printf("(%d * %d - %d * %d) == %d\n",
                                    a, b, c, d, (a * b - c * d));
        
        sc.close();
    }
}
