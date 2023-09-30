package com.designpatterns.prototype;

public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
        System.out.println("Creating object using prototype design pattern..");

        NetworkConnection connection = new NetworkConnection();
        connection.setIp("192.168.0.39");
        connection.loadVeryImportantData();
        System.out.println(connection.toString());
        //we want new object of Network connection
        NetworkConnection clonedConnection = (NetworkConnection)connection.clone();
        System.out.println(clonedConnection.toString());

    }
}
