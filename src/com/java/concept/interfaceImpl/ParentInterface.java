package com.java.concept.interfaceImpl;


//Abstract class allows non final variable however interface donot allow it .
//Multiple inheritance allowed in interface but not in abstract class (implements vs extends)
//Java 9 now allows private methods as well which can be used by default methods in interface

/*
 abstract classes allow non-static and non-final fields and allow methods to be public, private,
 or protected while interfaces' fields are inherently public, static, and final,
  and all interface methods are inherently public.
 */

public interface ParentInterface {//cannnot be protected or private
    public  int interestRate = 10;//by default the var is final public and static

     static void staticMethod(){
         System.out.println();
    }
    default void calculateROI() {
        //interestRate=20; cannot do this since var is final
        System.out.println("Calculating ROI in ParentInterface-1");
    }
}

interface ParentInterface2 {
    public int interestRate = 20;

    default void calculateROI() {
        System.out.println("Calculating ROI in ParentInterface-2");
    }
}

class Implementor implements ParentInterface, ParentInterface2 {

    public void calculateROI() {
        System.out.println("Printing var from Interface-1 --> " + ParentInterface.interestRate);
        System.out.println("Printing var from Interface-2 --> " + ParentInterface2.interestRate);
        System.out.println("Calculating ROI in Implementor");
        ParentInterface.super.calculateROI();
        ParentInterface2.super.calculateROI();
    }

    public static void main(String[] args) {
        Implementor i = new Implementor();
        i.calculateROI();
    }
}
/*Output
Printing var from Interface-1 --> 10
Printing var from Interface-2 --> 20
Calculating ROI in Implementor
Calculating ROI in ParentInterface-1
Calculating ROI in ParentInterface-2
 */

