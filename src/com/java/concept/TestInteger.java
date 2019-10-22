package com.java.concept;

public class TestInteger {

    //Integer.valueOf uses caching and no other mechanism . SO the concept of internal caching comes only when you use Integer.valueOf
    public static void main(String[] args) {
        Integer count = new Integer(0);
        Integer count1 = new Integer(0);
        System.out.println("is Count == count1 " + (count == count1));//false

        Integer count2 = 10;//this internally calls Integer.valueOf // Compiler converts this line to Integer a = Integer.valueOf(100);
        Integer count3 = 10;
        System.out.println("is Count2 == count3 (both have value 10 )" + (count2 == count3));//true

        count2 =128;//this internally calls Integer.valueOf
        count3=128;
        System.out.println("is Count2 == count3 (both have value 128 )" + (count2 == count3));//false

        Integer count10 = 10;
        Integer count20 = 20;
        System.out.println("is Count10 == count20 " + (count10 == count20));//false //no caching at this stage

        Integer count22 = Integer.valueOf(100);// Compiler converts this line to Integer a = Integer.valueOf(100);
        Integer count33 = Integer.valueOf(100);// Compiler converts this line to Integer a = Integer.valueOf(100);
        System.out.println("is Count22 == count33 " + (count22 == count33));//true
        /*
        Integer.valueOf(i) returns cache value  if i lies between -127 to 127
        code -
         public static Integer valueOf(int i) {
            if (i >= IntegerCache.low && i <= IntegerCache.high)
                return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
         }
         */


        Integer count222 = Integer.valueOf(128);
        Integer count333 = Integer.valueOf(128);
        System.out.println("is Count222 == count333 " + (count222 == count333));//false.Since value is greater than 127 ,it does not cache it


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