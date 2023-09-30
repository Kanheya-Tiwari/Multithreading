package com.designpatterns.singleton;

public class Singleton {
    private static Singleton instance;
    private Singleton(){
    }
    public static Singleton getInstance(){
        if(instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    public void doSomething() {
        System.out.println("Singleton Design pattern..");
    }
    public static void main(String[] args) {
       Singleton singleton = getInstance();
        singleton.doSomething();
    }
}
