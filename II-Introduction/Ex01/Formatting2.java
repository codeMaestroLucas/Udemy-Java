import java.util.Locale;

public class Formatting2 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        int number = 9;

        System.out.printf("%05d\n", number);

        System.out.printf("%-5d Ola\n", number);

        System.out.printf("Oi%n");
        System.out.printf("Oi%n");

    }
}