
import java.util.Scanner;
import java.util.Locale;

public class Ex05 {

    public static class Product {
        private int code;
        private String name;
        private double price;

        public Product(int code, String name, double price) {
            this.code = code;
            this.name = name;
            this.price = price;
        }


        public int getCode() {
            return code;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            // Ensure the format aligns with the header
            return String.format("  %-15d %-20s $%-15.2f",
                                    this.code, this.name, this.price);
        }
    }


    public static void printMenu(Product[] products) {
        String separator1 = "=".repeat(50);
        String separator2 = "-".repeat(50);
        String heading = "MENU";
        String mainIndentation = " ".repeat(
                (separator1.length() - heading.length()) / 2);

        System.out.println(separator1);
        System.out.println(mainIndentation + heading);
        System.out.println(separator2);
        System.out.printf("  %-15s %-20s %-15s%n", "CODE", "PROD_NAME", "VALUE");
        System.out.println(separator2);

        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println(separator1);
        System.out.println();
    }


    public static void calculateTotalValue(Product[] products,
                                           int code,
                                           int quantity) {
        double totalValue = 0;

        for (Product product : products) {
            if (code == product.getCode()) {
                totalValue = product.getPrice() * quantity;
                System.out.printf("Total Value: \033[1;32m$%.2f%n\033[m", totalValue);
                return ;
            }
        }

        System.out.printf("\033[31mDidn't find the product with the %d code\033[m", code);
    }


    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        Product[] products = new Product[5];

        products[0] = new Product(1, "HotDog", 4.9);
        products[1] = new Product(2, "Pizza", 12);
        products[2] = new Product(3, "Hamburger", 8);
        products[3] = new Product(4, "Salad", 5.30);
        products[4] = new Product(5, "Soda", 2.50);

        printMenu(products);

        int code, quantity;

        System.out.print("Enter the product code and the quantity u want: ");
        code = sc.nextInt();
        quantity = sc.nextInt();
        System.out.println();


        calculateTotalValue(products, code, quantity);

        sc.close();
    }
}
