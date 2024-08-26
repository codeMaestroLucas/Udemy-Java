package i_EnumAndComposition.Exercises.Ex03.entities;

import entities.enums.OrderStatus;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Order {
    
    private Instant moment;
    private OrderStatus status;
    private Client client;
    private ArrayList<OrderItem> orderItens = new ArrayList<>();


    public Order(OrderStatus status, Client client) {
        this.moment = Instant.now();
        this.status = status;
        this.client = client;
    }
    public void addOrderItem(OrderItem orderItem) {
        this.orderItens.add(orderItem);
        System.out.println("Order Item \033[32madded\033[m.");
    }

    public void removeOrderItem(OrderItem orderItem) {
        this.orderItens.remove(orderItem);
        System.out.println("Order Item \033[31mremoved\033[m");
    }

    public Double total() {
        Double total = 0.0;

        for (OrderItem orderItem : orderItens) {
            total += orderItem.getTotal_price();
        }

        return total;
    }


    public Instant getMoment() {
        return this.moment;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public String getOrderItens() {
        if (this.orderItens.isEmpty()) {
            return "No items.";
        }
        
        StringBuilder sb = new StringBuilder();

        for (OrderItem ordItem : this.orderItens) {
            sb.append(ordItem).append("\n");
        }

        return sb.toString();
    }

    public Client getClient() {
        return this.client;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern(
            "dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());

        StringBuilder sb = new StringBuilder();
        sb.append("\nORDER SUMMARY\n");
        sb.append("MOMENT: " + fmt1.format(this.moment)).append("\n");
        sb.append("STATUS: " + this.status).append("\n");
        sb.append("CLIENT:\n" + this.client).append("\n");
        sb.append("ORDER ITEMS:\n" + getOrderItens()).append("\n");
        sb.append("=".repeat(50)).append("\n");
        sb.append(String.format("TOTAL: \033[1;32m$%,.2f\033[m", total())).append("\n");
        sb.append("=".repeat(50));
        
        
        return sb.toString();
    }
    

}
