package com.java.concept.polymorphism;


class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }
}

class MySubException extends MyException{

    public MySubException(String message) {
        super(message);
    }
}
class A1{
    public void myMethod() throws MyException{
        throw new MySubException("from super");
    }
}
class A2 extends A1{
    @Override
    //without throws clause is allowed
    //throws Exception not allowed
    //throws MySubException allowed
    public void myMethod() throws MySubException{
        System.out.println("In sub class method");
    }

}
public class ExceptionTestFOrOverriding {
}
