package org.software.engineers.inn.functional.programming.functional;

import java.util.Arrays;
import java.util.List;

/*
* TODO: Example4 using Lambdas + Streams
* */
public class Example4 {

    public void addValues(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int suma = numbers.stream()
                .reduce(0, Integer::sum);

        System.out.println(suma); // 15
    }

}
// Typical case: accumulation → use reduce.