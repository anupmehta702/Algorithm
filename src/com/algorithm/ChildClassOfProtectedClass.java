package com.algorithm;

import com.algorithm.scope.ProtectedClass;

public class ChildClassOfProtectedClass extends ProtectedClass {
    public void defaultMethodCallingSuper(){
        super.callingProtectedMethod();
    }
    public void tryingToCallDefaultMethodOfParent(){
        System.out.println("Cannot call default method of parent");
    }

    public void tryingToCallPrivateMethodOfParent(){
        System.out.println("Cannot call private  method of parent");
    }

}
