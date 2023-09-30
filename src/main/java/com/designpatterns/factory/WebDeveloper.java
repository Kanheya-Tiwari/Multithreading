package com.designpatterns.factory;

public class WebDeveloper implements Employee{
    public double salary() {
        System.out.println("Getting web developer salary.");
        return 70000;
    }
}
