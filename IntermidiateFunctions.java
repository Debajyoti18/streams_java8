import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;
class IntermidiateFunctions{
    public static void main(String[] args) {
        /*
         * >>>>>>>>>>>>>> Differant INTERMIDIATE OPERATIONS  >>>>>>>>>>>>>
         * We can chain multiple intermidiate operations together to perform more
         * complex processing before applying the terminal operations to produce the reults.
         */
        //filter(Predicate<T> predicate)
      //filter() takes a Predicate functional interface as its parameter. A Predicate is a function that 
     // tests an element and returns a boolean value (true or false).-booleanTEST(T t)-abstract method
     //     Elements that return true are included in the resulting stream; those that return false are excluded.
     /*@FunctionalInterface
     public interface Predicate<T> {
       boolean test(T t);
 */
Stream<String> strings = Stream.of("hello","I am Debajyoti"," an aspiring java developer");
Stream<String> filtStream = strings.filter((String str)-> str.length()>6);
List<String> list1 = filtStream.collect(Collectors.toList());
System.out.println(list1);
//output : [I am Debajyoti,  an aspiring java developer]



// The map(Function<T,R> mapper) method in Java streams is used to transform each element in the stream 
//from one type to another. It applies a given function to each element and returns a new stream of the transformed elements.
  // map() takes a Function functional interface as its parameter. A Function is an 
  //interface that accepts an input of type T and produces an output of type R.
  // Stream<R> map(Function<? super T, ? extends R> mapper)
  Stream<String> string1 = Stream.of("Hello","I am Debajyoti"," An aspiring java developer");
  Stream<String> mapStreams= string1.map((String str)-> str.toLowerCase());
  //output : "hello","i am debajyoti"," an aspiring java developer"


  /*
   * The flatMap(Function<T, Stream<R>> mapper) method in Java streams is used to 
   * transform each element of a stream into another stream and then flatten the results into a single stream. It's particularly useful when dealing with nested
   *  collections(list of list ) or when you need to perform one-to-many transformations.
   */
 // Flattening a list of lists:

  List<List<Integer>> nestedLists = Arrays.asList(
      Arrays.asList(1, 2), 
      Arrays.asList(3, 4), 
      Arrays.asList(5, 6)
  );
  
  List<Integer> flatList = nestedLists.stream()
                        .flatMap(List<Integer> list -> list.stream());
                        //take each list and make it as a stream and  append all to that one stream
  // Result: [1, 2, 3, 4, 5, 6]
  
  //Getting all characters from multiple words:
  
  List<String> words = Arrays.asList("Hello", "World");
  List<Character> allChars = words.stream()
                                .flatMap(word -> word.chars().mapToObj(c -> (char)c))
                                .collect(Collectors.toList());
  // Result: ['H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd']
  
  //Handling optional values:
  
  List<Optional<String>> optionals = Arrays.asList(
      Optional.of("a"), 
      Optional.empty(), 
      Optional.of("b")
  );
  
  List<String> result = optionals.stream()
                               .flatMap(opt -> opt.isPresent() ? Stream.of(opt.get()) : Stream.empty())
                               .collect(Collectors.toList());
  // Result: ["a", "b"]
  
  //One-to-many mappings:
  
  // Example: Get all departments from a list of companies
  List<Company> companies = getCompanies();
  List<Department> allDepartments = companies.stream()
                                           .flatMap(company -> company.getDepartments().stream())
                                           .collect(Collectors.toList());


            /*
             * distinct()-Remove the duplicate elements from the list
             * The distinct() method in Java streams is used to remove
             *  duplicate elements from a stream, returning a new stream with only unique elements.
            distinct() creates a stream consisting of the distinct 
            elements from the source stream. It uses the equals() method to determine equality between objects.
             */
            List<String> wordaList = Arrays.asList("apple", "banana", "apple", "orange", "banana");
            List<String> distinctWords = wordaList.stream()
                                             .distinct()
                                             .collect(Collectors.toList());
            // Result: ["apple", "banana", "orange"]

            /*
             * sorted()-The sorted() method in Java streams is used to sort the elements of a stream according to natural order or a custom comparator.
               
                There are two variations of the sorted() method:

                sorted() - Uses natural ordering (elements must implement Comparable)
                sorted(Comparator<T> comparator) - Uses a custom comparator for ordering

                Basic Syntax
                    Stream<T> sorted()
                Stream<T> sorted(Comparator<? super T> comparator)
             */

             List<String> names = Arrays.asList("John", "Alice", "Bob", "Zack");
                List<String> sortedNames = names.stream()
                                            .sorted()
                                            .collect(Collectors.toList());
                // Result: ["Alice", "Bob", "John", "Zack"]alphabetically sorted

                // Sorting integers in descending order
            List<Integer> numbers = Arrays.asList(5, 3, 1, 4, 2);
            List<Integer> descendingOrder = numbers.stream()
                                                .sorted((a, b) -> b.compareTo(a))
                                                .collect(Collectors.toList());
                        // Result: [5, 4, 3, 2, 1]

            // Sorting employees by salary (custom objects)
            List<Employee> employees = getEmployees();
            List<Employee> sortedBySalary = employees.stream()
                                                    .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                                                    .collect(Collectors.toList());
        


            
    }
}