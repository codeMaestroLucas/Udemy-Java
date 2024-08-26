package j_InheritanceAndPolymorphism.Exercises.Ex02.entities;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {

    protected Date manufactureDate;

    public UsedProduct(String name, Double price, Double customsFee, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Convert Date to LocalDate
        LocalDate localDate = this.manufactureDate.toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();
                    
        return String.format("%s (Used) $%,.2f (Manufacture date: %s)",
                                this.name, this.price, fmt.format(localDate));
    }
}
