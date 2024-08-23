import java.util.Scanner;
import java.util.Locale;

public class Scanner2 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        int x;
        String s1, s2, s3;

        x = sc.nextInt();
        s1 = sc.nextLine();
        s2 = sc.nextLine();
        s3 = sc.nextLine();

        System.out.printf("x: %d;\n" +
                          "s1: %s;\n" +
                          "s2: %s;\n" +
                          "s3: %s;\n",
                          x, s1, s2, s3);

        /*
         * The Problem is caused because the new line in the `nextInt()` is
         * consider as the `nextLine()` of the s1 var. To fix this u need to
         * create a new line between the `x` and `s1`
        */

        x = sc.nextInt();
        sc.nextLine();
        s1 = sc.nextLine();
        s2 = sc.nextLine();
        s3 = sc.nextLine();

        System.out.printf("x: %d;\n" +
                          "s1: %s;\n" +
                          "s2: %s;\n" +
                          "s3: %s;\n",
                          x, s1, s2, s3);
        
        sc.close();
    }
}
