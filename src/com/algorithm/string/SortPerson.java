package com.algorithm.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortPerson {
    public static void main(String[] args) {
        Person p4, p5, p6 = null;
        Person p1 = new Person("Marlon", "Brando", 80, "USA");
        Person p2 = new Person("Bruce", "Lee", 32, "China");
        Person p3 = new Person("Brandon", "Lee", 28, "China");
        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        PersonUtils.sortPersons(persons, new String[]{"firstName"});
        //output - Brandon Bruce Marlon

        p1 = new Person("Marlon", "Brando", 80, "USA");
        p2 = new Person("Bruce", "Lee", 32, "China");
        p3 = new Person("Brandon", "Lee", 28, "China");
        p4 = new Person("Amjad", "Khan", 51, "India");
        p5 = new Person("Amrish", "Puri", 72, "India");
        p6 = new Person("Sanjeev", "Kumar", 47, "India");
        persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);
        persons.add(p6);
        PersonUtils.sortPersons(persons, new String[]{"country", "firstName"});
        //output Brandon China ,Bruce China ,Amjad India ,Amrish India ,Sanjeev India ,Marlon USA

    }
}

class Person {
    String firstName;
    String lastName;
    int age;
    String country;

    public Person(String firstName, String lastName, int age, String country) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return firstName + "|" + lastName + "|" + age + "|" + country;
    }
}

class PersonUtils {
    public static void sortPersons(List<Person> persons, String[] sortBy) {
        // implement the sorting logic
        if (sortBy.length == 0) {
            return;
        } else {
            Collections.sort(persons, new PersonComparator(sortBy));
            System.out.println("Sorted list -->" + persons);
        }

    }
}

class PersonComparator implements Comparator<Person> {
    String[] sortBy;

    public PersonComparator(String[] sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public int compare(Person o1, Person o2) {
        String firstSort = sortBy[0];
        int firstCompareValue = 0;
        int finalCompareValue = 0;
        return sortUsingElements(o1,o2,sortBy);
        /*if (firstSort.equalsIgnoreCase("firstName")) {
            firstCompareValue = o1.firstName.compareTo(o2.firstName);
            finalCompareValue = sortUsingOtherElement(o1, o2, firstCompareValue, finalCompareValue);
        } else if (firstSort.equalsIgnoreCase("country")) {
            firstCompareValue = o1.country.compareTo(o2.country);
            finalCompareValue = sortUsingOtherElement(o1, o2, firstCompareValue, finalCompareValue);
        } else if (firstSort.equalsIgnoreCase("lastName")) {
            firstCompareValue = o1.lastName.compareTo(o2.lastName);
            finalCompareValue = sortUsingOtherElement(o1, o2, firstCompareValue, finalCompareValue);
        } else if (firstSort.equalsIgnoreCase("age")) {
            Integer o1Age = o1.age;
            Integer o2Age = o2.age;
            firstCompareValue = o1Age.compareTo(o2Age);
            finalCompareValue = sortUsingOtherElement(o1, o2, firstCompareValue, finalCompareValue);
        } else {
            firstCompareValue = o1.firstName.compareTo(o2.firstName);
            finalCompareValue = sortUsingOtherElement(o1, o2, firstCompareValue, finalCompareValue);
        }
        return finalCompareValue;*/
    }

    private int sortUsingElements(Person o1, Person o2, String[] sortBy) {
        int finalCompareValue = 0;
        for (int i = 0; i < sortBy.length; i++) {
            String sortName = sortBy[i];
            if (sortName.equalsIgnoreCase("country")) {
                int compare = o1.country.compareTo(o2.country);
                if (compare != 0) {
                    finalCompareValue = compare;
                    break;
                }
            } else if (sortName.equalsIgnoreCase("lastName")) {
                int compare = o1.lastName.compareTo(o2.lastName);
                if (compare != 0) {
                    finalCompareValue = compare;
                    break;
                }
            } else if (sortName.equalsIgnoreCase("firstName")) {
                int compare = o1.firstName.compareTo(o2.firstName);
                if (compare != 0) {
                    finalCompareValue = compare;
                    break;
                }
            } else if (sortName.equalsIgnoreCase("age")) {
                Integer o1Age = o1.age;
                Integer o2Age = o2.age;
                int compare = o1Age.compareTo(o2Age);
                if (compare != 0) {
                    finalCompareValue = compare;
                    break;
                }
            }

        }
        return finalCompareValue;
    }

    private int sortUsingOtherElement(Person o1, Person o2, int firstCompareValue, int finalCompareValue) {
        if (firstCompareValue == 0) {
            for (int i = 1; i < sortBy.length; i++) {
                String sortName = sortBy[i];
                if (sortName.equalsIgnoreCase("country")) {
                    int compare = o1.country.compareTo(o2.country);
                    if (compare != 0) {
                        finalCompareValue = compare;
                        break;
                    }
                } else if (sortName.equalsIgnoreCase("lastName")) {
                    int compare = o1.lastName.compareTo(o2.lastName);
                    if (compare != 0) {
                        finalCompareValue = compare;
                        break;
                    }
                } else if (sortName.equalsIgnoreCase("firstName")) {
                    int compare = o1.firstName.compareTo(o2.firstName);
                    if (compare != 0) {
                        finalCompareValue = compare;
                        break;
                    }
                } else if (sortName.equalsIgnoreCase("age")) {
                    Integer o1Age = o1.age;
                    Integer o2Age = o2.age;
                    int compare = o1Age.compareTo(o2Age);
                    if (compare != 0) {
                        finalCompareValue = compare;
                        break;
                    }
                }

            }
        } else {
            finalCompareValue = firstCompareValue;
        }
        return finalCompareValue;
    }
}