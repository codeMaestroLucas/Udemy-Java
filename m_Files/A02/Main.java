package m_Files.A02;

import java.util.Locale;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        String path = "m_Files\\A02\\text.txt";
        String[] lines = new String[] {
            "Good morning",
            "Good afternoon",
            "Good night"
        };

        // FileWriter fwriter = new FileWriter(path); // Write
        // FileWriter fappend = new FileWriter(path, true); // Append
        
        //! OBS: If the file doesn't exist, it will be created
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine(); // To add an '\n' at the end
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
