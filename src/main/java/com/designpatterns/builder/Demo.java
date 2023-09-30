package com.designpatterns.builder;

import java.sql.SQLOutput;

public class Demo {
    public static void main(String[] args) {
       User user =  new User.UserBuilder().setUserId("101").setUserName("Kanheya Tiwari").setEmailId("tiwarikanheya@gmail.com").build();
        System.out.println("User Details:"+user.toString());
    }
}
