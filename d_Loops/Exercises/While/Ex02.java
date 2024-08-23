import java.util.Scanner;
import java.util.Locale;

public class Ex02 {
    public static void determinateQuadrant(double x, double y) {

        if (x == 0 || y == 0) {return ;}

        if (x > 0) {
            System.out.println((y > 0) ? "Q1" : "Q4");
        } else if (x < 0) {
            System.out.println((y > 0)? "Q2" : "Q3");
        }

    }


    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Type the X and Y coordinates." +
        "To stop the loop, type one of then null.");
        
        double x = 1;
        double y = 1;

        while (x != 0 && y != 0) {
            System.out.println("X and Y");
            x = sc.nextDouble();
            y = sc.nextDouble();

            determinateQuadrant(x, y);
            System.out.println("-".repeat(30));
        }


        sc.close();
    }
}
