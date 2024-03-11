package com.java.concept.immutabilityAndSingleton;

public final class Person {
    private final int id;
    private final String name;
    private final StringBuilder surname;
    private final StringBuilder city;

    public Person(int id, String name, StringBuilder surname, StringBuilder city) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.city = new StringBuilder(city);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public StringBuilder getSurname() {
        return surname;
    }

    public StringBuilder clonedGetSurname() {
        return new StringBuilder(surname);
    }

    public StringBuilder getCity() {
        return new StringBuilder(city);
    }

    public static void main(String[] args) {
        String name = new String("Anup");
        StringBuilder surname = new StringBuilder("Mehta");
        StringBuilder city = new StringBuilder("Pune");
        int id = 10;
        Person p = new Person(id, name, surname,city);

        id = 20;
        System.out.println("id --> " + p.getId());//output 10
        // bcoz for primitive types Java is pass by value
        //and for objects it is pass by address

        name = "Anoop";
        System.out.println("name --> " + p.getName());//Output Anup
        /*bcoz String is immutable though it is an object
        Reason - we passed Anup at mem location 1000
        next we created a new name pointing to 1001 (Anup) ,however name in person still points
        to 1000 (Anup)*/

        surname.append(" Junior");
        System.out.println("Surname --> " + p.surname);//Output Mehta Junior
        /*bcoz StringBuilder is object and java is pass by address for object
        Therefore earlier surname was pointing to 1005 (Mehta)
        THis address got copied to person and person.surname also points to 1005 (Mehta)
        Later we changed value and it was pointing to 1005 (Mehta Junior)
        therefore value of person.surname also changed since it was pointing to 1005 (Mehta Junior)
         */

        StringBuilder originalSurname = p.surname;
        originalSurname.append(" Junior 2");
        System.out.println("Surname --> " + p.surname);
        /*Another problem is what you return ,if you return an object ,the address is returned
        and anyone can make changes to it and hence immutability is lost .
        Always return cloned copy or create a fresh copy and return */

        city.append(" - Kondhwa");
        System.out.println("city --> "+ p.city);
        StringBuilder newCity= p.city;
        newCity.append(" - East Pune");
        System.out.println("city --> "+p.city);



    }

}
