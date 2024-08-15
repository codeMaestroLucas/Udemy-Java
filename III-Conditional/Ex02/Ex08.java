import java.util.Scanner;
import java.util.Locale;

public class Ex08 {

    public static void calculateTax(double salary) {
        double taxToPay = 0;

        if (salary <= 2000) {
            System.out.println("No Tax");
            return;

        } else if (salary <= 3000) {
            taxToPay = (salary - 2000) * 0.08;

        } else if (salary <= 4500) {
            taxToPay = (3000 - 2000) * 0.08;
            taxToPay += (salary - 3000) * 0.18;
            
        } else {
            taxToPay = (3000 - 2000) * 0.08;
            taxToPay += (4500 - 3000) * 0.18;
            taxToPay += (salary - 4500) * 0.28;
        }

        System.out.printf("TAX: %.2f%n", taxToPay);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.print("Salary: ");
        double salary = sc.nextDouble();

        calculateTax(salary);

        sc.close();
    }
}
