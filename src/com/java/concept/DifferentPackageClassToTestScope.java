package com.java.concept;

import com.java.concept.scope.ProtectedClass;
import com.java.concept.scope.PublicClass;
import com.java.concept.scope2.ChildClassOfProtectedClassInDiffPackage;

public class DifferentPackageClassToTestScope {

    public static void main(String[] args) {
        ProtectedClass protectedParentClass = new ProtectedClass();
        protectedParentClass.callingPublicMethod();
        System.out.println("Cannot call protected method & default method from public class since package is different");
        System.out.println("However public method can be called from anywhere");

        System.out.println("Cannot initiate default class since package is different");
        PublicClass publicClass = new PublicClass();
        System.out.println("Can only call public methods and not default methods of public class");

        ChildClassOfProtectedClassInDiffPackage childClassOfProtectedClassInDiffPackage = new ChildClassOfProtectedClassInDiffPackage();
        System.out.println("Cannot call directly protected method even if my class is child of parent class but my child class is in different package then parent class");
        //childClassOfProtectedClassInDiffPackage.callingProtectedMethod();//cannot call this since it throws error
        childClassOfProtectedClassInDiffPackage.methodCallingProtectedOfParentInternally();


        System.out.println("However you can call a public method in child class which internally calls super method");
    }
}
