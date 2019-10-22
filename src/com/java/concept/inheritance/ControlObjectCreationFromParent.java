package com.java.concept.inheritance;

import java.util.HashMap;
import java.util.Map;

public class ControlObjectCreationFromParent {

    public static void main(String[] args) {
        A a1=null;
        try {
            A a = new A();
            B b = new B(); //Basically it creates only one object which consist of both parent and child variables and methods .Parent is referred by super
            C c = new C();
            Thread.sleep(1000);//added to not mix sout statements in output
            //All below statements throw exception !
            //C c1 = new C();
            a1 = new A();
            //B b1 = new B();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Caught exception for "+ a1);
        }


    }
}
class A{
    public static Map<String,Integer> objCreationMap= new HashMap<>();
    public A() throws Exception {
        System.out.println("In A constructor");
        System.out.println("Called from -"+this.getClass().getName());
        if(objCreationMap.containsKey(this.getClass().getName())){
            System.out.println("Object already created !!");
            throw new Exception();
        }else{
            objCreationMap.put(this.getClass().getName(),1);
        }
    }

}
class B extends A{
    public B() throws Exception {
        System.out.println("In B constructor");
        System.out.println("super keyword -->"+super.hashCode()+" this keyword -->"+this.hashCode());//both hashcodes are same !
        System.out.println("ToString for super keyword -->"+super.toString()+" this keyword -->"+this.toString());//same for this and super
        System.out.println("Called from -"+this.getClass().getName());
       // super();//not allowed it says it should always be the first statement in the body
    }
}

class C extends B{
    public C() throws Exception {
        //super();//earlier super was called by default.As soon as we threw an exception ,
        //it asked us to call super explicitly and have throws clause
        System.out.println("In C Constructor");
    }
}

/*
Output -
In A constructor
Called from -com.java.concept.inheritance.A
In A constructor
Called from -com.java.concept.inheritance.B
In B constructor
Called from -com.java.concept.inheritance.B
In A constructor
Called from -com.java.concept.inheritance.C
In B constructor
Called from -com.java.concept.inheritance.C
In C Constructor

//For a1
In A constructor
Called from -com.java.concept.inheritance.A
Object already created !!
java.lang.Exception
	at com.java.concept.inheritance.A.<init>(ControlObjectCreationFromParent.java:33)
	at com.java.concept.inheritance.ControlObjectCreationFromParent.main(ControlObjectCreationFromParent.java:17)
Caught exception for null

 */