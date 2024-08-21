package Exercises.Array.Ex09.entities;

public class Student {
    
    private String name;
    private double grade1;
    private double grade2;

    public Student(String name, double grade1, double grade2) {
        this.name = name;
        this.grade1 = grade1;
        this.grade2 = grade2;
    }

    public String getName() {
        return this.name;
    }

    public double getGrade1() {
        return this.grade1;
    }

    public double getGrade2() {
        return this.grade2;
    }


    public double getFinalGrade() {
        return (this.getGrade1() + this.getGrade2()) / 2;
    }

}
