package com.algorithm.string;

import java.util.Arrays;

public class ReaarangeWords {

    public static void main(String[] args) {
        System.out.println("Reaaranged word -->"+rearrangeWord("xy"));
        System.out.println("Reaaranged word -->"+rearrangeWord("baca"));
        System.out.println("Reaaranged word -->"+rearrangeWord("hefg"));
        System.out.println("Reaaranged word -->"+rearrangeWord("pp"));
    }

    public static String rearrangeWord(String word) {
        // Write your code here
        char[] characters = word.toCharArray();
        int[] inputArr = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            inputArr[i]=(int) c;
        }
        findNextGreaterNumber(inputArr);

        StringBuilder stringBuilder = new StringBuilder();
        for(int i : inputArr){
            stringBuilder.append(Character.toString((char)i));
        }
        if(word.equalsIgnoreCase(stringBuilder.toString())) return "no answer";
        else
        return stringBuilder.toString();
    }

    public static void findNextGreaterNumber(int[] inputArr){
    //    System.out.println("Input int arr --> "+ Arrays.toString(inputArr));
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
      //  System.out.println("Output int arr --> "+ Arrays.toString(inputArr));

    }
    public static void sort(int[] inputArr,int startIndex,int endIndex){
        Arrays.sort(inputArr,startIndex,endIndex);
    }

    public  static void swap(int[] inputArr,int i ,int j){
        int temp = inputArr[i];
        inputArr[i]=inputArr[j];
        inputArr[j]=temp;
    }
}
