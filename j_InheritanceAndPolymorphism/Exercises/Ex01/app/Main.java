package j_InheritanceAndPolymorphism.Exercises.Ex01.app;

import j_InheritanceAndPolymorphism.Exercises.Ex01.entities.*;

import java.util.Scanner;
import java.util.Locale;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);


    public static void registerEmployees(Integer numberOfEmployees) {
        for (int c = 0 ; c < numberOfEmployees ; c++) {
            Employee e;

            System.out.println(STR."\033[1mEmployee #\{c + 1} Data\033[m");
            System.out.print("Outsourced? [ Y / N ] ");
            char outsourced = sc.next().toUpperCase().charAt(0);
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.next().trim();

            System.out.print("Hours: ");
            Integer hours = sc.nextInt();
            
            System.out.print("Value per Hours: ");
            Double valuePerHour = sc.nextDouble();

            if (outsourced == 'Y') {
                System.out.print("Additional Charge: ");
                Double adttCharge = sc.nextDouble();
                
                e = new OutsourcedEmployee(name, hours, valuePerHour, adttCharge);

            } else {
                e = new Employee(name, hours, valuePerHour);
            }


            employees.add(e);

        }
    };

    public static void readEmployees() {
        System.out.println();
        System.out.println("PAYMENTS:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    };

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        
        System.out.print("Enter the number of employees: ");
        registerEmployees(sc.nextInt());

        readEmployees();
        
        sc.close();
    }
}