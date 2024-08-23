package A02.app;

import A02.entities.Product;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Produc Data:");
        System.out.println("NAME PRICE QUANTITY");
        Product p1 = new Product(sc.next(), sc.nextDouble(), sc.nextInt());

        p1.addProducts(-32);
        p1.addProducts(3);
        p1.removeProducts(-32);
        p1.removeProducts(1);
        System.out.println(p1.quantity);
        p1.removeProducts(200);
        System.out.println(p1.getTotalValue());
        
        System.out.println(p1);

        sc.close();
    }
}
