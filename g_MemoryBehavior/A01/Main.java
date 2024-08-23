
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Times to iterate: ");
        int times = sc.nextInt();

        double[] heightCollector = new double[times];
        double avg_height = 0;

        for (int c = 0 ; c < times ; c++) {
            System.out.printf("%dst Height: ", c + 1);
            heightCollector[c] = sc.nextDouble();
            avg_height += heightCollector[c];

            System.out.println();
        }
        
        System.out.printf("AVERAGE HEIGHT: %.2f\n", avg_height / times);
        
        sc.close();
    }
}
