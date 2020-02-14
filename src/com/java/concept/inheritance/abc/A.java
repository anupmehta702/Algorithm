package com.java.concept.inheritance.abc;

import com.java.concept.inheritance.xyz.X;

public class A {

    public void publicMethod() {
        System.out.println("In public method of class A");
        System.out.println("class -->"+this.getClass().getCanonicalName()+" is calling this method");
        defaultMethod();//this calls local method ,since defaultMethod is not overridden
        this.protectedMethod();//this calls overridden method
    }

    protected void protectedMethod(){
        System.out.println("In protected method of class A ");
    }

    void defaultMethod() {
        System.out.println("In default method of class A ");
    }

    public static void main(String[] args) {
        A ax = new X();
        ax.defaultMethod();//In default method of class A
        ax.publicMethod();
        /*
        Public method of class X
        In public method of class A
        class -->com.java.concept.inheritance.xyz.X is calling this method
        In default method of class A
        In protected method of class X
         */
        System.out.println("---------------------");
        X x = new X();
        x.publicMethod();
        /* same as above
        Public method of class X
        In public method of class A
        class -->com.java.concept.inheritance.xyz.X is calling this method
        In default method of class A
        In protected method of class X
         */

    }
}
