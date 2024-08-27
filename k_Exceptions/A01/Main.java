package k_Exceptions.A01;
import java.util.Scanner;
import java.util.Locale;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Names: ");
        String[] vect = sc.nextLine().split(" ");

        System.out.print("Position to read: ");
        try {
            Integer position = sc.nextInt();

            System.out.println(vect[position]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of Bounds. " +
            "Type one number between 0 and " + vect.length);
            e.printStackTrace(); // Show the Stack of execution of that error
            // By default the StackTrace is showed in the terminal execution
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Type an integer.");
            
        } finally {
            System.out.println("This will be executed everytime.");
        }
        
        sc.close();
    }
}
