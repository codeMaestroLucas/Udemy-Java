import java.util.Locale;

public class TernaryExpression {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        int number = (2 > 4) ? 20 : 40;
        //                If True : False
        String name = (10 != 3) ? "Mary" : "Jhon";

        System.out.println(number);
        System.out.println(name);
        
    }
}
