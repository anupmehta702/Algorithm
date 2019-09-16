package com.java.concept;

public class TestInteger {

    public static void main(String[] args) {
        Integer count = new Integer(0);
        Integer count1 = new Integer(0);
        System.out.println("is Count == count1 " + (count == count1));//false

        Integer count2 = 10;
        Integer count3 = 10;
        System.out.println("is Count2 == count3 " + (count2 == count3));//true


        Integer count22 = Integer.valueOf(100);
        Integer count33 = Integer.valueOf(100);
        System.out.println("is Count22 == count33 " + (count22 == count33));//true

        Integer count4 = new Integer(4);
        System.out.println("is Count4 == ++count4 " + (count4 == (++count4)));//false
        System.out.println("is Count4 == count4+1 " + (count4 == (count4 = count4 + 1)));//false


    }
}
/* Output -
is Count == count1 false
is Count2 == count3 true
is Count22 == count33 true
is Count4 == ++count4 false
is Count4 == count4+1 false
 */