import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ParraleStream {
    public static void main(String[] args) {
        // Generate a large list of random numbers
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10_000_000; i++) {
            numbers.add(random.nextInt(100));
        }

        // Measure time taken by stream
        long startTime = System.currentTimeMillis();
        List<Integer> squaredNumbersStream = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by stream: " + (endTime - startTime) + " ms");

        // Measure time taken by parallelStream
        startTime = System.currentTimeMillis();
        List<Integer> squaredNumbersParallelStream = numbers.parallelStream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by parallelStream: " + (endTime - startTime) + " ms");
        
        /*
        Time taken by stream: 1200 ms
        Time taken by parallelStream: 400 ms
 ``````*/
        /*Parrale STREAM -HELPS TO PERFORM OPERATION ON STREAM CONCURRENTLY.
         * taking advantage of multi core cpu.
         * internally it does-
         * 1.task splitting - it uese "spliterator" function to split the data into multiple chunks
         * 2.Task submissin and paralle processing :Uses fork-join pool technique.
         * 
         */
    }
}
