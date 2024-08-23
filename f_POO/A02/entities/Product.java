package A02.entities;

public class Product {
    
    public String name;
    public double price;
    public int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getTotalValue() {
        return String.format("\033[32m$%.2f\033[m",
                                            price * quantity);
    }

    public void addProducts(int quantity_to_add) {
        if (quantity_to_add <= 0) {
            System.out.println("Can't remove products with the function " +
            "addProducts\nUse the function removeProducts instead.");
            return;
        }

        this.quantity += quantity_to_add;
        System.out.printf("%dx added to %s.\n",
                          quantity_to_add, this.name);
    }

    public void removeProducts(int quantity_to_remove) {
        if (quantity_to_remove <= 0) {
            System.out.println("Can't add products with the function " +
            "removeProducts\nUse the function addProducts instead.");
            return;
        }

        if (this.quantity - quantity_to_remove < 0) {
            System.out.printf("Not enough products to remove. Only have " +
            "%d products in stock.\n", this.quantity);
            return;
        }

        this.quantity -= quantity_to_remove;

    }

    @Override
    public String toString() {
        return String.format("Name: %s\nPrice: %s\nIn Stock: %d\n",
                                    this.name, getTotalValue(), this.quantity);
    }


}
