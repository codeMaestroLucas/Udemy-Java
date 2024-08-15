import java.util.Scanner;
import java.util.Locale;

public class Ex04 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        int number;
        double hours_worked, hourly_wage;

        System.out.print("Employee Number: ");
        number = sc.nextInt();

        System.out.print("Hours Worked: ");
        hours_worked = sc.nextDouble();

        System.out.print("Hourly Wage: ");
        hourly_wage = sc.nextDouble();

        String separator1 = "=".repeat(50);
        String separator2 = "-".repeat(50);
        String heading = "Data".toUpperCase();
        String formattedSpaces = " ".repeat(
            (separator1.length() - heading.length()) / 2
        );

        System.out.println(separator1);
        System.out.println(formattedSpaces + heading);
        System.out.println(separator2);

        System.out.printf("Employee Number: %d;\n" +
                          "Hours Worked: %.2fh;\n" +
                          "Hourly Wage: \033[32m$%.2f\033[m;\n" +
                          "MONTH WAGE: \033[1;32m$%.2f\033[m;\n",
                          number, hours_worked, hourly_wage,
                          hours_worked * hourly_wage);

        System.out.println(separator1);

        sc.close();
    }
}
