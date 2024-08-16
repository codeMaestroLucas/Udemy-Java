import java.util.Scanner;
import java.util.Locale;

public class Ex03 {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  // Clrears the terminal screen
        System.out.flush();                   // Garantees that the screen has been cleared
    }

    public static void printMenu() {
        String separator1 = "=".repeat(30);
        String separator2 = "-".repeat(30);
        String headingTxt = "MENU";
        String centralizedHeading = " ".repeat(
                (separator1.length() - headingTxt.length()) / 2) + headingTxt;

        System.out.println(separator1);
        System.out.println(centralizedHeading);
        System.out.println(separator2);
        System.out.printf(" %6s %15s\n", "CODE", "PRODUCT");
        System.out.println(separator2);

        System.out.printf("    %-12d %s\n", 1, "Alcohol");
        System.out.printf("    %-12d %s\n", 2, "Gasolin");
        System.out.printf("    %-12d %s\n", 3, "Diesel");
        System.out.printf("    %-12d %s\n", 4, "End");

        System.out.println(separator1);

    }

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        int option, qtdAlc, qtdGas, qtdDies;

        option = 0;
        qtdAlc = 0;
        qtdGas = 0;
        qtdDies = 0;

        while (option != 4) {

            printMenu();
            System.out.print("Option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    qtdAlc += 1;
                    clearScreen();
                    System.out.println("Alcohol \033[1;32m+1\033[m");
                    break;

                case 2:
                    qtdGas += 1;
                    clearScreen();
                    System.out.println("Gasolin \033[1;32m+1\033[m");
                    break;

                case 3:
                    qtdDies += 1;
                    clearScreen();
                    System.out.println("Diesel \033[1;32m+1\033[m");
                    break;

                default:
                    clearScreen();
                    System.out.println("\033[31mInvalid option: " + option + "\033[m\n\n");
                    break;
            }

        }

        clearScreen();
        System.out.println("Thanks for using our services!");

        System.out.println("Alcohol: " + qtdAlc);
        System.out.println("Gas: " + qtdGas);
        System.out.println("Diesel: " + qtdDies);

        sc.close();
    }
}
