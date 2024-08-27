package j_InheritanceAndPolymorphism.Exercises.Ex04.entities;

public class Company extends Person {

    private Integer numberOfEmployees;
    private Double EmployeesTax;
    
    public Company(String name, Double anualIncome, Integer numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;

        this.EmployeesTax = (numberOfEmployees > 10) ? 0.14 : 0.16;
        }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public Double getEmployeesTax() {
        return this.EmployeesTax;
    }


    public Double getTax() {
        return getAnualIncome() * this.EmployeesTax;
    }

}
