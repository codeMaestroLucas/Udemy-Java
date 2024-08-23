
package entities;

import java.util.Date;
import entities.enums.OrderStatus;

public class Order {
    
    private Integer id;
    private Date moment;
    private OrderStatus status;

    
    public Order(Integer id, Date moment, OrderStatus status) {
        this.id = id;
        this.moment = moment;
        this.status = status;
    }


    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMoment() {
        return this.moment;
    }
    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return this.status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        String txt = "ORDER DATA";
        String separator1 = "=".repeat(50);
        String separator2 = "=".repeat(50);

        String heading = " ".repeat(
            (separator1.length() - txt.length()) / 2
        ) + txt;

        sb.append(separator1).append("\n");
        // sb.append(separator1 + "\n");
        sb.append(heading).append("\n");
        sb.append(separator2).append("\n");

        sb.append(STR."ID: \{this.getId()}").append("\n");
        sb.append(STR."Date: \{this.getMoment()}").append("\n");
        sb.append(STR."STATUS: \{this.getStatus()}").append("\n");


        sb.append(separator1).append("\n");

        return sb.toString();

    }


}
