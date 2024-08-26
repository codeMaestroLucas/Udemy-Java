package j_InheritanceAndPolymorphism.Exercises.Ex02.entities;

public class Product {
    
    protected String name;
    protected Double price;


    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    public String priceTag() {
        return String.format("%s: $%,.2f", this.name, this.price);
    }

}
