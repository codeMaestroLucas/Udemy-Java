import java.util.Scanner;
import java.util.Locale;

public class Ex01 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("-> ");
        int number_to_check = sc.nextInt();

        for (int c = 1 ; c < number_to_check + 1 ; c++) {
            if (c % 2 != 0) {
                System.out.print(c + " ");
            }
        }
        
        sc.close();
    }
}
