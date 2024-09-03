
import java.util.Scanner;
import java.util.Locale;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = null;
        File file = new File("in.txt");

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }

        } catch (IOException e) {
            // IOException -> base exception when dealing with files
            System.out.println(e.getMessage());

        } finally {
            if (sc != null) { // To garantee that the scanner, if instancieted, is closed.
                sc.close();
            }
        }

        // OOORRR

        String path = "in.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine(); // Goes to the next line of the file
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
