package org.software.engineers.inn.kiss.wrong;

/**
 This design might make sense if many operations are going to be supported, but for something simple like addition,
 it's over-engineered. If you only do addition, the first example is better. **/
public class Operation {
    public int operate(int a, int b, String operation){
        if("add".equals(operation)) {
            return a + b;
        } else if ("substraction".equals(operation)){
            return a - b;
        } else {
            throw new IllegalArgumentException("Operation not supported");
        }
    }
}
