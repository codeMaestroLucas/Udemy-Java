import java.util.Scanner;
import java.util.Locale;

public class Ex07 {

    public static void determinateQuadrant(double x, double y) {
        if (x == 0 && y == 0) {
            System.out.println("Origin");
        } else if (x == 0) {
            System.out.println("Y-axis");
        } else if (y == 0) {
            System.out.println("X-axis");
        } else if (x > 0) {
            System.out.println(y > 0 ? "Q1" : "Q4");
        } else {
            System.out.println(y > 0 ? "Q2" : "Q3");
        }
    }
    

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.println("Coordinates X & Y");
        double x = sc.nextDouble();
        double y = sc.nextDouble();

        determinateQuadrant(x, y);

        sc.close();
    }
}
