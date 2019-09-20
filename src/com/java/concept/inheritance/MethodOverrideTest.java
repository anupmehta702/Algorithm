package com.java.concept.inheritance;

public class MethodOverrideTest {

    public void method(String s){
        System.out.println("In string for "+s);
    }
    public void method(int[] s){
        System.out.println("In array for "+s);
    }
    /* Not allowed .Only changing return type is not allowed
    public String method(String s){
        return s;
    }*/

   /* public void method(int s){
        System.out.println("In string for "+s);
    }
*/
    public void method(Object s){
        System.out.println("In object");
    }


    public void method(String... s){
        System.out.println("Print x= "+s);
    }

    public static void main(String[] args) {
        MethodOverrideTest mot=new MethodOverrideTest();
        //mot.method(null);
       // mot.method(null);//calls string method
        //mot.method(null); //this fails if we have  method(Integer s) .
        mot.method("input");

    }
}
