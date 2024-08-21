package A02.app;

import java.util.Scanner;

import A02.entities.Product;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Times to iterate: ");
        int times = sc.nextInt();

        Product[] products = new Product[times];
        double avg_price = 0;

        for (int c = 0 ; c < times ; c++) {

            System.out.println("Product NAME & VALUE");
            products[c] = new Product(sc.next(),        // Name
                                      sc.nextDouble()); // Price
            avg_price += products[c].getPrice();

        }

        System.out.printf("AVERAGE PRICE: $%.2f\n", avg_price / times);
        
        sc.close();
    }
}
