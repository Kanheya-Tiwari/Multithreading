package com.design.patterns;

public class AdapterPattern {
      public static void main(String[] args){
          CreditCard targetInterface = new BankCustomer();
          targetInterface.giveBankDetails();
          System.out.print(targetInterface.getCreditCard());
      }

}



/*Adapter Pattern: An Adapter Pattern says that just "converts the interface of a class into another interface that a client wants".
* In other words, to provide the interface according to client requirement while using the services of a class with a different interface.
* The Adapter Pattern is also known as Wrapper. */