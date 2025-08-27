package org.software.engineers.inn.design.patterns.creational;

import org.software.engineers.inn.design.patterns.creational.wrong.Report;

public class Main {
    public static void main(String[] args) {
        //wrong example
        Report r1 = new Report();
        Report r2 = new Report();
        //We must wait 2 seconds for each object ⏳.
    }
}