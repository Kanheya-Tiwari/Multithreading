package com.designpatterns.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter employee type: ");
        String empType = reader.readLine();
        Employee emp = EmployeeFactory.getEmployee(empType);
        if(null != emp) {
            System.out.println(emp.salary());
        }else{
            System.out.println("Wrong input!");
        }
    }
}
