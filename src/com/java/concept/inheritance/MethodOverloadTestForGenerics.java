package com.java.concept.inheritance;

public class MethodOverloadTestForGenerics {
    public static void main(String[] args) {
        Car c = new Car();
        ElectricCar ec = new ElectricCar();
        GenericQueue<Car,ElectricCar> genericCarQueue = new GenericQueue<>();
        genericCarQueue.myMethod(ec);//with parameter as R
        genericCarQueue.myMethod(null);//with parameter as R
        genericCarQueue.myMethod(new Object());//with parameter as Object
    }
}

class GenericQueue<T,R extends Car>{
    T localObject;
    public GenericQueue() {
        localObject = (T)new Object();
    }
    public void myMethod(Object o){
        System.out.println("With parameter as Object !!");
    }
    public void myMethod(R o){//this is allowed since R extends car and due to type earasure  R becomes of type Car
        System.out.println("With parameter as R !!");
    }
    /*
    public void myMethod(T o){//not allowed because it says both have same erasure
        System.out.println("With parameter as T !!");
    }
    */

}
class Car{
    String type="Car";
}
class ElectricCar extends Car{
    String type="ElectricCar";
}