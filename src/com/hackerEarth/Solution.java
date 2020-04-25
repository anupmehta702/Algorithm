package com.hackerEarth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String args[] ) throws Exception {
        System.out.println("Hello World");
        Map<String,Integer> map = new HashMap<>();
        int[] inputArr = new int[]{1,2,3,4,5,6,7,8,9};
        getSum(inputArr,8);
    }
    public static void getSum(int[] inputArr,int sum){
        Map<Integer,List<Integer>> balToIndexMap = new HashMap<>();
        for(int i= 0 ; i< inputArr.length ; i++){
            Integer bal = sum - inputArr[i];
            if(balToIndexMap.containsKey(inputArr[i])){
                List<Integer> existingIndexList = balToIndexMap.get(inputArr[i]);
                for(Integer index : existingIndexList){
                    System.out.println(" var 1 -> "+inputArr[i]+" at index -> "+i+" var 2 -> "+inputArr[index] + " at index ->"+index);
                }
            }
            if(balToIndexMap.containsKey(bal)){
                List<Integer> existingIndexList = balToIndexMap.get(bal);
                existingIndexList.add(i);
            }else{
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                balToIndexMap.put(bal,indexList);
            }
        }
        System.out.println("Map to index -->"+balToIndexMap);
    }
}