package com.java.concept;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        String a = "A" + "B" + "C";
        StringBuffer str = new StringBuffer("A").append("B").append("C");//StringBuilder is threadsafe
        String b = "ABC";
        String newString = new String("ABC");
        String internString = new String("ABC").intern();
        System.out.println("Is a and b equal - " + (a == b));
        System.out.println("Is a and strBuilder equal - " + (a == str.toString()));
        System.out.println("Is b and newString equal - " + (b == newString));
        System.out.println("Is b and internString equal - " + (b == internString));
        System.out.println("Is newString and internString equal - " + (newString == internString));

        String d = "abcd";
        char[] dArr = d.toCharArray();
        String[] eStringArr = new String[]{"a", "b", "c", "d"};
        String e = Arrays.toString(eStringArr);
        System.out.println(e);
        testIntern();

    }
    public static void testIntern(){
        String  aObj = new String("a");
        String bIntern = aObj.intern();
        String a = "a";
        System.out.println("Is aObj.equals(bIntern) --> "+aObj.equals(bIntern));
        System.out.println("Is aObj == (bIntern) --> "+(aObj == (bIntern)));

        System.out.println("Is a.equals(bIntern) --> "+a.equals(bIntern));
        System.out.println("Is a == (bIntern) --> "+(a == (bIntern)));

    }
}
/*
Output -
Is a and b equal - true
Is a and strBuilder equal - false
Is b and newString equal - false
Is b and internString equal - true
Is newString and internString equal - false
[a, b, c, d]
 */
