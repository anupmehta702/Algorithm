package com.algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateWordsInSentence {
    public static void main(String[] args) {
        String input = "I am in problem . Problem exists in everything . ";
        findDuplicateWordsInSentence(input);
        findDuplicatesNew(input);
    }

    public static void findDuplicatesNew(String input){
        String[] inputArr = input.split(" ");
        HashMap<String,Integer> countMap = new HashMap<>();
        for(String word : inputArr){
            if(countMap.containsKey(word.toLowerCase())){
                int count = countMap.get(word.toLowerCase());
                countMap.put(word.toLowerCase(),++count);
                System.out.println("Duplicate word found -->"+word);
            }else{
                countMap.put(word.toLowerCase(),1);
            }
        }
    }


    public static void findDuplicateWordsInSentence(String input) {
        char[] inputArr = input.toCharArray();
        Map<String, Integer> wordMap = new HashMap<>();
        List<String> duplicateWords = new ArrayList<>();

        for (int index = 0; index < inputArr.length; index++) {
            StringBuffer word = new StringBuffer();

            while (!String.valueOf(inputArr[index]).contains(" ")) {
                word.append(inputArr[index]);
                index++;
                if (index > inputArr.length) return;
            }
            System.out.print(" " + word);

            if (wordMap.containsKey(word.toString().toLowerCase())) {
                duplicateWords.add(word.toString());
                Integer count = wordMap.get(word.toString().toLowerCase());
                wordMap.put(word.toString().toLowerCase(), ++count);
            } else {
                wordMap.put(word.toString().toLowerCase(), 1);
            }
            word = new StringBuffer();

        }//for loop
        System.out.println();
        System.out.println("Duplicate words --> " + duplicateWords);
    }
}
/*
Output
 I am in problem . Problem exists in everything .
 Duplicate words --> [Problem, in, .]

 */