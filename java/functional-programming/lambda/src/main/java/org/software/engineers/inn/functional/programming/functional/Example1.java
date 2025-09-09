package org.software.engineers.inn.functional.programming.functional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Example1 migrated to functional using lambda
 */
public class Example1 {

    public void ExtractNamesWithL() {
        List<String> names = Arrays.asList("Juan", "Pedro", "Ana", "Lucía");

        List<String> result = names.stream()
                .filter(n -> n.startsWith("L"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(result);
    }

}
/**
 * Notice:
 * - filter with a lambda (n -> n.startsWith("L")).
 * - map using method reference (String::toUpperCase).
 * - the result became more declarative and readable
 * **/