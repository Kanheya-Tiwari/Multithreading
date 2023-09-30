package com.designpatterns.factory;

public class AndroidDeveloper implements Employee{
    @Override
    public double salary() {
        System.out.println("Getting android developer salary.");
        return 50000;
    }
}
