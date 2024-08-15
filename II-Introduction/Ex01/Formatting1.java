import java.util.Locale;

public class Formatting1 {

    public static void main(String[] args) {

        
        System.out.println("Hello World!");
        
        int a = 32;
        double b = 23.2464;

        String separator = "=".repeat(30);

         System.out.printf("%d + %f = %.2f\n", a, b, a + b);
        // With an "," separator, and not an "."
        // To fix this u have 2 options
        
        System.out.println(separator);

        // 1) Locale on the print
        System.out.printf(Locale.US , "%d + %f = %.2f\n", a, b, a + b);

        System.out.println(separator);

        // 2) Set the default locale to US before printing - recommended
        Locale.setDefault(Locale.US);
        System.out.printf("%d + %f = %.2f\n", a, b, a + b);

        /*
         * %s => For Strings (more than one char)
         * %d => For int
         * %f => For float
            * U also can format it like this: %.2f
         */

    }
}