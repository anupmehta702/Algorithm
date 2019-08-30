package java.concept.scope;

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

    public static void main(String[] args) {
        ChildClassOfProtectedClass ccps = new ChildClassOfProtectedClass();
        ccps.callingProtectedMethod();
    }
}
