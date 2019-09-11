package com.java.concept.scope;

public class ProtectedClass {

    protected void callingProtectedMethod() {
        System.out.println("Protected method is called");
    }

    public void callingPublicMethod() {
        System.out.println("callingPublicMethod");
    }

    void callingDefaultMethod(){
        System.out.println("callingDefaultMethod");
    }

    private void callingPrivateMethod(){
        System.out.println("callingPrivateMethod");
    }

}
