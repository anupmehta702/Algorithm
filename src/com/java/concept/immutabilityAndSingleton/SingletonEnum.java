package com.java.concept.immutabilityAndSingleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum SingletonEnum implements Serializable,Cloneable {
    SINGLETON_ENUM;
    private  String type = "Enum";
    private   int id = 22;
    public String getValues(){
        type="Enum updated";
        System.out.println("changing type to - "+type);
        return type;
    }
    public String setValues(String type){
        this.type=type;
        return type;
    }


    @Override
    public String toString() {
        return "SingletonEnum{" +
                "type='" + type + '\'' +
                ", id=" + id +
                '}';
    }
}

class TestSingletonEnum{
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        System.out.println("Singleton enum -->"+SingletonEnum.SINGLETON_ENUM.toString());
        System.out.println("Singleton enum ordinal -->"+SingletonEnum.SINGLETON_ENUM.ordinal());

        SingletonEnum.SINGLETON_ENUM.getValues();
        System.out.println("Updated Singleton enum -->"+SingletonEnum.SINGLETON_ENUM.toString());
        breakSingletonUsingReflection();
        breakUsingSerializable();

    }
    public static void breakSingletonUsingReflection() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        SingletonEnum instance1 = SingletonEnum.SINGLETON_ENUM;
        SingletonEnum instance2 = null;
        Constructor[] constructors = SingletonEnum.class.getDeclaredConstructors();
        for(Constructor constructor : constructors){
            constructor.setAccessible(true);
            instance2= (SingletonEnum) constructor.newInstance();
            //above line throws java.lang.IllegalArgumentException: Cannot reflectively create enum objects
        }
        System.out.println("Reflection instance1.hashCode():- " + instance1.hashCode());
        System.out.println("Reflection instance2.hashCode():- " + instance2.hashCode());

        /*Due to the exception you cannot create multiple instances  of enum through reflection
        */
    }


    public static void breakUsingSerializable() throws IOException, ClassNotFoundException {
        SingletonEnum singletonInstance= SingletonEnum.SINGLETON_ENUM;
        ObjectOutput op = new ObjectOutputStream(new FileOutputStream("myFile.txt"));
        op.writeObject(singletonInstance);
        op.close();

        ObjectInput in =  new ObjectInputStream(new FileInputStream("myFile.txt"));
        SingletonEnum instance2 = (SingletonEnum) in.readObject();
        in.close();

        System.out.println("Serializable instance1 hashCode:- " + singletonInstance.hashCode());
        System.out.println("Serializable instance2 hashCode:- " + instance2.hashCode());

        //by default both the instances are same you dont need to override readResolve method
    }

    public static void breakSingletonUsingCloneable(){
        SingletonEnum instance1 = SingletonEnum.SINGLETON_ENUM;
        /*
        //there is no clone method in enum  cannot run below code
         SingletonEnum instance2 = instance1.clone();
        cannot override clone method as well since clone method implementation is given
        by java.lang.Enum and it is made final due to which i cannot override.
        This guarantees that enums
        are never cloned, which is necessary to preserve their "singleton"
        status.
       */
    }
}

enum TestEnum{
    INSTANCE("instance"){
        public void defaultMethod(){
            System.out.println("In instance variable");
        }
    };
    private String type;
    TestEnum(String type){
        this.type=type;
    }
    abstract void defaultMethod();

}