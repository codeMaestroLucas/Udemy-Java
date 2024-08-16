import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        String prod1 = "Computer";
        String prod2 = "Office Desk";

        double price1 = 299.99;
        double price2 = 150.50;

        int age = 30;
        int code = 5290;
        char gender = 'M';

        double measure = 53.234567;

        String separator = "=".repeat(50);
        String heading = "Products".toUpperCase();
        String formattedSpaces = " ".repeat(
            (separator.length() - heading.length()) / 2);

        System.out.println(separator);
        System.out.println(formattedSpaces + heading);
        System.out.println(separator);

        System.out.printf("%s, which price is $%.2f\n", prod1, price1);
        System.out.printf("%s, which price is $%.2f\n", prod2, price2);

        System.out.printf("Record: %d years old;\n" +
                          "Code: %d;\n" +
                          "Gender: %c\n", age, code, gender);

        System.out.printf("Measure with eight decimal places: %.8f\n", measure);
        System.out.printf("Rounded with three decimal places: %.3f\n", measure);
        
        int a, b;

        a = 5;
        b = 2;
    
        double result = a / b;

        System.out.println(result);
        // Output: 2 -> int / int == int
        System.out.println((double) a / b);
        // Output: 2.5 -> Casting it results to a double

    }
}
