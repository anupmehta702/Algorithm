package com.java.concept;

public class PolymorphismTest extends Animal {
    public static void method (){
        System.out.println("In static main method of child");
    }

    public static void main(String[] args) {
        Animal a = new PolymorphismTest();
        a.method();
    }
}



