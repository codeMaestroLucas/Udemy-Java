import java.util.Scanner;
import java.util.Locale;

public class Ex03 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("-> ");
        int N = sc.nextInt();

        double sum = 0;

        for (int c = 0 ; c < N ; c++) {
            System.out.print("Provide 3 grades: ");
            sum += sc.nextDouble() * 2;
            sum += sc.nextDouble() * 3;
            sum += sc.nextDouble() * 5;

            System.out.println("-".repeat(20));
            System.out.printf("FINAL GRADE: %.1f\n", sum / 10);
            System.out.println("-".repeat(20));
            System.out.println();
            sum = 0;
        }

        
        sc.close();
    }
}
