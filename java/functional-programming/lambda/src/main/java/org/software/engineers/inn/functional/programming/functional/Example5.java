package org.software.engineers.inn.functional.programming.functional;

import java.util.Arrays;
import java.util.List;

/**
 * TODO: Example 5 using lambda
 * **/
public class Example5 {

    public void sortNames(){
        List<String> names = Arrays.asList("Pedro", "Ana", "Juan");

        names.sort((a, b) -> a.length() - b.length());

        System.out.println(names); // [Ana, Juan, Pedro]
    }

}
// ✅ Typical case: anonymous Comparator classes.