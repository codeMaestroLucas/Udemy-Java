package i_EnumAndComposition.Exercises.Ex03.entities;

public class OrderItem {

    private Product product;
    private Integer quantity;
    private Double total_price;

    public OrderItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
        this.total_price = product.getPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getTotal_price() {
        return total_price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(product);
        sb.append(" -> " + this.quantity + "x");
        sb.append(String.format(
            " SUBTOTAL: $%,.2f", this.getTotal_price())
            ).append("\n");
        sb.append("-".repeat(50));
        
        
        return sb.toString();
    }
    

    
}
