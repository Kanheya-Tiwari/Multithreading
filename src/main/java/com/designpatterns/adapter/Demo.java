package com.designpatterns.adapter;

public class Demo {
    public static void main(String[] args){
        AppleCharger appleCharger = new AdapterCharger(new DkCharger());
        Iphone13 iphone13 = new Iphone13(appleCharger);
        iphone13.chargeIphone();

    }
}
