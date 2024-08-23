package Exercises.List.Ex01.entities;

public class Employee {
    
    private Integer id;
    private String name;
    private Double salary;

    public Employee(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void raiseSalary(Double percentageToIncrease) {
        if (percentageToIncrease < 0) {
            System.out.println("Invalid percentage");
            return;
        }

        this.salary *= percentageToIncrease / 100 + 1;
        System.out.printf("Successfully increased the salary of %s"+
        " to \033[32m$%.2f\033[m.\n", this.name, this.salary);
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getSalary() {
        return this.salary;
    }


    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Salary: \033[32m$%,.2f\033[m",
                this.getId(), this.getName(), this.getSalary());
    }



}
