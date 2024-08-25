package i_EnumAndComposition.Exercises.Ex01.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Objects;


public class HourContract {
    
    private LocalDate date;
    private Double valuePerHour;
    private Integer hours;

    private static Scanner sc = new Scanner(System.in);

    
    public HourContract(LocalDate date, Double valuePerHour, Integer hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    /**
     * Provides an interface to create a new contract instance
     * @return Contract created from the given data
     */
    public static HourContract createContract() {
        System.out.print("DATE (DD/MM/YYYY): ");
        String contractDate = sc.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(contractDate, formatter);

        System.out.print("Value per Hour: ");
        Double contractValuePerHour = sc.nextDouble();

        System.out.print("Durantion in hours: ");
        Integer contractDuration = sc.nextInt();

        return new HourContract(date, contractValuePerHour, contractDuration);
    }

    // To compare objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HourContract that = (HourContract) o;
        return Objects.equals(date, that.date) &&
               Objects.equals(valuePerHour, that.valuePerHour) &&
               Objects.equals(hours, that.hours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, valuePerHour, hours);
    }


    public LocalDate getDate() {
        return this.date;
    }

    public Double getTotalValue() {
        return this.valuePerHour * this.hours;
    }

}
