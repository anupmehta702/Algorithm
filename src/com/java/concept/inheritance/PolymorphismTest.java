package com.java.concept.inheritance;

public class PolymorphismTest extends Animal {
    public PolymorphismTest(){
        System.out.println("In Child (PolymorphismTest) constructor");
        System.out.println("Hashcode for super keyword -->"+super.hashCode()+" this keyword -->"+this.hashCode());//same for this and super
        System.out.println("ToString for super keyword -->"+super.toString()+" this keyword -->"+this.toString());//same for this and super

    }
    int c=30;
    public static void staticMethod() {
        System.out.println("In static main method of child");
    }
    public void nonStaticMethod(){
        System.out.println("In nonStaticMethod of child");
    }
    public void childMethod(){
        System.out.println("In child method (non overriding)");
    }
    private void privateChildMethod(){
        System.out.println("In private child method (non overridden)");
    }

    private void protectedChildMethod(){
        System.out.println("In protected child method (non overridden)");
    }

    public static void main(String[] args) {
        Animal a = new PolymorphismTest();//Only Advantage is that a can be assigned any children on Animal compared to PolymorphicTest p
        System.out.println("Printing class name - " + a.getClass().getName());
        a.staticMethod();//static method does not follow overridden rules
        a.nonStaticMethod();//overridden method from child is called
        ((PolymorphismTest) a).childMethod();//Type casting is required because you are using polymorphic reference Animal a
        //a.privateAnimalMethod() //cannot access private method anyways
        //b.protectedAnimalMethod() // protected method can be accessed only from child
        ((PolymorphismTest) a).privateChildMethod();
        ((PolymorphismTest) a).protectedChildMethod();

        System.out.println("-------------------------");

        PolymorphismTest p = new PolymorphismTest();
        p.animalMethod();
        p.privateChildMethod();
        p.protectedChildMethod();


    }
}

class Animal {
    int a=10;
    int b=20;
    public Animal(){
        System.out.println("In Parent (Animal) constructor");
    }

    public static void staticMethod() {
        System.out.println("In static main method of animal ");
    }
    public void nonStaticMethod(){
        System.out.println("In nonStaticMethod of parent (animal)");
    }
    public void animalMethod(){
        System.out.println("In animal method (non overridden)");
    }
    private void privateAnimalMethod(){
        System.out.println("In private animal method (non overridden)");
    }

    private void protectedAnimalMethod(){
        System.out.println("In protected animal method (non overridden)");
    }

    public static void main(String[] args) {
        System.out.println("Hello world !");
    }

}
/*Output
In Parent (Animal) constructor
In Child (PolymorphismTest) constructor
Hashcode for super keyword -->2125039532 this keyword -->2125039532
ToString for super keyword -->com.java.concept.inheritance.PolymorphismTest@7ea987ac this keyword -->com.java.concept.inheritance.PolymorphismTest@7ea987ac
Printing class name - com.java.concept.inheritance.PolymorphismTest
In static main method of animal
In nonStaticMethod of child
In child method (non overriding)
In private child method (non overridden)
In protected child method (non overridden)
-------------------------
In Parent (Animal) constructor
In Child (PolymorphismTest) constructor
Hashcode for super keyword -->312714112 this keyword -->312714112
ToString for super keyword -->com.java.concept.inheritance.PolymorphismTest@12a3a380 this keyword -->com.java.concept.inheritance.PolymorphismTest@12a3a380
In animal method (non overridden)
In private child method (non overridden)
In protected child method (non overridden)

 */




