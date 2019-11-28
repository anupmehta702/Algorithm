package com.java.concept;

public class CloneableImplementation implements Cloneable {

    private int i;
    private String str;
    private Integer j;
    private Dog d;

    public CloneableImplementation(int i, String str, Integer j,Dog d) {

        this.i = i;
        this.str = str;
        this.j = j;
        this.d = d;
    }

    @Override
    public String toString() {
        return "CloneableImplementation{" +
                "i=" + i +
                ", str='" + str + '\'' +
                ", j=" + j +
                ", d=" + d +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Integer valueOfJ = new Integer(100);
        String valueOfStr = new String("anup");
        Dog d = new Dog();
        CloneableImplementation ci = new CloneableImplementation(1, valueOfStr, valueOfJ,d);
        CloneableImplementation cloneOfCi = (CloneableImplementation) ci.clone();
        valueOfJ = new Integer(256);
        valueOfStr = new String("Pankaj");
        d.name="Doberman 2";
        System.out.println("Clone of ci -->" + cloneOfCi);
        System.out.println(" ci -->" + ci);
        System.out.println("clone of dog-->"+d.clone());

    }

    /*
    Output -
    Clone of ci -->CloneableImplementation{i=1, str='anup', j=100, d=Dog{name='Doberman'}}
 ci -->CloneableImplementation{i=1, str='anup', j=100, d=Dog{name='Doberman 2'}}
clone of dog-->Dog{name='Doberman 2'}

     */

    @Override
    protected Object clone() throws CloneNotSupportedException {
        CloneableImplementation cloned = (CloneableImplementation) super.clone();
        cloned.d = (Dog) cloned.d.clone();
        return cloned;
    }
}
class Dog implements  Cloneable{
    String name="Doberman";

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
