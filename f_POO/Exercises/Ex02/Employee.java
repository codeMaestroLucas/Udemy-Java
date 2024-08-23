package Exercises.Ex02;

public class Employee {
    
    private String name;
    private double grossSalary;
    private double tax;

    public Employee(String name, double grossSalary, double tax) {
        this.name = name;
        this.grossSalary = grossSalary;
        this.tax = tax;
    }

    @Override
    public String toString() {
        double netSalary = grossSalary * (1 - tax / 100);
        return String.format("Employee: %s, $%.2f", this.name, netSalary);
    }


    public void increaseSalary(double percentage_to_increase) {
        this.grossSalary *= (1 + percentage_to_increase / 100);
        System.out.println("Updated Data: " + toString());
    }

}
