package Exercises.List.Ex01.app;

import Exercises.List.Ex01.entities.Employee;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
    
    // Instance variables as Static
    static Scanner sc = new Scanner(System.in);

    static String separator1 = "=".repeat(50);
    static String separator2 = "-".repeat(50);
    static String txt = "EMPLOYEE DATA";
    static String heading = " ".repeat(
        (separator1.length() - txt.length()) / 2
    ) + txt;
    
    static ArrayList<Employee> employees = new ArrayList<>();


    public static void addEmployees() {

        while (true) {
            System.out.print("Do you want to register a new employee?\n" +
            "[ \033[32mS\033[m / \033[31mN\033[m ]? ");
            char answer = sc.nextLine().trim().toUpperCase().charAt(0);
            System.out.println();

            if (answer == 'N') {
                break;
            }

            System.out.println(separator1);
            System.out.println(heading);
            System.out.println(separator2);
            System.out.println("ID NAME SALARY");

            employees.add(
                new Employee(sc.nextInt(),   // Id
                             sc.next(),      // Name
                             sc.nextDouble() // Salary
                ));

            sc.nextLine(); // Clear input buffer
            System.out.println(separator1);
            System.out.println();

        }
    }

    public static void raiseEmployeeSalary() {

        System.out.print("Enter the employee ID that will have the salary increase: ");
        int idToIncrease = sc.nextInt();
        System.out.print("Enter the percentage to increase: ");
        double percentageToIncrease = sc.nextDouble();

        
        Boolean flag = false;
        for (Employee employee : employees) {
            if (employee.getId() == idToIncrease) {
                employee.raiseSalary(percentageToIncrease);
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("\033[31mEmployee not found.\033[m");
            return;
        }
    }

    public static void listEmployees() {

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }


    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);

        addEmployees();

        raiseEmployeeSalary();

        listEmployees();

        sc.close();
        
    }
}
