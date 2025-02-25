import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TerminalOperations {
    public static void main(String[] args) {
         /*Treminal functions- are the ones that produces the results.It triggers the processing of the stream.
          * // Collection Operations
            collect()      // Collects elements into a collection or other data structure
            toList()       // Collects elements into a List (Java 16+)
            toArray()      // Collects elements into an array

            // Reduction Operations
            reduce()       // Reduces stream elements to a single value
            count()        // Returns the count of elements
            sum()          // Returns the sum (on numeric streams)
            min()          // Returns the minimum element
            max()          // Returns the maximum element
            average()      // Returns the average (on numeric streams)

            // Matching Operations
            anyMatch()     // Returns true if any elements match the predicate
            allMatch()     // Returns true if all elements match the predicate
            noneMatch()    // Returns true if no elements match the predicate

            // Finding Operations
            findFirst()    // Returns an Optional with the first element Donot returns any Value
            findAny()      // Returns an Optional with any element (useful for parallel streams)

            // Iteration
            forEach()      // Performs an action for each element
            forEachOrdered() // Like forEach but respects encounter order

            // Other Terminal Operations
            iterator()     // Returns an Iterator of the elements
            spliterator()  // Returns a Spliterator of the elements
          */
        
            List<Integer> li = Arrays.asList(2,3,6,7,9,23,12);
            //  li.stream()
            // .filter((Integer x)-> x >= 3)
            // .forEach((Integer x)-> System.err.println(x));
            // //6,7,9,23,12


            // toArray() -Collects elements of the stream into an Array
            
            // Object[] filteredNumvObject1 = li.stream()
            // .filter((Integer x)-> x >= 3)
            // .toArray();
            // Integer[] filteresdIntegers = li.stream()
            // .toArray((int size)-> new Integer[size]);

            /*reduce(BinaryOperator<T> accumulator)-does the reduction the the elements of the
            stream .Perform associative aggregation function.
             * 
             */
            Optional<Integer> reducedValue = li.stream()
            .reduce((Integer n1,Integer n2)-> n1+n2);
            System.out.println(reducedValue.get());
            //2+3=5 => 5+6=11 => 11+7 =18 => 18+9=27 => 27+23=50 =>50+12=62
            //output 62
            /*
             * import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class AllTerminalOperationsDemo {
    public static void main(String[] args) {
        // Our integer list
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 7, 3, 8, 6, 4, 10, 3);
        
        System.out.println("Original list: " + numbers);
        System.out.println("==========================================");
        
        // 1. collect() - Collecting into different structures
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("collect(toList) - Even numbers: " + evenNumbers);
        
        String commaSeparated = numbers.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", "));
        System.out.println("collect(joining) - Comma separated: " + commaSeparated);
        
        // 2. min() - Finding minimum value
        Optional<Integer> min = numbers.stream()
                .min((a, b) -> Integer.compare(a, b));
        System.out.println("min() - Minimum value: " + min.orElse(0));
        
        // 3. max() - Finding maximum value
        Optional<Integer> max = numbers.stream()
                .max((a, b) -> Integer.compare(a, b));
        System.out.println("max() - Maximum value: " + max.orElse(0));
        
        // 4. count() - Counting elements
        long count = numbers.stream().count();
        System.out.println("count() - Number of elements: " + count);
        
        // 5. anyMatch() - Check if any element matches
        boolean anyGreaterThan8 = numbers.stream()
                .anyMatch(n -> n > 8);
        System.out.println("anyMatch() - Any greater than 8: " + anyGreaterThan8);
        
        // 6. allMatch() - Check if all elements match
        boolean allPositive = numbers.stream()
                .allMatch(n -> n > 0);
        System.out.println("allMatch() - All positive: " + allPositive);
        
        // 7. noneMatch() - Check if no elements match
        boolean noneNegative = numbers.stream()
                .noneMatch(n -> n < 0);
        System.out.println("noneMatch() - None negative: " + noneNegative);
        
        // 8. findFirst() - Find first element
        Optional<Integer> first = numbers.stream()
                .findFirst();
        System.out.println("findFirst() - First element: " + first.orElse(0));
        
        // 9. findAny() - Find any element (often the first in sequential streams)
        Optional<Integer> any = numbers.stream()
                .findAny();
        System.out.println("findAny() - Any element: " + any.orElse(0));
        
        // 10. forEach() - Perform action on each element
        System.out.print("forEach() - Elements: ");
        numbers.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // 11. forEachOrdered() - Like forEach but respects encounter order
        System.out.print("forEachOrdered() - Elements in order: ");
        numbers.stream().forEachOrdered(n -> System.out.print(n + " "));
        System.out.println();
        
        // 12. reduce() - Reduce to single value
        Optional<Integer> sum = numbers.stream()
                .reduce((a, b) -> a + b);
        System.out.println("reduce() - Sum: " + sum.orElse(0));
        
        // 13. toArray() - Convert to array
        Integer[] array = numbers.stream().toArray(Integer[]::new);
        System.out.print("toArray() - Array: ");
        for (Integer n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
        
        // For numeric streams
        // 14. sum() - Get sum (using IntStream)
        int intSum = numbers.stream()
                .mapToInt(n -> n)
                .sum();
        System.out.println("sum() - Sum (IntStream): " + intSum);
        
        // 15. average() - Get average (using IntStream)
        OptionalDouble avg = numbers.stream()
                .mapToInt(n -> n)
                .average();
        System.out.println("average() - Average (IntStream): " + avg.orElse(0));
    }
}
             */


             //"""""""" ONE TERMINAL OPERATOION IS USED ON A STREAM,IT IS
             //CLOSED/CONSUMED AND CANNOT BE USED AGAIN FOR ANOTHER TERMINAL OPERATION.
              





    }
}
