import java.util.Scanner;
import java.util.Locale;

public class For {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        int sum = 0;
        System.out.print("-> ");
        int number = sc.nextInt();

        for (int i = 1 ; i < number + 1 ; i++) {
            sum += i;
        }

        System.out.println("SUM: " + sum);

        System.out.print("Let's make an count down: ");
        int count_down = sc.nextInt();
        
        for (int c = count_down ; c > 0 ; c--) {
            System.out.println(c + "s");
        }
        System.out.println("End of count down");
        sc.close();
    }
}
