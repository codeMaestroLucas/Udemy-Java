package Exercises.Array.Ex09.app;

import Exercises.Array.Ex09.entities.Student;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.print("Times to iterate: ");
        Student[] students = new Student[sc.nextInt()];

        for (int c = 0; c < students.length; c++) {

            System.out.println("STUDENTS DATA\nNAME GRADE1 GRADE2");
            students[c] = new Student(sc.next(), sc.nextDouble(), sc.nextDouble());
            System.out.println();

        }

        System.out.println("=".repeat(20));
        String heading = "APPROVED STUDENTS";
        System.out.println(" ".repeat(
            (20 - heading.length()) / 2)
            + heading);
        System.out.println("-".repeat(20));

        for (Student student : students) {

            if (student.getFinalGrade() >= 6) {
                System.out.printf("%s ---- %.2f\n",
                student.getName(), student.getFinalGrade());
            }

        }
        System.out.println("=".repeat(20));

        sc.close();
    }
}
