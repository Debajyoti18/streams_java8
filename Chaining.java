import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Chaining {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 1, 3, 4, 6);
        Stream<Integer> numberStream = list.stream()
            .filter((Integer val) -> val >= 3)
            .peek((Integer val) -> System.err.println("after filter val :" + val))
            .map((Integer x) -> x * -1)
            .peek((Integer val) -> System.err.println("after mapping val :" + val))
            .sorted()
            .peek((Integer val) -> System.err.println("after sorted val :" + val));
        List<Integer> num = numberStream.collect(Collectors.toList());

        /*Output:
         * after filter val :3
            after mapping val :-3
            after filter val :4
            after mapping val :-4
            after filter val :6
            after mapping val :-6
            after sorted val :-6
            after sorted val :-4
            after sorted val :-3
            Not all the functions requires all the data set .so they proces
            one by one for fast execution.
            The sorted() operation is a special case that requires seeing
             all elements before producing any output, which is why you see all filter/map operations complete before any sorted peek operations.
         */
    }
}