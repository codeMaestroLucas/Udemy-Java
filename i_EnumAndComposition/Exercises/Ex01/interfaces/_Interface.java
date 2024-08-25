package i_EnumAndComposition.Exercises.Ex01.interfaces;

import java.util.ArrayList;
import java.util.Scanner;

import i_EnumAndComposition.Exercises.Ex01.entities.Worker;
import i_EnumAndComposition.Exercises.Ex01.entities.Department;
import i_EnumAndComposition.Exercises.Ex01.entities.enums.WorkerLevel;

public class _Interface {

    static Scanner sc = new Scanner(System.in);
    static String separator1 = "=".repeat(40);
    static String separator2 = "-".repeat(40);
    static String txt = "";

    static ArrayList<Worker> workers = new ArrayList<>();

    public static void _interface() {

        txt = "MENU";
        String heading = " ".repeat(
                (separator1.length() - txt.length()) / 2) + txt;

        Boolean x = true;
        Worker worker;

        clearScreen();

        while (x) {

            System.out.println();
            System.out.println(separator1);
            System.out.println(heading);
            System.out.println(separator2);

            System.out.printf("%5d - Register a new Worker\n", 1);
            System.out.printf("%5d - Calculate Income\n", 2);
            System.out.printf("%5d - Remove Contract from employee\n", 3);
            System.out.printf("%5d - Out\n", 4);

            System.out.println(separator1);

            System.out.print("\033[33mOption -> \033[m");
            Integer option = sc.nextInt();

            System.out.println();

            switch (option) {

                case 1:
                    clearScreen();
                    registerWorker();
                    break;

                case 2:
                    clearScreen();
                    System.out.print("Employee name: ");
                    worker = findWorkerByName(sc.next().trim());

                    if (worker != null) {
                        worker.income();
                    }

                    break;

                case 3:
                    clearScreen();
                    System.out.print("Employee name: ");
                    worker = findWorkerByName(sc.next().trim());

                    if (worker != null) {
                        worker.removeContract();
                    }

                    break;

                case 4:
                    clearScreen();
                    System.out.println("Goodbye!");
                    x = false;
                    break;
                    
                default:
                    clearScreen();
                    System.out.println("Unknow option!\n\tType agian");

            }

        }

    }

    public static void registerWorker() {

        txt = "WORKER DATA";
        String heading = " ".repeat(
                (separator1.length() - txt.length()) / 2
                ) + txt;

        System.out.println(separator1);
        System.out.println(heading);
        System.out.println(separator2);

        System.out.print("Name: ");
        String wrkName = sc.next().trim();

        System.out.print("Level: ");
        WorkerLevel wrkLevel = WorkerLevel.valueOf(
                sc.next().trim().toUpperCase());

        System.out.print("Base Salary?: $");
        Double wrkBaseSal = sc.nextDouble();

        System.out.print("Department: ");
        Department wrkDepartment = new Department(sc.next().trim());

        Worker wrk = new Worker(wrkName, wrkLevel, wrkBaseSal, wrkDepartment);
        workers.add(wrk);

        System.out.print(STR."How many contracts did \{wrkName} worked in? ");
        Integer wrkNumberOfContratcts = sc.nextInt();

        System.out.println(separator2);

        for (int i = 0; i < wrkNumberOfContratcts; i++) {
            System.out.println(
                    STR."\n\033[3;36mEnter Contract #\{i + 1} data\033[m");
            wrk.addContract();

        }

    }

    /**
     * Find a worker by its name and if found, return it.
     * @param workerName: The name of the worker
     * @return the worker founded or null if not found.
     */
    public static Worker findWorkerByName(String workerName) {

        for (Worker worker : workers) {
            if (worker.getName().equals(workerName)) {
                return worker;
            }

        }
        System.out.println("Didn't found the worker with the name: " +
        STR."\{workerName}.\n Type it again!");
        return null;

    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  // Clrears the terminal screen
        System.out.flush();                 // Garantees that the screen has been cleared
    }

}
