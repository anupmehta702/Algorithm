package com.java.concept.inheritance;

public class PolymorphismTest extends Animal {
    public static void method (){
        System.out.println("In static main method of child");
    }

    public static void main(String[] args) {
        Animal a = new PolymorphismTest();
        a.method();//static method does not follow overridden rules
    }
}
class Animal {
    public static void method(){
        System.out.println("In static main method of animal ");
    }

    public static void main(String[] args) {
        System.out.println("Hello world !");
    }

}




