import java.util.Locale;

public class Bhaskara {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);

        double a, b, c, delta, x1, x2;

        a = 3.0;
        b = 12.0;
        c = 9.0;

        delta = Math.pow(b, 2) - (4 * a * c);

        x1 = (- b + Math.sqrt(delta) / 2 * a);
        x2 = (- b - Math.sqrt(delta) / 2 * a);

        System.out.println("x1: " + x1);
        System.out.println("x2: " + x2);
        
    }
}
