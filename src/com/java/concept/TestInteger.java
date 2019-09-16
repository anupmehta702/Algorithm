package com.java.concept;

public class TestInteger {

    public static void main(String[] args) {
        Integer count = new Integer(0);
        Integer count1 = new Integer(0);
        System.out.println("is Count == count1 " + (count == count1));//false

        Integer count2 = 10;
        Integer count3 = 10;
        System.out.println("is Count2 == count3 " + (count2 == count3));//true


        Integer count22 = Integer.valueOf(100);// Compiler converts this line to Integer a = Integer.valueOf(100);
        Integer count33 = Integer.valueOf(100);// Compiler converts this line to Integer a = Integer.valueOf(100);
        System.out.println("is Count22 == count33 " + (count22 == count33));//true
        /*
        Integer.valueOf(i) returns cache value  if i lies between -127 to 128
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