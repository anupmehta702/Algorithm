package com.java.concept.inheritance;

public class CheckInheritanceEquals {
    public static void main(String[] args) throws InterruptedException {
        AnimalOne a = new AnimalOne();
        Cat c = new Cat("Cat");
        AnimalOne animalCat = new Cat("Cat");
        System.out.println("a.getClass()-->"+a.getClass().getSimpleName()+
                " c.getClass()-->"+c.getClass().getSimpleName()+
                " animalCat.getClass()-->"+animalCat.getClass().getSimpleName());

        System.out.println("is catAnimal instanceOf Animal -->"+(animalCat instanceof AnimalOne));//true
        System.out.println("is cat instanceOf Animal -->"+(c instanceof AnimalOne));//true

        c.myMethod(); // OR ((Cat) animalCat).myMethod();
        c.printLegs();
        ((AnimalOne)animalCat).printLegs();//calls override method of cat despite casting

        a.printLegs();//Legs == 4




        //Upcasting of subtype .
        AnimalOne typeCastAnimal =(AnimalOne) c;//small can go in big upcasting
        typeCastAnimal.printLegs();//still calls override method of cat,
        //typeCastAnimal.myMethod(); //it doesnot have access to other cat related methods
        ((Cat)typeCastAnimal).myMethod();// however you can cast and call ir
        System.out.println("type of typeCastAnimal --> "+typeCastAnimal.type);//Animal
        typeCastAnimal.animalMethod();//Animal Method !!
        System.out.println("---------");
        typeCastAnimal.printLegs();

        //Downcasting of parent
        Thread.sleep(1000);
        Cat typeCastCat= (Cat) a;//doesnot throw compile type error
        //however at runtime it throws an exception bcoz Big cannot go in small

        //DOwncasting primitives
        Float f = new Float(2.56f);
        //Integer i = (Integer) f; //throws compile time exception


        //Downcasting polymorphic variable
        Number nf = new Float(2.56f);
        Integer inf = (Integer) nf; //this doesnot throw compile time error
        System.out.println("printing inf-->"+inf);//but at runtime it throws error

        //This is a major drawback of polymorphism ,it doesnot identify downcasting error at compile time
        //Second problem is fragile base class problem
        /*
        
         */
    }
}
class AnimalOne {
    String type="Animal";
    int legs = 4;

    public AnimalOne() {
        this.legs = 4;
    }
    public void printLegs(){
        System.out.println("Legs == "+legs);
    }
    public void animalMethod(){
        System.out.println("Animal method !!");
    }

}
class Cat extends AnimalOne{
    String type="Dog";

    public Cat( String type) {
        super();
        this.type = type;
    }
    public void myMethod(){
        System.out.println("super -->"+super.hashCode()+" this -->"+hashCode());
        System.out.println("Can access super ,super.legs -->"+super.legs+" type -->"+super.type);
    }
    @Override
    public void printLegs(){
        System.out.println("Legs of "+type+" is -->"+super.legs);
    }
}
