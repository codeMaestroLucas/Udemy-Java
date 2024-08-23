package A03;

import java.util.Scanner;
import java.util.Locale;

public class Main  {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("What is the dollar price? ");
        double dollar_price = sc.nextDouble();

        System.out.print("How many dollars have you bought? ");
        double dollar_bought = sc.nextDouble();

        CurrencyConverter c1 = new CurrencyConverter(dollar_price, dollar_bought);

        System.out.println(c1.convertValueToReias());
        
        sc.close();
    }
}
