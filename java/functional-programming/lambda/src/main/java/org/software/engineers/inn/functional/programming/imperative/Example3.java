package org.software.engineers.inn.functional.programming.imperative;

import java.util.Arrays;
import java.util.List;

/**
 * Finding the first that meets a condition
 */
public class Example3 {

    public void findBaseOnCondition(){
        List<Integer> numbers = Arrays.asList(3, 7, 10, 15);
        Integer found = null;

        for (Integer number : numbers) {
            if (number > 8) {
                found = number;
                break;
            }
        }
        System.out.println(found); // 10
    }

}
