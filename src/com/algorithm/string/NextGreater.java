package com.algorithm.string;

import java.util.Arrays;

public class NextGreater {
    //public static String input="534976"; //output -- 536479
    public static String input="218765"; //output -- 251678
    //public static String input="1234"; //output -- 251678

    public static void main(String[] args) {
         findNextGreaterNumber();
    }

    public static void findNextGreaterNumber(){
        char[] inputArr=input.toCharArray();
        int indexOfSmallestNumberFromRight=inputArr.length-1;

        for(int i=inputArr.length-2;i>=0;i--){

            if(inputArr[i]<inputArr[i+1]){
                swap(inputArr,i,indexOfSmallestNumberFromRight);
                sort(inputArr,i+1,inputArr.length);
                break;
            }
            if(inputArr[indexOfSmallestNumberFromRight]>inputArr[i]){
                indexOfSmallestNumberFromRight=i;
            }

        }
        System.out.println("Input arr --> "+Arrays.toString(inputArr));

    }
    public static void sort(char[] inputArr,int startIndex,int endIndex){
         Arrays.sort(inputArr,startIndex,endIndex);
    }

    public  static void swap(char[] inputArr,int i ,int j){
        char temp = inputArr[i];
        inputArr[i]=inputArr[j];
        inputArr[j]=temp;
    }
}
//Output 534976 -> 536974 -> 536479
/*
Algo -
1) Find an element from right which is smaller than it's previous consecutive no. i.e 4
2) Swap it with the smallest number from right till that index . i.e. 6 --> 536974
3) Sort array from the index in step 2 till last element ie.e 974->479 --> 536479
 */
