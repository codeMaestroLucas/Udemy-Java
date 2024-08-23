import java.util.Scanner;
import java.util.Locale;

public class Do_while {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        double celsiusTemp;
        double fharenTemp;
        char awnser;

        do {

            System.out.print("\nType one temperature in celsius: ");
            celsiusTemp = sc.nextDouble();
            fharenTemp = celsiusTemp * 9 / 5 + 32;

            System.out.printf("%.2fºC ------ %.2fºF\n", celsiusTemp, fharenTemp);

            System.out.print("\nContinue? [ \033[32mS\033[m / \033[31mN\033[m ] ");
            awnser = sc.next().charAt(0);

        } while (awnser == 'S' || awnser == 's');

        
        sc.close();
    }
}
