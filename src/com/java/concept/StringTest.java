package com.java.concept;

import java.util.*;

public class StringTest {
    public static void main(String[] args) {
        String a = "A"+"B"+"C";
        StringBuilder str= new StringBuilder("A").append("B").append("C");
        String b= "ABC";
        String newString = new String("ABC");
        String internString = new String("ABC").intern();
        System.out.println("Is a and b equal - "+ (a == b));
        System.out.println("Is a and str equal - "+ (a == str.toString()));
        System.out.println("Is b and newString equal - "+ (b == newString));
        System.out.println("Is b and internString equal - "+ (b == internString));
        System.out.println("Is newString and internString equal - "+ (newString == internString));
        Map<Integer, String> map=new HashMap<>();
        map.put(1, "h1");
        map.put(2, "h2");

        Set<Map.Entry<Integer,String>> itr= map.entrySet();
       // Collections.sort();

    }
}
/*
Output -
Is a and b equal - true
Is a and str equal - false
Is b and newString equal - false
Is b and internString equal - true
Is newString and internString equal - false
 */