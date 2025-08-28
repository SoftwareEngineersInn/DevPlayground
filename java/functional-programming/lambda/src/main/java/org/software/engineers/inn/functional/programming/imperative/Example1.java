package org.software.engineers.inn.functional.programming.imperative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example1 {

    public void ExtractNamesWithL() {

        List<String> names = Arrays.asList("Juan", "Pedro", "Ana", "Lucía");
        List<String> result = new ArrayList<>();

        for (String name : names) {
            if (name.startsWith("L")) {
                result.add(name.toUpperCase());
            }
        }
        System.out.println(result);

    }

}
