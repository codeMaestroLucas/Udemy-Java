package i_EnumAndComposition.Exercises.Ex03.app;

import i_EnumAndComposition.Exercises.Ex03.entities.Client;
import i_EnumAndComposition.Exercises.Ex03.entities.Order;
import i_EnumAndComposition.Exercises.Ex03.entities.OrderItem;
import i_EnumAndComposition.Exercises.Ex03.entities.Product;

import java.time.LocalDate;
import java.util.Locale;

import entities.enums.OrderStatus;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);

        LocalDate d1 = LocalDate.parse("2001-03-02");
        
        Order o1 = new Order(OrderStatus.PENDING_PAYMENT, new Client(
            "Lucas", "lucas@email", d1));

        System.out.println(o1);

        OrderItem orderItem1 = new OrderItem(
            new Product("Beans", 10.5),
            10);

        OrderItem orderItem2 = new OrderItem(
            new Product("Raw Meat", 48.9),
            2);

        OrderItem orderItem3 = new OrderItem(
            new Product("Rice", 15.8),
            5);

        o1.addOrderItem(orderItem1);
        o1.addOrderItem(orderItem2);
        o1.addOrderItem(orderItem3);

        System.out.println(o1);

        o1.removeOrderItem(orderItem3);

        System.out.println(o1);
        
    }
}
