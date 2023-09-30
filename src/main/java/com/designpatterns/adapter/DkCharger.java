package com.designpatterns.adapter;

public class DkCharger implements AndroidCharger{
    @Override
    public void chargerAndroidPhone() {
        System.out.println("your android phone is charging...");
    }
}
