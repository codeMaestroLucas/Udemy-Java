import java.util.Scanner;
import java.util.Locale;

public class Scanner1 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        int a, b;

        System.out.print("A: ");
        a = sc.nextInt();

        System.out.print("B: ");
        b = sc.nextInt();

        System.out.printf("%d + %d = %d\n", a, b, a + b);
        
        String name;
        char firstLetter;
        System.out.print("Enter your name: ");
        name = sc.next(); // The `next` reads just one word per time
        // To read more than one word u need to use the `nextLine()`
        firstLetter = name.charAt(0);

        System.out.println(name + " ---- " + firstLetter);

        double c;
        System.out.print("Enter a decimal number: ");
        c = sc.nextDouble();

        System.out.printf("%.5f\n", c);


        // More than one Input inline
        String m;
        int n;
        double o;

        m = sc.next();
        n = sc.nextInt();
        o = sc.nextDouble();

        System.out.printf("M: %s;\n" +
                          "N: %d;\n" +
                          "O: %.2f;\n", m, n, o);
        
        sc.close();
    }
}
