package i_EnumAndComposition.Exercises.Ex01.app;

import java.util.Scanner;
import java.util.Locale;

import i_EnumAndComposition.Exercises.Ex01.entities.HourContract;
import i_EnumAndComposition.Exercises.Ex01.entities.Worker;
import i_EnumAndComposition.Exercises.Ex01.entities.enums.WorkerLevel;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static String separator1 = "=".repeat(50);
    static String separator2 = "-".repeat(50);
    static String txt;
    static String heading = " ".repeat(
        (separator1.length() - txt.length()) / 2
    ) + txt;


    public static void registerWorkers() {

        System.out.println("Enter the number of workers:");
        int n = sc.nextInt();

        for (int c = 0 ; c < n ; c++) {
            txt = "WORKER " + (c + 1);

            System.out.println(separator1);
            System.out.println(heading);
            System.out.println(separator2);
            System.out.println(separator1);
            
        }

    }

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        System.out.println("Enter the Department's Name:");

        registerWorkers();
        
        sc.close();
    }
}
