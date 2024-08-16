import java.util.Scanner;
import java.util.Locale;

public class Ex06 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Number: ");
        int number = sc.nextInt();

        System.out.println();

        for (int c = 1 ; c < number + 1 ; c++) {
            if (number % c == 0) {
                System.out.println(c);
            }
        }
        
        sc.close();
    }
}
