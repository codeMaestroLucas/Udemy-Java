package i_EnumAndComposition.Exercises.Ex01.entities;

import i_EnumAndComposition.Exercises.Ex01.entities.enums.WorkerLevel;

public class Worker {
    
    private String name;
    private WorkerLevel level;
    private double baseSalary;


    public Worker(String name, WorkerLevel level, double baseSalary) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
    }


    public void addContract(HourContract contract) {

    }

    public void removeContract(HourContract contract) {

    }

    public Double income(Integer year, Integer month) {
        return 0.0;
    }

}
