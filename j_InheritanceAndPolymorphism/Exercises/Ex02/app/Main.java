package j_InheritanceAndPolymorphism.Exercises.Ex02.app;

import java.util.Scanner;
import java.util.Locale;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import j_InheritanceAndPolymorphism.Exercises.Ex02.entities.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Product> products = new ArrayList<Product>();

    public static void registerProducts(Integer numberOfProducts) throws ParseException {
        for (int i = 0; i < numberOfProducts; i++) {
            Product p;

            System.out.println(STR."\033[1mPRODUCT #\{i +  1} DATA \033[m");
            System.out.print("[C]ommun, [U]sed or [I]mported? ");
            char typeOfProduct = sc.next().trim().toUpperCase().charAt(0);

            System.out.print("Product name: ");
            String name = sc.next().trim();

            System.out.print("Product price: $");
            Double price = sc.nextDouble();




            if (typeOfProduct == 'U') {
                System.out.print("Date (DD/MM/YYYY): ");
                String dateInput = sc.next();

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false);
                Date date = dateFormat.parse(dateInput);

                p = new UsedProduct(name, price, date);

            } else if (typeOfProduct == 'I') {
                System.out.print("Custom Fee: $");
                Double customFee  = sc.nextDouble();
                p = new ImportedProduct(name, price, customFee);

            } else {
                p = new Product(name, price);

            }

            products.add(p);

        }
    }

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        
        System.out.print("Enter the number of products: ");
        registerProducts(sc.nextInt());

        System.out.println();
        for (Product p : products) {
            System.out.println(p.priceTag());
        }

        sc.close();
    }
}
