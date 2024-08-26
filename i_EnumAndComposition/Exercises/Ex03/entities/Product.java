package i_EnumAndComposition.Exercises.Ex03.entities;

public class Product {
    
    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {

        return String.format("%s, $%,.2f", this.name, this.price);

    }

}
