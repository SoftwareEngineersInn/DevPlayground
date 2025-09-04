package org.software.engineers.inn.functional.programming.functional;

import java.util.Arrays;
import java.util.List;

/**
 * Finding the first that meets a condition using Lambdas + Streams
 */
public class Example3 {

    public void findBaseOnCondition(){
        List<Integer> numbers = Arrays.asList(3, 7, 10, 15);

        Integer found = numbers.stream()
                .filter(n -> n > 8)
                .findFirst()
                .orElse(null);

        System.out.println(found); // 10
    }

}
// ✅ Typical case: stop the loop as soon as a condition is met.