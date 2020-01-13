package com.java.concept.scope2;

import com.java.concept.scope.ProtectedClass;

public class ChildClassOfProtectedClassInDiffPackage extends ProtectedClass {
    public void methodCallingProtectedOfParentInternally(){
        super.callingProtectedMethod();
    }
    public void tryingToCallDefaultMethodOfParent(){
        System.out.println("Cannot call default method of parent");
    }

    public void tryingToCallPrivateMethodOfParent(){
        System.out.println("Cannot call private  method of parent");
    }

    public static void main(String[] args) {
        ChildClassOfProtectedClassInDiffPackage ccps = new ChildClassOfProtectedClassInDiffPackage();
        ccps.callingProtectedMethod(); //can call since the main method is inside protected class
        ccps.callingPublicMethod();
        //ccps.callingDefaultMethod(); cannot call default method of parent
    }
}
