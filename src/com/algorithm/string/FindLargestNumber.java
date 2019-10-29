package com.algorithm.string;

public class FindLargestNumber {

    public static void main(String[] args) {
        String str = "1100";
        System.out.println("starts with 0"+str.startsWith(0+""));
        Integer int1 = Integer.parseInt(str);
        System.out.println(int1);
        System.out.println("12%1 = "+(12%10)+" 121%100 = "+(121%100));
        int[] input = new int[]{121,34,9};
        for(int i =0 ;i<input.length;i++){
            System.out.println("for num ->"+input[i]+" divide by -->"+findDivisorFor(input[i]));
        }
        String p = 10+"" + 4 +"";
        String q = 4 +"" + 10 + "";
        System.out.println("p --> "+p+" q --> "+q+" q > p --> "+q.compareTo(p));
    }

    public static int findDivisorFor(int num){
        int divideBy=1;
        String numStr = num+"";
        if(numStr.length() == 1){
            return divideBy;
        }else if(numStr.length()>1){
            for(int index=2;index<=numStr.length();index++){
                divideBy=divideBy*10;
            }
        }
        return divideBy;
    }
}
