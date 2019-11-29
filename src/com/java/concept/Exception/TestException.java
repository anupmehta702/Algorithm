package com.java.concept.Exception;

public class TestException {

    public static void main(String[] args) {
        TestException te = new TestException();
        System.out.println("Return value --> "+te.defaultMethod());
        System.out.println("Return value --> "+te.defaultMethodWithNoException());
    }
    public String defaultMethod(){
        try {
            defaultMethodThrowingCheckedExp();
            return "try";
        } catch (UserCheckedException e) {
            e.printStackTrace();
            return "catch";
        }finally{
            return "finally";
        }//with this block it returns finally
        //return "outside";//if finally uncommented ,this is compile error "unreachable code"
    }
    public String defaultMethodWithNoException(){
        try {
            defaultMethodThrowingNoCheckedExp();
            return "try";
        } catch (UserCheckedException e) {//this catch is compulsory since above method has throws clause
            e.printStackTrace();
            return "catch";
        }finally{
            System.out.println("in finally method for defaultMethodWithNoException ");
           // return "finally";//with this block it returns finally else returns "try"
        }

        //try can exist without catch ,however if method called has "throws" clause
        //then in that case you have to compulsarily catch the exception (have catch block)

    }

    public void defaultMethodThrowingCheckedExp() throws UserCheckedException {
        System.out.println("In default method");
        if(1 == 1) {
        throw new UserCheckedException();
        }
    }
    public void defaultMethodThrowingNoCheckedExp() throws UserCheckedException {
        System.out.println("In defaultMethodThrowingNoCheckedExp method");
        if(1 == 2) {
            throw new UserCheckedException();
        }
    }
    public void defaultMethodThrowingUnCheckedException(){
        System.out.println("In defaultMethodThrowingUnCheckedException method");
        if(1==1){
            //throw new UserDefinedRuntimeException(); //no throw clause required
            throw new Error("Error !!");//this is also unchecked exception
        }
    }
}
/*
 THrowable
 - Error
 - Exception  - RuntimeException
              - All other CheckedException
 */