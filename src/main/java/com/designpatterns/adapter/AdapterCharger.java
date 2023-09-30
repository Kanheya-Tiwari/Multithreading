package com.designpatterns.adapter;

public class AdapterCharger implements AppleCharger{
    private AndroidCharger androidCharger;

    public AdapterCharger(AndroidCharger androidCharger) {
        this.androidCharger = androidCharger;
    }

    @Override
    public void chargePhone() {
        androidCharger.chargerAndroidPhone();
        System.out.println("your phone is charging with adapter...");
    }
}
