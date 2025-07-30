package org.software.engineers.inn.kiss.wrong;

/**
 * This code works the same, but is unnecessarily verbose and difficult to read at first glance,
 * thus violating the KISS principle.
 * **/
public class NumberUtils {
    public static boolean isEven(int number){
        boolean result = false;
        if((number % 2) == 0){
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
