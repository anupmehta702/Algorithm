package com.algorithm.string;

import java.util.*;

public class FindLargestNumber {

    public static void main(String[] args) {
        FindLargestNumber flm = new FindLargestNumber();
        System.out.println("Output -- >" + flm.largestNumber(new int[]{30, 3, 34, 5, 9, 121, 12}));
        System.out.println("Output(Leet) -- >" + flm.largestNumberViaLeetCode(new int[]{30, 3, 34, 5, 9, 121, 12}));
    }


    public String largestNumberViaLeetCode(int[] nums) {
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(asStrs, new NumberAsStringComparator());
        if (asStrs[0] == "0") {
            return "0";
        }
        StringBuilder outputStr = new StringBuilder();
        for (String str : asStrs) {
            outputStr.append(str);
        }
        return outputStr.toString();

    }

    public String largestNumber(int[] nums) {
        List<Number> outputList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            outputList.add(new Number(nums[i]));
        }
        Collections.sort(outputList, new LargestNumComparator());
        StringBuilder outStr = new StringBuilder();
        for (Number input : outputList) {
            outStr.append(input.value);
        }

        if (outStr.toString().startsWith(0 + "")) {
            return "0";
        }

        return outStr.toString();
    }
}

class Number implements Comparable<Number> {
    Integer mod;
    Integer dividend;
    Integer value;

    public Number(int value) {
        this.mod = value % 10;
        this.dividend = value / 10;
        this.value = value;
    }

    public int compareTo(Number n) {
        if (n == null) return 1;
        if (this.mod > n.mod) return 1;
        else if (this.mod < n.mod) return 0;
        else {
            return this.dividend.compareTo(n.dividend);
        }
    }

}

class LargestNumComparator implements Comparator<Number> {

    public int compare(Number n1, Number n2) { //this is descending order compare method
        if (n1 == null && n2 == null) return 0;
        else if (n1 == null) return 1;
        else if (n2 == null) return -1;
        Integer n1UnitPlace = n1.value / (findDivisorFor(n1.value));
        Integer n2UnitPlace = n2.value / (findDivisorFor(n2.value));
        if (n2UnitPlace.compareTo(n1UnitPlace) == 0) { //for cases 30 and 3 (both have same unit place)
            String number1 = n1.value + "" + n2.value + "";
            String number2 = n2.value + "" + n1.value + "";
            return number2.compareTo(number1);
        }
        return n2UnitPlace.compareTo(n1UnitPlace);
    }

    public int findDivisorFor(int num) {
        int divideBy = 1;
        String numStr = num + "";
        if (numStr.length() == 1) {
            return divideBy;
        } else if (numStr.length() > 1) {
            for (int index = 2; index <= numStr.length(); index++) {
                divideBy = divideBy * 10;
            }
        }
        return divideBy;
    }
}

class NumberAsStringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String num1 = o1 + o2;
        String num2 = o2 + o1;
        return num2.compareTo(num1);
    }
}
/*
Input - [30,3,34,5,9,121,12]
Output -"953433012121"
 */
