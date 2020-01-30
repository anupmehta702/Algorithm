package com.java.concept.constructor;

class M {
    static {
        System.out.println('A');
    }

    {
        System.out.println('B');
    }

    public M() {
        System.out.println('C');
    }
}

class N extends M {
    static {
        System.out.println('D');
    }

    {
        System.out.println('E');
    }

    public N() {
        System.out.println('F');
    }
    public N(int y){
        System.out.println("In paremetrized constructor");
    }
}

public class CheckStaticBlockInInheritance {
    public static void main(String[] args) {
        N n = new N();
        N n1 = new N(10);
    }
}

