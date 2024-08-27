package j_InheritanceAndPolymorphism.Exercises.Ex02.entities;

public class ImportedProduct extends Product {

    protected Double customsFee;

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    @Override
    public String priceTag() {
        return String.format("%s: $%,.2f (Customs fee: $%,.2f)",
                                this.name, this.price + this.customsFee, this.customsFee);
    }

    
}
