package com.java.concept.polymorphism;


class A {
    void method(int[] a)  {
        System.out.println(2);
    }

}

class B extends A {
    @Override
    void method(int... a) {
        System.out.println(1);
    }

}

class C extends B {

}

public class MethodOverloadingTest {
    static void overloadedMethod(A a) {
        System.out.println("ONE");
    }

    static void overloadedMethod(B b) {
        System.out.println("TWO");
    }

    static void overloadedMethod(Object obj) {
        System.out.println("THREE");
    }


    public static void main(String[] args) {
        C c = new C();
        overloadedMethod(c);//output - TWO
    }
}


