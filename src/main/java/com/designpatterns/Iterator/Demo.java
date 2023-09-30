package com.designpatterns.Iterator;

public class Demo {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        userManagement.addUser(new User("Durgesh","101"));
        userManagement.addUser(new User("Harsh","102"));
        userManagement.addUser(new User("Ankit","103"));
        userManagement.addUser(new User("Sarthak","104"));

        MyIterator myIterator = userManagement.getIterator();
        while(myIterator.hasNext()){
            User user = (User)myIterator.next();
            System.out.println("Name: "+user.getName()+" ,ID: "+user.getUserId());
        }
    }
}
