package com.designpatterns.Iterator;

import java.util.ArrayList;
import java.util.List;

public class UserManagement {
    private List<User> userList = new ArrayList<>();

    public void addUser(User user){
        userList.add(user);
    }
    public MyIterator getIterator(){
        return new MyIteratorImpl(userList);
    }

}
