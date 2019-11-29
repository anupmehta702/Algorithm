package com.java.concept.immutabilityAndSingleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Parent implements Cloneable{
public int id =999;
public String type ="Overrriden from Parent";

    @Override
    public String toString() {
        return "Parent{" + "id=" + id + ", type='" + type + '\'' + '}';
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class SingletonClass extends Parent implements Serializable { //not necessary to implement Serializable but we are testing serializable failure

    private int id =10;
    private String type ="Singleton";
    private static final  SingletonClass  instance;
    //The below way is the simplest way
    //you can use volatile or final ,not both of them together
    // private static final  SingletonClass  instance= new SingletonClass();
    static{
        System.out.println("In static initializer !!");
        //use this method if you wish to throw user defined exception or special printouts
        //through the method
        instance = new SingletonClass();
        instance.id=20;
        instance.type="Using static method";
    }

    private SingletonClass(){
        /*//below code is written to avoid reflection creating a new instance !!
        if(instance == null){
            //do nothing
        }else{
            throw new RuntimeException("Hands up ! you are being caught !");
        }*/
    }


    public static SingletonClass getInstance(){
        return instance;
    }

    /*protected Object readResolve(){
        return instance;
    }*/

    /*public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }*/

    @Override
    public String toString() {
        return "SingletonClass{" + "id=" + id + ", type='" + type + '\'' + '}';
    }
}
class CheckSingleton{
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, InterruptedException, IOException, ClassNotFoundException, CloneNotSupportedException {
        System.out.println("In main method");
        SingletonClass singleton;
        System.out.println("Before creation of singleton");
        singleton = SingletonClass.getInstance();
        System.out.println("Singleton class -->"+singleton.toString());
        System.out.println("Java example of singleton ,free memory-->" +Runtime.getRuntime().freeMemory());
        Thread.sleep(1000);
        breakSingletonUsingReflection();
        breakUsingSerializable();
        breakSingletonUsingClone();
    }
    public static void breakSingletonUsingReflection() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        SingletonClass instance1 = SingletonClass.getInstance();
        SingletonClass instance2 = null;
        Constructor[] constructors = SingletonClass.class.getDeclaredConstructors();
        for(Constructor constructor : constructors){
            constructor.setAccessible(true);
            instance2= (SingletonClass) constructor.newInstance();
        }
        System.out.println("Reflection instance1.hashCode():- " + instance1.hashCode());
        System.out.println("Reflection instance2.hashCode():- " + instance2.hashCode());

        /*the above code violation can be avoided by two ways -
        1) make your private constructor throw error
        2) use enum singleton bcoz it has no constructor .Java ensures that it gets initialized only once
        */
    }

    public static void breakSingletonUsingClone() throws CloneNotSupportedException {
        SingletonClass instance1 = SingletonClass.getInstance();
        SingletonClass instance2 = (SingletonClass) instance1.clone();
        System.out.println("cloneable instance1 hashCode:- " + instance1.hashCode());
        System.out.println("cloneable instance2 hashCode:- " + instance2.hashCode());
        //avoid creation by implementing clone method and throwing CloneNotSupportedException
    }




    public static void breakUsingSerializable() throws IOException, ClassNotFoundException {
        SingletonClass singletonInstance= SingletonClass.getInstance();
        ObjectOutput op = new ObjectOutputStream(new FileOutputStream("myFile.txt"));
        op.writeObject(singletonInstance);
        op.close();

        ObjectInput in =  new ObjectInputStream(new FileInputStream("myFile.txt"));
        SingletonClass instance2 = (SingletonClass) in.readObject();
        in.close();

        System.out.println("Serializable instance1 hashCode:- " + singletonInstance.hashCode());
        System.out.println("Serializable instance2 hashCode:- " + instance2.hashCode());

        //avoid creation of two new instance by overriding readResolve method
    }

}


/*
Below code throws exception bcoz SingletonCLass has no default constructor
class Child extends SingletonClass{

}*/


/* Output
In main method
Before creation of singleton
In static initializer !!
Singleton class -->SingletonClass{id=20, type='Using static method'}
Java example of singleton ,free memory-->125566624
Reflection instance1.hashCode():- 2125039532
Reflection instance2.hashCode():- 312714112
Serializable instance1 hashCode:- 2125039532
Serializable instance2 hashCode:- 1725154839
cloneable instance1 hashCode:- 2125039532
cloneable instance2 hashCode:- 1670675563

 */