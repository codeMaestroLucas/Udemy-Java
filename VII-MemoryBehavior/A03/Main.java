package A03;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Locale;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        // List Operations

        List<Integer> number = new ArrayList<>();

        number.add(12); // Added on the last position;
        number.add(0, 13); // Inserted the element '13' on index 0

        System.out.println(number.size());  // Len of the list

        // number.remove(2); // Removed on the position '2' => Index of Error
        number.remove(1);
        number.remove(0);

        for (int i = 0; i < 11; i++) {

            number.add(i);

        }

        Integer[] otherList = {1, 2, 3, 4};
        number.removeAll(Arrays.asList(otherList)); // Remove all the elements from
        // the list `number` that also are in `otherList`.
        number.removeFirst(); // Remove the first element
        number.removeLast(); // Remove the last element
        number.removeIf(x -> x % 2 == 0); // Remove as a Predicate - LAMBDAS
        // Remove all the elements (x) from the list that are odd.


        System.out.println("Postion of the number '3': " + number.indexOf(3));
        System.out.println("Postion of the number '5': " + number.indexOf(5));

        number.add(5);
        number.add(2);
        number.add(4);
        number.add(8);

        System.out.println("Last Postion of the number '5': " + number.lastIndexOf(5));


        System.out.println(STR."All the list: \{number}");


        List<Integer> even_numbers = number.stream()
                                    .filter(x -> x % 2 != 0)
                                    .collect(Collectors.toList());

        System.out.println(STR."Even numbers \{even_numbers}");


        Integer number8 = number.stream()
                          .filter(x -> x == 8)
                          .findFirst()
                          .orElse(-1);
                          
        System.out.println(number8);

        
        sc.close();
    }
}
