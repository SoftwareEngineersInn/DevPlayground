package org.software.engineers.inn.functional.programming.functional;

import java.util.Arrays;
import java.util.List;

/**
 * Lambdas + Streams
 */
public class Example2 {

    public void filterAndTransform(String filterLetter) {

        List<String> names = Arrays.asList("Juan", "Pedro", "Ana", "Lucía");

        List<String> result = names.stream()
                .filter(n -> n.startsWith("L"))
                .map(String::toUpperCase)
                .toList();

        System.out.println(result); // [LUCÍA]
    }
}
