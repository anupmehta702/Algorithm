package com.java.concept.inheritance;

public class MethodOverrideTest {

    public void method(String s){
        System.out.println("In string for "+s);
    }
    public void method(int[] s){
        System.out.println("In array for "+s);
    }
    public void method(int s){
        System.out.println("In parameter for variable datatype --> "+s);
    }
    public void method(Integer s){
        System.out.println("In parameter for wrapper class  --> "+s);
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
        System.out.println(" in string ..Print x= "+s);
    }
    public void method(String s,String s2){
        System.out.println("In two string input method --> "+s);
    }

    public static void main(String[] args) {
        MethodOverrideTest mot=new MethodOverrideTest();
        //mot.method(null);
       // mot.method(null);//calls string method
       // mot.method(null); //this fails if we have  method(Integer s) .
        mot.method("input");//in string for input
        mot.method("a","b","c");
        mot.method(10);//In parameter for variable datatype --> 10
        mot.method(new Integer(100));//In parameter for wrapper class  --> 100
        mot.method(Integer.valueOf(10));//In parameter for variable datatype --> 10


        Integer i1 = 10;
        Integer i2 = 10;
        Integer i3 = new Integer(10);
        System.out.println("is i1 == i2 ?"+ (i1==i2));//true
        System.out.println("is i1 == i3 ?"+ (i1==i3));//false

    }
}
