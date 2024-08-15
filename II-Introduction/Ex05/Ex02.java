import java.util.Scanner;
import java.util.Locale;

public class Ex02 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        double π = 3.14159;

        System.out.print("Radius of the Circle: ");
        double radius = sc.nextDouble();

        System.out.printf("π * %.2f == %.4f \033[1mU.C\033[m\n", radius, radius * radius * π);
        
        sc.close();
    }
}
