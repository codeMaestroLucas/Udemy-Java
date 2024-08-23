
import entities.Order;
import entities.enums.OrderStatus;
import java.util.Date;
import java.util.Scanner;
import java.util.Locale;


public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);

        Order order01 = new Order(
            123, new Date(), OrderStatus.PENDING_PAYMENT);

        System.out.println(order01);

        System.out.println("Enter the Order Data:");
        System.out.println("Id & Status");

        Order order02 = new Order(
            sc.nextInt(),
            new Date(),
            // new Date(sc.nextLong()),
            OrderStatus.valueOf(sc.next().toUpperCase().trim())
            // The value of this STATUS must match the Enum possible values
        );

        System.out.println(order02);

        
        sc.close();
    }
}

