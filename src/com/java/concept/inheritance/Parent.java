package com.java.concept.inheritance;

public class Parent {
    Parent(){
        System.out.println("In parent constructor");
    }

    public static void main(String[] args) {
        Parent p = new Child();
        Parent p2 = new Orphan();
    }
}

class Child extends Parent{
    Child(){
        super();
        System.out.println("In child constructor -->"+this.getClass());
    }
}

class Orphan extends Parent{
    Orphan(){
        super();
        System.out.println("In child constructor -->"+this.getClass());
    }
}
