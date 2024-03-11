package com.java.concept.inheritance.xyz;

import com.java.concept.inheritance.abc.A;

public class X extends A {


    @Override
    public void publicMethod() {
        System.out.println("Public method of class X");
        super.publicMethod();
    }

    @Override
    protected void protectedMethod() {
        System.out.println("In protected method of class X ");
    }

    void defaultMethod() {
        System.out.println("Default method of class X");
    }
}
