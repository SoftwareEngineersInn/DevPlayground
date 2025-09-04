package org.software.engineers.inn.functional.programming.imperative;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * TODO: Imperative
 * **/
public class Example5 {

    public void sortNames(){
        List<String> names = Arrays.asList("Pedro", "Ana", "Juan");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        System.out.println(names); // [Ana, Juan, Pedro]
    }

}
