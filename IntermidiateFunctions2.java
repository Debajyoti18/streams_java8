import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class IntermidiateFunctions2{
    public static void main(String[] args) {
        /*
         * peek(Consumer<T> action)-Helps to see the intermidiate results of the stream
         * which is getting processed.Consumer is a Interface that have only one method which is accept() thet return nothing
         * 
         *     void accept(T t);
         */
        List<Integer> list = Arrays.asList(2,1,3,4,6);
        // Stream<Integer> numberStream = list.stream()
        // .filter((Integer val)-> val>2)
        // .peek((Integer x)->System.out.println(x)); 
        // List<Integer> li = numberStream.collect(Collectors.toList());


        /*
         * limit()-Truncate the stream to no longer than the maxSize
         * 
            Stream<Integer> nst = list.stream()
            .limit(2);
            List<Integer> li = nst.collect(Collectors.toList());
            //output : 2,1
         */


         /*
         * skip(long n)-Skip the first n elments of the stream
         * 
            Stream<Integer> nst = list.stream()
            .skip(2);
            List<Integer> li = nst.collect(Collectors.toList());
            //output : 2,1
         */
        /*
         * mapToint(ToIntFunction<T> mapper)-helps to work with the primitive "int" datatype
         * mapToLong(ToLongFunction<T> mapper)
         * mapToDouble(ToDoubleFunction<T> mapper)
         * 
         */
        List<String> list1 = Arrays.asList("2","1","3","4","6");
         IntStream numbersStream = list1.stream()
         .mapToInt((String x)-> Integer.parseInt(x));

         int[] numArray = numbersStream.toArray();//2 1 3 4 6

         int[] arr = {1,2,3,4,5,6};
         IntStream intStream = Arrays.stream(arr);
         intStream.filter((int val)->val>2);
         int[] filterArray = intStream.toArray();
         //3 4 5 6
         /*>>>>>>>>>>>>>>>>> LAZY <<<<<<<<<<<<<<<<<<<<<<<<<<<
          * In Java, intermediate operations in the Stream API are indeed "lazy" - they don't execute until a terminal operation is called. Let me show you some examples to demonstrate this behavior.
                           import java.util.Arrays;
                           import java.util.List;
                           import java.util.stream.Stream;

                           public class LazyIntermediateOperationsDemo {
                              public static void main(String[] args) {
                                 List<String> names = Arrays.asList("John", "Alice", "Bob", "Carol", "David");
                                 
                                 // Create a stream with intermediate operations
                                 Stream<String> stream = names.stream()
                                          .filter(name -> {
                                             System.out.println("Filtering: " + name);
                                             return name.length() > 3;
                                          })
                                          .map(name -> {
                                             System.out.println("Mapping: " + name);
                                             return name.toUpperCase();
                                          });
                                 
                                 // No output until here because intermediate operations are lazy
                                 System.out.println("Stream created but no terminal operation yet");
                                 
                                 // Terminal operation triggers execution of the entire pipeline
                                 System.out.println("Calling terminal operation (forEach):");
                                 stream.forEach(name -> System.out.println("Result: " + name));
                              }
                           }
                           When you run this code, you'll see that the filter and map operations don't execute until the forEach terminal operation is called. The output would look something like:
                           CopyStream created but no terminal operation yet
                           Calling terminal operation (forEach):
                           Filtering: John
                           Mapping: John
                           Result: JOHN
                           Filtering: Alice
                           Mapping: Alice
                           Result: ALICE
                           Filtering: Bob
                           Filtering: Carol
                           Mapping: Carol
                           Result: CAROL
                           Filtering: David
                           Mapping: David
                           Result: DAVID

                           Notice how each element goes through the entire pipeline one at 
                           a time - this is called "vertical execution" rather than "horizontal execution". 
                           Java processes each element completely through all intermediate operations before moving to the next element.
          */

        



    
    }
}