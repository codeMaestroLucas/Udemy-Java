import java.util.Locale;

public class MathLib {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        double x = 3.0;
        double y = 4.0;
        double z = -5.0;
        double A, B, C;

        A = Math.sqrt(y);
        System.out.printf("Square Root of %.0f == %.2f\n", y, A);

        B = Math.pow(x, 5);
        System.out.printf("%.0f ** 5 == %.2f\n", x, B);

        C = Math.abs(z);
        System.out.printf("Absolute Value of %.0f == %.0f\n", z, C);

        
    }
}
