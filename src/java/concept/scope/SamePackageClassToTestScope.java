package java.concept.scope;

public class SamePackageClassToTestScope {
    public static void main(String[] args) {
        ProtectedClass protectedClass= new ProtectedClass();
        protectedClass.callingProtectedMethod();
        System.out.println("Can call protected method without being a child if the caller class is from same package");
        protectedClass.callingDefaultMethod();
        protectedClass.callingPublicMethod();
        DefaultClass defaultClass = new DefaultClass();
        System.out.println("Can initiate default class since package is same ,however not allowed from other package");
    }
}
