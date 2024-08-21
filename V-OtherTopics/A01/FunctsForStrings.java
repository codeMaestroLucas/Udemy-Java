import java.util.Scanner;
import java.util.Locale;

public class FunctsForStrings {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        String changeString = " e a String To BE CHanGeD            ";

        System.out.printf("Normal: %s-\nLower Case: %s-\nUpper Case: %s-\n",
        changeString, changeString.toLowerCase(), changeString.toUpperCase());

        System.out.printf("TRIM: %s --\n", changeString.trim());

        System.out.println("=".repeat(30));

        String subString1 = changeString.substring(4);
        // A sub string starting with the forth caracter in the normal string
        
        String subString2 = changeString.substring(3,  7);
        // A sub string starting with the third caracter thill the seventh

        System.out.printf("SUB1: %s\nSUB2: %s\n", subString1, subString2);

        System.out.println("=".repeat(30));
        
        String replaceString1 = changeString.replace('T', '*');
        String replaceString2 = changeString.replace("String", "cake");
        
        System.out.printf("REPLACED STRING1: %s\nREPLACED STRING2: %s\n",
        replaceString1, replaceString2);

        System.out.println("=".repeat(30));
        
        System.out.printf("First index of\"e\": %d\n", changeString.indexOf("e"));
        System.out.printf("Last index of\"e\": %d\n", changeString.lastIndexOf("e"));
        
        System.out.println("=".repeat(30));

        String[] vect = changeString.split(" ");

        for (int c = 0 ; c < vect.length ; c++) {
            System.out.printf("VECT[%d] ----  %s\n", c, vect[c]);
        }


        sc.close();
    }
}
