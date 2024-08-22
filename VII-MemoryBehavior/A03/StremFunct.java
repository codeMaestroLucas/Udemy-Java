package A03;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StremFunct {
    
    String separator = "=".repeat(50);

    public StremFunct() {

    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    System.out.println("NORMAL: " + numbers);
    System.out.println(separator);

    // This parallel Stream is commonly used when the CPU cores aren't available
    List<Integer> oddNumbers = numbers.parallelStream()
                               .filter(x -> x % 2 != 0)
                               .collect(Collectors.toList());
    
    System.out.println("ODD: " + oddNumbers);
    System.out.println(separator);
                           

    List<Integer> doubleNumbers = numbers.stream()
                                  .map(x -> x * 2)
                                  .collect(Collectors.toList());

    System.out.println("DOUBLE: " + doubleNumbers);
    System.out.println(separator);
                              

    List<Integer> divisibleBy5and8 = numbers.stream()
                                    .map(x -> x * 10)
                                    .filter(x -> x % 5 == 0 && x % 8 == 0)
                                    .collect(Collectors.toList());

    System.out.println(divisibleBy5and8);
    System.out.println(separator);

    Optional<Integer> firstEvenNumber = numbers.stream()  // Have to be Optional if the number doesn't exist
                              .filter(x -> x % 2 ==0)
                              .findFirst();
    
    System.out.println("First even number: " + firstEvenNumber.get()); // To get the actual value
    System.out.println(separator);

    Integer sum = numbers.stream().reduce(1000, Integer::sum);  // Integer has a SUM funct
                                        // Start value
    System.out.println("Total Sum: " + sum);

    List<String> hey = new ArrayList<>(List.of("Hello", "World", "Java"));
    String helloString = hey.stream()
            .reduce("Concatenated String value: ", (a, b) -> a + "---" + b);
                                // Start value

    System.out.println(helloString);
    System.out.println(separator);

    hey.add("ac");
    hey.add("A");
    hey.add("b");
    hey.add("c");

    List<String> sortedString = hey.stream()
                .sorted()          // Sort the list
                .distinct()        // Only the distinct values
                .limit(10) // On max 10 values
                .collect(Collectors.toList());

    System.out.println(sortedString);
    System.out.println(separator);

    List<String> toUpper = hey.stream()
                          .filter(x -> x.length() > 3)
                          .peek(x ->  System.out.println("Word: " + x)) // Usefull when u want to debug
                          .map(String::toUpperCase)
                          .collect(Collectors.toList());
    System.out.println(toUpper);
    System.out.println(separator);

    }

    public static void main(String[] args) {
        new StremFunct();
    }

}
