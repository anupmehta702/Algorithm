package com.java.concept.constructor;


class A{
    static{
        System.out.println("In parent static block");
    }
    {
        System.out.println("in parent intializer block");
    }
    public A(){
        System.out.println("In parent default constructor");
    }
}
class B extends A{
    static{
        System.out.println("In child static block");
    }
    {
        System.out.println("in child intializer block");
    }
    public B(){
        System.out.println("In child default constructor");
    }
}
public class StaticBlockInitializerBlockTest {
    public static void main(String[] args) {
        B b = new B();
    }
}
/*Output
In parent static block
In child static block
in parent intializer block
In parent default constructor
in child intializer block
In child default constructor

Java converts the default constructor into following -
super();
(this)//calls initializer method
user defined statements in constructor

thus when you call default constructor of B ,it does following
super();
(this);//calls intializer method of A -- > prints - in child intializer block
System.out.println("In child default constructor");

the first super() calls default constructor of A and it does following -
super();
(this);//calls intializer method of A -- > prints - in parent intializer block
System.out.println("In parent default constructor");
 */