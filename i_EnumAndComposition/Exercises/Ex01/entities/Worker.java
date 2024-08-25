package i_EnumAndComposition.Exercises.Ex01.entities;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import i_EnumAndComposition.Exercises.Ex01.entities.enums.WorkerLevel;

public class Worker {

    private static Scanner sc = new Scanner(System.in);

    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private ArrayList<HourContract> contracts = new ArrayList<>();

    public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public void addContract() {
        this.contracts.add(HourContract.createContract());
        System.out.println("Contract added");
    }

    public void removeContract() {
        HourContract contractToRemove = HourContract.createContract();

        Boolean removed = this.contracts.removeIf(
            x -> x.equals(contractToRemove)
            );

        if (removed) {
            System.out.println("\n\033[31mContract removed.\033[m");
        } else {
            System.out.println("Didn't find the contract");
        }

    }

    private Double getIncome(Integer year, Integer month) {
        Double contractSalary = 0.0;

        for (HourContract contract : this.contracts) {
            if (contract.getDate().getYear() == year &&
                contract.getDate().getMonthValue() == month) {
                contractSalary += contract.getTotalValue();
            }
        }

        return this.getBaseSalary() + contractSalary;
    }

    /**
     * Provides an interface to implement the ``getIncome()`` method
     */
    public void income() {
        System.out.print("Enter month and year to calculate the Income (MM/YYYY): ");
        String incomePeriod = sc.next();

        LocalDate date = LocalDate.parse("01/" +
                incomePeriod, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        int targetYear = date.getYear();
        int targetMonth = date.getMonthValue();

        System.out.printf("""
                \n
                NAME: %s
                LEVEL: %s
                DEPARTMENT: %s
                INCOME IN %s: \033[32m$%,.2f\033[m
                \n""",
                this.getName(),
                this.getLevel(),
                this.department.getDepartment(),
                incomePeriod,
                getIncome(targetYear, targetMonth));
    }

    public String getName() {
        return this.name;
    }

    public WorkerLevel getLevel() {
        return this.level;
    }

    public Double getBaseSalary() {
        return this.baseSalary;
    }

}
