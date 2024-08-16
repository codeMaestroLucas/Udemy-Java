import java.util.Scanner;
import java.util.Locale;

public class Ex04 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Times to iterate: ");
        int N = sc.nextInt();

        int first = 0;
        int second = 0;

        for (int i = 0; i < N; i++) {

            System.out.print("Division: ");
            first = sc.nextInt();
            second = sc.nextInt();

            if (second == 0) {
                System.out.println("Impossible division.");
            } else {
                double div = (double) first / second;
                System.out.println(div);
            }

        }
        
        sc.close();
    }
}
