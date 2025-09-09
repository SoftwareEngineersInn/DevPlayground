package org.software.engineers.inn.functional.programming.imperative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Filter and transform
 */
public class Example2 {

    public void filterAndTransform(String filterLetter) {
        List<String> names = Arrays.asList("Juan", "Pedro", "Ana", "Lucía");
        List<String> result = new ArrayList<>();

        for (String name : names) {
            if (name.startsWith(filterLetter)) {
                result.add(name.toUpperCase());
            }
        }
        System.out.println(result); // [LUCÍA]
    }

}
