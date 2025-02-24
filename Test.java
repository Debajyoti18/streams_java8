import java.util.*;
import java.util.stream.Collectors;
class Test{
    public static void main(String[] args) {
        //without stream
        // Creating a list of salaries
        List<Integer> salaries = new ArrayList<>();
        salaries.add(2500);
        salaries.add(3200);
        salaries.add(4000);
        salaries.add(2800);
        salaries.add(5500);
        salaries.add(3000);
        
        // Without using streams - traditional approach
        
        // Count salaries > 3000 without streams
        int count1 = 0;
        for (Integer salary : salaries) {
            if (salary > 3000) {
                count1++;
            }
        }
        System.out.println("Count of salaries > 3000 (without streams): " + count1);
        
        // Using streams to filter salaries
        List<Integer> highSalaries2 = salaries.stream()
                                             .filter(salary -> salary > 3000)
                                             .collect(Collectors.toList());
        System.out.println("Salaries > 3000 (with streams): " + highSalaries2);
        
        // Count salaries > 3000 using streams
        long count2 = salaries.stream()
                            .filter(salary -> salary > 3000)
                            .count();
        System.out.println("Count of salaries > 3000 (with streams): " + count2);
    

    }
}