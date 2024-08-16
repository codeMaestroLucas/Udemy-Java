import java.util.Scanner;
import java.util.Locale;

public class Ex02 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        int N, X, qtdIn, qtdOut;

        N = 0;
        X = 0;
        qtdIn = 0;
        qtdOut = 0;
        
        System.out.print("Times to iterate: ");
        N = sc.nextInt();

        for (int i = 0 ; i < N ; i++) {
            
            System.out.printf("%dst X value: ", i + 1 );
            X = sc.nextInt();

            if (10 <= X && X <= 20) {
                qtdIn++;
            } else {
                qtdOut++;
            }

        }

        System.out.println(qtdIn + " in");
        System.out.println(qtdOut + " out");

        sc.close();
    }
}
