import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;
class StreamCreation{
     public static void main(String[] args) {
        //from List
        List<Integer> list =Arrays.asList(100,200,300,400,500,600,700,800);
             Stream<Integer> streamFromList = list.stream();

        //from array
        Integer[] myarr = {12,24,36,48,60};
        Stream<Integer> fromAarray = Arrays.stream(myarr);

        //from static method of Stream
        Stream<Integer> streamFromMethod = Stream.of(10,12,14,1,2,2);

        //from StreamBuilder
        Stream.Builder<Integer> streamBuilder = Stream.builder();//builder() method
        streamBuilder.add(10).add(12).add(140).add(14);
        Stream<Integer> stream = streamBuilder.build();//build() method
        

        //from iterator
        Stream<Integer> streamByIteratorStream = Stream.iterate(100, (Integer x)-> x+10).limit(3);


    }
}