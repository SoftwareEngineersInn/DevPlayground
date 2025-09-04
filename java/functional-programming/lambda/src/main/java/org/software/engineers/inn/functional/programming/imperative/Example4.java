package org.software.engineers.inn.functional.programming.imperative;

import java.util.Arrays;
import java.util.List;

/*
 * TODO: Accumulate (add values)
 */
public class Example4 {

    public void addValues(){
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        int suma = 0;

        for (Integer n : numeros) {
            suma += n;
        }

        System.out.println(suma); // 15
    }

}
