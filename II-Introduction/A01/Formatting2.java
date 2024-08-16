import java.util.Locale;

public class Formatting2 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        int number = 9;

        System.out.printf("%05d\n", number);

        System.out.printf("%-5d Ola\n", number);

        System.out.printf("Oi%n");
        System.out.printf("Oi%n");
        System.out.printf("%20s", "ola formatado".toUpperCase());
        System.out.printf("   %-20s", "oi aqui");
        System.out.printf("Oi%n");

        /*
         * right to left format: positive numbers
         * left to right format: negative numbers
         */

         System.out.printf("%-20s %20s", "oi", "como vai?");

    }
}