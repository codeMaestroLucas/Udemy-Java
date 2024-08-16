import java.math.BigInteger;
import java.util.Scanner;
import java.util.Locale;

public class Ex05 {

    public static BigInteger fatorial(int number) { // BitInteger to get the bigger values
        if (number <= 1) {
            return BigInteger.ONE;
        }

        return BigInteger.valueOf(number).multiply(fatorial(number - 1));
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        BigInteger result = fatorial(sc.nextInt());

        System.out.println(result);

        sc.close();
    }
}
